package com.nyist.Hospital.Model;

import java.io.Serializable;

//药品库		hospital drugstore
public class hospital_drugstore implements Serializable{
	private int hds_id;					//药品库ID
	private int hds_patientid;			//病人ID
	private int hds_drugid;				//药品ID
	public int getHds_id() {
		return hds_id;
	}
	public void setHds_id(int hds_id) {
		this.hds_id = hds_id;
	}
	public int getHds_patientid() {
		return hds_patientid;
	}
	public void setHds_patientid(int hds_patientid) {
		this.hds_patientid = hds_patientid;
	}
	public int getHds_drugid() {
		return hds_drugid;
	}
	public void setHds_drugid(int hds_drugid) {
		this.hds_drugid = hds_drugid;
	}
	public hospital_drugstore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_drugstore(int hds_id, int hds_patientid, int hds_drugid) {
		super();
		this.hds_id = hds_id;
		this.hds_patientid = hds_patientid;
		this.hds_drugid = hds_drugid;
	}
	@Override
	public String toString() {
		return "hospital_drugstore [hds_id=" + hds_id + ", hds_patientid="
				+ hds_patientid + ", hds_drugid=" + hds_drugid + "]";
	}
	
}
