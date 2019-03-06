package com.nyist.cn.Test;

import org.junit.Test;

public class TestHashCode {
	
	@Test
	public void test1(){
		String string = "cba54eb8-ca91-4808-94dd-5777630087e6_你好.txt";
		int hashCode = string.hashCode();
		System.out.println("哈希值:"+hashCode);
	}
}
