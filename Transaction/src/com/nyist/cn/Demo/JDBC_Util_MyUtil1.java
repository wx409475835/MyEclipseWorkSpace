package com.nyist.cn.Demo;

import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import java.sql.Connection;

import com.mysql.jdbc.ResultSetMetaData;
import com.nyist.cn.Utils.JDBCUtil_c3p0;

public class JDBC_Util_MyUtil1 {
	
	/**
	 * 参数元数据
	 * @throws SQLException
	 */
	@Test
	public void Test1() throws SQLException{
		/**
		    1.拿到数据库连接
		 */
		Connection connection = (Connection) JDBCUtil_c3p0.getConnection();
		String sql = "select * from account where id=? and name =?";
		PreparedStatement pd = connection.prepareStatement(sql);
		ParameterMetaData pm = pd.getParameterMetaData();											//获得元数据
		System.out.println("参数个数:"+pm.getParameterCount());
		//System.out.println("参数类型:"+pm.getParameterType(1));										//mysql 不支持获得指定参数的类型
	}
	
	
	//结果集元数据
	@Test
	public void Test2() throws SQLException{
		/**
		    1.拿到数据库连接
		 */
		Connection connection = (Connection) JDBCUtil_c3p0.getConnection();
		String sql = "select * from account";
		PreparedStatement pd = connection.prepareStatement(sql);
		ResultSet st = pd.executeQuery();
		ResultSetMetaData set = (ResultSetMetaData) st.getMetaData();															//获得结果集
		System.out.println("结果集:"+set.getColumnCount());
		System.out.println("第一列:"+set.getColumnName(1));
		System.out.println("第二列:"+set.getColumnName(2));
		System.out.println("第三列:"+set.getColumnName(3));
		
		//System.out.println("元数据:"+st.getObject(1));
	}
}
