package com.nyist.mybatis.Dao1;

import java.util.List;

import com.nyist.mybatis.pojo.User;

public interface UserMapper {
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
