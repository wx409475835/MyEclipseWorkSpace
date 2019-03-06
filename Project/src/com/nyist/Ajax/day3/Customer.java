package com.nyist.Ajax.day3;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	private Integer id;
	private String username;
	private Date birthday;
	private Address adderess;
	
	public Address getAdderess() {
		return adderess;
	}
	public void setAdderess(Address adderess) {
		this.adderess = adderess;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer id, String username, Date birthday,Address address) {
		super();
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.adderess = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", birthday="
				+ birthday + ", adderess=" + adderess + "]";
	}
	
}
