package com.nyist.cn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.cn.service.BusinessServiceDao;
import com.nyist.cn.service.impl.BusinessService;


public class ListFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BusinessServiceDao service = new BusinessService();
		List list = service.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/listfile.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
