package com.nyist.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyist.cn.dao.TreeMapper;
import com.nyist.cn.service.TreeService;

@Service
public class TreeServiceImpl implements TreeService{

	@Autowired
	private TreeMapper mapper;
	
	@Override
	public List getAll() {
		return mapper.getAll();
	}
	
}
