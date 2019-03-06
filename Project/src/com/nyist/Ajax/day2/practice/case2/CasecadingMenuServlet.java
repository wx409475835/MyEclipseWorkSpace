package com.nyist.Ajax.day2.practice.case2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nyist.Ajax.day2.practice.case2.Dao.AjaxMapper;
import com.nyist.Ajax.day2.practice.case2.Service.AjaxService;
import com.nyist.Ajax.day2.practice.case2.Service.Impl.AjaxServiceImpl;
import com.nyist.Ajax.day2.practice.case2.entity.City;

@SuppressWarnings("serial")
public class CasecadingMenuServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1，收集数据
		String country = request.getParameter("city");
		System.out.println(country);
		AjaxService ajaxService = new AjaxServiceImpl();
		List<City> city = ajaxService.queryCityByCountry(country);
		System.out.println(city);
		//2.Service ------>  dao
		/*List<String> bj = new ArrayList<String>();
		bj.add("东城");
		bj.add("西城");
		bj.add("海淀");
		
		List<String> sh = new ArrayList<String>();
		sh.add("浦东");
		sh.add("虹口");
		sh.add("徐家汇");
		
		List<String> tj = new ArrayList<String>();
		tj.add("南开");
		tj.add("河西");
		tj.add("河东");
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("bj",bj);
		map.put("sh",sh);
		map.put("tj",tj);*/
		
		//通过 key 获得 值
		//List<String> singlecity = map.get(city);
		response.setCharacterEncoding("UTF-8");
		//将 java 对象 转换成json 发送到前台页面
		Gson gson = new Gson();
		String jsonString =  gson.toJson(city);
		System.out.println(jsonString);
		response.getWriter().println(jsonString);
	}
}
