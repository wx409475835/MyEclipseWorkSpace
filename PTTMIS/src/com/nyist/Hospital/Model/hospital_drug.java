package com.nyist.Hospital.Model;

import java.io.Serializable;
import java.util.Date;

//药品表		hospital drug
public class hospital_drug implements Serializable{
	private int hdrug_id;				//药品ID
	private String hdrug_name;			//药品名称
	private Double hdrug_price;			//药品价格
	private String hdrug_birthday;		//药品生产日期
	private String hdrug_type;			//药品类型
	private String hdrug_introduce;		//药品介绍
	public int getHdrug_id() {
		return hdrug_id;
	}
	public void setHdrug_id(int hdrug_id) {
		this.hdrug_id = hdrug_id;
	}
	public String getHdrug_name() {
		return hdrug_name;
	}
	public void setHdrug_name(String hdrug_name) {
		this.hdrug_name = hdrug_name;
	}
	public Double getHdrug_price() {
		return hdrug_price;
	}
	public void setHdrug_price(Double hdrug_price) {
		this.hdrug_price = hdrug_price;
	}
	public String getHdrug_birthday() {
		return hdrug_birthday;
	}
	public void setHdrug_birthday(String hdrug_birthday) {
		this.hdrug_birthday = hdrug_birthday;
	}
	public String getHdrug_type() {
		return hdrug_type;
	}
	public void setHdrug_type(String hdrug_type) {
		this.hdrug_type = hdrug_type;
	}
	public String getHdrug_introduce() {
		return hdrug_introduce;
	}
	public void setHdrug_introduce(String hdrug_introduce) {
		this.hdrug_introduce = hdrug_introduce;
	}
	public hospital_drug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_drug(int hdrug_id, String hdrug_name, Double hdrug_price,
			String hdrug_birthday, String hdrug_type, String hdrug_introduce) {
		super();
		this.hdrug_id = hdrug_id;
		this.hdrug_name = hdrug_name;
		this.hdrug_price = hdrug_price;
		this.hdrug_birthday = hdrug_birthday;
		this.hdrug_type = hdrug_type;
		this.hdrug_introduce = hdrug_introduce;
	}
	@Override
	public String toString() {
		return "hdrug_id=" + hdrug_id + ", hdrug_name="
				+ hdrug_name + ", hdrug_price=" + hdrug_price
				+ ", hdrug_birthday=" + hdrug_birthday + ", hdrug_type="
				+ hdrug_type + ", hdrug_introduce=" + hdrug_introduce;
	}
	
}
