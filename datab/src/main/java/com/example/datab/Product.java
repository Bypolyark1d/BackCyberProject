package com.example.datab;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private double price;
	private Integer quantity;
	@Column(length = 1500)
	private String deatails;
	@ManyToOne
	private Category category;
	private String image;
	public Product() 
	{
		super();
	}
	public Product(String name, double price, Integer quantity, String deatails, Category category,String image) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.deatails = deatails;
		this.category = category;
	}
	public Integer getId() {
		return id;
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
	public void setDeatails(String deatails) {
		this.deatails = deatails;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
