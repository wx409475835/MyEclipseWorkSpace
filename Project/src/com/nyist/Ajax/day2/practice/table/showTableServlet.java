package com.nyist.Ajax.day2.practice.table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nyist.Ajax.day2.User1;

@SuppressWarnings("serial")
public class showTableServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//1.收集数据
		
		//2.service ------>Dao 处理数据
		User1 u1 = new User1(1,"suns","123456");
		User1 u2 = new User1(2,"lvhg","123456");
		User1 u3 = new User1(3,"lixq","123456");
		List<User1> list = new ArrayList<User1>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		//将数据转化为json字符串
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		response.getWriter().println(jsonString);
	}	
}
