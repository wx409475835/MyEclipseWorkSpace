package com.nyist.Hospital.Model;

import java.io.Serializable;

//费用结算表	hospital fee settlement
public class hospital_fee_settlement implements Serializable{
	private int hfs_id;			//费用结算ID
	private int hfs_bedid;		//床号
	private int hfs_register;	//挂号
	private int hfs_patientid;	//病人ID
	private String hfs_ispay;	//是否支付
	private int allmoney;		//总金额
	public int getHfs_id() {
		return hfs_id;
	}
	public void setHfs_id(int hfs_id) {
		this.hfs_id = hfs_id;
	}
	public int getHfs_bedid() {
		return hfs_bedid;
	}
	public void setHfs_bedid(int hfs_bedid) {
		this.hfs_bedid = hfs_bedid;
	}
	public int getHfs_register() {
		return hfs_register;
	}
	public void setHfs_register(int hfs_register) {
		this.hfs_register = hfs_register;
	}
	public int getHfs_patientid() {
		return hfs_patientid;
	}
	public void setHfs_patientid(int hfs_patientid) {
		this.hfs_patientid = hfs_patientid;
	}
	public String getHfs_ispay() {
		return hfs_ispay;
	}
	public void setHfs_ispay(String hfs_ispay) {
		this.hfs_ispay = hfs_ispay;
	}
	public int getAllmoney() {
		return allmoney;
	}
	public void setAllmoney(int allmoney) {
		this.allmoney = allmoney;
	}
	public hospital_fee_settlement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_fee_settlement(int hfs_id, int hfs_bedid, int hfs_register,
			int hfs_patientid, String hfs_ispay, int allmoney) {
		super();
		this.hfs_id = hfs_id;
		this.hfs_bedid = hfs_bedid;
		this.hfs_register = hfs_register;
		this.hfs_patientid = hfs_patientid;
		this.hfs_ispay = hfs_ispay;
		this.allmoney = allmoney;
	}
	@Override
	public String toString() {
		return "hospital_fee_settlement [hfs_id=" + hfs_id + ", hfs_bedid="
				+ hfs_bedid + ", hfs_register=" + hfs_register
				+ ", hfs_patientid=" + hfs_patientid + ", hfs_ispay="
				+ hfs_ispay + ", allmoney=" + allmoney + "]";
	}
	
}
