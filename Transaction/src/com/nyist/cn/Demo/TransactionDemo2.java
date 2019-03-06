package com.nyist.cn.Demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
/*
import com.mysql.jdbc.Connection;*/

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.nyist.cn.Utils.JDBCUtil_dbcp;

public class TransactionDemo2 {
	@Test
	public void TransactionDemo() throws SQLException, InterruptedException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try{
			conn = JDBCUtil_dbcp.getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);			//设置隔离级别  为最高
			conn.setAutoCommit(false); 													//开始事务
			String sql = "select * from account";
			conn.prepareStatement(sql).executeQuery();
			Thread.sleep(1000*20);													//当前线程睡眠  20 秒
			
			conn.commit();
		}finally{
			JDBCUtil_dbcp.close(rs, stat, conn);
		}
	}
}
