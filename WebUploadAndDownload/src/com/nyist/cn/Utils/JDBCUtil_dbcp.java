package com.nyist.cn.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil_dbcp {
	
	private static DataSource ds = null;
	
	static{
		InputStream in = JDBCUtil_dbcp.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pt = new Properties();
		try {
			pt.load(in);
			BasicDataSourceFactory bs = new BasicDataSourceFactory();
			ds = bs.createDataSource(pt);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
