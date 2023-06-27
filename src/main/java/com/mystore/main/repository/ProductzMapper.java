package com.mystore.mystore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mystore.mystore.model.Product;

public class ProductzMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rSet, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Product product = new Product();
		product.setId(rSet.getInt("id"));
		product.setProductName(rSet.getString("productname"));
		product.setPrice(rSet.getFloat("price"));
		product.setProductImage(rSet.getString("productimage"));
		product.setCategory(rSet.getString("category"));
		return product;
		
	}
	

}
