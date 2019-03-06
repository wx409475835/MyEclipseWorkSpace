package com.nyist.mybatis.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyist.mybatis.model.User;
import com.nyist.mybatis.service.UserService;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private UserService service;
	
	@RequestMapping("/select")
	@ResponseBody
	public String getUserById(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//通过id 查询 User用户
		User user = service.getUserById(Integer.valueOf(id));
		System.out.println("user:"+user);
		return user.toString();
	}
}
