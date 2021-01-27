package com.sapient.pc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="category")
	private String category;
	
	@Column(name="color")
	private String color;
	
	@Column(name="size")
	private String size;
	
	@Column(name="offPercent")
	private Integer offPercent;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="quantity")
	private Integer quantity;

	public Product() {
		super();
	}

	public Product(Long productId, String productName, String category, String color, String size, Integer offPercent,
			Double price, Integer quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.color = color;
		this.size = size;
		this.offPercent = offPercent;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getOffPercent() {
		return offPercent;
	}

	public void setOffPercent(Integer offPercent) {
		this.offPercent = offPercent;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
