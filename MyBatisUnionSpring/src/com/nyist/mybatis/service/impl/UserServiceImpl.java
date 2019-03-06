package com.nyist.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyist.mybatis.dao.UserDao;
import com.nyist.mybatis.model.User;
import com.nyist.mybatis.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

	@Override
	public List<User> getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return dao.getUserByUserName(username);
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return dao.insertUser(user);
	}

}
