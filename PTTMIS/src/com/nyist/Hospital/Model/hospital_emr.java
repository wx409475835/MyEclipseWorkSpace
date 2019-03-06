package com.nyist.Hospital.Model;

import java.io.Serializable;
import java.util.Date;

//电子病历表		hospital electronic medical record
public class hospital_emr implements Serializable{
	private int hemr_id;			//电子病历ID
	private int hemr_patientid;		//电子病历病人编号
	private int hemr_doctorid;		//电子病历医生ID 
	private String hemr_starttime;	//治疗开始时间
	private String hemr_endtime;	//治疗结束时间
	private String hemr_treatisend;	//治疗是否结束
	private String hemr_diagnosis;	//诊断
	private String hemr_symptom;	//病状
	private String hemr_method;		//处方
	public int getHemr_id() {
		return hemr_id;
	}
	public void setHemr_id(int hemr_id) {
		this.hemr_id = hemr_id;
	}
	public int getHemr_patientid() {
		return hemr_patientid;
	}
	public void setHemr_patientid(int hemr_patientid) {
		this.hemr_patientid = hemr_patientid;
	}
	public int getHemr_doctorid() {
		return hemr_doctorid;
	}
	public void setHemr_doctorid(int hemr_doctorid) {
		this.hemr_doctorid = hemr_doctorid;
	}
	public String getHemr_starttime() {
		return hemr_starttime;
	}
	public void setHemr_starttime(String hemr_starttime) {
		this.hemr_starttime = hemr_starttime;
	}
	public String getHemr_endtime() {
		return hemr_endtime;
	}
	public void setHemr_endtime(String hemr_endtime) {
		this.hemr_endtime = hemr_endtime;
	}
	public String getHemr_treatisend() {
		return hemr_treatisend;
	}
	public void setHemr_treatisend(String hemr_treatisend) {
		this.hemr_treatisend = hemr_treatisend;
	}
	public String getHemr_diagnosis() {
		return hemr_diagnosis;
	}
	public void setHemr_diagnosis(String hemr_diagnosis) {
		this.hemr_diagnosis = hemr_diagnosis;
	}
	public String getHemr_symptom() {
		return hemr_symptom;
	}
	public void setHemr_symptom(String hemr_symptom) {
		this.hemr_symptom = hemr_symptom;
	}
	public String getHemr_method() {
		return hemr_method;
	}
	public void setHemr_method(String hemr_method) {
		this.hemr_method = hemr_method;
	}
	public hospital_emr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_emr(int hemr_id, int hemr_patientid, int hemr_doctorid,
			String hemr_starttime, String hemr_endtime, String hemr_treatisend,
			String hemr_diagnosis, String hemr_symptom, String hemr_method) {
		this.hemr_id = hemr_id;
		this.hemr_patientid = hemr_patientid;
		this.hemr_doctorid = hemr_doctorid;
		this.hemr_starttime = hemr_starttime;
		this.hemr_endtime = hemr_endtime;
		this.hemr_treatisend = hemr_treatisend;
		this.hemr_diagnosis = hemr_diagnosis;
		this.hemr_symptom = hemr_symptom;
		this.hemr_method = hemr_method;
	}
	@Override
	public String toString() {
		return "hospital_emr [hemr_id=" + hemr_id + ", hemr_patientid="
				+ hemr_patientid + ", hemr_doctorid=" + hemr_doctorid
				+ ", hemr_starttime=" + hemr_starttime + ", hemr_endtime="
				+ hemr_endtime + ", treatisend=" + hemr_treatisend
				+ ", hemr_diagnosis=" + hemr_diagnosis + ", symptom=" + hemr_symptom
				+ ", hemr_methdo=" + hemr_method + "]";
	}
	
}
