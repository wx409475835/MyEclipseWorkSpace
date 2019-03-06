package com.nyist.cn.Test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.nyist.cn.Utils.JDBCUtil_c3p0;
import com.nyist.cn.Utils.JDBCUtil_dbcp;

public class test1 {
	
	@Test
	public void TestJDBC_dbcp() throws SQLException{
		Connection connection = JDBCUtil_dbcp.getConnection();
		System.out.println("DBCP_Connection:"+connection);
	}
	
	@Test
	public void TestJDBC_c3p0() throws SQLException{
		Connection connection = JDBCUtil_c3p0.getDataSource().getConnection();
		System.out.println("C3p0_Connection:"+connection);
	}
}
