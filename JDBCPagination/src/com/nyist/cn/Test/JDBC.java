package com.nyist.cn.Test;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class JDBC {
	
	@Test
	public void Test() throws BeansException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml"); 
		System.out.println("ctx:"+ctx);
		Object obj = ctx.getBean("sqlSessionFactory");
		System.out.println("ctx:"+obj);
	}
}
