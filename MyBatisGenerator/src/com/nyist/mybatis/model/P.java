package com.nyist.mybatis.model;

import java.io.Serializable;

public class P implements Serializable {
    private String birthday;

    private static final long serialVersionUID = 1L;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }
}