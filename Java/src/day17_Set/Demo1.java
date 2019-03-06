package day17_Set;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

import day16_List.List;

public class Demo1 {

	public static void main(String[] args){
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		
	}

	private static void test5() {
		/**
		 * TreeSet:元素唯一、元素自动排序
		 * 案例:TreeSet
		 */
		TreeSet set = new TreeSet();
		set.add("4");
		set.add("5");
		set.add("4");
		set.add("1");
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("3");
		System.out.println(set);
	}

	private static void test4() {
		/**
		 * 案例:去除List集合中的重复数字
		 */
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("e");
		list.add("e");
		getSignal(list);
	}

	private static void getSignal(ArrayList list) {
		LinkedHashSet set = new LinkedHashSet();
		set.addAll(list);
		for (Object c : set) {
			System.out.print(c);
		}
	}

	private static void test3() {
		/**
		 * 案例:使用Scanner从键盘中读取一行输入,去掉哪些重复字符,打印出哪些不同的字符。
		 * 输入:aaabbbcccssdsssdddfffggg
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一行字符:");
		String s = scanner.nextLine();
		char[] string = s.toCharArray();
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for(int i=0;i<string.length;i++){
			set.add(string[i]);
		}
		for(Character c:set){
			System.out.print(c);
		}
	}

	private static void test2() {
		/***
		 * 案例:要求编写一个程序,获取10个1至20的随机数,要求随机数不能重复,并把最终的结果输出到控制台
		 */
		Random random = new Random();
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		int i = 0;
		for(;set.size()<10;){
			while(true){
				int o = random.nextInt(20);
				if(o!=0 && !(String.valueOf(o).isEmpty())){
					set.add(String.valueOf(o));
					break;
				}
			}
		}
		System.out.println("Set:"+set);
	}

	private static void test1() {
		//LinkedHaseSet
		@SuppressWarnings("rawtypes")
		LinkedHashSet set = new LinkedHashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("a");
		set.add("d");
		System.out.println(set);
	}
}
