package com.nyist.dao;

import java.sql.SQLException;
import java.util.List;

import com.nyist.domain.User;

public interface UserDao {
	void register();
	void add(User user) throws SQLException;
	void update(User user)  throws SQLException;
	User getByCode(String code);
	User getByUserNameAndPassWord(String username, String password) throws SQLException;
	List<User> findAll(Integer currPage, int pageSize) throws SQLException;
	int getTotalCount() throws SQLException;
	User getUserByUid(String uid) throws SQLException;
	void updateUser(User user) throws SQLException;
	void delete(String uid) throws SQLException;
}
