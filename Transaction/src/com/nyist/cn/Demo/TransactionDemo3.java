package com.nyist.cn.Demo;

import java.sql.SQLException;

import org.junit.Test;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.nyist.cn.Utils.JDBCUtil_dbcp;

public class TransactionDemo3 {
	
	@Test
	public void TransactionDemo() throws SQLException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try{
			conn =JDBCUtil_dbcp.getConnection();
			System.out.println("Connection:"+conn.getClass().getName());
		}finally{
			JDBCUtil_dbcp.close(rs, stat, conn);
		}
	}
}
