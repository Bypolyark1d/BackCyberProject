package com.example.datab;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class ProductDTO 
{
	private Integer id;
	private String name;
	private double price;
	private Integer quantity;
	private String deatails;
	private String image;
	
	
	public ProductDTO(Integer id, String name, double price, Integer quantity, String details, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.deatails = details;
		this.image = image;
	}
	public ProductDTO()
	{
		
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDeatails() {
		return deatails;
	}
	public void setDeatails(String details) {
		this.deatails = details;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
