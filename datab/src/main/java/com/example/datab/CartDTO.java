package com.example.datab;

import java.util.List;

public class CartDTO 
{
	Integer id;
	List<ProductDTO> listproduct;
	public CartDTO(Integer id, List<ProductDTO> listproduct) {
		super();
		this.id = id;
		this.listproduct = listproduct;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<ProductDTO> getListproduct() {
		return listproduct;
	}
	public void setListproduct(List<ProductDTO> listproduct) {
		this.listproduct = listproduct;
	}
	
}
