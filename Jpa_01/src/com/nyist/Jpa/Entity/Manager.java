package com.nyist.Jpa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="jpa_manager")
@Entity
public class Manager {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;
	@Column(name="mgr_name")
	private String mgrName;
	//对于不维护 关联关系的一方,使用@OneToOne 来进行映射关联属性,建议设置mapperBy=true 
	@OneToOne(mappedBy="mgr",fetch=FetchType.LAZY)
	private Department dept;
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMgrName() {
		return mgrName;
	}
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}
	protected Manager(Integer id, String mgrName) {
		this.id = id;
		this.mgrName = mgrName;
	}
	public Manager() {
		super();
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", mgrName=" + mgrName + ",dept="+dept+"]";
	}
}
