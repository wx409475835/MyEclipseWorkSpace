package com.nyist.Jpa.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="jpa_category")
@Entity
public class Category {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;
	@Column(name="category_name")
	private String categoryName;
	@ManyToMany(mappedBy="categories") 
	private Set<Item> items = new HashSet<Item>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<Item> getSet() {
		return items;
	}
	public void setSet(Set<Item> set) {
		this.items = set;
	}
	public Category(Integer id, String categoryName, Set<Item> set) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.items = set;
	}

	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", set=" + items + "]";
	}
	
}
