package nyist.net.Library.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class personread implements Serializable{
	private String read_id;				//借阅ID
	private String person_id;			//读者ID
	private String book_id;				//图书ID
	private String book_name;			//图书名称
	private String book_type;			//图书类型
	private String book_count;			//图书数量
	private String book_add;			//图书的出版社
	public String getRead_id() {
		return read_id;
	}
	public void setRead_id(String read_id) {
		this.read_id = read_id;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
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
	public personread() {
		super();
		// TODO Auto-generated constructor stub
	}
	public personread(String read_id, String person_id, String book_id,
			String book_name, String book_type, String book_count,
			String book_add) {
		super();
		this.read_id = read_id;
		this.person_id = person_id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_type = book_type;
		this.book_count = book_count;
		this.book_add = book_add;
	}
	@Override
	public String toString() {
		return "personread [read_id=" + read_id + ", person_id=" + person_id
				+ ", book_id=" + book_id + ", book_name=" + book_name
				+ ", book_type=" + book_type + ", book_count=" + book_count
				+ ", book_add=" + book_add + "]";
	}

}
