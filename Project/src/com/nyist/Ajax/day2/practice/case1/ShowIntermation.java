package com.nyist.Ajax.day2.practice.case1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class ShowIntermation extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.收集数据
		String username = request.getParameter("username");
		
		//2.service ---dao 查询数据库
		Map<String,User> map = new HashMap<String,User>();
		map.put("suns",new User("1","suns","666666"));
		map.put("xiaohei",new User("2","xiaohei","777777"));
		map.put("lvhg",new User("3","lvhg","88888888"));
		
		User user3 = map.get(username);
		
		//3. 将 Java 对象 转换成Json字符串  打回给Client
		Gson gson = new Gson();
		//将传进来的字符串转换成  Json 字符串
		String jsonString = gson.toJson(user3);
		response.getWriter().print(jsonString);	
	}
}
