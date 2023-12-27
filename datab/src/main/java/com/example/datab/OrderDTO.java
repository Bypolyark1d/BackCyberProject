package com.example.datab;

public class OrderDTO 
{
	Integer id;
	Integer priceorder;
	Status status;
	public OrderDTO(Integer id, Integer orderPrice ,Status status) {
		super();
		this.id = id;
		this.priceorder = orderPrice;
		this.status = status;
	}
	
	public OrderDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getPriceorder() {
		return priceorder;
	}

	public void setPriceorder(Integer priceorder) {
		this.priceorder = priceorder;
	}
	
}

