package com.nyist.Cookie.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.Cookie.model.User;
import com.nyist.Cookie.utils.Content;
import com.sun.xml.bind.v2.schemagen.xmlschema.ComplexContent;

@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("UTF-8");
		
		//获取 登陆用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(username.equals("root")&&password.equals("asd")){
			System.out.println("********************************");
			request.setAttribute("msg","登录成功咯！");
			//判断是否勾选了自动登录
			System.out.println("autoLogin:"+request.getParameter("autoLogin"));
			if(Content.IS_AUTO_LOGIN.equals(request.getParameter("autoLogin"))){
				//创建Cookie
				Cookie cookie = new Cookie("user",username+"#"+password);
				cookie.setMaxAge(900);
				cookie.setPath(request.getSession().getServletContext().getContextPath()+"/");
				response.addCookie(cookie);
				response.sendRedirect(request.getContextPath()+"/product_list.htm");
				return ;
			}
			request.getRequestDispatcher("/msg.html").forward(request, response);
		}else {
			request.setAttribute("msg","登陆失败！很遗憾!");
			request.getRequestDispatcher("/msg.html").forward(request, response);
		}
		
	}
}
