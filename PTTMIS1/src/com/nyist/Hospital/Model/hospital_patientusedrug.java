package com.nyist.Hospital.Model;

public class hospital_patientusedrug {
	private int hpt_id;
	private int hpt_patientid;
	private int hpt_drugid;
	private int hpt_count;
	
	public int getHpt_count() {
		return hpt_count;
	}
	public void setHpt_count(int hpt_count) {
		this.hpt_count = hpt_count;
	}
	public int getHpt_id() {
		return hpt_id;
	}
	public void setHpt_id(int hpt_id) {
		this.hpt_id = hpt_id;
	}
	public int getHpt_patientid() {
		return hpt_patientid;
	}
	public void setHpt_patientid(int hpt_patientid) {
		this.hpt_patientid = hpt_patientid;
	}
	public int getHpt_drugid() {
		return hpt_drugid;
	}
	public void setHpt_drugid(int hpt_drugid) {
		this.hpt_drugid = hpt_drugid;
	}
	public hospital_patientusedrug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_patientusedrug(int hpt_id, int hpt_patientid,
			int hpt_drugid, int hpt_count) {
		super();
		this.hpt_id = hpt_id;
		this.hpt_patientid = hpt_patientid;
		this.hpt_drugid = hpt_drugid;
		this.hpt_count = hpt_count;
	}
	@Override
	public String toString() {
		return "hospital_patientusedrug [hpt_id=" + hpt_id + ", hpt_patientid="
				+ hpt_patientid + ", hpt_drugid=" + hpt_drugid + ", hpt_count="
				+ hpt_count + "]";
	}
	
}
