package com.nyist.SpringData.Entity;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Table(name="JPA_PERSON")
@Entity
public class Person {
	
	//@GeneratedVale 自动生成主键
	@GeneratedValue
	@Id				//指定ID
	private Integer id;
	private String lastName;
	private String email;
	private Date birth;
	//@ManyToOne  多对1   一个人对应多个地址
	@JoinColumn(name="ADDRESS")
	@ManyToOne
	private Address address;
	@Column(name="ADD_ID")
	private Integer addressId;
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", email=" + email + ", birth=" + birth + "]";
	}
	
}
