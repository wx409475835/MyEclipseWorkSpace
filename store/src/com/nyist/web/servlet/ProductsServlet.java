package com.nyist.web.servlet;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nyist.domain.PageBean;
import com.nyist.domain.Product;
import com.nyist.service.ProductService;
import com.nyist.service.impl.ProductServiceImpl;
import com.nyist.utils.CookUtils;
public class ProductsServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String select(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProductService productService = new ProductServiceImpl();
		List<Product> hot = productService.findHot();
		List<Product> ne= productService.findNew();
		request.getSession(true).setAttribute("hotProducts",hot);
		request.getSession(true).setAttribute("newProducts",ne);
		return "/jsp/index.jsp";
	}
	
	public String show(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//1.获取商品ID
		String pid = request.getParameter("pid");
		//2.调用Service
		ProductService productService = new ProductServiceImpl();
		request.getSession(true).setAttribute("product",productService.getProductById(pid));
		Cookie cookie = CookUtils.getCookieByName("ids", request.getCookies());
		String s = null;
		if (cookie == null) {
			System.out.println("***********************");
			System.out.println("******Cookie为空了******");
			System.out.println("***********************");
			// 将浏览记录Id 保存到Cookie中
			cookie = new Cookie("ids", pid);
			cookie.setMaxAge(31536000);
			cookie.setPath("http://localhost:8888/store/products?method=show");
		} else {
			if(cookie.getValue()==null){
				System.out.println("***********************");
				System.out.println("****cookie-value:"+pid+"****");
				System.out.println("****Cookie Value为空****");
				System.out.println("***********************");
				cookie.setValue(pid);
			}else {
				if(cookie.getValue().contains(pid)){
					System.out.println("***********************");
					System.out.println("******Cookie不为空******");
					System.out.println("****Cookie包含pid:"+pid+"****");
					System.out.println("***********************");
					String[] value = cookie.getValue().split("#");
					System.out.println("((((((value.length:"+value.length);
					if(value.length<=7){
						for (int i=0;i<value.length;i++) {
							//第一个元素执行
							if(i==0){
								if(pid.equals(value[0]))
								{
									continue;
								}
								s=value[i]+"#";
								continue;
							}
							//最后一个元素执行
							if(i==value.length-1){
								if(value[i].equals(pid)){
									s=pid+"#"+s;
									System.out.println("elen-1:s:"+s);
									continue;
								}
								if(s!=null)
									s=pid+"#"+s+value[i];
								else
									s=pid+"#"+value[i];
								System.out.println("len-1:s:"+s);
								continue;
							}
							if(pid.equals(value[i])){
								continue;
							}
							if(s==null){
								s=value[i]+"#";
								System.out.println("尼玛空:"+s);
								continue;
								
							}
							s=s+value[i]+"#";
							System.out.println("s:"+s);
						}
					}else {
						for (int i=0;i<7;i++) {
							if(i==0){
								if(pid.equals(value[0]))
								{
									continue;
								}
								s=value[i]+"#";
								continue;
							}	
							if(i==6){
								if(value[6].equals(pid)){
									s=pid+"#"+s;
									System.out.println("e6:s:"+s);
									continue;
								}
								s=pid+"#"+s+value[i];
								System.out.println("6:s:"+s);
								continue;
							}
							if(pid.equals(value[i])){
								continue;
							}
							if(s==null){
								s=value[i]+"#";
								System.out.println("qv掉:"+s);
								continue;
							}
							s=s+value[i]+"#";
							System.out.println("6s:"+s);
						}
					}
					cookie.setValue(s);
				}else{
					cookie.setValue(pid+"#"+cookie.getValue());
				}
			}
		}
		// 将 cookie 返回前端;
		// 持久化cookie 设置为 一年
		cookie.setMaxAge(31536000);
		cookie.setPath("http://localhost:8888/store/products?method=show");
		response.addCookie(cookie);
		return "/jsp/product_info.jsp";
	}
	
	public String findByPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String cid = request.getParameter("cid");
		int currPage =Integer.parseInt(request.getParameter("currPage"));
		int pageSize = 12;
		ProductService pro = new ProductServiceImpl();
		PageBean<Product> list = pro.findByPage(currPage,pageSize,cid);
		request.getSession(true).setAttribute("pb",list);
		return "/jsp/product_list.jsp";
	}
	
	public String record(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获得  业务层 对象
		ProductService productService = new ProductServiceImpl();
		//查找Cookie   保存浏览记录
		Cookie cookie = CookUtils.getCookieByName("ids", request.getCookies());
		List<Product> pList = new ArrayList<Product>();
		if (cookie != null) {
			// 拿到id
			String[] value = cookie.getValue().split("#");
			for (String s : value) {
				System.out.print(s+"#");
			}
			//去除重复ID  如果ID > 7 截断
			// 查询数据库  将浏览记录保存到List集合中
			int i=0;
			for (String str : value) {
				i++;
				if(i>7){
					break;
				}
				pList.add(productService.getProductById(str));
			}
			Gson gson = new Gson();
			response.getWriter().print(gson.toJson(pList));
		}
		// 将 cookie 返回前端
		return null;
	}
}
