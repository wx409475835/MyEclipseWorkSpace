package com.nyist.Hospital.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nyist.Hospital.Model.hospital_administrator;
import com.nyist.Hospital.Model.hospital_aoto;
import com.nyist.Hospital.Model.hospital_doctor;
import com.nyist.Hospital.Model.hospital_doctor_authority;
import com.nyist.Hospital.Model.hospital_drug;
import com.nyist.Hospital.Model.hospital_emr;
import com.nyist.Hospital.Model.hospital_inform;
import com.nyist.Hospital.Model.hospital_patient;
import com.nyist.Hospital.Model.hospital_patientusedrug;
import com.nyist.Hospital.Model.hospital_treatemoney;
import com.nyist.Hospital.Model.hospital_treaterecord;

public interface AdministratorService {
	/**
	 * 管理员登陆表
	 * @param username	用户名
	 * @param account	账户名
	 * @param password	密码
	 * @return
	 */
	public String AdministratorLogin(String ha_username,String ha_account,String ha_password);
	/**
	 * 判断用户名是否存在
	 * @param ha_username
	 * @return
	 */
	public String AdministratorLoginJudgeByName(String ha_username);
	/**
	 * 通过ha_id 查询管理员信息
	 * @param ha_id
	 * @return
	 */
	public hospital_administrator SelectAllByHa_id(int ha_id);
	/**
	 * 添加用户 -->医生用户
	 * @param hospital_doctor
	 * @return
	 */
	public int AddDoctorAccount(hospital_doctor hospital_doctor);
	/**
	 * 通过 名字获得ID(在Hospital_Doctor表中)
	 * @param hd_name
	 */
	public int SelectIdByNameInHDoctor(String hd_name);
	/**
	 * 将信息 插入到医生与权限对应表
	 * @param hospital_doctor_authority
	 */
	public void InsetToHDoctorAuthority(hospital_doctor_authority hospital_doctor_authority);
	/**
	 * 通过给定的权限名 查找权限ID (hospital_authority)
	 * @param hau_name
	 * @return
	 */
	public String SelectIdByNameInHAuthority(String hau_name);
	/**
	 * 通过给定医生的姓名查找医生ID
	 * @param hd_name
	 * @return
	 */
	public int SelectDoctorIdByDoctorNameInHDoctor(String hd_name); 
	/*--------------------------------   删除用户    ----------------------------------------*/
	/**
	 * 删除医生账户(hospital_doctor)
	 * @param hd_id
	 */
	public void DeleteDoctorAccount(int hd_id);
	/**
	 * 删除权限表中医生与权限对应的记录
	 * @param hda_id
	 */
	public void DeleteHDAuthorityRecord(int hda_id);
	/**
	 * 删除 医生  登陆账号
	 * @param hl_doctorid
	 */
	public void DeleteHDoctorLogin(int hl_doctorid);
	/*=================================   查询医生用户  ==================================*/
	/**
	 * 查询医生信息(hospital_doctor)
	 * @param hd_id
	 */
	public hospital_doctor SelectDoctorAccount(int hd_id);
	/**
	 * 查询医生用户信息(返回List<hospital_doctor>)
	 * @param hd_id
	 * @return
	 */
	public List<hospital_doctor> SelectDoctorAccounts(int hd_id);
	/**
	 * 查询所有医生用户
	 * @return
	 */
	public List<hospital_doctor> SelectAllDoctorAccount();
	/**
	 * 查询所有医生Id(hospital_id)
	 * @return
	 */
	public List<Integer> SelectAllHd_ids();
	/**
	 * 通过  科室 id  查询  医生信息
	 * @param hd_haotoid
	 */
	public List<hospital_doctor> SelectHDoctorByHd_Haotoid(int hd_haotoid);
	/**
	 * @param hd_name
	 * @return
	 */
	public List<hospital_doctor> SelectDoctorByHd_name(String hd_name);
	/*---------------------------------   更新医生用户  -----------------------------------*/
	/**
	 * 更新医生用户信息(hospital_doctor)
	 * @param hd_id
	 * @return
	 */
	public void UpdateDoctorAccount(hospital_doctor hdDoctor);
	/**
	 * 查询所有 科室表中的 科室ID ---->haoto_id
	 */
	public List<Integer> SelectAllHaotoidFromHAoto();
	/*======================================  医院科室部门管理  =============================*/
	/*-------------------------------------- 添加科室 -------------------------------- */
	/**
	 * 添加科室部门(hospital_aoto)
	 * @param hAoto
	 */
	public void AddHaoto(hospital_aoto hAoto);
	/*-------------------------------------- 查询科室 ---------------------------------*/
	/**
	 * 查询所有科室(hospital_aoto)
	 * @return
	 */
	public List<hospital_aoto> SelectAllHaoto();
	/**
	 * 通过ID查询 科室信息
	 * @param haoto_id
	 * @return
	 */
	public hospital_aoto SelectHaotoById(int haoto_id);
	/**
	 * 通过ID查询 科室信息(List<hospita_haoto>)
	 * @param haoto_id
	 * @return
	 */
	public List<hospital_aoto> SelectHaotoByIds(int haoto_id);
	/**
	 * 通过科室名称  查询科室信息
	 * @param haoto_name
	 * @return
	 */
	public List<hospital_aoto> SelectHaotoByName(String haoto_name);
	/*-------------------------------------- 更新科室 -----------------------------------*/
	/**
	 * 更新科室信息(hospital_aoto)
	 * @param hAoto
	 */
	public void AlterHaoto(hospital_aoto hAoto);
	/*------------------------------------- 删除科室 -----------------------------------*/
	/**
	 * 通过科室ID删除科室信息(hospital_aoto)
	 * @param haoto_id
	 */
	public void DeleteHaoto(int haoto_id);
	//数据字典管理
	/*===================================== 添加病人信息 ================================*/
	/**
	 * 添加病人信息(hospital_patient)
	 * @param hPatient
	 */
	public void AddPatient(hospital_patient hPatient);
	/*------------------------------------ 修改病人信息 ----------------------------------*/
	/**
	 * 通过病人Id 插入 病人信息  修改hp_mrid
	 * @param hemr_id
	 */
	public void UpdateHemr_idByHp_patientid(@Param("hemr_id")int hemr_id,@Param("hemr_patientid")int hemr_patientid);
	/**
	 * 更改 病人信息
	 * @param hPatient
	 */
	public void UpdateHPatient(hospital_patient hPatient);
	/**
	 * 
	 * @param hemr_diagnosis
	 * @param hemr_tath
	 */
	public void UpdateHPatientByHemr_diagnosisAndHemr_starttime(@Param("hemr_patientid")int hemr_patientid,@Param("hemr_diagnosis")String hemr_diagnosis,@Param("hemr_starttime")String hemr_starttime);
	/*------------------------------------ 查询病人信息 ---------------------------------*/
	/**
	 * 通过ID查询病人信息(返回hospital_patient)
	 * @param hPatient
	 * @return
	 */
	public hospital_patient SelectPatientById(int hp_id);
	/**
	 * 通过 病人姓名获得病人ID(hospital_patient)
	 * @param hp_name
	 * @return
	 */
	public int SelectHPatientIDByName(String hp_name);
	/**
	 * 查询所有病人信息
	 * @return
	 */
	public List<hospital_patient> SelectAllPatients();
	/**
	 * 查询病人的所有ID信息
	 * @return
	 */
	public List<Integer> SelectAllHp_ids();
	/**
	 * 通过 医生id(hp_doctorid 查询 hospital_patient)病人记录
	 * @param hp_doctorid
	 * @return
	 */
	public List<hospital_patient> SelectHPatientByHp_doctorid(int hp_doctorid);
	/**
	 * 通过 病人姓名  查询  病人信息
	 * @param hp_name
	 * @return
	 */
	public List<hospital_patient> SelectHPatientsByHp_name(String hp_name);
	/*=================================== 删除病人信息 ======================================*/
	/**
	 * 通过 ID 删除病人 信息
	 * @param hp_id
	 */
	public void DeletePatientById(int hp_id);
	/*----------------------------------- 添加电子病历信息 -----------------------------------*/
	/**
	 * 添加电子病历(hospital_emr)
	 * @param hEmr
	 */
	public void AddPatientElectronicMedicalRecord(hospital_emr hEmr);

