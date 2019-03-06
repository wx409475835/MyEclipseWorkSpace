package nyist.net.Library.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class person_user implements Serializable {
	private String person_id;
	private String username;
	private String ident;
	private String book_id;
	private String book_name;
	private String book_type;
	private Double book_price;
	private String book_count;
	private String book_add;
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
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
	public String getBook_count() {
		return book_count;
	}
	public void setBook_count(String book_count) {
		this.book_count = book_count;
	}
	public String getBook_add() {
		return book_add;
	}
	public void setBook_add(String book_add) {
		this.book_add = book_add;
	}
	public person_user(String person_id, String username, String ident,
			String book_id, String book_name, String book_type,
			Double book_price, String book_count, String book_add) {
		super();
		this.person_id = person_id;
		this.username = username;
		this.ident = ident;
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_type = book_type;
		this.book_price = book_price;
		this.book_count = book_count;
		this.book_add = book_add;
	}
	public person_user() {
		super();
		// TODO Auto-generated constructor stub
	}
}
