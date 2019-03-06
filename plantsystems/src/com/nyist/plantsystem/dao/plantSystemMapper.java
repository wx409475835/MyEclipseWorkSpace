package com.nyist.plantsystem.dao;

import com.nyist.plantsystem.model.loginAccount;

public interface plantSystemMapper {
    /**
     * 用户登陆模块
     * */
    //添加用户
    public void insertLoginAccount(loginAccount loginAccount);
    //删除用户
}
