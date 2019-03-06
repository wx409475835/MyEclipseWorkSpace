package com.nyist.Jpa.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="jpa_order")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String orderName;
	//如何映射 单项 多对一 的 n-1的关系
	//@JoinColumn	外键列的列名称
	//使用@ManyToOne	来映射多对一
	//使用@JoinColumn 映射外键
	//@ManyToOne 使用fetch 方法来改变默认关联属性的加载策略
	/**fetch: 表示该属性的读取策略,有 EAGER 和 LAZY 两种,分别表示主支抓取和延迟加载,默认为 EAGER.
	 *  FetchType.LAZY：懒加载，加载一个实体时，定义懒加载的属性不会马上从数据库中加载。
　　		FetchType.EAGER：急加载，加载一个实体时，定义急加载的属性会立即从数据库中加载。
	 */
	@JoinColumn(name="customer_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Order(Integer id, String orderName, Customer customer) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.customer = customer;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + "]";
	}
	
}
