package com.sahay.springbootjpatutorial.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahay.springbootjpatutorial.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
  //Custom Finder methods
	Product findByName(String name);
	
	//This method will return list of products either by name or description
	//means either name should be match or description should match 
	List<Product> findByNameOrDescription(String name, String description);
	
	//This method will return list if name and description both matches
	List<Product> findByNameAndDescription(String name, String description);
	
	List<Product> findByPriceGreaterThan(BigDecimal price);
	
	List<Product> findByPriceLessThan(BigDecimal price);
	
	List<Product> findByNameContaining(String name);
	
	List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

}
