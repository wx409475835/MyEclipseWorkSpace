package cn.itcast.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//dbutils  
	private static DataSource ds;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	static{
		try {
			ds = new ComboPooledDataSource();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
}
