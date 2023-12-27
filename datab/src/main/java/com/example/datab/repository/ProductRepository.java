package com.example.datab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.datab.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query("select p from Product p inner join p.category c where c.id = :category")
	List<Product>findByCategory(Integer category);
}
