package com.nyist.Ajax.day3;

import com.google.gson.annotations.Expose;

public class Address {
	@Expose
	private String city;
	@Expose
	private String zipcode;
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
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
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String city, String zipcode, Customer customer) {
		super();
		this.city = city;
		this.zipcode = zipcode;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", zipcode=" + zipcode + ", customer="
				+ customer + "]";
	}
	
}
