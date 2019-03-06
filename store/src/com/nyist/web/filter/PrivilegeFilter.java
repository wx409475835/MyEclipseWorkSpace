package com.nyist.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.domain.User;

@WebFilter(urlPatterns="/jsp/cart.jsp")

public class PrivilegeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.强转
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//2.业务逻辑
		//从session中获取user 判断user是否为空
		User user = (User)req.getSession(true).getAttribute("user");
		if(user==null){
			req.getSession(true).setAttribute("msg","请先登陆吧！");
			req.getRequestDispatcher("/jsp/msg.jsp").forward(req, resp);
			return ;
		}
		//3.放行
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
