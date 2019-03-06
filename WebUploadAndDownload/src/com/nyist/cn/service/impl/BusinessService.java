package com.nyist.cn.service.impl;
import java.util.List;

import com.nyist.cn.dao.upfileDao;
import com.nyist.cn.domain.upfile;
import com.nyist.cn.factory.DaoFactory;
import com.nyist.cn.service.BusinessServiceDao;

public class BusinessService implements BusinessServiceDao{	
	private upfileDao dao = DaoFactory.getInstance().createDao(upfileDao.class);
	
	public void addfile(upfile upfile){
		dao.addfile(upfile);
	}
	
	public List<upfile> getAll(){
		 return dao.getAll();
	}

	public upfile findupfile(String id){
		return dao.find(id);
	}
}
