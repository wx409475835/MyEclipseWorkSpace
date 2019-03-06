package com.nyist.plantsystem.model;

public class PageBean {
	private String uuidname;
	private String dat;
	private String filename;
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public PageBean(String uuidname, String dat, String filename) {
		super();
		this.uuidname = uuidname;
		this.dat = dat;
		this.filename = filename;
	}
	
	@Override
	public String toString() {
		return "PageBean [uuidname=" + uuidname + ", date=" + dat + ", filename=" + filename + "]";
	}
	public PageBean() {
		super();
	}

}
