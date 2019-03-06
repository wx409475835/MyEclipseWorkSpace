package com.dw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.jar.Attributes.Name;

import com.dw.dao.BookDao;
import com.dw.dao.BorrowDao;
import com.dw.model.Book;
import com.dw.model.Borrow;
import com.dw.util.DbConn;

public class BorrowDaoImpl implements BorrowDao {
	private Connection conn = DbConn.getConn();

	@Override
	public int borrowBook(String name, int id) {
		int flag =4 ; int a=0,b=0,s1=0;
		String bname ="";
		long nums=0;
		
		Date data =new Date();
		SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd");
		String da=s.format(data);
		
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE, 30);
		String db=s.format(c.getTime());
		
	
		
		
		
		String sql = "select bookname ,num from book2 where BookId='"+id+"'";
		try {
			Statement psmt = conn.createStatement();
			ResultSet rs =psmt.executeQuery(sql);
			if(rs.next()){
				bname=rs.getString("bookname");
				nums=rs.getLong("num");
				 a=1;
			}else
			{
				System.out.print("查找失败");
				flag=1;
			}
			
			if(nums>=1){
				nums=nums-1;
				String sl ="update book2 set num="+nums+" where bookId='"+id+"'";
				psmt.executeUpdate(sl);
				 b=2;
				
			}else{
				System.out.print("更新失败");
				flag= 1;
				
			}
				
			if(a==1&&b==2){
				//存在bug
				String si="insert into borrow(bookID,bookName,readerName,borrowDate,backDate)values('"+id+"','"+bname+"','"+name+"','"+da+"','"+db+"')";
				 s1=psmt.executeUpdate(si);
				if(s1>0){
					System.out.print("添加成功");
					flag= 2;
				}else
				{
					flag=3;
				}
				
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return flag;
	}

	@Override
	public boolean backBook(String name, int id) {
		boolean flag = false;
		long a=0;
		
		String sql = "select num from book2 where BookId='"+id+"'";
	
			Statement psmt;
			try {
				psmt = conn.createStatement();
				ResultSet rs =psmt.executeQuery(sql);
				if(rs.next()){
					a=rs.getLong("num");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			a=a+1;
		System.out.println("查找成功！");
		String sql2="update book2 set num='"+a+"' where bookId='"+id+"'";

		try {
			
			psmt = conn.createStatement();
			psmt.executeUpdate(sql2);
			System.out.print("还书成功");
			
			String nb="delete from borrow where bookId='"+id+"' and Readername='"+name+"'";
			psmt.executeUpdate(nb);
			flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return flag;
	}

	@Override
	public List bbListSelect() {
		
		List list = new ArrayList();
		String sql = "select * from borrow";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				String BookId = rs.getString("BookId");
				String BookName = rs.getString("BookName");
				String ReaderName = rs.getString("ReaderName");
				String BorrowDate = rs.getString("BorrowDate");
				//Long num = rs.getLong("num");
				String BackDate = rs.getString("BackDate");
				//String BookAddress = rs.getString("BookAddress");

				Borrow bk = new Borrow(BookId, BookName,BorrowDate,ReaderName, BackDate);
				list.add(bk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List brListSelect(String username) {
		List list = new ArrayList();
		String sql = "select * from borrow where ReaderName='"+username+"'";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				String BookId = rs.getString("BookId");
				String BookName = rs.getString("BookName");
				String ReaderName = rs.getString("ReaderName");
				String BorrowDate = rs.getString("BorrowDate");
				//Long num = rs.getLong("num");
				String BackDate = rs.getString("BackDate");
				//String BookAddress = rs.getString("BookAddress");

				Borrow bk = new Borrow(BookId, BookName,BorrowDate,ReaderName, BackDate);
				list.add(bk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	}
}

// @Override
// public List StSelect() {
// // TODO Auto-generated method stub
// return null;
