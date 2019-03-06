package com.nyist.cn.mode;

import java.io.Serializable;

public class person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "person [id=" + id + ", name=" + name + "]";
	}
	public person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
