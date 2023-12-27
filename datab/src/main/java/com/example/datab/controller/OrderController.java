package com.example.datab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.datab.Cart;
import com.example.datab.Order;
import com.example.datab.OrderDTO;
import com.example.datab.Status;
import com.example.datab.User;
import com.example.datab.repository.CartProductsRepository;
import com.example.datab.repository.OrderRepository;
import com.example.datab.repository.UserRepository;

@Controller
public class OrderController 
{
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartProductsRepository cartProductsRepository;
	@GetMapping(value = "/user/{id}/order/")
	public ResponseEntity<List<OrderDTO>>get(@PathVariable Integer id)
	{
		List<Order> ordlsit = orderRepository.getOrder(id);
		List<OrderDTO> listDTO = new ArrayList();
		for(Order i:ordlsit)
		{
			listDTO.add(new OrderDTO(i.getId(),i.getPriceOrder(),i.getStatus()));
		}
		return ResponseEntity.ok(listDTO);
	}
	@PostMapping(value = "/user/{id}/order/")
	public ResponseEntity<Void>add(@PathVariable Integer id,@RequestParam Integer price)
	{
		User cuUser = userRepository.findById(id).get();
		Order order  = new Order(cuUser,price,Status.ACCEPTED);
		orderRepository.save(order);
		Cart cuCart = cartProductsRepository.getCart(id);
		cartProductsRepository.delete(cuCart);
		return ResponseEntity.ok().build();
	}
	
	
}
