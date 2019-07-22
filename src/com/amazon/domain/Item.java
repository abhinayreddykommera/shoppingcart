package com.amazon.domain;

public class Item {

	private Integer id;
	private String name;
	private Float unitPrice;
	private String description;
	private Integer quantity;

	public Item(Integer id, String name, Float unitPrice, String description, Integer quantity) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.description = description;
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
