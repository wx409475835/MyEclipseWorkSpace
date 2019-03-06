package com.nyist.SpringData.Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nyist.SpringData.Repostiory.PersonDaoRepository;

public class TestPersonDaoRepository {
	
	private static ApplicationContext ctx = null;
	private static PersonDaoRepository personDaoRepository = null;
	static{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("ctx:"+ctx);
		personDaoRepository = ctx.getBean(PersonDaoRepository.class);
		System.out.println("personDaoRepository:"+personDaoRepository);
	}
	
	@Test
	public void testPersonDaoRepository(){
		personDaoRepository.test();
	}
}
