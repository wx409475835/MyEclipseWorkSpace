package com.nyist.dbutils.Demo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import com.nyist.dbutils.Utils.JDBCUtil_c3p0;
import com.nyist.dbutils.model.user;
public class Demo1 {
	
	@Test
	public void Insert() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "insert into user(id,name,password,email,birthday) values(?,?,?,?,?)";
		Object params[] = {1,"aaa","123","aa@123.com",new Date()};
		runner.update(sql, params);
	}
	
	@Test
	public void update() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "update user set email = ? where id = ?";
		Object params[] = {"baidu@123.com",1};
		runner.update(sql, params);
	}
	
	@Test
	public void delete() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "delete from user where id = ?";
		runner.update(sql, 1);
	}
	
	/**
	 	BeanHandler(对像)
	 	User:com.nyist.dbutils.model.user@5b464ce8
	 * @throws SQLException
	 */
	@Test
	public void find() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "select * from user where id = ?";
		user user = (user) runner.query(sql, 1, new BeanHandler(user.class));
		System.out.println("User:"+user);
	}
	
	/**
	 	BeanListHandler(对象)
	 	user:[com.nyist.dbutils.model.user@340f438e, com.nyist.dbutils.model.user@30c7da1e, com.nyist.dbutils.model.user@5b464ce8]
	 * @throws SQLException
	 */
	@Test
	public void getAll() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "select * from user";
		List<user> user = (List<user>) runner.query(sql,new BeanListHandler(user.class));
		System.out.println("user:"+user);
	}
	
	//batch批处理sql
	@Test
	public void batch() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		String sql = "insert into user(id,name,password,email,birthday) values(?,?,?,?,?)";
		Object params[][] = new Object[3][5];						//二位数组用来保存sql 的长度和sql 的个数
		int i =0;
		for(i=0;i<params.length;i++){
			params[i] =  new Object[]{i+1,"ccc","123",i+"aa@123.com",new Date()};			//利用for循环填充二位数组
		}
		runner.batch(sql, params);
	}
	
	/**
	 	ScalarHandler
	 	TotalRecord:3
	 * @throws SQLException
	 */
	@Test
	public void getCount() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		String sql = "select count(*) from user";
		//Object result[] = (Object[]) runner.query(sql,new ArrayHandler());
		/*	第一种做法
		long num = (long)result[0];
		int number = (int)num;
		System.out.println("number:"+number);*/
		/*第二种做法
		int totalrecord = ((Long)result[0]).intValue();
		System.out.print("TotalRecord:"+totalrecord);*/
		/*
		 第三种做法   使用ScalarHandler		作用:将处理的结果转到一个对象中去
		 * */
		int totalrecord = ((Long)runner.query(sql,new ScalarHandler())).intValue();
		System.out.println("TotalRecord:"+totalrecord);
	}
}

