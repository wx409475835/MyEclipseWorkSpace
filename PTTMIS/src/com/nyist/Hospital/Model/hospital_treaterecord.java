package com.nyist.Hospital.Model;

import java.io.Serializable;
import java.util.Date;

//治疗记录表			hospital  treaterecord
public class hospital_treaterecord implements Serializable{
	private int htr_id;				//治疗记录ID
	private int htr_doctorid;		//主治医生ID
	private int htr_patientid;		//病人ID
	private String htr_treatecase;		//治疗详情
	private int htr_aotoid;			//科室ID
	private int htr_treatetimes;		//治疗次数
	private String htr_treatetime;	//治疗时间
	public int getHtr_id() {
		return htr_id;
	}
	public void setHtr_id(int htr_id) {
		this.htr_id = htr_id;
	}
	public int getHtr_doctorid() {
		return htr_doctorid;
	}
	public void setHtr_doctorid(int htr_doctorid) {
		this.htr_doctorid = htr_doctorid;
	}
	public int getHtr_patientid() {
		return htr_patientid;
	}
	public void setHtr_patientid(int htr_patientid) {
		this.htr_patientid = htr_patientid;
	}
	public String getHtr_treatecase() {
		return htr_treatecase;
	}
	public void setHtr_treatecase(String htr_treatecase) {
		this.htr_treatecase = htr_treatecase;
	}
	public int getHtr_aotoid() {
		return htr_aotoid;
	}
	public void setHtr_aotoid(int htr_aotoid) {
		this.htr_aotoid = htr_aotoid;
	}
	public int getHtr_treatetimes() {
		return htr_treatetimes;
	}
	public void setHtr_treatetimes(int htr_treatetimes) {
		this.htr_treatetimes = htr_treatetimes;
	}
	public String getHtr_treatetime() {
		return htr_treatetime;
	}
	public void setHtr_treatetime(String htr_treatetime) {
		this.htr_treatetime = htr_treatetime;
	}
	public hospital_treaterecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_treaterecord(int htr_id, int htr_doctorid,
			int htr_patientid, String htr_treatecase, int htr_aotoid,
			int htr_treatetimes, String htr_treatetime) {
		super();
		this.htr_id = htr_id;
		this.htr_doctorid = htr_doctorid;
		this.htr_patientid = htr_patientid;
		this.htr_treatecase = htr_treatecase;
		this.htr_aotoid = htr_aotoid;
		this.htr_treatetimes = htr_treatetimes;
		this.htr_treatetime = htr_treatetime;
	}
	@Override
	public String toString() {
		return "hospital_treaterecord [htr_id=" + htr_id + ", htr_doctorid="
				+ htr_doctorid + ", htr_patientid=" + htr_patientid
				+ ", treatecase=" + htr_treatecase + ", htr_aotoid=" + htr_aotoid
				+ ", treatetimes=" + htr_treatetimes + ", htr_treatetime="
				+ htr_treatetime + "]";
	}
	
}
