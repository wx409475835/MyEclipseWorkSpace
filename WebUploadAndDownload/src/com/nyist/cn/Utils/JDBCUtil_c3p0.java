package com.nyist.cn.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nyist.cn.dao.ResultSetHandler;


public class JDBCUtil_c3p0 {
	//创建c3p0连接池
	
	private static DataSource ds = null;
	static{
		ds = new ComboPooledDataSource();				//new  一下就创建了一个连接池
	}
	
	public static DataSource getDataSource() throws SQLException{
		return ds;
	}
	
	public static void close(ResultSet rs,Connection con,Statement stat){
		if(rs!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void update(String sql,Object params[]){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil_c3p0.getDataSource().getConnection();
			st = con.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1,params[i]);
			}
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil_c3p0.close(rs, con, st);
		}
	}
	
	
	//查询优化
		public static Object Query(String sql,Object params[],ResultSetHandler handler){
			Connection connection = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				//拿到数据库连接
				connection = JDBCUtil_dbcp.getConnection();
				//select * from account where id = ? , name = ?
				st = connection.prepareStatement(sql);
				for(int i = 0;i<params.length;i++){
					st.setObject(i+1,params[i]);
				}
				rs = st.executeQuery();
				return handler.handler(rs);					//返回处理过后的结果集合								
			} catch (Exception e) {
				throw new RuntimeException(e);
			}		
		}
}
