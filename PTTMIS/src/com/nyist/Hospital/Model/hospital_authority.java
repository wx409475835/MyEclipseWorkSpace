package com.nyist.Hospital.Model;

import java.io.Serializable;

//权限表
public class hospital_authority implements Serializable{
	private int hau_id;					//权限ID
	private String hau_name;				//权限名称
	public hospital_authority() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_authority(int hau_id, String hau_name) {
		super();
		this.hau_id = hau_id;
		this.hau_name = hau_name;
	}
	public int getHau_id() {
		return hau_id;
	}
	public void setHau_id(int hau_id) {
		this.hau_id = hau_id;
	}
	public String getHau_name() {
		return hau_name;
	}
	public void setHau_name(String hau_name) {
		this.hau_name = hau_name;
	}
	@Override
	public String toString() {
		return "hospital_authority [hau_id=" + hau_id + ", hau_name="
				+ hau_name + "]";
	}
	
}
