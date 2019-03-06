package com.nyist.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用Servlet
 * @author LHG
 *
 */
public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取子类
		Class clazz = this.getClass();
		//2.获取请求方法
		String m = request.getParameter("method");
		if(m==null){
			m="index";
		}
		//3.获得方法对象
		try {
			Method method = clazz.getMethod(m,HttpServletRequest.class,HttpServletResponse.class);
			//4.让方法执行
			String s = (String)method.invoke(this,request,response);
			//5.判断s是否为空
			if(s!=null){
				request.getRequestDispatcher(s).forward(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("问题正在抢修中");
		}
	}
	
	public String index(HttpServletRequest request,HttpServletResponse response){
		return null;
	}
}
