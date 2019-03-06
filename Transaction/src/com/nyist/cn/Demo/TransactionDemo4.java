package com.nyist.cn.Demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.nyist.cn.Utils.JDBCUtil_c3p0;

public class TransactionDemo4 {
	
	@Test
	public  void TransactionDemo() throws SQLException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try{
			conn =JDBCUtil_c3p0.getConnection();
			System.out.println("Connection_c3p0:"+conn.getClass().getName());
		}finally{
			JDBCUtil_c3p0.close(rs, stat, conn);
		}
	}
}
