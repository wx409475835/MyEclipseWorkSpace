package com.dw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dw.dao.BookDao;
import com.dw.model.Book;
import com.dw.util.DbConn;

/**
 * @author bigshuai
 *@date 2017年5月18日
 *
 */
public class BookDaoImpl implements BookDao {
	private Connection conn = DbConn.getConn();

	/**
	 * 获取指定的用戶(更新页面操作使用)
	 * 
	 * @param id
	 * @return stu
	 */
	public Book findBookByid(int id) {
		Book bk = null;
		String sql = "select * from Book2 where BookId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				int BookId = rs.getInt("BookId");
				String BookName = rs.getString("BookName");
				String writer = rs.getString("writer");
				String price = rs.getString("price");
				Long num = rs.getLong("num");
				String BookDept = rs.getString("BookDept");
				String BookAddress = rs.getString("BookAddress");
				bk = new Book(BookId,BookName, writer, price, num, BookDept,
						BookAddress);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bk;
	}

	/**
	 * 添加图书信息
	 * 
	 * @param stu
	 * @retursn flag
	 */
	public boolean addBook(Book stu) {
		// bookid 不要
		boolean flag = false;
		String sql = "insert into Book2(BookName,writer,price,num,BookDept,BookAddress) values(?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			//psmt.setInt(1, stu.getBookId());
			psmt.setString(1, stu.getBookName());
			psmt.setString(2, stu.getWriter());
			psmt.setString(3, stu.getPrice());
			psmt.setLong(4, stu.getNum());
			psmt.setString(5, stu.getBookDept());
			psmt.setString(6, stu.getBookAddress());
			int i = psmt.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 删除图书信息
	 * 
	 * @param id
	 * @return flag
	 */
	public boolean delBook(int id) {
		boolean flag = false;
		String sql = "delete from Book2 where BookId=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			if (psmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 更新图书信息
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean updateBook(Book stu) {
		boolean flag = false;
		String sql = "update Book2 set BookName=?,writer=?,price=?,num=?,BookDept=?,BookAddress=? where BookId=? ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getBookName());
			psmt.setString(2, stu.getWriter());
			psmt.setString(3, stu.getPrice());
			psmt.setLong(4, stu.getNum());
			psmt.setString(5, stu.getBookDept());
			psmt.setString(6, stu.getBookAddress());
			psmt.setInt(7, stu.getBookId());

			int i = psmt.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 查询全体图书信息
	 * 
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public List StSelect() {
		List list = new ArrayList();
		String sql = "select * from Book2";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				int BookId = rs.getInt("BookId");
				String BookName = rs.getString("BookName");
				String writer = rs.getString("writer");
				String price = rs.getString("price");
				Long num = rs.getLong("num");
				String BookDept = rs.getString("BookDept");
				String BookAddress = rs.getString("BookAddress");

				Book bk = new Book(BookId, BookName,writer, price, num,
						BookDept, BookAddress);
				list.add(bk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book findBookById(int id) {
		// TODO Auto-generated method stub
		Book book = null;
		String sql = "select * from Book2 where BookId=?";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt("BookId"));
				book.setBookName(rs.getString("BookName"));
				book.setWriter(rs.getString("writer"));
				book.setPrice(rs.getString("price"));
				book.setBookDept(rs.getString("BookDept"));
				book.setBookAddress(rs.getString("BookAddress"));
				book.setNum(Long.parseLong(rs.getString("num")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

}
