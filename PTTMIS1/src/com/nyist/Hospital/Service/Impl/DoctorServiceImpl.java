package com.nyist.Hospital.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyist.Hospital.Dao.DoctorMapper;
import com.nyist.Hospital.Model.hospital_inform;
import com.nyist.Hospital.Model.hospital_login;
import com.nyist.Hospital.Model.hospital_treatemoney;
import com.nyist.Hospital.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorMapper doctorMapper;
	
	@Override
	public void InsertDoctorLoginInfo(hospital_login hLogin) {
		doctorMapper.InsertDoctorLoginInfo(hLogin);
	}

	@Override
	public String DoctorLogin(String hl_usernameString, String hl_password) {
		String hl_doctorid = doctorMapper.DoctorLogin(hl_usernameString, hl_password);
		return hl_doctorid;
	}

	@Override
	public String JudgeDoctorName(String hd_name) {
		String hd_id = doctorMapper.JudgeDoctorName(hd_name);
		return hd_id;
	}

	@Override
	public String JudgePatientName(String hp_name) {
		String hp_id = doctorMapper.JudgePatientName(hp_name);
		return hp_id;
	}

	@Override
	public void UpdateDoctorAccountPassword(hospital_login hLogin) {
		doctorMapper.UpdateDoctorAccountPassword(hLogin);
	}

	@Override
	public String SelectHl_usernameByHl_doctorid(int hl_doctorid) {
		String hl_username = doctorMapper.SelectHl_usernameByHl_doctorid(hl_doctorid); 
		return hl_username;
	}

	@Override
	public hospital_treatemoney SelectTreateMoneyByHtm_patientid(
			int htm_patientid) {
		hospital_treatemoney hTreatemoney = doctorMapper.SelectTreateMoneyByHtm_patientid(htm_patientid);
		return hTreatemoney;
	}

	@Override
	public List<String> SelectAccount(String account) {
		List<String> ac = doctorMapper.SelectAccount(account);
		return ac;
	}
	
	@Override
	public List<hospital_inform> SelectAllInforms() {
		List<hospital_inform> hInforms = doctorMapper.SelectAllInforms();
		return hInforms;
	}

	@Override
	public void AddInforms(hospital_inform hInform) {
		doctorMapper.AddInforms(hInform);
	}

	@Override
	public void DeleteAllInforms() {
		doctorMapper.DeleteAllInforms();
	}

	@Override
	public void UpdateInformById(hospital_inform hInform) {
		doctorMapper.UpdateInformById(hInform);
	}	
}
