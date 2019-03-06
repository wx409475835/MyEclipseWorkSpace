package com.nyist.cn.Dao;

import java.util.List;

import com.nyist.cn.model.Upfile;

public interface UpfileDao {
	
	//添加文件
	public void addfile(Upfile upfile);
	
	//查找文件
	public Upfile findUpfile(String id);
	
	//修改文件
	public void updateupfile(Upfile upfile);
	
	//删除文件
	public void deleteupfile(String id);
	
	//查询所有的文件
	public List getAllFile();
}
