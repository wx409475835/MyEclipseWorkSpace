package com.nyist.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
public class Cart implements Serializable {

	/**
	 * 购物车
	 */
	private static final long serialVersionUID = 1L;
	//使用LinkHashMap 保证有序性	存放购物车项的集合  key=商品Id  CartItem=购物车项
	private LinkedHashMap map = new LinkedHashMap();
	private Double total = 0.0;
	
	//获得 map的values
	public Collection<CartItem> getItems(){
		return map.values();
	}
	
	//添加到购物车
	public void add2Cart(CartItem cartItem){
		//判断 购物车中有无该商品
		String pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			//有
			//设置购买数量+1
			CartItem oItem = (CartItem) map.get(pid);
			//设置 数量
			oItem.setCount(oItem.getCount()+cartItem.getCount());
		}else{
			//将购物车项添加进去
			map.put(cartItem.getProduct().getPid(),cartItem);
			//计算总金额  当前金额+ 小计
			total += cartItem.getSubtotal();
		}
	}
	//删除购物车
	public void removeFormatCart(String id){
		//从集合中删除
		CartItem cartItem = (CartItem) map.remove(id);
		//修改金额
		total-=cartItem.getSubtotal();
	}
	
	//清空购物车
	public void clearCart(){
		//将map置空
		map.clear();
		//将金额置0
		total=0.0;
	}
	
	public LinkedHashMap getMap() {
		return map;
	}
	public void setMap(LinkedHashMap map) {
		this.map = map;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(LinkedHashMap map, Double total) {
		super();
		this.map = map;
		this.total = total;
	}
}
