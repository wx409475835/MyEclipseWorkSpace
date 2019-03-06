package com.nyist.web.servlet;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nyist.dao.impl.OrderDaoImpl;
import com.nyist.domain.Order;
import com.nyist.domain.OrderItem;
import com.nyist.domain.PageBean;
import com.nyist.service.OrderService;
import com.nyist.service.impl.OrderServiceImpl;

public class AdminOrder extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	//查询所有订单
	public String findAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Integer currPage = Integer.parseInt(request.getParameter("currPage"));
		OrderService oService = new OrderServiceImpl();
		PageBean<Order> bean = oService.findAllByPageOrder(currPage, 25);
		request.getSession(true).setAttribute("bean",bean);
		return "/admin/order/list.jsp";
	}
	
	public String updateState(HttpServletRequest request,HttpServletResponse response){
		
		return null;
	}
	
	public String getDetailByOid(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String oid = request.getParameter("oid");
		OrderService orderService = new OrderServiceImpl();
		//拿到订单项
		List<OrderItem> order = orderService.getById(oid).getItems();
		Gson gson = new Gson();
		String jsontoString = gson.toJson(order);
		System.out.println("jsontostring:"+jsontoString);
		response.getWriter().print(jsontoString);
		return null;
	}
	
	//未支付订单
	public String NotPay(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Integer state = Integer.parseInt(request.getParameter("state"));
		System.out.println("state:"+state);
		Integer currPage = Integer.parseInt(request.getParameter("currPage"));
		System.out.println("currPage:"+currPage);
		int pageSize = 15;
		PageBean<Order> oBean = new OrderServiceImpl().NotPay(state,currPage,pageSize);
		System.out.println("Obean:"+oBean);
		request.getSession(true).setAttribute("bean",oBean);
		return "/admin/order/NotPay.jsp";
	}
	
	//已支付订单
	public String HadPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer state = Integer.parseInt(request.getParameter("state"));
		System.out.println("state:" + state);
		Integer currPage = Integer.parseInt(request.getParameter("currPage"));
		System.out.println("currPage:" + currPage);
		int pageSize = 15;
		PageBean<Order> oBean = new OrderServiceImpl().HadPay(state, currPage, pageSize);
		System.out.println("Obean:" + oBean);
		request.getSession(true).setAttribute("bean", oBean);
		return "/admin/order/HadPay.jsp";
	}
	
	//已发货订单
	public String HadStart(HttpServletRequest request, HttpServletResponse response) throws Exception {
			Integer state = Integer.parseInt(request.getParameter("state"));
			System.out.println("state:" + state);
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			System.out.println("currPage:" + currPage);
			int pageSize = 15;
			PageBean<Order> oBean = new OrderServiceImpl().HadPay(state, currPage, pageSize);
			System.out.println("Obean:" + oBean);
			request.getSession(true).setAttribute("bean", oBean);
			return "/admin/order/HadStart.jsp";
	}
	
	//已完成
	public String HadFinish(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer state = Integer.parseInt(request.getParameter("state"));
		System.out.println("state:" + state);
		Integer currPage = Integer.parseInt(request.getParameter("currPage"));
		System.out.println("currPage:" + currPage);
		int pageSize = 15;
		PageBean<Order> oBean = new OrderServiceImpl().HadPay(state, currPage, pageSize);
		System.out.println("Obean:" + oBean);
		request.getSession(true).setAttribute("bean", oBean);
		return "/admin/order/HadFinish.jsp";
	}
}
