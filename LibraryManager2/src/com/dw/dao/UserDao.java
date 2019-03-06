package com.dw.dao;


import java.sql.SQLException;
import java.util.List;

import com.dw.model.User;

/**
 * @author bigshuai
 *@date 2017年5月8日
 *
 */
public interface UserDao {
	    /**
	     * 登陆用户验证
	     * @param page
	     * @return
	     */
	  public boolean isLogin(User user);

		 /**
		  * 修改用户的密码
		  * @param page
		  * @return
		 * @throws SQLException 
		  */
	public boolean isLogin1(User user);
	  
	  
//	
//	public String insertUser(String sql) throws SQLException;
//	/*
//	 * 用于保存读者信息
//	 * */
	  
	  void register(User user);
	  /*
	   * 
	   * 添加用户
	   * */

	
		public int updateUserPassWord(User  user);
		
		
		public List<User> ReaderSelect();
		
}
