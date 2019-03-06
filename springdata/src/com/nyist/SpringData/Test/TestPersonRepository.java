package com.nyist.SpringData.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nyist.SpringData.Entity.Person;
import com.nyist.SpringData.Repostiory.PersonRepostory;
import com.nyist.SpringData.Service.PersonService;



public class TestPersonRepository {
	
	private static ApplicationContext ctx=null;
	private static PersonRepostory personRepostory = null;
	private static PersonService personService = null;
	static{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		personRepostory = ctx.getBean(PersonRepostory.class);
		personService = ctx.getBean(PersonService.class);
	}
	@Test
	public void testJpa(){}
	
	@Test
	public void testDataSource(){
		Object dataSource = ctx.getBean("dataSource");
		System.out.println("DataSource:"+dataSource);
	}
	
	@Test
	public void testHelloWorldSpringData(){
		PersonRepostory personRepostiory = ctx.getBean(PersonRepostory.class);
		System.out.println(personRepostiory.getClass().getName());
		Person person = personRepostiory.getByLastName("AA");
		System.out.println(person);
	}
	
	@Test
	public void testgetByLastNameStaringWithAndIdLessThan(){
		PersonRepostory personRepostory = ctx.getBean(PersonRepostory.class);
		List<Person> repostory = personRepostory.getByLastNameStartingWithAndIdLessThan("h",10);
		System.out.println(repostory);
		
	}
	
	@Test
	public void testgetByLastNameEndingWithAndIdGreaterThan(){
		PersonRepostory personRepostory = ctx.getBean(PersonRepostory.class);
		List<Person> list = personRepostory.getByLastNameEndingWithAndIdGreaterThan("o", 10);
		System.out.println(list);
	}
	
	@Test
	public void testgetByEmailInOrBirthLessThan() throws ParseException{
		PersonRepostory personRepostory = ctx.getBean(PersonRepostory.class);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String s = "2019-02-01";
		List<Person> list = personRepostory.getByEmailInOrBirthLessThan("@qq.com",simpleDateFormat.parse(s));
		System.out.println(list);
	}
	
	@Test
	public void testgetByAddressIdGreaterThan(){
		PersonRepostory personRepostory = ctx.getBean(PersonRepostory.class);
		List<Person> list = personRepostory.getByAddress_IdGreaterThan(5);
		System.out.println(list);
	}
	
	@Test
	public void testQueryAnnotation(){
		PersonRepostory personRepostory = ctx.getBean(PersonRepostory.class);
		Person person = personRepostory.getMaxIdPerson();
		System.out.println(person);
	}
	
	@Test
	public void testQueryAnnotationParms(){
		PersonRepostory personRepostory = ctx.getBean(PersonRepostory.class);
		List<Person> person =personRepostory.testQueryAnnotationParms("AA","qq@qq.com");
		System.out.println(person);
	}
	
	@Test
	public void testQueryAnnotationParms1(){
		List<Person> list = personRepostory.testQueryAnnotationParms1("qq@qq.com","AA");
		System.out.println(list);
	}
	
	
	@Test
	public void testQueryAnnotationListParm(){
		List<Person> list = personRepostory.testQueryAnnotationLikeParm("AA","qq");
		System.out.println(list);
	}
	
	@Test
	public void testQueryAnnotationLikeParm2(){
		List<Person> list = personRepostory.testQueryAnnotationLikeParm2("AA","qq");
		System.out.println(list);
	}
	
	@Test
	public void testgetTotalCoung(){
		long l = personRepostory.getTotalCount();
		System.out.println(l);
	}
	
	@Test
	public void testupdatePersonEmail(){
		personService.updatePersonEmail("AAAAAAQ@qq.com", 1);
	}
	
}
