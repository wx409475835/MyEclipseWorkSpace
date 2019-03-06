package com.nyist.dbutils.model;

public class Account {
	private int id;
	private String name;
	private double money;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double d) {
		this.money = d;
	}
	public Account(int id, String name, double money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
	}
	public Account() {
		super();
	}
}