	/*==================================== 更新电子病历 =====================================*/
	/**
	 * 更新 电子病历(hospital_emr)
	 * @param hEmr
	 */
	public void UpdateHPatientEmr(hospital_emr hEmr);
	/**
	 * 更新病历  通过hp_id hp_doctorid hp_tsd hp_tath
	 * @param hp_id
	 * @param hp_doctorid
	 * @param hp_tsd
	 * @param hp_tath
	 */
	public void UpdateHPatientEmrByIdNameTT(@Param("hp_id")int hp_id,@Param("hp_doctorid")int hp_doctorid,@Param("hp_tsd")String hp_tsd,@Param("hp_tath")String hp_tath);
	/*------------------------------------ 删除电子病历信息 -----------------------------------*/
	/**
	 * 通过病人ID hemr_patientid 删除 病历信息
	 * @param hemr_patientid
	 */
	public void DeleteHPatientEmrByPatientid(int hemr_patientid);
	/*==================================== 查询电子病历信息 ====================================*/
	/**
	 * 查询所有病历信息
	 */
	public List<hospital_emr> SelectAllHPatientsEmr();
	/**
	 * 通过 病历ID 查找病历信息
	 * @param hemr_id
	 * @return
	 */
	public hospital_emr SelectHPatientEmrByHemr_Id(int hemr_id);
	/**
	 * 通过 病人Id 查询 病历信息(hospital_emr)
	 * @param hemr_patientid
	 * @return
	 */
	public int SelectHemr_idByHemr_patientid(int hemr_patientid);
	/**
	 * 通过病人ID查询病历信息
	 * @param hemr_patientid
	 * @return
	 */
	public hospital_emr SelectHemrByHemr_patientid(int hemr_patientid);
	
