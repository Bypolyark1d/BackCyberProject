package com.example.datab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.datab.Cart;
import com.example.datab.Category;
import com.example.datab.Product;
@Repository
public interface CartProductsRepository extends JpaRepository<Cart, Integer>{
	@Query("select c from Cart c where c.user.id = :id")
	Cart getProducts(Integer id);
	@Query("select c from Cart c where c.user.id = :id")
	Cart getCart(Integer id);
}
