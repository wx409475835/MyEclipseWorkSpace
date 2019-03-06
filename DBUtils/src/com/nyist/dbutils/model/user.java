package com.nyist.dbutils.model;

import java.io.Serializable;
import java.util.Date;

public class user implements Serializable{
	private int id;
	private String name;
	private String password;
	private String email;
	private Date birthday;
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected Date getBirthday() {
		return birthday;
	}
	protected void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public user(int id, String name, String password, String email, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
	}
	public user() {
		super();
	}
}
