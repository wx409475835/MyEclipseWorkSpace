package com.nyist.Hospital.Model;

import java.io.Serializable;
import java.util.Date;

//病人表		hospital	patient
@SuppressWarnings("serial")
public class hospital_patient implements Serializable{
	private int hp_id;			//病人ID
	private int hp_doctorid;	//主治医生ID
	private String hp_name;		//病人姓名
	private String hp_sex;		//病人性别
	private String hp_birthday;	//病人生日
	private String hp_tath;		//入院时间
	private String hp_tsd;		//症状描述
	private int hp_mrid;		//病历编号
	private String hp_stat;		//病人状态
	private String hp_marry;	//病人婚否
	public int getHp_id() {
		return hp_id;
	}
	public void setHp_id(int hp_id) {
		this.hp_id = hp_id;
	}
	public int getHp_doctorid() {
		return hp_doctorid;
	}
	public void setHp_doctorid(int hp_doctorid) {
		this.hp_doctorid = hp_doctorid;
	}
	public String getHp_name() {
		return hp_name;
	}
	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}
	public String getHp_sex() {
		return hp_sex;
	}
	public void setHp_sex(String hp_sex) {
		this.hp_sex = hp_sex;
	}
	public String getHp_birthday() {
		return hp_birthday;
	}
	public void setHp_birthday(String hp_birthday) {
		this.hp_birthday = hp_birthday;
	}
	public String getHp_tath() {
		return hp_tath;
	}
	public void setHp_tath(String hp_tath) {
		this.hp_tath = hp_tath;
	}
	public String getHp_tsd() {
		return hp_tsd;
	}
	public void setHp_tsd(String hp_tsd) {
		this.hp_tsd = hp_tsd;
	}
	public int getHp_mrid() {
		return hp_mrid;
	}
	public void setHp_mrid(int hp_mrid) {
		this.hp_mrid = hp_mrid;
	}
	public String getHp_stat() {
		return hp_stat;
	}
	public void setHp_stat(String hp_stat) {
		this.hp_stat = hp_stat;
	}
	public String getHp_marry() {
		return hp_marry;
	}
	public void setHp_marry(String hp_marry) {
		this.hp_marry = hp_marry;
	}
	public hospital_patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hospital_patient(int hp_id, int hp_doctorid, String hp_name,
			String hp_sex, String hp_birthday, String hp_tath, String hp_tsd,
			int hp_mrid, String hp_stat, String hp_marry) {
		super();
		this.hp_id = hp_id;
		this.hp_doctorid = hp_doctorid;
		this.hp_name = hp_name;
		this.hp_sex = hp_sex;
		this.hp_birthday = hp_birthday;
		this.hp_tath = hp_tath;
		this.hp_tsd = hp_tsd;
		this.hp_mrid = hp_mrid;
		this.hp_stat = hp_stat;
		this.hp_marry = hp_marry;
	}
	@Override
	public String toString() {
		return "hospital_patient [hp_id=" + hp_id + ", hp_doctorid="
				+ hp_doctorid + ", hp_name=" + hp_name + ", hp_sex=" + hp_sex
				+ ", hp_birthday=" + hp_birthday + ", hp_tath=" + hp_tath
				+ ", tsd=" + hp_tsd + ", hp_mrid=" + hp_mrid + ", hp_stat="
				+ hp_stat + ", hp_marry=" + hp_marry + "]";
	}
	
}
