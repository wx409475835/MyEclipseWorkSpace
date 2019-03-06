package com.nyist.cn.Test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import com.nyist.cn.Utils.JDBCUtil_c3p0;

public class TestJDBC {
	
	@Test
	public void test1() throws SQLException{
		Connection connection = JDBCUtil_c3p0.getConnection();
		System.out.println("JDBC连接为:"+connection);
	}
}
