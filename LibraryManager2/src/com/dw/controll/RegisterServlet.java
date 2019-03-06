package com.dw.controll;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.UserDao;
import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.User;
import com.dw.util.MD5Util;


/**ע��servlet
 * @author bigshuai
 *@date 2017��5��14��
 *
 */
public class RegisterServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//���ܲ���
		String username = req.getParameter("username");
		String password1 = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String date = req.getParameter("date");
		
		String salt=MD5Util.getSalt(4);
		String password =MD5Util.jdkMD(password1+salt);
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		user.setSalt(salt);
		/**
		 * �ַ���ת����
		 */
		Date date2 = null;
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UserDao userDao=new UserDaoImpl();
		
//		//����ҵ��
//		UserService us = new UserServiceImpl();
		userDao.register(user);
		//��ת
		res.sendRedirect(req.getContextPath()+"/login.jsp");
	}
}
