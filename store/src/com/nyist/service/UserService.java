package com.nyist.service;
import java.sql.SQLException;

import com.nyist.domain.PageBean;
import com.nyist.domain.User;

public interface UserService {
	
	void register(User user) throws Exception;
	
	User active(String code) throws Exception;

	User login(String username, String password) throws Exception;
	
	public PageBean<User> findAll(Integer currPage, int pageSize) throws Exception;

	User getUserByUid(String uid) throws Exception;

	void update(User user) throws Exception;
	
	void updateUser(User user) throws SQLException;

	void delete(String uid) throws Exception;

	void addUser(User user) throws Exception;
}
