package com.example.datab;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	private String login;
	private String password;
	
	public User()
	{
		
	}
	public User(String login,String password)
	{
		this.login = login;
		this.password = password;
	}
	public void setUser_id(Integer user_id)
	{
		this.user_id = user_id;
	}
	public void setLogin(String login)
	{
		this.login = login;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public int getUserId()
	{
		return user_id;
	}
	public String getLogin()
	{
		return login;
	}
	public String getPassword()
	{
		return password;
	}
}
