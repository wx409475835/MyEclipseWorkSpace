package com.nyist.web.servlet;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.domain.Category;
import com.nyist.service.CategoryService;
import com.nyist.service.impl.CategoryServiceImpl;
import com.nyist.utils.UUIDUtils;

/**
 * Servlet implementation class adminCategory
 */
@WebServlet("/adminCategory")
public class adminCategory extends BaseServlet {
	private static final long serialVersionUID = 1L;

   public String findAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   request.removeAttribute("list");
	   //1.调用categoreService 查询所有的分类信息
	   CategoryService s = new CategoryServiceImpl();
	   List<Category> list = s.findAllCategory();
	   //2.将查询结果放在List中 放入request狱中 请求转发
	   request.setAttribute("list",list);
	   return "/admin/category/list.jsp";
   }
   
   //添加分类
   public String addUI(HttpServletRequest request,HttpServletResponse response){
	   //1.
	   return "/admin/category/add.jsp";
   }
   
   //添加分类实现
   public String add(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   String cname = request.getParameter("cname");
	   Category category = new Category();
	   category.setCid(UUIDUtils.getId());
	   category.setCname(cname);
	   CategoryService categoryService = new CategoryServiceImpl();
	   categoryService.add(category);
	   response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
	   return null;
   }
   
   public String getById(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   request.setAttribute("bean",new CategoryServiceImpl().getById(request.getParameter("cid")));
	   return "/admin/category/edit.jsp";
	}
	
	public String update(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category(cid, cname);
		categoryService.update(category);
		response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
		return null;
	}
	
	public String delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String cid = request.getParameter("cid");
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.delete(cid);
		response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
		return null;
	}
}
