package nyist.net.Library.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class book implements Serializable{
	private String book_id;		//书的id号
	private String book_name;	//书名名称
	private String book_type;	//书的种类
	private Double book_price;	//书的单价
	private String book_count;	//书的数量
	private String book_add;    //书的出版社
	

	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	public Double getBook_price() {
		return book_price;
	}
	public void setBook_price(Double book_price) {
		this.book_price = book_price;
	}
	public String getBook_add() {
		return book_add;
	}
	public void setBook_add(String book_add) {
		this.book_add = book_add;
	}
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getBook_count() {
		return book_count;
	}
	public void setBook_count(String book_count) {
		this.book_count = book_count;
	}
	
	public book(String book_id, String book_name, String book_type,
			Double book_price, String book_count, String book_add) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_type = book_type;
		this.book_price = book_price;
		this.book_count = book_count;
		this.book_add = book_add;
	}
	@Override
	public String toString() {
		return "book [book_id=" + book_id + ", book_name=" + book_name
				+ ", book_type=" + book_type + ", book_price=" + book_price
				+ ", book_count=" + book_count + ", book_add=" + book_add
				+ ", book_stat=" + "]";
	}
	
}
