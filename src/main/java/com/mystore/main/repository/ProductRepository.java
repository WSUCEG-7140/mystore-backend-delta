package com.mystore.mystore.repository;

import java.util.List;

import com.mystore.mystore.model.Product;

public interface ProductRepository {
	  List<Product> findAll();
	  List<Product> findByIds(List<Integer> ids);
	  Product findById(Integer id);
	  List<Product> findByCategory(String category);
}
