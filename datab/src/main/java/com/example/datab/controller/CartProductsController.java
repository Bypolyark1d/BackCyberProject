package com.example.datab.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.datab.Cart;
import com.example.datab.CartDTO;
import com.example.datab.Product;
import com.example.datab.ProductDTO;
import com.example.datab.User;
import com.example.datab.controller.UserController.UserRequster;
import com.example.datab.repository.CartProductsRepository;
import com.example.datab.repository.ProductRepository;
import com.example.datab.repository.UserRepository;
@Controller
public class CartProductsController 
{
	@Autowired
	CartProductsRepository cartRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@GetMapping("/user/{id}/cart")
	public ResponseEntity<CartDTO> get(@PathVariable Integer id)
	{
		Cart a = cartRepository.getProducts(id);
		List<ProductDTO> b = new ArrayList<ProductDTO>(); 
		for(Product i:a.getProductList())
		{
			b.add(new ProductDTO(i.getId(),i.getName(),i.getPrice(),i.getQuantity(),i.getDeatails(),i.getImage()));
		}
		CartDTO z = new CartDTO(a.getId(),b);
		return ResponseEntity.ok(z);
	}
	@PostMapping("/user/{userId}/cart/product/{productId}")
	public ResponseEntity<Void> save(@PathVariable Integer userId, @PathVariable Integer productId)
	{
		Cart cart = cartRepository.getCart(userId);
		Product product = productRepository.findById(productId).get();
		if(cart == null)
		{
			User user = userRepository.findById(userId).get();
			cart = new Cart();
			cart.setUser(user);
			cart.setProductList(Arrays.asList(product));
		}
		else
		{
			cart.getProductList().add(product);
		}
		cartRepository.save(cart);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/cart/{cartId}/product/{productId}")
	public ResponseEntity<Void> delete(@PathVariable Integer cartId, @PathVariable Integer productId)
	{
		Cart cart = cartRepository.findById(cartId).get();
		Product product = productRepository.findById(productId).get();
		cart.getProductList().remove(product);
		cartRepository.save(cart);
		return ResponseEntity.noContent().build();
	}
}
