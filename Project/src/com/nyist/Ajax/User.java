package com.nyist.Ajax;

public class User {
	private Integer id;
	private String username;
	private String password;
	
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	public User(Integer id, String username, String password, Address address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
