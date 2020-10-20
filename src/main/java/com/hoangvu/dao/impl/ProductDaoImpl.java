package com.hoangvu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hoangvu.dao.ProductDao;
import com.hoangvu.model.Product;

@Repository
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product product) {
		Session session;
		
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		
		session.saveOrUpdate(product);
	    session.flush();
	}
	
	public Product getProductById(Integer id) {
		Session session;
		
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		
		Product product = new Product();
		product = (Product) session.get(Product.class, id);
		session.flush();
		
		return product;
	}
	
	
	public List<Product> getAllProducts() {	
		Session session;
		
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		Query query = session.createQuery("from Product");
        @SuppressWarnings("unchecked")
		List<Product> productList = query.list();
        
		session.flush();
		
		return productList;
	}
	
	public void deleteProduct(Integer id) {
		Session session;
		
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		
		session.delete(getProductById(id));
		session.flush();
	}
	
}
