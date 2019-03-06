package com.nyist.Demo.Test;

import java.sql.Connection;

import org.junit.Test;

import com.nyist.Demo.Utils.JDBCUtil;

public class TestJDBCUtil {

	@Test
	public void test1(){
		Connection connection = JDBCUtil.getConnection();
		System.out.println("JDBC连接:"+connection);
	}
}
