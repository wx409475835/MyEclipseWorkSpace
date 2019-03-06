package com.nyist.Ajax.day3;

import com.google.gson.annotations.Expose;
import com.nyist.Ajax.day2.Address;

public class User {
	@Expose
	private Integer id;
	@Expose
	private String username;
	@Expose
	private String password;
	@Expose
	private Address address;
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
	
	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", address=" + address + "]";
	}
	
}
