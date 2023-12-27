package com.example.datab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.datab.User;

public interface UserRepository extends CrudRepository<User,Integer>
{
	User findByLogin(String login);
	List<User> findAll();
}
