package day12_String;

import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Demo4_String {

	public static void main(String[] args){
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//字符串反转
		/**
		 *    abc
		 *    cba
		 */
		String s = "abc";
		char[] arr = s.toCharArray();
		char temp;
		int i;
		for(i=arr.length-1;i>=0;i--){
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			System.out.println(temp);
			arr[arr.length-i-1] =temp;
		}
		String str = String.valueOf(arr);
		System.out.println("Str:"+str);
	}

	private static void test5() {
		/**
		 * 将数组中的数据按照指定的格式转换成以下格式:
		 * 	int[] arr = {1,2,3};
		 *  "[1,2,3]"
		 */
		int[] arr = {1,2,3};
		String string = String.valueOf(arr);
		String s = "[";
		for(int i=0;i<arr.length;i++){
			if(i==arr.length - 1){
				s=s+arr[i]+"]";
			}else {
				s=s+arr[i]+",";
			}
		}
		
		System.out.println("s:"+s);
	}

	private static void test4() {
		//将字符串第一个字母转换成大写,其他转换成小写
		String string="lvhaoguangisOK";
		String str = string.toUpperCase().charAt(0)+string.substring(string.indexOf(string.charAt(0))+1).toLowerCase();
		System.out.println("str:"+str);
	}

	private static void test3() {
		char[] arr = {'l','h','g'};
		String s = String.valueOf(arr);
		System.out.println("s:"+s);
	}

	private static void test2() {
		String s = "lvhaoguang";
		char[]  arr = s.toCharArray();				//将字符串转换成字符数组
		for(int i=0;i<arr.length;i++){
			System.out.println("i:"+arr[i]);
		}
	}

	private static void test1() {
		int i;
		for(i=0;i<3;i++){
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名:");
			String username = scanner.nextLine();
			System.out.println("请输入密码:");
			String password = scanner.nextLine();
			if("admin".equals(username) && "410923".equals(password)){
				System.out.println("欢迎admin登陆!");
				break;
			}else{
				if(i==2){
					System.out.println("今日输入密码次数已用完,请明天在试!");
				}else{
					System.out.println("用户名或密码错误!您还有"+(2-i)+"次机会");
				}
			}
		}
	}
}
