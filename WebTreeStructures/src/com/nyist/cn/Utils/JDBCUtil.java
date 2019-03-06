package com.nyist.cn.Utils;



import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	
	private static ComboPooledDataSource ds = null;
	static{
		ds = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
}
