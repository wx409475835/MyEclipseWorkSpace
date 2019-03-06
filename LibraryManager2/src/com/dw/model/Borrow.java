package com.dw.model;

//import java.util.Date;

public class Borrow {
	
	public Borrow(String bookID, String bookName, String readerName, String borrowDate, String backDate) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.readerName = readerName;
		this.borrowDate = borrowDate;
		this.backDate = backDate;
		//this.num = num;½èÔÄ´ÎÊý
		//BorrowStatus = borrowStatus;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
//	public int getNum() {
//		return num;
//	}
//	public void setNum(int num) {
//		this.num = num;
//	}
//	public String getBorrowStatus() {
//		return BorrowStatus;
//	}
//	public void setBorrowStatus(String borrowStatus) {
//		BorrowStatus = borrowStatus;
//	}
	private String bookID;
	private String bookName;
	private String readerName;
	//private Date finalTime;
	private String  borrowDate;
	private String backDate;
	//private int num;//½èÔÄ´ÎÊý
	//private String BorrowStatus;//½èÔÄ×´Ì¬
	
	

}
