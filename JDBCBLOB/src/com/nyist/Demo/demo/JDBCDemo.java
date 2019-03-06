package com.nyist.Demo.demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nyist.Demo.Utils.JDBCUtil;

public class JDBCDemo {
	/**读大文本数据
	 * 1.首先创建数据库表
	 * create table testclob{
	 * 		id varchar(40) primary key,
	 * 		resume	text
	 * };
	 */
	
	@Test
	public void insert(){
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;	
		try {
			connection = JDBCUtil.getConnection();
			String sql = "insert into testclob(id,resume) values(?,?)";
			st =(PreparedStatement) connection.prepareStatement(sql);
			st.setString(1,"1");
			File file = new File("src/1.text");
			FileReader reader = new FileReader(file);
			st.setCharacterStream(2, reader, (int)file.length());
			int num = st.executeUpdate();
			if(num > 0){
				System.out.println("插入成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, connection);
		}
	}
	
	 
	@Test
	public void read(){
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;	
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select id,resume from testclob where id = '1' ";
			st = (PreparedStatement)connection.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				//String str = rs.getString("reume");	适用于小文本
				Reader reader = rs.getCharacterStream("resume");
				FileWriter writer = new FileWriter("D:\\testclob.text");  
				try{
					int len = 0;
					char buffer[] = new char[1024];
					while((len = reader.read(buffer)) > 0){
						writer.write(buffer,0,len);
					}	
				}finally{
					if(reader!=null){
					     reader.close();
					}
					writer.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, connection);
		}
	}
}
