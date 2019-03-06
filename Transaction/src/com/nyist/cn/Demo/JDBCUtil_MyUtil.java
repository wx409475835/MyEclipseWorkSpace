package com.nyist.cn.Demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;import com.nyist.cn.Utils.JDBCUtil_c3p0;

public class JDBCUtil_MyUtil {
	
	public static void main(String[] args) throws SQLException{
		Connection connection = (Connection)JDBCUtil_c3p0.getConnection();				//拿到数据库连接
		DatabaseMetaData dt = connection.getMetaData();									//调用方法  获取元数据
		System.out.println("数据库版本号:"+dt.getDatabaseMajorVersion());				//打印数据库版本号
		System.out.println("数据库产品名称:"+dt.getDatabaseProductName());				//打印数据库产品名称
		System.out.println("数据库默认事务隔离级别:"+dt.getDefaultTransactionIsolation());
		System.out.println("数据库驱动:"+dt.getDriverName());
	}
}
