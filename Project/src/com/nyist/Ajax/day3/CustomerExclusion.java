package com.nyist.Ajax.day3;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CustomerExclusion implements ExclusionStrategy{
	@Override
	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		//获得属性的名字
		if(f.getName().equals("customer")){
			return true;
		}else{
			return false;
		}
	}
}
