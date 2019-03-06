package com.nyist.Hospital.Model;

import java.io.Serializable;

//医生与权限对应表	history doctor authority
public class hospital_doctor_authority implements Serializable{
	private int hda_id;
	private int hda_aid;
	private int hda_authorityid;
	public hospital_doctor_authority() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_doctor_authority(int hda_id, int hda_aid,
			int hda_authorityid) {
		super();
		this.hda_id = hda_id;
		this.hda_aid = hda_aid;
		this.hda_authorityid = hda_authorityid;
	}
	@Override
	public String toString() {
		return "hospital_doctor_authority [hda_id=" + hda_id + ", hda_aid="
				+ hda_aid + ", hda_authorityid=" + hda_authorityid + "]";
	}
	public int getHda_id() {
		return hda_id;
	}
	public void setHda_id(int hda_id) {
		this.hda_id = hda_id;
	}
	public int getHda_aid() {
		return hda_aid;
	}
	public void setHda_aid(int hda_aid) {
		this.hda_aid = hda_aid;
	}
	public int getHda_authorityid() {
		return hda_authorityid;
	}
	public void setHda_authorityid(int hda_authorityid) {
		this.hda_authorityid = hda_authorityid;
	}
	
}	
