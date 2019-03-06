package com.nyist.Ajax.day2.practice.case2.entity;

public class City {
	private String conutry;
	private String area;
	public String getConutry() {
		return conutry;
	}
	public void setConutry(String conutry) {
		this.conutry = conutry;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public City(String conutry, String area) {
		super();
		this.conutry = conutry;
		this.area = area;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "City [conutry=" + conutry + ", area=" + area + "]";
	}
	
}
