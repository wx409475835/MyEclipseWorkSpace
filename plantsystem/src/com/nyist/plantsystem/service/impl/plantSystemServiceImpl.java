package com.nyist.plantsystem.service.impl;

import com.nyist.plantsystem.dao.plantSystemMapper;
import com.nyist.plantsystem.model.PageBean;
import com.nyist.plantsystem.model.loginAccount;
import com.nyist.plantsystem.service.plantSystemService;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class plantSystemServiceImpl implements plantSystemService {

    @Autowired
    private plantSystemMapper plantSystemMapper;

	@Override
	public void insertLoginAccount(loginAccount loginAccount) {
		// TODO Auto-generated method stub
		plantSystemMapper.insertLoginAccount(loginAccount);
	}

	@Override
	public String selectAccount(@Param("username")String username,@Param("password")String password){
		return plantSystemMapper.selectAccount(username, password);
	}

	@Override
	public void insertFileInfo(PageBean pageBean) {
		plantSystemMapper.insertFileInfo(pageBean);
	}

	@Override
	public List<PageBean> selectFileInfo(String name) {
		return plantSystemMapper.selectFileInfo(name);
	}

	@Override
	public void deleteFileInfo(String uuidname) {
		plantSystemMapper.deleteFileInfo(uuidname);
	}
}
