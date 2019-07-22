package com.amazon.domain;

public class Summary {

	private String name;
	private Integer quantity;
	private Float totalPrice;
	
	

	public Summary(String name, Integer quantity, Float totalPrice) {
		this.name = name;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
