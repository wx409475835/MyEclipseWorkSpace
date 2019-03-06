package day14_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
	
	public static void main(String[] args){
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		//test9();
		//test10();
		//将字符串中得手机号提取出来
		//test11();
	}

	private static void test11() {
		String string = "我现在得是手机号是:18812345670,之前用过得手机号:13888888888,还用过的手机号:14465555555";
		String regex = "1[345789]\\d{9}";
		Pattern pt = Pattern.compile(regex);
		Matcher m = pt.matcher(string);
		while(m.find()!=false){
			System.out.println(m.group());
		}
	}

	private static void test10() {
		//Pattern.compile()接收一个正则表达式
		Pattern pt = Pattern.compile("a*b");
		Matcher matcher = pt.matcher("aaaaaab");
		System.out.println(matcher.matches());
	}

	private static void test9() {
		//\W
		String regex = "\\W";
		System.out.println("s".matches(regex));
		System.out.println("8".matches(regex));
		System.out.println("Q".matches(regex));
		System.out.println("588".matches(regex));
		System.out.println("_".matches(regex));
	}

	private static void test8() {
		//\w
		String regex = "\\w";
		System.out.println("s".matches(regex));
		System.out.println("A".matches(regex));
		System.out.println("0".matches(regex));
		System.out.println("9".matches(regex));
		System.out.println("88".matches(regex));
		System.out.println(".".matches(regex));
	}

	private static void test7() {
		//\D
		String regex = "^\\D$";
		System.out.println("s".matches(regex));
		System.out.println("0".matches(regex));
	}

	private static void test6() {
		//[a-z&&[def]] ------>	[def]
		String regex = "^[a-z&&[def]]$";
		System.out.println("s".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("e".matches(regex));
	}

	private static void test5() {
		//[a-d[m-p]]	---->	[a-dm-p]
		String regex = "^[a-d[m-p]]$";
		System.out.println("s".matches(regex));
		System.out.println("e".matches(regex));
		System.out.println("m".matches(regex));
	}

	private static void test4() {
		//[a-zA-Z]
		String regex = "^[a-zA-Z]$";
		String s = "S";
		System.out.println(s.matches(regex));
	}

	private static void test3() {
		//[^abc]
		String regex = "^[^abc]$";
		String s = "q";
		System.out.println(s.matches(regex));
	}

	private static void test2() {
		//[abc]		
		String regex = "^[abc]$";				//^代表开始 $代表结束 []代表单个字符
		String string = "ab";
		System.out.println(string.matches(regex));
	}

	private static void test1() {
		/**
		 * 校验QQ:
		 * 		1.要求必须是5-15位数字
		 * 		2.0不能开头
		 * 		3.必须都是数字
		 */
		String s = "1234546666666666";
		String regex = "^[1-9]\\d{4,14}$";
		System.out.println(s.matches(regex));
	}
	
}
