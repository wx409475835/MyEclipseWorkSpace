package com.nyist.Hospital.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyist.Hospital.Dao.AdministratorMapper;
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
import com.nyist.Hospital.Service.AdministratorService;

/*
 * 在这里使用@Service 这个注解  表明这是前边接口 AdministratorService 的实现类
 * */
@Service
public class AdministratorServiceImpl implements AdministratorService{

	@Autowired
	private AdministratorMapper administratorMapper;
	
	@Override
	public String AdministratorLogin(String ha_username, String ha_account,String ha_password) {
		System.out.println("========");
		String i=administratorMapper.AdministratorLogin(ha_username, ha_account, ha_password);
		return i;
	}

	@Override
	public String AdministratorLoginJudgeByName(String ha_username) {
		String ha_id = administratorMapper.AdministratorLoginJudgeByName(ha_username);
		return ha_id;
	}

	@Override
	public int AddDoctorAccount(hospital_doctor hospital_doctor) {
		int i=0;
		i=administratorMapper.AddDoctorAccount(hospital_doctor);
		return i;
	}

	@Override
	public int SelectIdByNameInHDoctor(String hd_name) {
		int i = administratorMapper.SelectIdByNameInHDoctor(hd_name);
		return i;
	}

	@Override
	public void InsetToHDoctorAuthority(
			hospital_doctor_authority hospital_doctor_authority) {
		administratorMapper.InsetToHDoctorAuthority(hospital_doctor_authority);
	}

	@Override
	public String SelectIdByNameInHAuthority(String hau_name) {
		String hau_id = administratorMapper.SelectIdByNameInHAuthority(hau_name);
		return hau_id;
	}

	@Override
	public int SelectDoctorIdByDoctorNameInHDoctor(String hd_name) {
		int hd_id = administratorMapper.SelectDoctorIdByDoctorNameInHDoctor(hd_name);
		return hd_id;
	}

	@Override
	public void DeleteDoctorAccount(int hd_id) {
		administratorMapper.DeleteDoctorAccount(hd_id);
	}

	@Override
	public void DeleteHDAuthorityRecord(int hda_id) {
		administratorMapper.DeleteHDAuthorityRecord(hda_id);
	}

	@Override
	public hospital_doctor SelectDoctorAccount(int hd_id) {
		hospital_doctor hdoctor;
		hdoctor = administratorMapper.SelectDoctorAccount(hd_id);
		return hdoctor;
	}

	@Override
	public void UpdateDoctorAccount(hospital_doctor hdDoctor) {
		administratorMapper.UpdateDoctorAccount(hdDoctor);
	}

	@Override
	public List<Integer> SelectAllHaotoidFromHAoto() {
		List<Integer> haoto_id;
		haoto_id = administratorMapper.SelectAllHaotoidFromHAoto();
		return haoto_id;
	}

	@Override
	public List<hospital_doctor> SelectAllDoctorAccount() {
		List<hospital_doctor> hospital_doctor;
		hospital_doctor = administratorMapper.SelectAllDoctorAccount();
		return hospital_doctor;
	}

	@Override
	public List<hospital_doctor> SelectDoctorAccounts(int hd_id) {
		List<hospital_doctor> hospital_doctors;
		hospital_doctors = administratorMapper.SelectDoctorAccounts(hd_id);
		return hospital_doctors;
	}

	@Override
	public void AddHaoto(hospital_aoto hAoto) {
		administratorMapper.AddHaoto(hAoto);
	}

	@Override
	public List<hospital_aoto> SelectAllHaoto() {
		List<hospital_aoto> hAotos = administratorMapper.SelectAllHaoto();
		return hAotos;
	}

	@Override
	public hospital_aoto SelectHaotoById(int haoto_id) {
		hospital_aoto hAoto = administratorMapper.SelectHaotoById(haoto_id);
		return hAoto;
	}

	@Override
	public void AlterHaoto(hospital_aoto hAoto) {
		administratorMapper.AlterHaoto(hAoto);
	}

	@Override
	public List<hospital_aoto> SelectHaotoByIds(int haoto_id) {
		List<hospital_aoto> hAotos = administratorMapper.SelectHaotoByIds(haoto_id);
		return hAotos;
	}

	@Override
	public void DeleteHaoto(int haoto_id) {
		administratorMapper.DeleteHaoto(haoto_id);
	}

