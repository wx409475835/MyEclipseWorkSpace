package com.nyist.utils.myConventer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class MyConventer implements Converter {

	@Override
	public Object convert(Class clazz, Object obj) {
		// Class 要转换的类型
		//object 页面上传入的值
		
		//将object 转成data
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = s.parse((String)obj);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
