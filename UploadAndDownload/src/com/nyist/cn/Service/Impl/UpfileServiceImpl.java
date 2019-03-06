package com.nyist.cn.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyist.cn.Dao.UpfileDao;
import com.nyist.cn.Service.UpfileService;
import com.nyist.cn.model.Upfile;

@Service
public class UpfileServiceImpl implements UpfileService{

	@Autowired
	private UpfileDao upfileDao ;
	
	@Override
	public void addfile(Upfile upfile) {
		upfileDao.addfile(upfile);
	}

	@Override
	public Upfile findUpfile(String id) {
		return upfileDao.findUpfile(id);
	}

	@Override
	public void updateupfile(Upfile upfile) {
		upfileDao.updateupfile(upfile);
	}

	@Override
	public void deleteupfile(String id) {
		upfileDao.deleteupfile(id);
	}

	@Override
	public List getAllFile() {
		return upfileDao.getAllFile();
	}
}
