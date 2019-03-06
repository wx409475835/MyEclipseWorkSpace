package com.nyist.plantsystem.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBC {
	@Test
	public void Test1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object object = ctx.getBean("dataSource");
		System.out.println(object);
	}
	
	
	@Test
	public void Date() throws ParseException{
		/*Date date = new Date();
		String date1 = "Tue Mar 13 18:51:32 CST 2018";
		String date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);*/
		Date date3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-09-09 09:09:09");
		System.out.println(date3);
		/*System.out.println(date2);
		System.out.println(date3);*/
		/*SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		System.out.println("sdf1"+sdf1);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String birth = sdf2.format(sdf1.parse(dt));
		Date date = java.sql.Date.valueOf(birth);
		System.out.println(birth);  */
	}
	
}
