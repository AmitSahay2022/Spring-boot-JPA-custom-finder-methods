package com.sahay.springbootjpatutorial.service;

import java.math.BigDecimal;
import java.util.List;

import com.sahay.springbootjpatutorial.entity.Product;

public interface ProductService {
	Product saveProduct(Product product);

	Product updatePRoduct(Product product, long id);

	String deleteProduct(long id);

	Product getProductById(long id);

	List<Product> getAllProducts();
	
	Product findByName(String name);
	
	List<Product> findByNameOrDescription(String name, String description);
	
	List<Product> findByNameAndDescription(String name, String description);
	
	List<Product> findByPriceGreaterThan(BigDecimal price);
	
	List<Product> findByPriceLessThan(BigDecimal price);
	
	List<Product> findByNameContaining(String name);
	
	List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

}