	//通知管理
	/*==================================== 添加通知 ==========================================*/
	/**
	 * 添加通知信息(hospital_inform)
	 * @param hInform
	 */
	public void AddInforms(hospital_inform hInform);
	/*------------------------------------- 查询通知 ------------------------------------------*/
	/**
	 * 查询所有通知
	 * @return
	 */
	public List<hospital_inform> SelectAllInforms();
	/**
	 * 通过通知ID查询通知信息(hospital_infrom)
	 * @param hi_id
	 * @return
	 */
	public hospital_inform SelectInformByHi_id(int hi_id);
	
	/**
	 * 通过 通知id 查找 通知人姓名
	 * @param hi_id
	 * @return
	 */
	public String SelectHi_personNameByHi_id(int ha_id);
	/*------------------------------------- 更新通知 ------------------------------------------*/
	/**
	 * 更新 通知 信息
	 * @param hi_id
	 * @param hi_personid
	 */
	public void UpdateInformById(hospital_inform hInform);
	/*===================================== 删除通知 ==========================================*/
	/**
	 * 删除通知 通过hi_id
	 * @param hi_id
	 */
	public void DeleteInform(int hi_id);
	
	//药品管理
	/*==================================== 添加药品信息 =======================================*/
	/**
	 * 添加药品信息(hospital_drug)
	 * @param hDrug
	 */
	public void AddDrugs(hospital_drug hDrug);
	/*------------------------------------ 查询药品信息 ---------------------------------------*/
	/**
	 * 查询所有药品消息
	 * @return
	 */
	public List<hospital_drug> SelectAllDrugs();
	/**
	 * 通过ID 查询 药品信息
	 * @param hdrug_id
	 * @return
	 */
	public hospital_drug SelectHDrugByHdrug_id(int hdrug_id);
	/**
	 * 通过 药品ID查询 药品信息(List<hospital_drug>)
	 * @param hdrug_id
	 * @return
	 */
	public List<hospital_drug> SelectHDrugsByHdrug_id(int hdrug_id);
	/**
	 * 通过  药品名字  查询  药品信息
	 * @param hdrug_name
	 * @return
	 */
	public List<hospital_drug> SelectHDrugByName(String hdrug_name);
	
	//查询数据库判断药品名称是否已经存在
	/**
	 * 查看药品名称是否存在
	 * @param hdrug_name
	 * @return
	 */
	public String JudgeDrugName(String hdrug_name);
	/**
	 * 查询药品信息  通过 药品名称
	 * @param hdrug_name
	 * @return
	 */
	public List<hospital_drug> SelectDrugByHdrug_name(String hdrug_name);
	/*==================================== 更新药品信息 =======================================*/
	/**
	 * 更新 药品信息
	 * @param hDrug
	 */
	public void UpdateDrug(hospital_drug hDrug);
	/*------------------------------------ 删除药品信息 ---------------------------------------*/
	/**
	 * 通过 ID 删除药品信息
	 * @param hdrug_id
	 */
	public void DeleteDrug(int hdrug_id);
	
	//诊断记录  管理
	/*==================================== 添加诊断记录 =======================================*/
	/**
	 *  采集病人信息后,创建病历,生成诊断记录
	 * @param hTreaterecord
	 */
	public void InsertRecord(hospital_treaterecord hTreaterecord);
	/*------------------------------------ 查询诊断记录 ---------------------------------------*/
	/**
	 * 通过 诊断诊断记录查询 诊断
	 * @param htr_id
	 * @return
	 */
	public List<hospital_treaterecord> SelectTreateRecordByHtr_patientid(int htr_patientid);
	/**
	 * 查询所有 诊断记录 返回(List<hospital_tresterecord>)
	 * @return
	 */
	public List<hospital_treaterecord> SelectAllTreateRecords();
	/**
	 * 通过病人ID 查询诊断次数
	 * @param htr_patinentid
	 * @return
	 */
	public int SelectTreateRecordsCountByHtr_patientid(int htr_patientid);
	/**
	 * 通过  诊断记录 ID  查询诊断记录
	 * @param htr_id
	 * @return
	 */
	public hospital_treaterecord SelectTreateRecordByHtr_id(int htr_id);
	/*==================================== 更新诊断记录 =========================================*/
	/**
	 * 通过 记录ID  更新病历   
	 * @param htr_id
	 */
	public void UpdateTreateRecord(hospital_treaterecord hTreaterecord);
	/*------------------------------------ 删除诊断记录 -----------------------------------------*/
	/**
	 * 删除诊断记录
	 * @param htr_id
	 */
	public void DeleteTreateRecord(int htr_id);
	/**
	 * 通过病人id 删除  诊断记录ID
	 * @param htr_patientid
	 */
	public void DeleteTreateRecordByHtr_patientid(int htr_patientid);
	/*==================================== 添加治疗费用信息 ======================================*/
	/**
	 * 添加治疗费用
	 * @param hTreatemoney
	 */
	public void AddTreateMoney(hospital_treatemoney hTreatemoney);
	
