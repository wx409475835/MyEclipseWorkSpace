package com.nyist.cn.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.cn.Dao.TreeDao;
import com.nyist.cn.Service.TreeService;
import com.nyist.cn.model.Tree;

public class ListTreeServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TreeService service = new TreeService();
		List<Tree> list = service.getAllTree();
		request.getSession().setAttribute("list",list);
		request.getRequestDispatcher("/listtree.jsp").forward(request, response);
	}

}
