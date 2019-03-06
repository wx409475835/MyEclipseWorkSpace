package com.nyist.mybatis.Test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nyist.mybatis.Dao.OrderMapper;
import com.nyist.mybatis.Dao.PMapper;
import com.nyist.mybatis.Dao.PerMapper;
import com.nyist.mybatis.Dao.UserMapper;
import com.nyist.mybatis.model.User;

public class MyBatisTest {
	/*
	 * ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSession = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
		SqlSession session = sqlSession.openSession();
	 * */
	@Autowired
	UserMapper userMapper;
	@Autowired
	PerMapper perMapper;
	@Autowired
	PMapper pMapper;
	@Autowired
	OrderMapper orderMapper;
	
	@Test
	public void Test1(){
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user);
	}
}
