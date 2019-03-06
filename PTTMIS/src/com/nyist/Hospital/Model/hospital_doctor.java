package com.nyist.Hospital.Model;

import java.io.Serializable;

//医生表		hospital doctor
public class hospital_doctor implements Serializable{
	private int hd_id;				//医生ID
	private String hd_name;			//医生姓名
	private int hd_age;				//医生年龄
	private String hd_sex;			//医生性别
	private String hd_speciality;	//医生特长
	private String hd_pt;			//医生的职责
	private String hd_ri;			//医生预约信息
	private String hd_haotoid;		//医生科室ID
	private String hd_mobile;	    //医生手机号
	public int getHd_id() {
		return hd_id;
	}
	public void setHd_id(int hd_id) {
		this.hd_id = hd_id;
	}
	public String getHd_name() {
		return hd_name;
	}
	public void setHd_name(String hd_name) {
		this.hd_name = hd_name;
	}
	public int getHd_age() {
		return hd_age;
	}
	public void setHd_age(int hd_age) {
		this.hd_age = hd_age;
	}
	public String getHd_sex() {
		return hd_sex;
	}
	public void setHd_sex(String hd_sex) {
		this.hd_sex = hd_sex;
	}
	public String getHd_speciality() {
		return hd_speciality;
	}
	public void setHd_speciality(String hd_speciality) {
		this.hd_speciality = hd_speciality;
	}
	public String getHd_pt() {
		return hd_pt;
	}
	public void setHd_pt(String hd_pt) {
		this.hd_pt = hd_pt;
	}
	public String getHd_ri() {
		return hd_ri;
	}
	public void setHd_ri(String hd_ri) {
		this.hd_ri = hd_ri;
	}
	public String getHd_haotoid() {
		return hd_haotoid;
	}
	public void setHd_haotoid(String hd_haotoid) {
		this.hd_haotoid = hd_haotoid;
	}
	public String getHd_mobile() {
		return hd_mobile;
	}
	public void setHd_mobile(String hd_mobile) {
		this.hd_mobile = hd_mobile;
	}
	public hospital_doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_doctor(int hd_id, String hd_name, int hd_age,
			String hd_sex, String hd_speciality, String hd_pt, String hd_ri,
			String hd_haotoid, String hd_mobile) {
		super();
		this.hd_id = hd_id;
		this.hd_name = hd_name;
		this.hd_age = hd_age;
		this.hd_sex = hd_sex;
		this.hd_speciality = hd_speciality;
		this.hd_pt = hd_pt;
		this.hd_ri = hd_ri;
		this.hd_haotoid = hd_haotoid;
		this.hd_mobile = hd_mobile;
	}
	@Override
	public String toString() {
		return "hospital_doctor [hd_id=" + hd_id + ", hd_name=" + hd_name
				+ ", hd_age=" + hd_age + ", hd_sex=" + hd_sex
				+ ", hd_speciality=" + hd_speciality + ", hd_pt=" + hd_pt
				+ ", hd_ri=" + hd_ri + ", hd_haotoid=" + hd_haotoid
				+ ", hd_mobile=" + hd_mobile + "]";
	}
	
}
