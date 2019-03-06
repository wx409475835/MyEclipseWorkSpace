package com.nyist.Ajax.day2.practice.case2.Dao;

import java.util.List;

import com.nyist.Ajax.day2.practice.case2.entity.City;

public interface AjaxMapper {
	//查询数据库中是否存传进来的值
	public List<City> queryCityByCountry(String country);
}
