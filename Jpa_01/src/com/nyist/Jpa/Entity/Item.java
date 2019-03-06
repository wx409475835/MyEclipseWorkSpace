package com.nyist.Jpa.Entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Table(name="jpa_item")
@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="item_name")
	private String itemName;
	/**
	 * 使用 @ManyToMany  注解来映射多对多关联映射关系
	 * 使用@JoinTable	来映射中间表
	 * 1.name	指向中间表的名称
	 * 2.joinColumns	映射当前类所在的表在中间表的外键
	 * 	2.1	name	制定外键列名
	 * 	2.2	referencedColumnName	指定外键列关联当前表的那一列
	 * 3.inverseJoinColumns	映射关联的类所在中间表的外键
	 * 当前类所在的表在中间表的外键
	 */
	@JoinTable(name="jpa_item_category",
			joinColumns={@JoinColumn(name="item_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="category_id",referencedColumnName="id")})
	@ManyToMany
	private Set<Category> categories = new HashSet<Category>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", categories=" + categories + "]";
	}
}
