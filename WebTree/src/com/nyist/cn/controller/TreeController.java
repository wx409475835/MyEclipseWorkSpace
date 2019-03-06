package com.nyist.cn.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyist.cn.model.Tree;
import com.nyist.cn.service.TreeService;

@Controller
public class TreeController {
	
	@Autowired
	private TreeService service;
	
	@RequestMapping("hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("ListTreeAction")
	public void ListTree(){
		List<Tree> list = service.getAll();
		System.out.println("List:"+list);
	}
}
