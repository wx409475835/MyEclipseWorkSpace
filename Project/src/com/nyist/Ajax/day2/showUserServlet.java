package com.nyist.Ajax.day2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class showUserServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.收集客户端传过来的数据
		String name = request.getParameter("name");
		
		//2.调用Service ---->dao 查询user对象
		Map<String,User1> dbs = new HashMap<String,User1>();
		dbs.put("suns",new User1(1,"suns","123456"));
		dbs.put("xiaohei",new User1(2,"xiaohei","123456"));
		dbs.put("lvhg",new User1(3,"lvhg","123456"));
		
		//通过 key 的方式 获得值
		User1 user = dbs.get(name);
		
		//将  java 对象 转换成Json 字符串
		Gson gson = new Gson();
		String jsonString = gson.toJson(user);
		response.getWriter().print(jsonString);
	}
}
