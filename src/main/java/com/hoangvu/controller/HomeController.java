package com.hoangvu.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hoangvu.dao.ProductDao;
import com.hoangvu.model.Product;

@Controller
public class HomeController {

	
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
	
	    
}