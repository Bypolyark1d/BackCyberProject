package com.example.datab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.datab.User;
import com.example.datab.repository.UserRepository;

@Controller
public class UserController 
{
	@Autowired
	UserRepository userRepository;
	@PostMapping("/login")
	public ResponseEntity<UserDTO> get(@RequestBody UserRequster requster)
	{
		User user = userRepository.findByLogin(requster.login);
		if(user == null|| !user.getPassword().equals(requster.password))
		{
			return ResponseEntity.badRequest().build();
		}
		else
		{
			UserDTO usdtDto = new UserDTO(user.getUserId(),user.getLogin());
			return ResponseEntity.ok(usdtDto);
		}
	}
	@PostMapping("/sign")
	public ResponseEntity<UserDTO> add(@RequestBody UserRequster requster)
	{
		User curUser = new User(requster.getLogin(),requster.getPassword());
		User user = userRepository.findByLogin(requster.login);
		if(user == null)
		{
			userRepository.save(curUser);
			UserDTO usdtDto = new UserDTO(curUser.getUserId(),curUser.getLogin());
			return ResponseEntity.ok(usdtDto);
		}
		else
		{
			return ResponseEntity.badRequest().build();
		}
	}
	static class UserRequster
	{
		String login;
		String password;
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	static class UserDTO
	{
		private Integer id;
		private String login;
		public UserDTO(Integer id, String login) {
			super();
			this.id = id;
			this.login = login;
		}
		public UserDTO()
		{
			
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		
	}
}

