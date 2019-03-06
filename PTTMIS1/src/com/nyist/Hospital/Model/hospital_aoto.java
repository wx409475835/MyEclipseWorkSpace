package com.nyist.Hospital.Model;

import java.io.Serializable;

//科室表 history administrative or technical offices
public class hospital_aoto implements Serializable{
	private int haoto_id;		//科室ID
	private String haoto_name;		//科室名称
	private String haoto_person;	//科室负责人
	private String haoto_decribe;	//科室描述
	public int getHaoto_id() {
		return haoto_id;
	}
	public void setHaoto_id(int haoto_id) {
		this.haoto_id = haoto_id;
	}
	public String getHaoto_name() {
		return haoto_name;
	}
	public void setHaoto_name(String haoto_name) {
		this.haoto_name = haoto_name;
	}
	public String getHaoto_person() {
		return haoto_person;
	}
	public void setHaoto_person(String haoto_person) {
		this.haoto_person = haoto_person;
	}
	public String getHaoto_decribe() {
		return haoto_decribe;
	}
	public void setHaoto_describe(String haoto_decribe) {
		this.haoto_decribe = haoto_decribe;
	}
	public hospital_aoto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_aoto(int haoto_id, String haoto_name,
			String haoto_person, String haoto_decribe) {
		super();
		this.haoto_id = haoto_id;
		this.haoto_name = haoto_name;
		this.haoto_person = haoto_person;
		this.haoto_decribe = haoto_decribe;
	}
	@Override
	public String toString() {
		return "hospital_aoto [haoto_id=" + haoto_id + ", haoto_name="
				+ haoto_name + ", haoto_person=" + haoto_person
				+ ", haoto_describe=" + haoto_decribe + "]";
	}
}
