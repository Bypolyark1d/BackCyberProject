package com.example.datab.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.datab.Product;
import com.example.datab.ProductDTO;
import com.example.datab.repository.ProductRepository;

@Controller
public class ProductController 
{
	@Autowired
	ProductRepository productRepository;
	@GetMapping(value = "/product/{product_id}",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamResource> getimage(@PathVariable Integer product_id)
	{
		Product a  = productRepository.findById(product_id).get();
		try
		{
			FileInputStream fith = new FileInputStream(a.getImage());
			return ResponseEntity.ok(new InputStreamResource(fith));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	@ResponseBody
	@GetMapping(value = "category/{category_id}")
	public List<ProductDTO> getProduct(@PathVariable Integer category_id)
	{
		List<Product> a = productRepository.findByCategory(category_id);
		List<ProductDTO> b = new ArrayList<ProductDTO>(); 
		for(Product i:a)
		{
			b.add(new ProductDTO(i.getId(),i.getName(),i.getPrice(),i.getQuantity(),i.getDeatails(),i.getImage()));
		}
		return b;
	}
}
