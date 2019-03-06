package com.nyist.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.inject.New;

public class Order implements Serializable {

	/**
	 * CREATE TABLE `orders` (
		  `oid` varchar(32) NOT NULL,
		  `ordertime` datetime DEFAULT NULL,
		  `total` double DEFAULT NULL,
		  `state` int(11) DEFAULT NULL,
		  `address` varchar(30) DEFAULT NULL,
		  `name` varchar(20) DEFAULT NULL,
		  `telephone` varchar(20) DEFAULT NULL,
		  `uid` varchar(32) DEFAULT NULL,
		  PRIMARY KEY (`oid`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 */
	private static final long serialVersionUID = 1L;
	private String oid;
	private Date ordertime;
	private Double total;
	private Integer state = 0;		//0  未支付 1已经支付 2发货状态
	private String address;
	private String name;
	private String telephone;
	//属于那个用户
	private User user;
	//包含哪些订单项目
	private List<OrderItem> items = new LinkedList<OrderItem>();
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public Order(String oid, Date ordertime, Double total, Integer state, String address, String name, String telephone,
			User user, List<OrderItem> items) {
		super();
		this.oid = oid;
		this.ordertime = ordertime;
		this.total = total;
		this.state = state;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.user = user;
		this.items = items;
	}
	public Order() {
		super();
	}
}
