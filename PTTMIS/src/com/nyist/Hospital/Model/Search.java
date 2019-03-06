package com.nyist.Hospital.Model;

import java.io.Serializable;

public class Search implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Search(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public Search() {
		super();
	}
}