	@Override
	public void AddPatient(hospital_patient hPatient) {
		administratorMapper.AddPatient(hPatient);
	}

	@Override
	public void AddPatientElectronicMedicalRecord(hospital_emr hEmr) {
		administratorMapper.AddPatientElectronicMedicalRecord(hEmr);
	}

	@Override
	public hospital_patient SelectPatientById(int hp_id) {
		hospital_patient hPatient = administratorMapper.SelectPatientById(hp_id);
		return hPatient;
	}

	@Override
	public int SelectHPatientIDByName(String hp_name) {
		int i = administratorMapper.SelectHPatientIDByName(hp_name);
		return i;
	}

	@Override
	public List<Integer> SelectAllHd_ids() {
		List<Integer> hd_id = administratorMapper.SelectAllHd_ids();
		return hd_id;
	}

	@Override
	public int SelectHemr_idByHemr_patientid(int hemr_patientid) {
		int i = administratorMapper.SelectHemr_idByHemr_patientid(hemr_patientid);
		return i;
	}

	@Override
	public void UpdateHemr_idByHp_patientid(int hemr_id, int hemr_patientid) {
		administratorMapper.UpdateHemr_idByHp_patientid(hemr_id, hemr_patientid);
	}

	@Override
	public List<hospital_patient> SelectAllPatients() {
		List<hospital_patient> hPatients = administratorMapper.SelectAllPatients();
		return hPatients;
	}

	@Override
	public void UpdateHPatient(hospital_patient hPatient) {
		administratorMapper.UpdateHPatient(hPatient);
	}

	@Override
	public void UpdateHPatientEmr(hospital_emr hEmr) {
		administratorMapper.UpdateHPatientEmr(hEmr);
	}

	@Override
	public void UpdateHPatientEmrByIdNameTT(int hp_id, int hp_doctorid,
			String hp_tsd, String hp_tath) {
		administratorMapper.UpdateHPatientEmrByIdNameTT(hp_id, hp_doctorid, hp_tsd, hp_tath);
	}

	@Override
	public void DeletePatientById(int hp_id) {
		administratorMapper.DeletePatientById(hp_id);
	}

	@Override
	public void DeleteHPatientEmrByPatientid(int hemr_patientid) {
		administratorMapper.DeleteHPatientEmrByPatientid(hemr_patientid);
	}

	@Override
	public List<hospital_emr> SelectAllHPatientsEmr() {
		List<hospital_emr> hEmrs = administratorMapper.SelectAllHPatientsEmr();
		return hEmrs;
	}

	@Override
	public hospital_emr SelectHPatientEmrByHemr_Id(int hemr_id) {
		hospital_emr hEmr = administratorMapper.SelectHPatientEmrByHemr_Id(hemr_id);
		return hEmr;
	}

	@Override
	public void UpdateHPatientByHemr_diagnosisAndHemr_starttime(
			int hemr_patientid, String hemr_diagnosis, String hemr_starttime) {
		administratorMapper.UpdateHPatientByHemr_diagnosisAndHemr_starttime(hemr_patientid, hemr_diagnosis, hemr_starttime);
	}

	@Override
	public void AddInforms(hospital_inform hInform) {
		administratorMapper.AddInforms(hInform);
	}

	@Override
	public hospital_administrator SelectAllByHa_id(int ha_id) {
		hospital_administrator hAdministratorl = administratorMapper.SelectAllByHa_id(ha_id);
		return hAdministratorl;
	}

	@Override
	public List<hospital_inform> SelectAllInforms() {
		List<hospital_inform> hInforms = administratorMapper.SelectAllInforms();
		return hInforms;
	}

	@Override
	public hospital_inform SelectInformByHi_id(int hi_id) {
		hospital_inform hInform = administratorMapper.SelectInformByHi_id(hi_id);
		return hInform;
	}

	@Override
	public void UpdateInformById(hospital_inform hInform) {
		administratorMapper.UpdateInformById(hInform);
	}

	@Override
	public void DeleteInform(int hi_id) {
		administratorMapper.DeleteInform(hi_id);
	}

	@Override
	public void AddDrugs(hospital_drug hDrug) {
		administratorMapper.AddDrugs(hDrug);
	}

	@Override
	public List<hospital_drug> SelectAllDrugs() {
		List<hospital_drug> hDrugs = administratorMapper.SelectAllDrugs();
		return hDrugs;
	}

