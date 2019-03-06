package com.nyist.cn.model;

//实体
public class Upfile {
	private String id;										//文件ID
	private String uuidname;								//uuid文件名称
	private String filename;								//文件的真实名称
	private String savepath;								//文件的保存路径
	private String uptime;									//文件上传时间
	private String description;								//文件的描述
	private String username;								//上传的用户
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}							
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Upfile() {
		super();
	}
	public Upfile(String id, String uuidname, String filename, String savepath, String uptime,String description, String username) {
		super();
		this.id = id;
		this.uuidname = uuidname;
		this.filename = filename;
		this.savepath = savepath;
		this.uptime = uptime;
		this.description = description;
		this.username = username;
	}
	@Override
	public String toString() {
		return "upfile [id=" + id + ", uuidname=" + uuidname + ", filename=" + filename + ", savepath=" + savepath
				+ ", uptime=" + uptime + ",description="+description+", username=" + username + "]";
	}
}
