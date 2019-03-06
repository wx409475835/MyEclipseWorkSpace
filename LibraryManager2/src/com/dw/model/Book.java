package com.dw.model;


/**
 * @author bigshuai
 *@date 2017��5��9��
 *
 */
public class Book {

	public Book(int bookId, String bookName, String writer, String price, long num, String bookDept,
			String bookAddress) {
		super();
		BookId = bookId;
		BookName = bookName;
		this.writer = writer;
		this.price = price;
		this.num = num;
		BookDept = bookDept;
		BookAddress = bookAddress;
	}

	
	public Book( String bookName, String writer, String price, long num, String bookDept,
			String bookAddress) {
		super();
		BookName = bookName;
		this.writer = writer;
		this.price = price;
		this.num = num;
		BookDept = bookDept;
		BookAddress = bookAddress;
	}
	
	public int getBookId() {
		return BookId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getBookDept() {
		return BookDept;
	}

	public void setBookDept(String bookDept) {
		BookDept = bookDept;
	}

	public String getBookAddress() {
		return BookAddress;
	}

	public void setBookAddress(String bookAddress) {
		BookAddress = bookAddress;
	}

	private int BookId;// ���
	private String BookName;// ����
	private String writer;// ����
	private String price;// ��Ǯ
	private long num;// ����
	private String BookDept;// ���
	private String BookAddress;// ������

	

//	public Book(int BookId, String stName, String stSex, String stAge,
//			long stTel, String stDept, String stAddress) {
//		this.stId = BookId;
//		this.stName = stName;
//		this.stSex = stSex;
//		this.stAge = stAge;
//		this.stTel = stTel;
//		this.stDept = stDept;
//		this.stAddress = stAddress;
//	}
//
//	public Book(String stName, String stSex, String stAge, long stTel,
//			String stDept, String stAddress) {
//		this.stName = stName;
//		this.stSex = stSex;
//		this.stAge = stAge;
//		this.stTel = stTel;
//		this.stDept = stDept;
//		this.stAddress = stAddress;
//	}

	public Book() {
	}
   
}
