package com.nyist.cn.Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil_c3p0 {
	
	private static ComboPooledDataSource ds=null;
	
	//设置一个静态代码块
	static{
		try {
			/**
			 * 当 new 出这么一个对象的时候,该方法会自从到/src目录下,根据c3p0的命名规范去找相应的配置文件,然后自动加载
			 * 
			 * 配置文件需要命名为c3p0-config.xml
			 */
			ds = new ComboPooledDataSource();						//new 一个c3p0连接池
			/*ds.setDriverClass("com.mysql.jdbc.Driver");				//设置需要的驱动
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/lhg");		//设置路径Url
			ds.setUser("root");										//设置用户名
			ds.setPassword("410923");								//设置密码
			ds.setMaxPoolSize(30);									//设置最大连接数
			ds.setMinPoolSize(5);									//设置最小连接数
			ds.setInitialPoolSize(10);								//设置初始化连接属
*/		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public static void close(ResultSet rs,Statement stat,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(stat != null){
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
