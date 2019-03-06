package com.nyist.Ajax.day3;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

//将 Feb 4,2018 10:44:33 AM 转换成 2018 2 4 10:44:33
/*
 * 	(1)明确接口中规定的方法 作用
	(2)无需知道参数哪里来的,只需要明确其含义 使用即可
	(3)按照接口规定的方法提供返回值.
 * */
@SuppressWarnings("rawtypes")
public class DateEditor implements JsonSerializer{
	//通过 SimpleDateFormat ---->
	@Override
	public JsonElement serialize(Object date, Type arg1,
			JsonSerializationContext arg2) {
		//JsonElement   ----->Json的基本类型
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:ss");
		String dateString = simpleDateFormat.format(date);
		//8中基本类型+String  --->JsonPrimitive();
		return new JsonPrimitive(dateString);
	}

}
