package com.nyist.Hospital.Model;

import java.io.Serializable;
import java.util.Date;

//预约表		hospital reservation
public class hospital_reservation implements Serializable{
	private int hr_id;				//预约ID
	private int hr_personid;		//预约人ID
	private Date hr_tet;			//录入时间
	private String hr_title;		//标题
	private String hr_content;		//内容
	public int getHr_id() {
		return hr_id;
	}
	public void setHr_id(int hr_id) {
		this.hr_id = hr_id;
	}
	public int getHr_personid() {
		return hr_personid;
	}
	public void setHr_personid(int hr_personid) {
		this.hr_personid = hr_personid;
	}
	public Date getHr_tet() {
		return hr_tet;
	}
	public void setHr_tet(Date hr_tet) {
		this.hr_tet = hr_tet;
	}
	public String getHr_title() {
		return hr_title;
	}
	public void setHr_title(String hr_title) {
		this.hr_title = hr_title;
	}
	public String getHr_content() {
		return hr_content;
	}
	public void setHr_content(String hr_content) {
		this.hr_content = hr_content;
	}
	public hospital_reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_reservation(int hr_id, int hr_personid, Date hr_tet,
			String hr_title, String hr_content) {
		super();
		this.hr_id = hr_id;
		this.hr_personid = hr_personid;
		this.hr_tet = hr_tet;
		this.hr_title = hr_title;
		this.hr_content = hr_content;
	}
	@Override
	public String toString() {
		return "hospital_reservation [hr_id=" + hr_id + ", hr_personid="
				+ hr_personid + ", hr_tet=" + hr_tet + ", hr_title=" + hr_title
				+ ", hr_content=" + hr_content + "]";
	}
	
}
