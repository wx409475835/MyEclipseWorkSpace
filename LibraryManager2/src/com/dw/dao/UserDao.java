package com.dw.dao;


import java.sql.SQLException;
import java.util.List;

import com.dw.model.User;

/**
 * @author bigshuai
 *@date 2017��5��8��
 *
 */
public interface UserDao {
	    /**
	     * ��½�û���֤
	     * @param page
	     * @return
	     */
	  public boolean isLogin(User user);

		 /**
		  * �޸��û�������
		  * @param page
		  * @return
		 * @throws SQLException 
		  */
	public boolean isLogin1(User user);
	  
	  
//	
//	public String insertUser(String sql) throws SQLException;
//	/*
//	 * ���ڱ��������Ϣ
//	 * */
	  
	  void register(User user);
	  /*
	   * 
	   * ����û�
	   * */

	
		public int updateUserPassWord(User  user);
		
		
		public List<User> ReaderSelect();
		
}
