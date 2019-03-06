package com.nyist.plantsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nyist.plantsystem.model.PageBean;
import com.nyist.plantsystem.model.loginAccount;

public interface plantSystemMapper {
    /**
     * 用户登陆模块
     * */
    //添加用户
    public void insertLoginAccount(loginAccount loginAccount);
    
    //用户登陆		返回用户ID
    public String selectAccount(@Param("username")String username,@Param("password")String password);
    
    //添加文件信息到数据库
    public void insertFileInfo(PageBean pageBean);
    
    //模糊查询 
    public List<PageBean> selectFileInfo(String name);
    
    //删除数据库表
    public void deleteFileInfo(String uuidname);
}
