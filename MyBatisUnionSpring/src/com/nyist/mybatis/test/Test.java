package com.nyist.mybatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	@org.junit.Test
	public void testDataSource(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object object = ctx.getBean("dataSource");
		System.out.println("Object:"+object);
	}
}
