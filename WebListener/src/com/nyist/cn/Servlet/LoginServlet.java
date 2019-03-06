package com.nyist.cn.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.cn.Model.User;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//生成一个User对像
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//将USer对象保存到
		request.getSession().setAttribute("user",user);
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
}
