package com.nyist.cn.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.cn.Service.TreeService;
import com.nyist.cn.model.Tree;

public class AddTree extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {	
			String pid = request.getParameter("pid");
			String name = request.getParameter("name");
			TreeService tree = new TreeService();
			tree.addTree(pid, name);
			request.getSession().setAttribute("message","添加成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("message","添加失败");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
