package com.nyist.cn.service;

import java.util.List;

import com.nyist.cn.domain.upfile;

public interface BusinessServiceDao {
	
	void addfile(upfile upfile);

	List<upfile> getAll();

	upfile findupfile(String id);
}