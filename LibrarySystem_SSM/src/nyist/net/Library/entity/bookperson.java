package nyist.net.Library.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class bookperson implements Serializable{
	private String person_id;			//读者id
	private String person_name;			//读者的姓名
	private int person_age;				//读者年龄
	private String person_sex;			//读者性别
	private String person_we;			//读者微信
	private String person_com;			//读者的邮箱
	private String person_mobile;		//读者的手机号
	private String person_add;			//读者的地址 
	
	
	
	public String getPerson_sex() {
		return person_sex;
	}
	public void setPerson_sex(String person_sex) {
		this.person_sex = person_sex;
	}
	public String getPerson_we() {
		return person_we;
	}
	public void setPerson_we(String person_we) {
		this.person_we = person_we;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public int getPerson_age() {
		return person_age;
	}
	public void setPerson_age(int person_age) {
		this.person_age = person_age;
	}
	public String getPersong_sex() {
		return person_sex;
	}
	public void setPersong_sex(String person_sex) {
		this.person_sex = person_sex;
	}
	public String getPersong_we() {
		return person_we;
	}
	public void setPersong_we(String person_we) {
		this.person_we = person_we;
	}
	public String getPerson_com() {
		return person_com;
	}
	public void setPerson_com(String person_com) {
		this.person_com = person_com;
	}
	public String getPerson_mobile() {
		return person_mobile;
	}
	public void setPerson_mobile(String person_mobile) {
		this.person_mobile = person_mobile;
	}
	public String getPerson_add() {
		return person_add;
	}
	public void setPerson_add(String person_add) {
		this.person_add = person_add;
	}
	public bookperson(String person_id, String person_name, int person_age,
			String person_sex, String person_we, String person_com,
			String person_mobile, String person_add) {
		super();
		this.person_id = person_id;
		this.person_name = person_name;
		this.person_age = person_age;
		this.person_sex = person_sex;
		this.person_we = person_we;
		this.person_com = person_com;
		this.person_mobile = person_mobile;
		this.person_add = person_add;
	}
	public bookperson() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "bookperson [person_id=" + person_id + ", person_name="
				+ person_name + ", person_age=" + person_age + ", person_sex="
				+ person_sex + ", person_we=" + person_we + ", person_com="
				+ person_com + ", person_mobile=" + person_mobile
				+ ", person_add=" + person_add + "]";
	}
}
