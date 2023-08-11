package com.sahay.springbootjpatutorial.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahay.springbootjpatutorial.entity.Product;
import com.sahay.springbootjpatutorial.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
   @Autowired
	private ProductService productService;
   
   @PostMapping
   public ResponseEntity<Product> saveProduct(@RequestBody Product product){
	   return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
   }
   @PutMapping("{id}")
   public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable long id){
	   return new ResponseEntity<Product>(productService.updatePRoduct(product, id),HttpStatus.OK);
   }
   @DeleteMapping("{id}")
   public ResponseEntity<String> deleteProduct(@PathVariable long id){
	   return new ResponseEntity<String>(productService.deleteProduct(id),HttpStatus.OK);
   }
   @GetMapping("{id}")
   public ResponseEntity<Product> getProductById(@PathVariable long id){
	   return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
   }
   @GetMapping
   public ResponseEntity<List<Product>> getAllProducts(){
	   return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
   }
   
   @GetMapping("/pname")
   public ResponseEntity<Product> getProductByName(@RequestParam String name){
	   return new ResponseEntity<Product>(productService.findByName(name),HttpStatus.OK);
   }
   
   @GetMapping("/pname-description")
   public ResponseEntity<List<Product>> getProductByNameOrDescription(@RequestParam String name,@RequestParam String desc){
	   return new ResponseEntity<>(productService.findByNameOrDescription(name, desc),HttpStatus.OK);
   }
   
   @GetMapping("/pname-and-description")
   public ResponseEntity<List<Product>> getProductByNameAndDescription(@RequestParam String name,@RequestParam String desc){
	   return new ResponseEntity<>(productService.findByNameAndDescription(name, desc),HttpStatus.OK);
   }
   
   @GetMapping("/price-greater-then/{price}")
   public ResponseEntity<List<Product>> getProductByPriceGreaterThan(@PathVariable BigDecimal price){
	
	   return new ResponseEntity<>(productService.findByPriceGreaterThan(price),HttpStatus.OK);
   }
   @GetMapping("/price-less-then/{price}")
   public ResponseEntity<List<Product>> getProductByPriceLessThan(@PathVariable BigDecimal price){
	
	   return new ResponseEntity<>(productService.findByPriceLessThan(price),HttpStatus.OK);
   }
   
   @GetMapping("/pname-contains")
   public ResponseEntity<List<Product>> getProductByNameContains(@RequestParam String name){
	   return new ResponseEntity<>(productService.findByNameContaining(name),HttpStatus.OK);
   }
   
   @GetMapping("/price-between/{price1}/{price2}")
   public ResponseEntity<List<Product>> getProductbyPriceBetween(@PathVariable BigDecimal price1,@PathVariable BigDecimal price2){
	
	   return new ResponseEntity<>(productService.findByPriceBetween(price1,price2),HttpStatus.OK);
   }
}
