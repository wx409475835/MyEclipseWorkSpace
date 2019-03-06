package com.nyist.dbutils.test;


import javax.sql.DataSource;

import org.junit.Test;

import com.nyist.dbutils.Utils.JDBCUtil_dbcp;
import com.nyist.dbutils.Utils.JDBCUtil_c3p0;

public class testJDBC {
	@Test
	public void test1(){
		DataSource ds = JDBCUtil_dbcp.getDataSource();
		System.out.println("DataSource:"+ds);
	}
	
	@Test
	public void test2(){
		DataSource ds = JDBCUtil_c3p0.getDataSource();
		System.out.println("DataSource:"+ds);
	}
}
