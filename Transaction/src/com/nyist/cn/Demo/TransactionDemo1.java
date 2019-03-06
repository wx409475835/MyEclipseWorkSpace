package com.nyist.cn.Demo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import com.nyist.cn.Utils.JDBCUtil_dbcp;

public class TransactionDemo1 {
	
	@Test
	public void TransactionDemo() throws SQLException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try{
			conn = (Connection)JDBCUtil_dbcp.getConnection();
			conn.setAutoCommit(false);				//关闭自动提交事务,相当于开始事务 start transction
			String sql1 = "update account set money = money - 100 where name ='aaa'";
			String sql2 = "update account set money = money + 100 where name ='bbb'";
			String sql3 = "update account set money = money + 100 where name ='ccc'";
			stat = (PreparedStatement)conn.prepareStatement(sql1);
			stat.executeUpdate();
			
			sp = conn.setSavepoint();
			
			int a = 1/0;    //程序运行到这里    抛出异常   抛异常之后  下面代码不会执行  数据会回滚
			
			stat = (PreparedStatement)conn.prepareStatement(sql2);
			stat.executeUpdate();
			
			stat = (PreparedStatement)conn.prepareStatement(sql3);
			stat.executeUpdate();
			
			conn.commit();
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback(sp);				//手动回滚后   一定要记得提交事务
			conn.commit();
		}
		finally{
			
		}
	}
}
