package com.nyist.cn.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	
	@Test
	public void test1(){
		ApplicationContext ctx= new  ClassPathXmlApplicationContext("application.xml");
		Object obj = ctx.getBean("sqlSessionFactory");
		System.out.println("Connextion:"+obj);
	}
}
