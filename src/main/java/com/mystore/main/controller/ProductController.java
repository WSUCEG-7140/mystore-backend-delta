package com.mystore.mystore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mystore.mystore.model.Product;
import com.mystore.mystore.repository.ProductRepository;

@RestController
public class ProductController {
	@Autowired
	private Environment environment;
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProductDetails(){
		List<Product> products = new ArrayList<Product>();
		String port = environment.getProperty("local.server.port");
		List<Product> prods = productRepository.findAll();
		for(Product product: prods) {
			products.add(product);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	@GetMapping("/getProducts")
	public ResponseEntity<List<Product>> getProducts(@RequestParam("ids") List<Integer> ids){
		if(ids.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<Product> products = productRepository.findByIds(ids);
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<Product>> getCategoryProducts(@RequestParam String category){
		List<Product> products = productRepository.findByCategory(category);
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}
}
	
	