	@Override
	public hospital_drug SelectHDrugByHdrug_id(int hdrug_id) {
		hospital_drug hDrug = administratorMapper.SelectHDrugByHdrug_id(hdrug_id);
		return hDrug;
	}

	@Override
	public void UpdateDrug(hospital_drug hDrug) {
		administratorMapper.UpdateDrug(hDrug);
	}

	@Override
	public void DeleteDrug(int hdrug_id) {
		administratorMapper.DeleteDrug(hdrug_id);
	}

	@Override
	public void InsertRecord(hospital_treaterecord hTreaterecord) {
		administratorMapper.InsertRecord(hTreaterecord);
	}

	@Override
	public List<hospital_treaterecord> SelectTreateRecordByHtr_patientid(int htr_patientid) {
		List<hospital_treaterecord> hTreaterecord = administratorMapper.SelectTreateRecordByHtr_patientid(htr_patientid);
		return hTreaterecord;
	}

	@Override
	public List<Integer> SelectAllHp_ids() {
		List<Integer> hp_ids = administratorMapper.SelectAllHp_ids(); 
		return hp_ids;
	}

	@Override
	public List<hospital_treaterecord> SelectAllTreateRecords() {
		List<hospital_treaterecord> hTreaterecords = administratorMapper.SelectAllTreateRecords();
		return hTreaterecords;
	}

	@Override
	public int SelectTreateRecordsCountByHtr_patientid(int htr_patientid) {
		int count = administratorMapper.SelectTreateRecordsCountByHtr_patientid(htr_patientid);
		return count;
	}

	@Override
	public void UpdateTreateRecord(hospital_treaterecord hTreaterecord) {
		administratorMapper.UpdateTreateRecord(hTreaterecord);
	}

	@Override
	public hospital_treaterecord SelectTreateRecordByHtr_id(int htr_id) {
		hospital_treaterecord hTreaterecord = administratorMapper.SelectTreateRecordByHtr_id(htr_id);
		return hTreaterecord;
	}

	@Override
	public void DeleteTreateRecord(int htr_id) {
		administratorMapper.DeleteTreateRecord(htr_id);
	}

	@Override
	public void AddTreateMoney(hospital_treatemoney hTreatemoney) {
		administratorMapper.AddTreateMoney(hTreatemoney);
	}

	@Override
	public hospital_emr SelectHemrByHemr_patientid(int hemr_patientid) {
		hospital_emr hEmr = administratorMapper.SelectHemrByHemr_patientid(hemr_patientid);
		return hEmr;
	}

	@Override
	public List<hospital_drug> SelectHDrugByName(String hdrug_name) {
		List<hospital_drug> hDrug = administratorMapper.SelectHDrugByName(hdrug_name);
		return hDrug;
	}

	@Override
	public void InsertPatientUseDrug(hospital_patientusedrug hPatientusedrug) {
		administratorMapper.InsertPatientUseDrug(hPatientusedrug);
	}

	@Override
	public int SelectPatientUseDrug(int hpt_patientid,int hpt_id) {
		int hpt_drug_id = administratorMapper.SelectPatientUseDrug(hpt_patientid,hpt_id);
		return hpt_drug_id;
	}

	@Override
	public List<hospital_drug> SelectHDrugsByHdrug_id(int hdrug_id) {
		List<hospital_drug> hDrugs = administratorMapper.SelectHDrugsByHdrug_id(hdrug_id);
		return hDrugs;
	}

	@Override
	public String SelectPatientUseDrugByHpt_patientidAndHpt_drugid(
			int hpt_patientid, int hpt_drugid) {
		String hpt_id = administratorMapper.SelectPatientUseDrugByHpt_patientidAndHpt_drugid(hpt_patientid, hpt_drugid);
		return hpt_id;
	}

	@Override
	public void AlterPatientUseDrugCount(int hpt_id) {
		administratorMapper.AlterPatientUseDrugCount(hpt_id);
	}

	@Override
	public List<Integer> SelectPatientUseDrug1(int hpt_patientid) {
		List<Integer> hpt_id = administratorMapper.SelectPatientUseDrug1(hpt_patientid);
		return hpt_id;
	}

	@Override
	public List<hospital_patientusedrug> SelectHPUseDrugByHpt_patientid(
			int hpt_patientid) {
		List<hospital_patientusedrug> hPatientusedrug = administratorMapper.SelectHPUseDrugByHpt_patientid(hpt_patientid);
		return hPatientusedrug;
	}

