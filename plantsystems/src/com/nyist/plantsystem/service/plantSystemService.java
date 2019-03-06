package com.nyist.plantsystem.service;

import com.nyist.plantsystem.model.loginAccount;

public interface plantSystemService {
    /**
     * 用户登陆模块
     * */
    //添加用户
    public void insertLoginAccount(loginAccount loginAccount);
}
