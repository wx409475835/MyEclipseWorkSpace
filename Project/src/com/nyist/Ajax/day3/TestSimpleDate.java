package com.nyist.Ajax.day3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestSimpleDate {
	@Test
	public void testSD(){
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:ss");
		String dString = simpleDateFormat.format(d);
		
		System.out.println("现在时间是:"+dString);
	}
}
