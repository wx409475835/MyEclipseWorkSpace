package com.nyist.dbutils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;


public class JDBCUtil_dbcp {
	private static DataSource dataSource = null ;
	static{
		//1.首先new出来一个工厂
		//2.通过工厂创建创建连接池
		//3.读取配置文件
		BasicDataSourceFactory factory = new BasicDataSourceFactory();
		//读取配置文件
		FileInputStream in = null;
		try {
			in = new FileInputStream("src/db.properties");
			Properties pro = new Properties();
			pro.load(in);
			dataSource = factory.createDataSource(pro);
		}catch (IOException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	//在这里没有必要关闭链接了,调用dbutils框架的方法之后自动会释放链接
}
