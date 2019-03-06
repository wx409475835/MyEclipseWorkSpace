package com.dw.dao.impl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dw.dao.UserDao;
import com.dw.model.User;
import com.dw.util.DbConn;
import com.dw.util.MD5Util;

/**
 * @author bigshuai
 *@date 2017��5��8��
 *
 */
public class UserDaoImpl implements UserDao {
	
			private static Connection conn = DbConn.getConn();
	
	
	//��½�û���֤
	  public boolean isLogin(User user){
		  boolean flag=false;
		  String sql="select * from t_manager where username=? and password=?";
		  
		  try {
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, user.getUsername());//�Դ��������û�����������з�װ
			pmst.setString(2, user.getPassword());
			ResultSet rs=pmst.executeQuery();
			if(rs.next()){
				// System.out.println("�ڴ˴�");
				flag=true;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	  
	  }
	
	
		 /**
		  * �޸��û�������
		  * @param page
		  * @return
		  */
		
		public int updateUserPassWord(User  user) {
			int a=0;
			String sql = "update t_manager set password=? where username=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getPassword());
				pstmt.setString(2, user.getUsername());
				a= pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return a;
		}


//		@Override
//		public String insertUser(String sql) throws SQLException {
//			
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			int num = pstmt.executeUpdate(sql);
//			String result="";
//			if(num>0){
//				result="����ע��ɹ�";	
//			}else{
//				result="����ע��ʧ��";	
//			}
//			conn.close();
//			return result;
//		}


		@Override
		public void register(User user) {
			
			//���ַ���
			String sql ="INSERT INTO tb_user(username,password,phone,email,salt) VALUES(?,?,?,?,?)";
		
			try {
				
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getPhone());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getSalt());
				
				int row=ps.executeUpdate();
				if(row>0)
				{
					System.out.print("����û��ɹ���");
				}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
			
			
		}


		@Override
		public boolean isLogin1(User user){
		
			  boolean flag=false;
			  String sql2="select salt from tb_user where username='"+user.getUsername()+"'";
			  String sql="select * from tb_user where username=? and password=?";
			  
			  try {
					String salt="";
				  Statement psmt = conn.createStatement();
					ResultSet rs =psmt.executeQuery(sql2);
					if(rs.next()){
						 salt=rs.getString("salt");
					}else
					{
						System.out.println("û���ҵ���");
					}
					
				  
				PreparedStatement pmst=conn.prepareStatement(sql);
				pmst.setString(1, user.getUsername());//�Դ��������û�����������з�װ
				 String mdpass=MD5Util.jdkMD(user.getPassword()+salt);  
				pmst.setString(2, mdpass);
				System.out.println(user.getUsername());
				System.out.println(mdpass);
				System.out.print(salt);
				
				ResultSet rs1=pmst.executeQuery();
				if(rs1.next()){
					// System.out.println("�ڴ˴�");
					flag=true;				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;	  
		  }


			@Override
			public List<User> ReaderSelect() {
				
				List<User> list = new ArrayList<User>();
				String sql = "select * from tb_user";
				try {
					Statement smt = conn.createStatement();
					ResultSet rs = smt.executeQuery(sql);
					while (rs.next()) {
						
						String username = rs.getString("username");
						String password = rs.getString("password");
						String phone = rs.getString("phone");
						//Long num = rs.getLong("num");
						String email = rs.getString("email");
						//String BookAddress = rs.getString("BookAddress");

						User us = new User(username, password,phone, email);
						list.add(us);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
				
				
			
			}

			
			
			
			
	
		

		


}
