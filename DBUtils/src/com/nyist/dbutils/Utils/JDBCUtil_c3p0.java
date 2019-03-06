package com.nyist.dbutils.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil_c3p0 {
	
	private static ThreadLocal<Connection> t1 =  new ThreadLocal<Connection>();		//定义一个ThreadLocal 来保存绑定再当前线程上的链接
	private static ComboPooledDataSource cs = null;		
	static{
		cs = new ComboPooledDataSource();
	}
	public static DataSource getDataSource(){
		return cs;
	} 
	
	public static Connection getConnection() throws SQLException{
		try {
			//得到当前线程上绑定的链接开启事务
			Connection conn = t1.get();
			if(conn==null){
				conn = cs.getConnection();				//从数据库连接池里得到一个链接
				t1.set(conn);							//将得到的连接绑定到当前线程上
			}
			return conn;								//返回该连接
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	//开启事务
	public static void startTransaction(){
		try {
			//得到当前线程上绑定的链接开启事务
			Connection conn = t1.get();			
			if(conn==null){
				conn = getConnection();
				t1.set(conn);
			}
			conn.setAutoCommit(false);			//开启事务
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	//提交事务
	public static void commitTransaction(){
		try{
			Connection conn = t1.get();				//得到当前线程上绑定的连接
			if(conn != null){						//如果得到的连接不为空
				conn.commit();						//提交事务
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//关闭数据库连接   从map容器中删除掉关闭掉的连接
	public static void closeConnection() throws SQLException{
		try{
			Connection conn = t1.get();				//得到当前线程上绑定的连接
			if(conn != null){						//如果得到的连接不为空
				conn.close();						//关闭事务
			}
		}finally{
			t1.remove();							//**重点，千万要牢记** 解除当前线程上的绑定--从threadLocal中移除关闭的链接
			//如果不将关闭的连接从ThreadLocal容器中移除,ThreadLocal容器越老越大,最终会将内存耗尽
		}
	}
}	
