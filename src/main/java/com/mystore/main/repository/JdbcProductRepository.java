package com.mystore.mystore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mystore.mystore.ProductzMapper;
import com.mystore.mystore.model.Product;

@Repository
public class JdbcProductRepository implements ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from products", BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public List<Product> findByIds(List<Integer> ids) {
		List<Product> productsById = new ArrayList<>();
		for(Integer id: ids) {
			String sql = "SELECT * FROM products WHERE id IN (?)"; 
			Product p = jdbcTemplate.queryForObject(sql, new Object[] {id}, new ProductzMapper());
			productsById.add(p);
		}
		
		return productsById;
			
	
	}

	@Override
	public List<Product> findByCategory(String category) {
		String q = "SELECT * from products WHERE category=?";

	    return jdbcTemplate.query(q, new Object[] {category}, BeanPropertyRowMapper.newInstance(Product.class));	
	    }

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
