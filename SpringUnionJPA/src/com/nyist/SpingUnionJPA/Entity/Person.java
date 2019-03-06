package com.nyist.SpingUnionJPA.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="jpa_person")
@Entity
public class Person {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(length=10,unique=true,nullable=false)
	private Integer id;
	@Column(name="last_name",length=255)
	private String lastName;
	@Column(name="email",length=255)
	private String email;
	@Column(name="age",length=11,nullable=false)
	private Integer age;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Person(Integer id, String lastName, String email, Integer age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}
	
	
}
