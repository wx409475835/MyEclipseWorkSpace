package com.nyist.cn.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.nyist.cn.Utils.JDBCUtil;

public class JNDIDao {
	
	public void add() throws SQLException{
		Connection con = JDBCUtil.getConnection();
		System.out.println("Connection:"+con);
	}
}
