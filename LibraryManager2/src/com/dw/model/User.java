package com.dw.model;

/**
 * @author bigshuai
 *@date 2017��5��8��
 *����ʵ��
 */
public class User {
	private int id;//����Աid
	private String username;//�û���
	private String password;//����
	
	//���
	private String phone;
	private String email;
	
	private String salt;//����
	//private String status;�����Ƿ����״̬
	
	//private Date finalTime;����¼ʱ��
	

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

	@Override//���
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
