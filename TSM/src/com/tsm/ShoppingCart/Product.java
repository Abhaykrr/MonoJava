package com.tsm.ShoppingCart;

public class Product {

	private int id;
	private String name;
	private Double price;
	private Double discountPercent;
	
	public Product(int id, String name, Double price, Double discountPercent) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.discountPercent = discountPercent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public double calculateDiscountedPrice() {
		
		double revisedPrice = this.price -(double)(this.discountPercent*this.price)/100;
		return revisedPrice;
	}
	
	
	
}
