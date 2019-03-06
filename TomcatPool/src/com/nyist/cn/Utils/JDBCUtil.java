package com.nyist.cn.Utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCUtil {
	
	private static DataSource ds = null;
	static{
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");				//创建JNDI容器
			System.out.println(envCtx);
			 ds = (DataSource)envCtx.lookup("jdbc/TomcatPool");						//从JNDI容器中 检索数据源
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
