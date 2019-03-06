package com.nyist.domain;

import java.io.Serializable;

public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Product product;		//商品对象
	private Integer count;			//商品数量
	private Double subtotal = 0.0;	//小计
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return product.getShop_price()*count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public CartItem(Product product, Integer count) {
		super();
		this.product = product;
		this.count = count;
	}
	public CartItem() {
		super();
	}
	
}
