package com.nyist.Cookie.Rem;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemberServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//0.设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter outPrintWriter = resp.getWriter();
		HttpSession sessions =(HttpSession)req.getSession();
		//销毁session
		sessions.invalidate();
		//1.获取指定的cookie
		Cookie cookie = getCookieByName("lastTime",req.getCookies());
		//2.判断cookie 是否为空
		if(cookie==null){
			//cookie 为空提示第一次时间
			outPrintWriter.write("您是第一次访问!");
		}else{
			//cookie 不为空 显示上一次登陆时间
			String value = cookie.getValue();  //lastTime=12123454
			long time = Long.parseLong(value);
			Date date = new Date(time);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd E hh:mm:ss");
			outPrintWriter.print("Cookie名称:"+cookie.getName()+"\n"+"Cookie值:"+cookie.getValue()+"\n"+"CookeiePath:"+cookie.getPath());
			outPrintWriter.print("你上次访问的时间:"+simpleDateFormat.format(date));
		}
		//3.将当前访问时间记录
		//3.1创建Cookie
		cookie = new Cookie("lastTime",new Date().getTime()+"");
		//3.2 写回浏览器
		//3.3设置cookie 持久化
		cookie.setMaxAge(1800);
		cookie.setPath(req.getSession().getServletContext().getContextPath()+"/");
		resp.addCookie(cookie);
		
	}

	private Cookie getCookieByName(String value, Cookie[] cookies) {
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(value)){
					return cookie;
				}
			}
		}
		return null;
		
	}
}
