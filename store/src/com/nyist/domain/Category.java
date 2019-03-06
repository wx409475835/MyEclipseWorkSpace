package com.nyist.domain;

import java.io.Serializable;

public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cid;
	private String cname;
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCid() {
		return cid;
	}
	public void setCi(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
