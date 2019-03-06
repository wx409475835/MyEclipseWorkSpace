package com.nyist.Ajax.day2.Testgson;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.google.gson.Gson;
import com.nyist.Ajax.day2.Address;
import com.nyist.Ajax.day2.User;

public class Testgon {
	@Test
	public void testgon1(){
		//将对象 转换成 Json  字符串
		User u = new User(1,"suns","123456",null);			//--->转换成Json字符串
		
		Gson gon =new Gson();
		String jsontostring = gon.toJson(u);
		System.out.println(jsontostring);
	}
	
	@Test
	public void testgson2(){
		//将String  字符串转换成 Json 
		Gson gson = new Gson();
		String[] name = new String[]{"suns","lvhg"};
		String stringtojson = gson.toJson(name);
		System.out.println(stringtojson);
	}
	
	@Test
	public void testgson3(){
		//将集合 数据 转换成 Json格式的数据 
		Gson gson = new Gson();
		List<User> list = new ArrayList<User>();
		User u1 = new User(2,"xianhei","123456",null);
		User u2 = new User(3,"xiaoming","123456",null);
		list.add(u1);
		list.add(u2);
		String Listtojson = gson.toJson(list);
		System.out.println(Listtojson);
	}
	
	@Test
	public void testgson4(){
		//将 符合类型的对象转换为 json
		Address address =new Address("bj","10456");
		User u = new User(4,"jinlong","123546",address);
		Gson gson =new Gson();
		String jsonString = gson.toJson(u);
		System.out.println(jsonString);
	}
}
