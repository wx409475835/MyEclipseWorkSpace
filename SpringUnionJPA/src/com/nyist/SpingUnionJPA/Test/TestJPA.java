package com.nyist.SpingUnionJPA.Test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nyist.SpingUnionJPA.Entity.Person;
import com.nyist.SpingUnionJPA.Service.PersonService;


public class TestJPA {

	private PersonService personService = null;
	private ApplicationContext ctx = null;
	@Before
	public void before(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		personService = ctx.getBean(PersonService.class);
	}
	
	@Test
	public void testJPA(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ComboPooledDataSource dataSource = (ComboPooledDataSource)ctx.getBean("dataSource");
		System.out.println(dataSource);
	}
	
	
	@Test
	public void testPersonService(){
		Person person1 = new Person();
		person1.setAge(12);
		person1.setEmail("qq@qq.com");
		person1.setLastName("NiHao");
		
		Person person2 = new Person();
		person2.setAge(13);
		person2.setEmail("QQ@qq.com");
		person2.setLastName("Hello World ");
		personService.savePerson(person1, person2);
	}
	
}
