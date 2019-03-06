package com.nyist.generic;

import java.util.ArrayList;
import java.util.Collection;

public class Demo3 {
	
	public void test(){
		printf(new ArrayList<String>());
	}
	
	public void printf(Collection<?> c){
		//只要使用到 ? 号通配符,就不能调用与泛型相关的方法
		System.out.println(c);
	}
}
