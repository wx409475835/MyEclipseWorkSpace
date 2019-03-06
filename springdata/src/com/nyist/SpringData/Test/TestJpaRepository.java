package com.nyist.SpringData.Test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nyist.SpringData.Entity.Person;
import com.nyist.SpringData.Repostiory.SpringDataJpaRepository;

public class TestJpaRepository {
	
	private static ApplicationContext ctx = null;
	private static SpringDataJpaRepository jpaRepository = null;
	static{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jpaRepository = ctx.getBean(SpringDataJpaRepository.class);
	}
	
	@Test
	public void testJapRepository(){
		Person person = new Person();
		person.setBirth(new Date());
		person.setEmail("XYZ@nyist.com");
		person.setLastName("XY");	
		person.setId(27);
		Person person2 = jpaRepository.saveAndFlush(person);
		System.out.println(person==person2);
	}
}
