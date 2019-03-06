package com.nyist.cn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.cn.service.BusinessServiceDao;
import com.nyist.cn.service.impl.BusinessService;

//列出所有的文件 
@WebServlet("/listservlet")
public class ListServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		BusinessServiceDao service = new BusinessService();
		List list = service.getAll();
	}
}
