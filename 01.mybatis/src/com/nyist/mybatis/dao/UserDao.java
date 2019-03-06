package com.nyist.mybatis.dao;

import java.util.List;

import com.nyist.mybatis.pojo.User;
/**
 * 用户信息 持久化接口
 * @author LHG
 *
 */
public interface UserDao {
	//根据用户Id 查询 用户信息
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	//根据用户名查找用户列表
	/**
	 * 
	 * @param username
	 * @return
	 */
	List<User> getUserByUserName(String username);
	//添加用户
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
}
