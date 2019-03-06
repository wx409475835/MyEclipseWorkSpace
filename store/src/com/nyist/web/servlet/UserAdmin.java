package com.nyist.web.servlet;import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.domain.PageBean;
import com.nyist.domain.User;
import com.nyist.service.UserService;
import com.nyist.service.impl.UserServiceImpl;
import com.nyist.utils.MD5Utils;
import com.nyist.utils.UUIDUtils;
public class UserAdmin extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String findAll(HttpServletRequest request,HttpServletResponse response) throws SQLException{
		Integer currPage = Integer.parseInt(request.getParameter("currPage"));
		int pageSize = 15;
		PageBean<User> user = new UserServiceImpl().findAll(currPage,pageSize);
		System.out.println("user:"+user);
		request.getSession(true).setAttribute("bean",user);
		return "/admin/user/list.jsp";
	}
	
	public String update(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String uid = request.getParameter("uid");
		UserService service = new UserServiceImpl();
		//通过uid 查询出来用户
		User user = service.getUserByUid(uid);
		System.out.println("A-user:"+user);
		request.getSession(true).setAttribute("user",user);
		return "/admin/user/edit.jsp";
	}
	
	public String updateUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//封装前台传来的数据
		String uid = request.getParameter("uid");
		String username = request.getParameter("username");
		String password;
		if(request.getParameter("password").length()>=31){
			password = request.getParameter("password");
		}else{
			password = MD5Utils.md5(request.getParameter("password"));
		}
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		User user = new User();
		user.setUid(uid);
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setStat(Integer.parseInt(state));
		user.setCode(code);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
		Date date = simpleDateFormat.parse(birthday);
		user.setBirthday(date);
		user.setSex(sex);
		UserService service = new UserServiceImpl();
		System.out.println("user-A:"+user);
		service.updateUser(user);
		response.sendRedirect(request.getContextPath()+"/userAdmin?method=findAll&currPage=1");
		return null;
	}
	
	//删除用户delete
	public String delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String uid = request.getParameter("uid");
		UserService service = new UserServiceImpl();
		service.delete(uid);
		response.sendRedirect(request.getContextPath()+"/userAdmin?method=findAll&currPage=1");
		return null;
	}
	
	public String addUser(HttpServletRequest request,HttpServletResponse response){
		return "/admin/user/add.jsp";
	}
	
	//添加用户
	public String add(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String username = request.getParameter("username");
		String password = MD5Utils.md5(request.getParameter("password"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		User user = new User();
		user.setUid(UUIDUtils.getId());
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setStat(0);
		user.setCode(UUIDUtils.getCode());
		user.setSex(sex);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse(birthday);
		System.out.println("date:"+date);
		user.setBirthday(date);
		UserService service = new UserServiceImpl();
		service.addUser(user);
		response.sendRedirect(request.getContextPath()+"/userAdmin?method=findAll&currPage=1");
		return null;
	}
}
