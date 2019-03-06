package com.nyist.Ajax.day3;

import java.util.Date;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestHuiHuanGson{
	@Test
	public void testHH(){
		Customer customer = new Customer();
		customer.setId(1);
		customer.setUsername("suns");
		customer.setBirthday(new Date());
		
		Address address = new Address();
		address.setCity("ny");
		address.setZipcode("100029");
		address.setCustomer(customer);
		customer.setAdderess(address);
		
		GsonBuilder gb = new GsonBuilder();
		//注册 时间日期转换器
		gb.registerTypeAdapter(Date.class,new DateEditor());
		//注册 回环问题的解决策略   
		gb.setExclusionStrategies(new CustomerExclusion());
		/*注解开发*/
		//gb.excludeFieldsWithoutExposeAnnotation();
		Gson gson = gb.create();
		String jsonString = gson.toJson(customer);
		System.out.println(jsonString);
	}	
}
