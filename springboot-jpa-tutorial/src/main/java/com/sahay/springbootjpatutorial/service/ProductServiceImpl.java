package com.sahay.springbootjpatutorial.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahay.springbootjpatutorial.entity.Product;
import com.sahay.springbootjpatutorial.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product updatePRoduct(Product product, long id) {
		// TODO Auto-generated method stub
		Product updateProduct = productRepository.findById(id).get();
		updateProduct.setActive(product.isActive());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setImageUrl(product.getImageUrl());
		updateProduct.setName(product.getName());
		updateProduct.setPrice(product.getPrice());
		updateProduct.setSku(product.getSku());
		return productRepository.save(updateProduct);
	}

	@Override
	public String deleteProduct(long id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
		return "Product Deleted Successfully";
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> findByNameOrDescription(String name, String description) {
		// TODO Auto-generated method stub
		return productRepository.findByNameOrDescription(name, description);
	}
	
	@Override
	public List<Product> findByNameAndDescription(String name, String description) {
		// TODO Auto-generated method stub
		return productRepository.findByNameAndDescription(name, description);
	}
	@Override
	public List<Product> findByPriceGreaterThan(BigDecimal price) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceGreaterThan(price);
	}
	
	@Override
	public List<Product> findByPriceLessThan(BigDecimal price) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceLessThan(price);
	}
	
	@Override
	public List<Product> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByNameContaining(name);
	}
	
	@Override
	public List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceBetween(startPrice, endPrice);
	}
}
