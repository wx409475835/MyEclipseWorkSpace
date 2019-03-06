package com.dw.dao;

/**
 * 数据访问层，学生信息CRUD操作
 * @author DY1101shaoyuxian
 */

import java.util.List;

import com.dw.model.Book;

public interface BookDao {
	
	/**
	 * 获取指定的用戶(更新页面操作使用)
	 * 
	 * @param id
	 * @return Book
	 */
	public Book findBookByid(int id);
		

	/**
	 * 添加学生信息
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean addBook(Book stu);

	/**
	 * 删除学生信息
	 * 
	 * @param id
	 * @return flag
	 */
	public boolean delBook(int id);

	/**
	 * 更新学生信息
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean updateBook(Book stu);

	/**
	 * 查询全体学生信息
	 * 
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public List StSelect();
	/**
	 * 根据ID查询学生信息
	 * 
	 * @return Student
	 */
	 public Book findBookById(int id); 

}
