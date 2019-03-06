package com.nyist.Ajax.day3;

import java.util.Date;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TestTeShuLeixingGson {
	@Test
	public void testTSLXG(){
		
		Customer  c = new Customer(1,"lvhg",new Date(),new Address());
		
		
		/*Gson gson = new Gson();
		String jsonString = gson.toJson(c);
		System.out.println(jsonString);
		*/
		//Feb 4,2018 10:44:33 AM
		//2018 2 4
		//日期类型需要使用 GsonBuilder 来创建 Gson 
		GsonBuilder gb = new GsonBuilder();
		//注册类型转换器   第一个参数  是需要注册那种类型   第二个参数是需要使用那个转换器注册
		gb.registerTypeAdapter(Date.class,new DateEditor());
		Gson gson = gb.create();
		String jsonString = gson.toJson(c);
		System.out.println(jsonString);
	}
}
