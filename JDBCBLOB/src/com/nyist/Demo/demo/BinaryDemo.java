package com.nyist.Demo.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nyist.Demo.Utils.JDBCUtil;

public class BinaryDemo {
	/**
	 * 1.在数据库中保存一个表用来保存照片
	 * create table testblob(
	 * 		id varchar(40) primary key,
	 * 		image blob
	 * );
	 */
	@Test
	public void insert(){
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;	
		try {
			connection = JDBCUtil.getConnection();
			String sql = "insert into testblob(id,image) values(?,?)";
			st = (PreparedStatement)connection.prepareStatement(sql);
			File file = new File("src/1.jpg");
			FileInputStream in = new FileInputStream(file);
			st.setString(1,"1");
			st.setBinaryStream(2,in,(int)file.length());
			st.executeUpdate();
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
			String sql = "select id,image from testblob where id = '1' ";
			st = (PreparedStatement)connection.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				//String str = rs.getString("reume");	适用于小文本
				InputStream in = rs.getBinaryStream("image");
				OutputStream out = new FileOutputStream("D:\\甜橙金融河南.jpg");
				try{	
					int len = 0;
					byte buffer[] = new byte[1024];
					while((len = in.read(buffer)) > 0){
						out.write(buffer,0,len);
					}
				}finally{
					if(in!=null){
						in.close();
					}
					if(out !=null){
						out.close(); 
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, connection);
		}
	}
}
