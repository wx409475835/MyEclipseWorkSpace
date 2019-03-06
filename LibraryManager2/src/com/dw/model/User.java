package com.dw.model;

/**
 * @author bigshuai
 *@date 2017年5月8日
 *读者实体
 */
public class User {
	private int id;//管理员id
	private String username;//用户名
	private String password;//密码
	
	//添加
	private String phone;
	private String email;
	
	private String salt;//加盐
	//private String status;读者是否可用状态
	
	//private Date finalTime;最后登录时间
	

	public User() {

	}

	public User(int id, String username, String password, String phone, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	

	public User(String username, String password, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override//添加
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email="
				+ email + "]";
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
