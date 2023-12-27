package com.example.datab;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Cart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@OneToOne
	User user;
	@ManyToMany
	@JoinTable(name ="cart_products",joinColumns = @JoinColumn(name = "cart_id",nullable = false),inverseJoinColumns = @JoinColumn(name ="product_id",nullable = false))
	List<Product> productList;
	public Cart(Integer id, User user, List<Product> productList) {
		super();
		this.id = id;
		this.user = user;
		this.productList = productList;
	}
	public Cart()
	{
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
