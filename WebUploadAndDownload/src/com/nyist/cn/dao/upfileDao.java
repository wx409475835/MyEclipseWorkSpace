package com.nyist.cn.dao;

import java.util.List;

import com.nyist.cn.domain.upfile;

public interface upfileDao {
	
	public void addfile(upfile upfile);
	
	public List<upfile> getAll();
	
	public upfile find(String id);
	
	public void delete(String id);
	
	public upfile updatefile(upfile upfile);
}
