package com.nyist.plantsystem.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class CreateTableServlet extends HttpServlet{
	
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("****************************************");
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		    Connection connection = null;
		    try
		    {
		      connection = DriverManager.getConnection("jdbc:sqlite:plantsystem.db");
		      System.out.println("************************");
		      System.out.println("connection:"+connection);
		      System.out.println("************************");
		      Statement statement = connection.createStatement();
		      statement.setQueryTimeout(100);  // set timeout to 30 sec.
		      //statement.executeUpdate("sqlite3.exe plantsystem.db");
		      statement.executeUpdate("create table if not exists sys_user(id INTEGER not null primary key AUTOINCREMENT,username varchar(100),upassword varchar(100))");
		      statement.executeUpdate("insert into sys_user('username','upassword') values('root', 'root');");
		      statement.executeUpdate("create table if not exists file (uuidname varchar(100) unique primary key,filename varchar(100),filepath varchar(255));");
		      System.out.println("创建sys_user 和 file 表成功");
		    }catch(SQLException e){
		      System.err.println(e.getMessage());
		    }finally{
		     try{
		        if(connection != null)
		          connection.close();
		      }catch(SQLException e)
		      {
		        System.err.println(e);
		      }
		  }
	}*/
}
