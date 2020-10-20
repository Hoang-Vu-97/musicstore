package com.hoangvu.dao;

import java.util.List;

import com.hoangvu.model.Product;

public interface ProductDao {

	void addProduct(Product product);
	
	Product getProductById(Integer id);
	
	List<Product> getAllProducts();
	
	void deleteProduct(Integer id);
	
}
