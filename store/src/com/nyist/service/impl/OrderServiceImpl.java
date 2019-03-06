package com.nyist.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.SQLException;
import java.util.List;

import javax.swing.ListModel;

import com.nyist.dao.OrderDao;
import com.nyist.dao.impl.OrderDaoImpl;
import com.nyist.domain.Order;
import com.nyist.domain.OrderItem;
import com.nyist.domain.PageBean;
import com.nyist.domain.User;
import com.nyist.service.OrderService;
import com.nyist.utils.DataSourceUtils;

import net.sf.ehcache.search.expression.Or;

public class OrderServiceImpl implements OrderService {

	@Override
	public void add(Order order) throws Exception{
		try {
			//开启事务
			DataSourceUtils.startTransaction();
			
			OrderDao od = new OrderDaoImpl();
			//向order中添加一条数据
			od.add(order);
			//向orders中添加n条数据
			for (OrderItem item : order.getItems()) {
				od.addItem(item);
			}
			//4.事务处理
			DataSourceUtils.commitAndClose();
		} catch (SQLException e) {
			e.printStackTrace();
			DataSourceUtils.rollbackAndClose();
			throw new RuntimeException(e);
		}
		
	}

	//分页查询
	@Override
	public PageBean<Order> findAllByPage(int currPage, int pageSize, User user) throws Exception {
		//查询当前页
		OrderDao dao = new OrderDaoImpl();
		List<Order> list = dao.findAllPage(currPage,pageSize,user);
		//查询总条数
		int totalCount = dao.getTotalCount(user.getUid());
		return new PageBean<Order>(list, currPage, pageSize, totalCount);
	}

	//查看订单详情
	@Override
	public Order getById(String oid) throws Exception {
		OrderDao dao = new OrderDaoImpl();
		return dao.getById(oid);
	}

	@Override
	public Order getOrderByOid(String oid) throws Exception {
		OrderDao dao = new OrderDaoImpl();
		return dao.getById(oid);
	}

	@Override
	public void update(Order order) throws Exception {
		OrderDao dao = new OrderDaoImpl();
		dao.update(order);
	}

	@Override
	public PageBean<Order> findAllByPageOrder(Integer currPage, int i) throws Exception {
		PageBean<Order> oBean = new PageBean<Order>();
		OrderDao dao = new OrderDaoImpl();
		List<Order> oList = dao.findAllByPageOrder(currPage,i);
		int totalCount = dao.getTotalCount();
		oBean.setCurrPage(currPage);
		oBean.setList(oList);
		oBean.setPageSize(i);
		oBean.setTotalCount(totalCount);
		oBean.getTotalPage();
		return oBean; 
	}

	@Override
	public Order getDetailByOid(String oid) throws Exception {
		return new OrderServiceImpl().getById(oid);
	}

	public PageBean<Order> NotPay(int state, Integer currPage, int pageSize) throws Exception {
		PageBean<Order> oBean = new PageBean<Order>();
		List<Order> orderItems = new OrderDaoImpl().Pay(state, currPage,pageSize);
		System.out.println("orderItems:"+orderItems);
		Integer totalCount = new OrderDaoImpl().getTotalPayCount(state);
		oBean.setCurrPage(currPage);
		oBean.setPageSize(pageSize);
		oBean.setList(orderItems);
		oBean.setTotalCount(totalCount);
		oBean.getTotalPage();
		return oBean;
	}

	public PageBean<Order> HadPay(Integer state, Integer currPage, int pageSize) throws Exception {
		PageBean<Order> oBean = new PageBean<Order>();
		List<Order> orderItems = new OrderDaoImpl().Pay(state, currPage,pageSize);
		System.out.println("orderItems:"+orderItems);
		Integer totalCount = new OrderDaoImpl().getTotalPayCount(state);
		oBean.setCurrPage(currPage);
		oBean.setPageSize(pageSize);
		oBean.setList(orderItems);
		oBean.setTotalCount(totalCount);
		oBean.getTotalPage();
		return oBean;
	}
}
