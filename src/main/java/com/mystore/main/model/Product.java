package com.mystore.mystore.model;

public class Product {
	
	private int id;
	private String productName;
	private float price;
	private String productImage;
	private String category;
	
	public Product(int id, String productName, float price, String productImage, String category) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.productImage = productImage;
		this.category = category;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", productImage="
				+ productImage + ", category=" + category + "]";
	}
	
	
	
	

}
