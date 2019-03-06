package com.nyist.cn.Test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataSource {
	
	@Test
	public void test1(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Object obj = context.getBean("sqlSessionFactory");
		System.out.println("Connection:"+obj);
	}
}
