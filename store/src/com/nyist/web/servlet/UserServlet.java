package com.nyist.web.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import com.nyist.constant.Constant;
import com.nyist.domain.User;
import com.nyist.service.UserService;
import com.nyist.service.impl.UserServiceImpl;
import com.nyist.utils.MD5Utils;
import com.nyist.utils.UUIDUtils;
import com.nyist.utils.myConventer.MyConventer;

/***
 * 和用户相关的方法
 * @author LHG
 *
 */
public class UserServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet执行了！");
		return null;
	}
	
	public String registerUI(HttpServletRequest request,HttpServletResponse response){
		System.out.println("registerUI执行了");
		return "/jsp/register.jsp";
	}
	
	public String loginUI(HttpServletRequest request,HttpServletResponse response){
		return "/jsp/login.jsp";
	}
	
	public String register(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//用户注册
		//1.封装数据  
		User user = new User();
		//转换器 注册
		ConvertUtils.register(new MyConventer(),Date.class);		
		//数据封装
		BeanUtils.populate(user,request.getParameterMap());
		//1.设置用户ID
		user.setUid(UUIDUtils.getId());
		//1.2 设置激活码
		user.setCode(UUIDUtils.getCode());
		//加密密码
		user.setPassword(MD5Utils.md5(user.getPassword()));
		//2.调用Service完成注册
		UserService us = new UserServiceImpl();
		us.register(user);
		request.getSession(true).setAttribute("msg","用户已注册成功,快去邮箱激活吧！！！");
		return "/jsp/msg.jsp";
	}
	
	public String active(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//1.获得激活码
		String code = request.getParameter("code");
		System.out.println("code:"+code);
		//2.调用Service 完成激活
		UserService uService = new UserServiceImpl();
		User user = uService.active(code);
		if(user==null){
			//通过激活码 没有找到用户
			request.getSession(true).setAttribute("msg","请重新注册");
		}else{
			//不为空 添加信息
			request.getSession().setAttribute("msg","激活成功!");
		}
		//3.请求转发到msg.jsp
		return "/jsp/msg.jsp";	
	}
	
	//登陆
	public String login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//1.获取用户名密码
		System.out.println("login*********************");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("User-password:"+username+"-"+password);
		if(password!=null)
			password=MD5Utils.md5(password);
		System.out.println("pass:"+password);
		//2.调用service完成业务 返回user
		UserService userService = new UserServiceImpl();
		User user = userService.login(username,password);
		//3.判断用户
		if(user == null){
			//用户名密码不匹配
			request.getSession(true).setAttribute("msg","用户名密码不匹配");
			return "/jsp/login.jsp";
		}else{
			//继续判断用户的状态是否激活
			if(Constant.USER_IS_ACTIVE!=user.getStat()){
				request.getSession(true).setAttribute("msg","用户未激活!!");
				return "/jsp/login.jsp";
			}
		}
		//4.将user放入session中
		request.getSession().setAttribute("user",user);
		response.sendRedirect(request.getContextPath()+"/");
		return null;
	}
	
	//退出
	public String exit(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession(true).invalidate();//销毁Session
		response.sendRedirect(request.getContextPath()+"/");
		return null;
	}
}
