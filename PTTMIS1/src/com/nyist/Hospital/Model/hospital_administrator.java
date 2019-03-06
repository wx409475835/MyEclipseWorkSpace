package com.nyist.Hospital.Model;

import java.io.Serializable;

//管理员表  hospital administrator
public class hospital_administrator implements Serializable{
	private int ha_id;					//管理员ID
	private String ha_username;			//管理员用户名
	private String ha_account;			//管理员账户名
	private String ha_password;		    //管理员密码
	public int getHa_id() {
		return ha_id;
	}
	public void setHa_id(int ha_id) {
		this.ha_id = ha_id;
	}
	public String getHa_username() {
		return ha_username;
	}
	public void setHa_username(String ha_username) {
		this.ha_username = ha_username;
	}
	public String getHa_account() {
		return ha_account;
	}
	public void setHa_account(String ha_account) {
		this.ha_account = ha_account;
	}
	public String getHa_password() {
		return ha_password;
	}
	public void setHa_password(String ha_password) {
		this.ha_password = ha_password;
	}
	public hospital_administrator(int ha_id, String ha_username,
			String ha_account, String ha_password) {
		super();
		this.ha_id = ha_id;
		this.ha_username = ha_username;
		this.ha_account = ha_account;
		this.ha_password = ha_password;
	}
	public hospital_administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "hospital_administrator [ha_id=" + ha_id + ", ha_username="
				+ ha_username + ", ha_account=" + ha_account + ", ha_password="
				+ ha_password + "]";
	}
}
