package com.nyist.cn.Test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import com.nyist.cn.Utils.JDBCUtil;

public class TestJDBC {

	@Test
	public void test1() throws SQLException{
		Connection conn = (Connection) JDBCUtil.getDataSource().getConnection();
		System.out.println("Connection:"+conn);
	}
}
