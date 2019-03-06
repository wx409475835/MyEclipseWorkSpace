package com.dw.dao;

/**
 * ���ݷ��ʲ㣬ѧ����ϢCRUD����
 * @author DY1101shaoyuxian
 */

import java.util.List;

import com.dw.model.Book;

public interface BookDao {
	
	/**
	 * ��ȡָ�����Ñ�(����ҳ�����ʹ��)
	 * 
	 * @param id
	 * @return Book
	 */
	public Book findBookByid(int id);
		

	/**
	 * ���ѧ����Ϣ
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean addBook(Book stu);

	/**
	 * ɾ��ѧ����Ϣ
	 * 
	 * @param id
	 * @return flag
	 */
	public boolean delBook(int id);

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean updateBook(Book stu);

	/**
	 * ��ѯȫ��ѧ����Ϣ
	 * 
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public List StSelect();
	/**
	 * ����ID��ѯѧ����Ϣ
	 * 
	 * @return Student
	 */
	 public Book findBookById(int id); 

}
