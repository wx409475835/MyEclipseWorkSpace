package com.nyist.Ajax;

public class Address {
	private String city;
	private String zipcode;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Address(String city, String zipcode) {
		super();
		this.city = city;
		this.zipcode = zipcode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
}
