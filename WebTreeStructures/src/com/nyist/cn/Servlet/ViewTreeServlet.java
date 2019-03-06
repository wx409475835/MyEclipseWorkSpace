package com.nyist.cn.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.cn.Service.TreeService;
import com.nyist.cn.model.Tree;

public class ViewTreeServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		TreeService service = new TreeService();
		Tree tree = service.findTrees(id);
		request.getSession().setAttribute("tree",tree);
		request.getRequestDispatcher("/viewTree.jsp").forward(request, response);
	}
}
