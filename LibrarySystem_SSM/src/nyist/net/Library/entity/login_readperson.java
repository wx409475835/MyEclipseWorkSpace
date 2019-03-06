package nyist.net.Library.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class login_readperson implements Serializable{
	private String username;	//登陆用户名
	private String pw;			//登陆密码
	private String person_id;	//登陆ID
	private String ident;		//登陆身份
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public login_readperson(String username, String pw, String person_id) {
		super();
		this.username = username;
		this.pw = pw;
		this.person_id = person_id;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public login_readperson() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "login_readperson [username=" + username + ", pw=" + pw
				+ ", person_id=" + person_id + ", ident=" + ident + "]";
	}
}
