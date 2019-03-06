package com.nyist.Hospital.Model;

import java.io.Serializable;

//住院表
public class hospital_beinhospital implements Serializable{
	private int hbi_id;				//住院ID				
	private int hbi_patientid;		//住院病人ID
	private int hbi_doctorid;		//主治医生ID
	private int hbi_register;		//挂号
	private int hbi_bedid;			//床号
	public int getHbi_id() {
		return hbi_id;
	}
	public void setHbi_id(int hbi_id) {
		this.hbi_id = hbi_id;
	}
	public int getHbi_patientid() {
		return hbi_patientid;
	}
	public void setHbi_patientid(int hbi_patientid) {
		this.hbi_patientid = hbi_patientid;
	}
	public int getHbi_doctorid() {
		return hbi_doctorid;
	}
	public void setHbi_doctorid(int hbi_doctorid) {
		this.hbi_doctorid = hbi_doctorid;
	}
	public int getHbi_register() {
		return hbi_register;
	}
	public void setHbi_register(int hbi_register) {
		this.hbi_register = hbi_register;
	}
	public int getHbi_bedid() {
		return hbi_bedid;
	}
	public void setHbi_bedid(int hbi_bedid) {
		this.hbi_bedid = hbi_bedid;
	}
	public hospital_beinhospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_beinhospital(int hbi_id, int hbi_patientid,
			int hbi_doctorid, int hbi_register, int hbi_bedid) {
		super();
		this.hbi_id = hbi_id;
		this.hbi_patientid = hbi_patientid;
		this.hbi_doctorid = hbi_doctorid;
		this.hbi_register = hbi_register;
		this.hbi_bedid = hbi_bedid;
	}
	@Override
	public String toString() {
		return "hospital_beinhospital [hbi_id=" + hbi_id + ", hbi_patientid="
				+ hbi_patientid + ", hbi_doctorid=" + hbi_doctorid
				+ ", hbi_register=" + hbi_register + ", hbi_bedid=" + hbi_bedid
				+ "]";
	}
}
