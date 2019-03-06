package com.nyist.Jpa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="jpa_department")
@Entity
public class Department {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="dept_name")
	private String deptName;
	
	//使用@OneToOne 来映射 一对一 关系
	//若需要在当前数据表中添加主键则使用 @JOinColumn() 来映射,注意 一对一关联关系  需要添加 unique=true
	//注意:	@Column 和 @OneToOne 、@ManyToOne 等注解 不能一块使用
	//@Column(name="mgr")
	@JoinColumn(name="mgr_id",unique=true,nullable=false)
	@OneToOne(fetch=FetchType.LAZY)
	private Manager mgr;
	
	public Manager getMgr() {
		return mgr;
	}
	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Department(Integer id, String deptName,Manager mgr) {
		this.id = id;
		this.deptName = deptName;
		this.mgr=mgr;
	}
	public Department() {
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName +",mgr="+mgr+"]";
	}
}
