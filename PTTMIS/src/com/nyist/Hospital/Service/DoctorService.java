package com.nyist.Hospital.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nyist.Hospital.Model.hospital_inform;
import com.nyist.Hospital.Model.hospital_login;
import com.nyist.Hospital.Model.hospital_treatemoney;
import com.nyist.Hospital.Pagination.PageBean;
import com.nyist.Hospital.Pagination.QueryInfo;

public interface DoctorService {
	/**
	 * 注册医生用户信息注册
	 * @param hLogin
	 */
	public void InsertDoctorLoginInfo(hospital_login hLogin);
	/**
	 * 判断医生用户名是否存在
	 * @param hd_name
	 * @return
	 */
	public String JudgeDoctorName(String hd_name);
	/**
	 * 判断病人姓名是否已经存在
	 * @param hp_name
	 * @return
	 */
	public String JudgePatientName(String hp_name);
	/**
	 * 医生用户登陆
	 * @param hLogin
	 * @return
	 */
	public String DoctorLogin(@Param("hl_username")String hl_usernameString,@Param("hl_password")String hl_password);
	/**
	 * 更新医生用户用户名和密码
	 * @param username
	 * @param password
	 */
	public void  UpdateDoctorAccountPassword(hospital_login hLogin);
	/**
	 * 通过  医生id  获得  登陆用户名
	 * @param hl_doctorid
	 * @return
	 */
	public String SelectHl_usernameByHl_doctorid(int hl_doctorid);
	/**
	 * 通过  病人ID 查询 结算记录
	 */
	public hospital_treatemoney SelectTreateMoneyByHtm_patientid(int htm_patientid);
	/**
	 * 查询账户 
	 * @param account
	 * @return
	 */
	public List<String> SelectAccount(String account);
	
	//医生用户  清空通知功能
	/**
	 * 查询  所有通知
	 * @return
	 */
	public List<hospital_inform> SelectAllInforms();
	
	//添加   通知功能
	/**
	 * 添加通知功能
	 * @param hInform
	 */
	public void AddInforms(hospital_inform hInform);
	//清空表中得所有数据
	/**
	 * 清除表中得所有数据
	 */
	public void DeleteAllInforms();
	
	//更新通知消息
	/**
	 * 更新 通知 信息
	 * @param hi_id
	 * @param hi_personid
	 */
	public void UpdateInformById(hospital_inform hInform);
	/*
	 * 分页技术
	 * */
	/**
	 * 查询List集合,传递参数,起始位置和页面大小
	 * @param startIndex
	 * @param pagesize
	 * @return
	 */
	public List QueryLimitListHospital_doctor_inform(@Param("startIndex")int startIndex,@Param("pagesize")int pagesize);
	/**
	 * 查询 表hospital_doctor_inform 总记录数
	 * @return
	 */
	public int CountHospital_doctor_inform();
	/**
	 * 通过 QueryInfo带来的参数,查询页面需要的PageBean
	 * @param queryInfo
	 * @return
	 */
	public PageBean pageQueryHospital_doctor_inform(QueryInfo queryInfo);
}
