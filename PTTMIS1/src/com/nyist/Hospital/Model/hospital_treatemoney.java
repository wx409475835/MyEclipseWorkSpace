package com.nyist.Hospital.Model;

import java.io.Serializable;
//治疗费用表		hospital	treatemoney
@SuppressWarnings("serial")
public class hospital_treatemoney implements Serializable{
	private int htm_id;					//治疗费用ID
	private int htm_patientid;			//病人编号
	private String htm_name;		//费用名称
	private String htm_ispaymoney;		//是否付款
	private String htm_treatmoneytype;	//治疗费用类型
	private String htm_moneyconsum;		//消费金额
	private String htm_consumtime;		//消费日期
	public int getHtm_id() {
		return htm_id;
	}
	public void setHtm_id(int htm_id) {
		this.htm_id = htm_id;
	}
	public int getHtm_patientid() {
		return htm_patientid;
	}
	public void setHtm_patientid(int htm_patientid) {
		this.htm_patientid = htm_patientid;
	}
	public String getHtm_name() {
		return htm_name;
	}
	public void setHtm_name(String htm_name) {
		this.htm_name = htm_name;
	}
	public String getHtm_ispaymoney() {
		return htm_ispaymoney;
	}
	public void setHtm_ispaymoney(String htm_ispaymoney) {
		this.htm_ispaymoney = htm_ispaymoney;
	}
	public String getHtm_treatmoneytype() {
		return htm_treatmoneytype;
	}
	public void setHtm_treatmoneytype(String htm_treatmoneytype) {
		this.htm_treatmoneytype = htm_treatmoneytype;
	}
	public String getHtm_moneyconsum() {
		return htm_moneyconsum;
	}
	public void setHtm_moneyconsum(String htm_moneyconsum) {
		this.htm_moneyconsum = htm_moneyconsum;
	}
	public String getHtm_consumtime() {
		return htm_consumtime;
	}
	public void setHtm_consumtime(String htm_consumtime) {
		this.htm_consumtime = htm_consumtime;
	}
	public hospital_treatemoney() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_treatemoney(int htm_id, int htm_patientid,
			String htm_name, String htm_ispaymoney,
			String htm_treatmoneytype, String htm_moneyconsum, String htm_consumtime) {
		super();
		this.htm_id = htm_id;
		this.htm_patientid = htm_patientid;
		this.htm_name = htm_name;
		this.htm_ispaymoney = htm_ispaymoney;
		this.htm_treatmoneytype = htm_treatmoneytype;
		this.htm_moneyconsum = htm_moneyconsum;
		this.htm_consumtime = htm_consumtime;
	}
	@Override
	public String toString() {
		return "hospital_treatemoney [htm_id=" + htm_id + ", htm_patientid="
				+ htm_patientid + ", htr_nameString=" + htm_name
				+ ", htm_ispaymoney=" + htm_ispaymoney
				+ ", htm_treatmoneytype=" + htm_treatmoneytype
				+ ", htm_moneyconsum=" + htm_moneyconsum + ", htm_consumtime="
				+ htm_consumtime + "]";
	}
	
}
