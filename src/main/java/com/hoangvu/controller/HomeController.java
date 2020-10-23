package com.hoangvu.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hoangvu.dao.ProductDao;
import com.hoangvu.model.Product;

@Controller
public class HomeController {

	private Path path;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@RequestMapping(value="/productList") 
	public String getProducts(Model model) {
	    List<Product> productList = productDao.getAllProducts();
	    model.addAttribute("productList", productList);
	    
		return "productList";
	}
	
	@RequestMapping(value="/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) throws IOException {
		Product product = productDao.getProductById(productId);
		model.addAttribute("product", product);
		
		return "viewProduct";
	}
	
	@RequestMapping(value="/admin")
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping(value="/admin/productInventory") 
	public String productInventory(Model model) {
		model.addAttribute("productList", productDao.getAllProducts());
		return "productInventory";
	}
	
	@RequestMapping(value="/admin/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}
	
	@RequestMapping(value="/admin/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
		 productDao.addProduct(product);

	        MultipartFile productImage = product.getProductImage();
	        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "\\WEB-INF\\resource\\images\\"+product.getProductId()+".png");
            System.out.println(path);
	        if (productImage != null && !productImage.isEmpty()) {
	            try {
	                productImage.transferTo(new File(path.toString()));
	            } catch (Exception e) {
	                e.printStackTrace();
	                throw new RuntimeException("Product image saving failed", e);
	            }
	        }

	   
		/*
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resource\\images\\" + product.getProductId() + ".png");
		System.out.println(path);
		try {
			byte[] bytes = productImage.getBytes();
			String name = product.getProductId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(rootDirectory +"WEB-INF/resource/images/"+name)));
		    System.out.println(stream);
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value="/admin/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		productDao.deleteProduct(productId);
		return "redirect:/admin/productInventory";
	}
	
}