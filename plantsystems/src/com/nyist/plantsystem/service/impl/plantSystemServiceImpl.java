package com.nyist.plantsystem.service.impl;

import com.nyist.plantsystem.dao.plantSystemMapper;
import com.nyist.plantsystem.model.loginAccount;
import com.nyist.plantsystem.service.plantSystemService;
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

   
}
