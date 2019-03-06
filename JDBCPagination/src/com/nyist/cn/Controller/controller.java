package com.nyist.cn.Controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.nyist.cn.Pagination.PageBean;
import com.nyist.cn.Pagination.QueryInfo;
import com.nyist.cn.Service.PersonService;
import com.nyist.cn.Util.WebUtil;
import com.nyist.cn.mode.person;

@Controller
public class controller {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/show")
	public String show() {
		return "show";
	}
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("AddInfo")
	public String AddInfo(){
		return "AddInfo";
	}
			
	/*=======================================================================================*/
	@RequestMapping("showAllInfoAction")
	public void showAllInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<person> persons = personService.SelectAll();
		System.out.println("persons:"+persons);
		request.getSession(true).setAttribute("persons",persons);
		request.getRequestDispatcher("./show.apex").forward(request, response);
	}
	
	@RequestMapping("AddInfoAction")
	public void AddInfoAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		person pe = new person();
		pe.setName(name);
		personService.AddInfo(pe);
		System.out.println("添加数据成功!");
		request.getRequestDispatcher("/showAllInfoAction.apex").forward(request,response);
	}
	
	@RequestMapping("DeleteInfoAction")
	public void DeleteInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String id  = request.getParameter("id");
		personService.DeleteInfo(id);
		System.out.println("删除数据成功");
		request.getRequestDispatcher("/showAllInfoAction.apex").forward(request, response);
	}
	
	//处理用户分页请求
	@RequestMapping("pageQueryAction")
	public void pageQuery(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		/*QueryInfo queryInfo = new QueryInfo();
		String currentpage = request.getParameter("currentpage"); 
		System.out.println("currentPage:"+currentpage);
		if(currentpage!=null){
			int cur = Integer.parseInt(currentpage);
			queryInfo.setCurrentpage(cur);
		}
		String pageszie = request.getParameter("pagesize");
		System.out.println("pagesize:"+pageszie);
		if(pageszie != null){
			int size = Integer.parseInt(pageszie);
			queryInfo.setPagesize(size);
		}*/
		QueryInfo queryInfo = WebUtil.request2Bean(request, QueryInfo.class);
		PageBean pageBean = personService.pageQuery(queryInfo);
		System.out.println("PageBean:"+pageBean);
		session.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/show.apex").forward(request, response);
	}
	
	@RequestMapping("SearchAction")
	public void Search(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		String key = request.getParameter("q");
		key = new String(key.getBytes("iso8859-1"),"UTF-8");
		System.out.println("Key:"+key);
		//调用Service
		List<person> per = personService.search(key);
		System.out.println("per:"+per.toString());
		Gson gson = new Gson();
		String stringtoJson = gson.toJson(per);
		System.out.println("StringToJson:"+stringtoJson);
		response.getWriter().write("KISSY.Suggest.callback({'result':"+stringtoJson+"})");
	}
}
