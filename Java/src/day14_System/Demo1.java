package day14_System;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) throws ParseException{
		//test1();
		//test2();
		//test3();
		test4();
	}

	private static void test4() {
		//从键盘录入任何一个年份,判断该年是闰年还是平年
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个年份:");
		if(!scanner.hasNextInt()){
			System.out.println("请输入合法的年份");
			return ;
		}
		int s = Integer.valueOf(scanner.nextLine());
		if((s%100!=0&&s%4==0)||s%400==0){
			System.out.println("是闰年");
		}else {
			System.out.println("不是闰年");
		}
	}

	private static void test3() {
		//Calendar 类
		Calendar cal = Calendar.getInstance();				//父类引用指向子类对象
		System.out.println("年:"+cal.get(Calendar.YEAR));
		System.out.println("月:"+cal.get(Calendar.MONTH));
		System.out.println("日:"+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(GetWeek(cal.get(Calendar.DAY_OF_WEEK)));
		System.out.println("时:"+cal.get(Calendar.HOUR));
		System.out.println("分:"+cal.get(Calendar.MINUTE));
		System.out.println("秒:"+cal.get(Calendar.SECOND));
	}
	
	private static String GetWeek(int filed){
		String week = null;
		switch (filed) {
		case 1:
			week="星期日";
			break;
		case 2:
			week="星期一";
			break;
		case 3:
			week="星期二";
			break;
		case 4:
			week="星期三";
			break;
		case 5:
			week="星期四";
			break;
		case 6:
			week="星期五";
			break;
		case 7:
			week="星期六";
			break;
		default:System.out.println("没有该日期");
			break;
		}
		return week;
	}
	
	private static void test2() throws ParseException {
		//算一下 年来到这个世界多少天？
		/**
		 * 步骤:1.将生日字符串和今天日期字符串存在变量中
		 * 		2.定义日期格式化对象
		 * 		3.将日期字符串转化成日期对象
		 * 		4.通过日期对象 获得时间毫秒值
		 * 		5.将两个毫秒值相减,处以1000,处以60,再除以60,在处以24
		 */
		String s1 = "1996-03-10";
		String s2 = "2018-07-23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(new Date());
		Date date1 = sdf.parse(s1);
		Date date2 = sdf.parse(s2);
		long time = date2.getTime() - date1.getTime();
		System.out.println("共来到世界上: "+(time/1000/60/60/24)+" 天");
	}

	private static void test1() {
		Date date = new Date();
		System.out.println(date);
		Date date2 = new Date(0);
		System.out.println(date2);
		System.out.println(date.getTime()); 					//通过时间对象获取毫秒值
		System.out.println(System.currentTimeMillis());			//通过系统类获取毫秒值
	}
}
