package com.nyist.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.domain.Category;
import com.nyist.service.CategoryService;
import com.nyist.service.impl.CategoryServiceImpl;
import com.nyist.utils.JsonUtil;

public class CategoryServlet extends BaseServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将查询的商品放到request域中
		// 1.调用cateogoryservice 查询所有分类 返回List
		CategoryService cs =  new CategoryServiceImpl();
		List<Category> clist = null;
		try {
			clist = cs.findAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.将数据以json的格式返回到界面上
		//request.setAttribute("clist", clist);
		String json = JsonUtil.list2json(clist);
		//写回页面
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
		return null;
	}
}
