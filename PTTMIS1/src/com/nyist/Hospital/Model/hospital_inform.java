package com.nyist.Hospital.Model;

import java.io.Serializable;
import java.util.Date;

//通知表		hospital  inform
public class hospital_inform implements Serializable{
	private int hi_id;			//通知ID
	private int hi_personid;	//操作人ID
	private String hi_tet;		//录入时间
	private String hi_content;	//通知内容
	public int getHi_id() {
		return hi_id;
	}
	public void setHi_id(int hi_id) {
		this.hi_id = hi_id;
	}
	public int getHi_personid() {
		return hi_personid;
	}
	public void setHi_personid(int hi_personid) {
		this.hi_personid = hi_personid;
	}
	public String getHi_tet() {
		return hi_tet;
	}
	public void setHi_tet(String hi_tet) {
		this.hi_tet = hi_tet;
	}
	public String getHi_content() {
		return hi_content;
	}
	public void setHi_content(String hi_content) {
		this.hi_content = hi_content;
	}
	public hospital_inform() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_inform(int hi_id, int hi_personid, String hi_tet,
			String hi_content) {
		super();
		this.hi_id = hi_id;
		this.hi_personid = hi_personid;
		this.hi_tet = hi_tet;
		this.hi_content = hi_content;
	}
	@Override
	public String toString() {
		return "hospital_inform [hi_id=" + hi_id + ", hi_personid="
				+ hi_personid + ", hi_tet=" + hi_tet + ", hi_content="
				+ hi_content + "]";
	}
	
}
