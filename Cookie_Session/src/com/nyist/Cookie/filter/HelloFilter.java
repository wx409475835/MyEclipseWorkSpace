package com.nyist.Cookie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/*")
public class HelloFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("收到了请求!");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		Cookie cookie = getCookieByName("user",request.getCookies());
		System.out.println("(((((:"+cookie);
		if(cookie!=null){
			String val = cookie.getValue();
			System.out.println("username:"+val.split("\\#")[0]);
			request.setAttribute("aaaaaaaaaausername",val.split("\\#")[0]);
			request.setAttribute("password",val.split("#")[1]);
		}
		chain.doFilter(request, response);
	}

	private Cookie getCookieByName(String value, Cookie[] cookies) {
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(value.equals(cookie.getName())){
					return cookie;
				}
			}
		}
		return null;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
