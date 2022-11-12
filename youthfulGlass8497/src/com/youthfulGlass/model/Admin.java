package com.youthfulGlass.model;

import java.util.Objects;

public class Admin {

	private String username = "myRoot";
	private String password = "root";
	
	
//	public Admin(String username, String password) {
//		super();
//		this.username = username;
//		this.password = password;
//	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
