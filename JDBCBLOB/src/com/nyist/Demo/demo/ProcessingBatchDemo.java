package com.nyist.Demo.demo;


import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.nyist.Demo.Utils.JDBCUtil;

public class ProcessingBatchDemo {
	//mysql数据库批处理机制
	/**
	 * createa table testbatch(
	 * 	id varchar(40) primary key,
	 *  name varchar(40)	
	 * );
	 */
	
	//实现mysql 数据库批处理的第一种方式
	@Test
	public void test1(){
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;	
		try {
			connection = JDBCUtil.getConnection();
			String sql = "insert into testbatch(id,name) values('1','aaa')";
			String sql2 = "update testbatch set name = 'bbb' where id = '1'";
			st=(Statement) connection.createStatement();
			st.addBatch(sql);
			st.addBatch(sql2);
			
			//[1,4]
			st.executeBatch();
			st.clearBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, connection);
		}
	}
	
	
	//mysql数据库批处理的第二种方式
	@Test
	public void test2(){
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;	
		try {
			connection = JDBCUtil.getConnection();
			String sql = "insert into testbatch(id,name) values(?,?)";
			st =(PreparedStatement) connection.prepareStatement(sql);
			st.setString(1,"1");
			st.setString(2,"aa");
			st.addBatch();
			st.setString(1,"2");
			st.setString(2,"bb");
			st.addBatch();
			st.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, connection);
		}
	}
	
	@Test
	public void test3(){
		long starttime = System.currentTimeMillis();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;	
		try {
			connection = JDBCUtil.getConnection();
			String sql = "insert into testbatch(id,name) values(?,?)";
			st =(PreparedStatement) connection.prepareStatement(sql);
			for(int i=1;i<=10000006;i++){
				st.setString(1,i+"");
				st.setString(2,"aa"+i);
				st.addBatch();
				if(i%1000==0){
					st.executeBatch();
					st.clearBatch();
				}
			}
			st.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, connection);
		}
		
		long endtime = System.currentTimeMillis();
		System.out.println("当前程序总共花费 "+(endtime-starttime)/1000+" 秒");
	}
}
