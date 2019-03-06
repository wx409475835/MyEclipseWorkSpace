package com.nyist.SpringData.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nyist.SpringData.Entity.Person;
import com.nyist.SpringData.Service.CrudRepositoryService;

public class TestCrudRepository {

	private static ApplicationContext ctx = null;
	private static CrudRepositoryService crudRepositoryService;
	static{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		crudRepositoryService = ctx.getBean(CrudRepositoryService.class);
	}
	
	
	@Test
	public void testCrudRepository(){
		List<Person> list = new ArrayList<Person>();
		for(int i='a';i<='z';i++){
			Person person = new Person();
			person.setAddressId(i+1);
			person.setBirth(new Date());
			person.setEmail((char)i+""+(char)i+"@nyist.com");
			person.setLastName((char)i+""+(char)i);
			list.add(person);
		}
		crudRepositoryService.savePerson(list);
	}
	
    @Test
    public void testgetById(){
    	Person person = crudRepositoryService.getById(1);
    	System.out.println("查询单个实体:"+person);
    }
    
    @Test
    public void testisExistsId(){
    	boolean bol = crudRepositoryService.isExistsId(5);
    	System.out.println("是否存在:"+bol);
    }
    @Test
    public void testSelectAll(){
    	List<Person> persons = crudRepositoryService.selectAll();
    	System.out.println("总实体:"+persons);
    }
    
    @Test
    public void testDeleteById(){
    	System.out.println(crudRepositoryService.deleteById(20));
    }
}
