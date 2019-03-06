package com.dw.dao;

/**
 * 数据访问层，学生信息CRUD操作
 * @author DY1101shaoyuxian
 */

import java.util.List;

import com.dw.model.Book;
import com.dw.model.Borrow;

public interface BorrowDao {
	
	
	
	
	//public Book findBookByid(int id);
		
		public int borrowBook(String name,int id);

	//public boolean updateBook(Book stu);

	//@SuppressWarnings("unchecked")
	//public List StSelect();
		
		public boolean backBook(String name,int id);
		
		public List bbListSelect();
		public List brListSelect(String username);
		
	

}
