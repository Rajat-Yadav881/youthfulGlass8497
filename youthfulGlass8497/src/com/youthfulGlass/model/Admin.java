package com.youthfulGlass.model;

public class Admin {

	private String username = "myRoot";
	private String password = "root";
	
	



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
