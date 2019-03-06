package com.nyist.Ajax.day2.practice.case2.Service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.nyist.Ajax.day2.practice.case2.Dao.AjaxMapper;
import com.nyist.Ajax.day2.practice.case2.Service.AjaxService;
import com.nyist.Ajax.day2.practice.case2.Util.MybatisUtil;
import com.nyist.Ajax.day2.practice.case2.entity.City;

public class AjaxServiceImpl implements AjaxService{
	
	private AjaxMapper ajaxMapper;
	public AjaxServiceImpl(){
		SqlSession sqlSession = MybatisUtil.openSession();
		ajaxMapper = sqlSession.getMapper(AjaxMapper.class);
	}
	
	@Override
	public List<City> queryCityByCountry(String country) {		
		return ajaxMapper.queryCityByCountry(country);
	}
	
}
