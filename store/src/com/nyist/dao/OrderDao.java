package com.nyist.dao;

import java.util.List;

import com.nyist.domain.Order;
import com.nyist.domain.OrderItem;
import com.nyist.domain.PageBean;
import com.nyist.domain.User;

public interface OrderDao {

	void add(Order order) throws Exception;

	void addItem(OrderItem item) throws Exception;

	List<Order> findAllPage(int currPage, int pageSize, User user) throws Exception;

	int getTotalCount(String uid) throws Exception;

	Order getById(String oid) throws Exception;

	void update(Order order) throws Exception;

	List<Order> findAllByPageOrder(Integer currPage, int i) throws Exception;

	int getTotalCount() throws Exception;

	int getTotalPayCount(int state) throws Exception;
	
	public List<Order> Pay(int state, Integer currPage,int pageSize) throws Exception;
}
