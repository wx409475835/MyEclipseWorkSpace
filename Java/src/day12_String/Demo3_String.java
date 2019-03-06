package day12_String;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Demo3_String {

	public static void main(String[] args) {
		//String 常用的几个构造函数   
		byte[] arr1 = {97,98,99,100,101,121};
		String str = new String(arr1,2,3);
		System.out.println("str:"+str);
		
		char[] ch = {'a','b','c','z','x','y'};
		String s = new String(ch);
		System.out.println("s:"+s);
		
		String sr = new String(ch,2,2);
		System.out.println("sr:"+sr);
		
		//String 面试题  创建了几个对象？
		//创建了2个对像   一个在常量池中,一个在堆中
		String string = new String("abc");
		System.out.println("str:"+str);
	}

}
