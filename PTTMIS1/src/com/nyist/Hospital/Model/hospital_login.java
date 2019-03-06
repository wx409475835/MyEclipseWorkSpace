package com.nyist.Hospital.Model;

import java.io.Serializable;

//登陆表		history login
public class hospital_login implements Serializable{
	private String hl_username;			//用户名
	private String hl_password;			//密码
	private int hl_doctorid;		    //医生用户ID
	public String getHl_username(){
		return hl_username;
	}
	public void setHl_username(String hl_username) {
		this.hl_username = hl_username;
	}
	public String getHl_password() {
		return hl_password;
	}
	public void setHl_password(String hl_password) {
		this.hl_password = hl_password;
	}
	public int getHl_doctorid() {
		return hl_doctorid;
	}
	public void setHl_doctorid(int hl_doctorid) {
		this.hl_doctorid = hl_doctorid;
	}
	public hospital_login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_login(String hl_username, String hl_password,
			int hl_doctorid) {
		super();
		this.hl_username = hl_username;
		this.hl_password = hl_password;
		this.hl_doctorid = hl_doctorid;
	}
	@Override
	public String toString() {
		return "hospital_login [hl_username=" + hl_username + ", hl_password="
				+ hl_password + ", hl_authorityid=" + hl_doctorid + "]";
	}

}
