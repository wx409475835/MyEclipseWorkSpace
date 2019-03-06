package com.nyist.service;

import com.nyist.domain.Order;
import com.nyist.domain.PageBean;
import com.nyist.domain.User;

public interface OrderService {

	void add(Order order) throws Exception;
	
	PageBean<Order> findAllByPage(int currPage,int pageSize,User user) throws Exception;

	Order getById(String oid) throws Exception;

	Order getOrderByOid(String oid) throws Exception;

	void update(Order order) throws Exception;

	PageBean<Order> findAllByPageOrder(Integer currPage, int i) throws Exception;

	Order getDetailByOid(String oid) throws Exception;
	
	public PageBean<Order> NotPay(int state, Integer currPage,int pageSize) throws Exception;
}
