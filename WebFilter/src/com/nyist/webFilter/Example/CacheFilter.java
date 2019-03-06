package com.nyist.webFilter.Example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {

	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		//1.获得浏览器想访问的资源
		String uri = request.getRequestURI();
		//2.获得该资源的时间
		int expires = 0;
		if(uri.endsWith("jpg")){
			expires = Integer.parseInt(this.config.getInitParameter("jpg"));
		}else if(uri.endsWith("css")){
			expires = Integer.parseInt(this.config.getInitParameter("css"));
		}else{
			expires = Integer.parseInt(this.config.getInitParameter("js"));
		}
		
		response.setDateHeader("expires",System.currentTimeMillis()+expires*60*1000);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = filterConfig;
	}

}
