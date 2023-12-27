package com.example.datab;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "_order")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@JoinColumn(name = "user_id")
	@ManyToOne
	User user;
	Integer priceOrder;
	Status status;
	public Order(User user, Integer priceOrder, Status status) {
		super();
		this.user = user;
		this.priceOrder = priceOrder;
		this.status = status;
	}
	public Order() {
		super();
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
	public Integer getPriceOrder() {
		return priceOrder;
	}
	public void setPriceOrder(Integer priceOrder) {
		this.priceOrder = priceOrder;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
