package day2.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Per implements Serializable{
	private String username;
	private String pwd;
	private String email;
	private Date birthday;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Per [username=" + username + ", pwd=" + pwd + ", email="
				+ email + ", birthday=" + birthday + "]";
	}
	public Per() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Per(String username, String pwd, String email, Date birthday) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.birthday = birthday;
	}
}