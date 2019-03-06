package com.nyist.webFilter.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterDemo1 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 filter在开发中的常见应用
	 	1.filter可以以目标
	 */
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("FilterDemo1-拦截成功");
		chain.doFilter(request, response);
		System.out.println("FilterDemo1-放行通过！");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