	@Override
	public int DrugCounts(int hpt_patientid, int hpt_drugid) {
		int hpt_count = administratorMapper.DrugCounts(hpt_patientid, hpt_drugid);
		return hpt_count;
	}

	@Override
	public void InsertTreatMoney(hospital_treatemoney hTreatemoney) {
		administratorMapper.InsertTreatMoney(hTreatemoney);
	}

	@Override
	public List<hospital_treatemoney> SelectTreateMoney() {
		List<hospital_treatemoney> hTreatemoneys = administratorMapper.SelectTreateMoney();
		return hTreatemoneys;
	}

	@Override
	public String JudgeDrugName(String hdrug_name) {
		String hdrug_id = administratorMapper.JudgeDrugName(hdrug_name);
		return hdrug_id;
	}

	@Override
	public String SelectHi_personNameByHi_id(int ha_id) {
		String hi_personname = administratorMapper.SelectHi_personNameByHi_id(ha_id);
		return hi_personname;
	}

	@Override
	public List<hospital_patient> SelectHPatientByHp_doctorid(int hp_doctorid) {
		List<hospital_patient> hPatient = administratorMapper.SelectHPatientByHp_doctorid(hp_doctorid);
		return hPatient;
	}

	@Override
	public List<hospital_doctor> SelectHDoctorByHd_Haotoid(int hd_haotoid) {
		List<hospital_doctor> hDoctors = administratorMapper.SelectHDoctorByHd_Haotoid(hd_haotoid);
		return hDoctors;
	}

	@Override
	public List<hospital_treatemoney> SelectHTreatemoneyByHt_patientid(int htm_patientid) {
		List<hospital_treatemoney> hTreatemoneys = administratorMapper.SelectHTreatemoneyByHt_patientid(htm_patientid);
		return hTreatemoneys;
	}

	@Override
	public void DeleteHDoctorLogin(int hl_doctorid) {
		administratorMapper.DeleteHDoctorLogin(hl_doctorid);
	}

	@Override
	public void DeleteTreateRecordByHtr_patientid(int htr_patientid) {
		administratorMapper.DeleteTreateRecordByHtr_patientid(htr_patientid);
	}

	@Override
	public void DeletePatientUseDrugByHpt_patientid(int hpt_patientid) {
		administratorMapper.DeletePatientUseDrugByHpt_patientid(hpt_patientid);
	}

	@Override
	public int SelectDrugCountByHpt_patientidAndHpt_drugid(int hpt_patientid,
			int hpt_drugid) {
		int hpt_count = administratorMapper.SelectDrugCountByHpt_patientidAndHpt_drugid(hpt_patientid, hpt_drugid);
		return hpt_count;
	}

	@Override
	public void UpdateDrugCount(int hpt_patientid, int hpt_drugid) {
		administratorMapper.UpdateDrugCount(hpt_patientid, hpt_drugid);
	}

	@Override
	public void DeletePatientUseDrug(int hpt_id) {
		administratorMapper.DeletePatientUseDrug(hpt_id);
		
	}

	@Override
	public List<hospital_doctor> SelectDoctorByHd_name(String hd_name) {
		List<hospital_doctor> hDoctors = administratorMapper.SelectDoctorByHd_name(hd_name);
		return hDoctors;
	}

	@Override
	public List<hospital_aoto> SelectHaotoByName(String haoto_name) {
		List<hospital_aoto> hAotos = administratorMapper.SelectHaotoByName(haoto_name);
		return hAotos;
	}

	@Override
	public List<hospital_patient> SelectHPatientsByHp_name(String hp_name) {
		List<hospital_patient> hPatients = administratorMapper.SelectHPatientsByHp_name(hp_name);
		return hPatients;
	}

	@Override
	public List<hospital_drug> SelectDrugByHdrug_name(String hdrug_name) {
		List<hospital_drug> hDrugs = administratorMapper.SelectDrugByHdrug_name(hdrug_name);
		return hDrugs;
	}

	@Override
	public void DeleteTreateMoney(int htm_id) {
		administratorMapper.DeleteTreateMoney(htm_id);
	}

	@Override
	public void DeleteTreateMoneyByHtm_patientid(int htp_patientid) {
		administratorMapper.DeleteTreateMoneyByHtm_patientid(htp_patientid);
	}
}
