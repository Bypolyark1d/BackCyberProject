package com.example.datab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.datab.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>
{
	@Query("select o from Order o where o.user.id = :id")
	List<Order>getOrder(Integer id);
	
}
