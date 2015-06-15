package com.pehulja.mongo.model;

public class Item {
	private Long id;
	private int quntity;
	private double price;
	private String product;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", quntity=" + quntity + ", price=" + price
				+ ", product=" + product + "]";
	}
	
	
}
