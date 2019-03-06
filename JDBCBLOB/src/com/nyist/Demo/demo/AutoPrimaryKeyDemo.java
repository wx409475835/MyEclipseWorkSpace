package com.nyist.Demo.demo;


import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.nyist.Demo.Utils.JDBCUtil;

public class AutoPrimaryKeyDemo {
	//获得自动生成的主键
	/**
	 create table test(
	 	id int primary key auto_increment,
	 	name fresher(40)
	 );
	 */
	@Test
	public void test1(){
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;	
		try {
			connection = JDBCUtil.getConnection();
			String sql = "insert into test(name) values('aaa')";
			//Statement.RETURN_GENERATED_KEYS   是一个常量   获取自动生成的主键
			st = (PreparedStatement)connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.executeUpdate();
			rs = st.getGeneratedKeys();
			if(rs.next()){
				System.out.println(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, connection);			
		}
	}
}
