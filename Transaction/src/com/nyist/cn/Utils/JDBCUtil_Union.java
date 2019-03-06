package com.nyist.cn.Utils;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class JDBCUtil_Union {
	
	private static DataSource ds=null;
	
	//设置一个静态代码块
	static{
		try {
			InputStream in = JDBCUtil_Union.class.getClassLoader().getResourceAsStream("db.properties");
			Properties pt = new Properties();
			pt.load(in);
			//创建工厂
			BasicDataSourceFactory db = new BasicDataSourceFactory();
			ds = db.createDataSource(pt);
		} catch (Exception e) {
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
	
	public static void update(String sql,Object params[]){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil_dbcp.getConnection();
			st = con.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1,params[i]);
			}
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil_Union.close(rs, st, con);
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
	
	public interface ResultSetHandler{
		public Object handler(ResultSet rs);
	}
	
	public static class BeanHandler implements ResultSetHandler{
		
		private Class clazz;				//定义一个Class  用来将数据封装到指定对象中
		public BeanHandler(Class clazz){
			this.clazz = clazz;
		}
		
		@Override
		public Object handler(ResultSet rs) {
			/**
			 * 1.首先判断 结果集 rs 是否为空 如果为空则返回Null
			 */
			try {
				if(!rs.next()){
					return null;
				}
				//如果不为空  则将数据封装到clazz类中
				//2.生成该类的对象
				Object bean = clazz.newInstance();
				//3.拿到结果集数据
				ResultSetMetaData rm = rs.getMetaData();					//拿到结果集的元数据
				int column = rm.getColumnCount();
				for(int i=0;i<column;i++){
					//拿到列名  通过列名获得数值
					String name = rm.getColumnName(i+1);					//拿到列明  name
					Object value = rs.getObject(name);						//id
					
					//有了 列名 和  列名的值   相当于  id  1  有了  组合成id=1  使用反射技术可以实现
					Field fd = bean.getClass().getDeclaredField(name);		//反射的变量通常是private 所以使用getDeclaredField()
					fd.setAccessible(true);
					fd.set(bean, value);									//id = 1
				}
				return bean;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}	
	}
	
	public static class BeanListHandler implements ResultSetHandler{
		
		private Class clazz;
		public BeanListHandler(Class clazz){
			this.clazz = clazz;
		}
		
		@Override
		public Object handler(ResultSet rs) {
			/**
			 * 1.定义一个List 集合
			 */
			List lt = new ArrayList();
			//2.将数据封装到 List集合中的对象中去
			try {
				while(rs.next()){
					Object bean = clazz.newInstance();							//生成对象
					//3.获得数据的列数,然后通过数据的名称得到数据的值，在通过反射技术引射到对应的实体中
					ResultSetMetaData meta = rs.getMetaData();						//获得结果集的元数据
					int column = meta.getColumnCount();								//获得结果集的个数
					for(int i = 0;i < column;i++){
						String name = meta.getColumnName(i+1);						//获得对应的名称
						Object value = rs.getObject(name);							//通过名称获得对象的值
						
						//将 结果  反射 bean 中
						Field field = bean.getClass().getDeclaredField(name);
						field.setAccessible(true); 									//打开私有保护
						field.set(bean,value);
					}
					lt.add(bean);
				}
				return lt;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
	}
}
