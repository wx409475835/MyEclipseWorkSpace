package com.nyist.cn.Servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//get请求乱码解决
		//request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso8859-1"),"UTF-8");
		Map map = (Map) this.getServletContext().getAttribute("map");
		HttpSession session = (HttpSession) map.get(username);
		if(session!=null){
			session.invalidate(); 										//从session集合中删除sessionID
			map.remove(username);										//从map集合中删除属性为username,值为session的记录
		}
		System.out.println("哈哈哈");
		request.getRequestDispatcher("/AllPerson.jsp").forward(request, response);
	}
}