	//病人用药信息管理
	/*------------------------------------ 添加病人用药信息  ---------------------------------------*/
	/**
	 * 添加病人用药信息
	 * @param hPatientusedrug
	 */
	public void InsertPatientUseDrug(hospital_patientusedrug hPatientusedrug);
	/*==================================== 查询病人用药信息 ======================================*/
	/**
	 * 查询 通过病人ID hpt_patientid 查询病人要用信息
	 * @param hpt_patientid
	 * @return
	 */
	public int SelectPatientUseDrug(@Param("hpt_patientid")int hpt_patientid,@Param("hpt_id")int hpt_id);
	/***
	 * 只通过 病人ID 查找病人用药信息ID
	 * @param patientid
	 * @return
	 */
	public List<Integer> SelectPatientUseDrug1(int hpt_patientid);
	/**
	 *  通过  hpt_patientid 和 hpt_drugid 查询   病人用药信息 ID  hpt_id
	 * @param hpt_patientid
	 * @param hpt_drugid
	 * @return
	 */
	public String SelectPatientUseDrugByHpt_patientidAndHpt_drugid(@Param("hpt_patientid")int hpt_patientid,@Param("hpt_drugid")int hpt_drugid);
	/**
	 * 通过 病人ID-->hpt_patientid   查询   病人用药信息  hospital_patientusedrug
	 * @param hpt_patientid
	 * @return
	 */
	public List<hospital_patientusedrug> SelectHPUseDrugByHpt_patientid(int hpt_patientid);
	/**
	 * 通过 hpt_patientid 和 hpt_drugid 查询 hpt_count 
	 * @param hpt_patientid
	 * @param hpt_drugid
	 * @return
	 */
	public int DrugCounts(@Param("hpt_patientid")int hpt_patientid,@Param("hpt_drugid")int hpt_drugid);
	/**
	 * 通过病人ID 和 药品ID  查找 药品数量
	 * @param hpt_patientid
	 * @param hpt_drugid
	 * @return
	 */
	public int SelectDrugCountByHpt_patientidAndHpt_drugid(@Param("hpt_patientid")int hpt_patientid,@Param("hpt_drugid")int hpt_drugid);
	/*----------------------------------- 修改病人用药信息 ---------------------------------------*/
	/**
	 * 修改  病人用药信息 的数量  实现自加1
	 */
	public void AlterPatientUseDrugCount(int hpt_id);
	/**
	 * 药品数量 自减1
	 * @param hpt_patientid
	 * @param hpt_drugid
	 */
	public void UpdateDrugCount(@Param("hpt_patientid")int hpt_patientid,@Param("hpt_drugid")int hpt_drugid);
	/*=================================== 删除用药信息 ==========================================*/
	/**
	 * 删除  用药信息
	 * @param hpt_id
	 */
	public void DeletePatientUseDrug(int hpt_id);
	/**
	 * 通过  病人 Id  删除 病人用药信息
	 * @param hpt_patientid
	 */
	public void DeletePatientUseDrugByHpt_patientid(int hpt_patientid);
	/*----------------------------------- 结算记录 ---------------------------------------------*/
	/**
	 * 添加 结账结论
	 * @param hTreatemoney
	 */
	public void InsertTreatMoney(hospital_treatemoney hTreatemoney);
	/**
	 * 查询所有的  结算结记录
	 */
	public List<hospital_treatemoney> SelectTreateMoney();
	/**
	 * 通过  病人 id 查询诊断记录
	 * @param htm_patientid
	 * @return
	 */
	public List<hospital_treatemoney> SelectHTreatemoneyByHt_patientid(int htm_patientid);
	/*===================================== 删除结算记录 =====================================*/
	/**
	 * 删除结算记录
	 * @param htm_id
	 */
	public void DeleteTreateMoney(int htm_id);
	/**
	 * 删除结算记录  通过病人ID删除
	 * @param htp_patientid
	 */
	public void DeleteTreateMoneyByHtm_patientid(int htp_patientid);
}
