package com.nyist.domain;

import java.io.Serializable;

public class OrderItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemid;
	private Integer count;
	private double subtotal;
	//包含 那个商品  
	private Product product;
	//属于那个订单
	private Order order;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderItem(String itemid, Integer count, double subtotal, Product product, Order order) {
		super();
		this.itemid = itemid;
		this.count = count;
		this.subtotal = subtotal;
		this.product = product;
		this.order = order;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
