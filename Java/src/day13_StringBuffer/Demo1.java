package day13_StringBuffer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args){
		//test1();
		//test2();
		//test3();
		//test4()
		//test5();
		//teest6();
		//test7();
		//test8();
		//test9();
		//test10();
		//test11();
		//test12();
		//test13();
		//test14();
		int a = 65;
		Integer integer = new Integer(a);					//将int 类型转换成	Integer		手动装箱
		int q = integer.intValue();							//将Integer 转换成	int			手动拆箱
		System.out.println("Q:"+q);
		
		//JDK1.5之后
		Integer i = 100;									//自动装箱
		int i1 = i+200;										//自动拆箱
		System.out.println("i1:"+i1);
	}

	private static void test14() {
		//Arrays.toString()
		int[] arr = {45,65,88,1,3,101,56,23,11,8,4,98};
		String s = Arrays.toString(arr);
		System.out.println("s:"+s.toString());
	}

	private static void test13() {
		//Arrays.binarySearch()
		int[] arr = {1,3,4,8,11,23,45,56,65,88,98,101};
		int i = Arrays.binarySearch(arr,56);
		System.out.println(i);
	}

	private static void test12() {
		//Arrays.sort()
		int[] arr = {45,65,88,1,3,101,56,23,11,8,4,98};
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void test11() {
		//Arrays.asList()
		List<String> list = Arrays.asList(".jpg",".png",".txt",".docx");
		for(String ls:list){
			System.out.println(ls);
		}
	}

	private static void test10() {
		//二分查找
		int[] arr = {45,65,88,1,3,101,56,23,11,8,4,98};
		int mid,min,max,temp;
		int i,j;
		for(i=0;i<arr.length;i++){
			for(j=0;j<arr.length;j++){
				if(arr[i]<arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		min=arr[0];
		max=arr[arr.length-1];
		mid=arr[((arr.length-1)/2)];
		System.out.println("请输入需要查找的数值:");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a>min&&a<mid){
			
		}
	}

	private static void test9() {
		//冒泡排序
		int[] arr = {45,65,88,1,3,101,56,23,11,8,4,98};
		int i,j,temp;
		for(i =0;i<arr.length;i++){
			for(j=0;j<arr.length-i-1;j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

	private static void test8() {
		//选择排序
		int[] arr = {45,65,88,1,3,101,56,23,11,8,4,98};
		int temp,j;
		for(int i=0;i<arr.length;i++){
			for(j=0;j<arr.length;j++){
				if(arr[i]< arr[j]){
					temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

	private static void test7() {
		/**
		 * 字符串反转  abc   cba
		 */
		StringBuffer sb = new StringBuffer("abc");
		sb.reverse();
		System.out.println("sb:"+sb.toString());
	}

	private static void teest6() {
		/*
		 * 将数组中的形式:int arr={1,2,3};
		 * 		 输出结果:[1,2,3]
		 * 		使用StringBuffer实现
		 * */
		int[] arr = {1,2,3};
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0;i<arr.length;i++){
			if(i==arr.length-1){
				sb.append(arr[i]).append("]");
			}else {
				sb.append(arr[i]).append(",");
			}
		}
	System.out.println("sb:"+sb.toString());
	}

	private static void test5() {
		//StringBuffer 的截取功能
		//substring()  返回值String
		StringBuffer buffer = new StringBuffer("lvhaoguang");
		String s = buffer.substring(0,2);			//lv
		System.out.println("buffer:"+s);
	}

	private static void test4() {
		//反转和替换  replace() 和  reverse()
		StringBuffer sb = new StringBuffer("lvhaoguang");
		sb.replace(0, 3,"lhg");
		System.out.println("sb:"+sb);
		sb.reverse();
		System.out.println("sb:"+sb);
	}

	private static void test3() {
		//delete
		StringBuffer sb = new StringBuffer("abcdef");
		sb.deleteCharAt(5);
		System.out.println("sb:"+sb);
		sb.delete(0,3);
		System.out.println("sb:"+sb);
	}

	private static void test2() {
		StringBuffer sb = new StringBuffer("lhg");
		sb.append("-lvhaoguang");
		System.out.println("sb:"+sb);
		StringBuffer sBuffer = new StringBuffer("123");
		sBuffer.insert(2,"lhg");
		System.out.println("SBuffer:"+sBuffer);
		/**
		 * 结果：
		 * 		sb:lhg-lvhaoguang
				SBuffer:12lhg3

		 */
	}

	private static void test1() {
		//StringBuffer的几个构造函数
		StringBuffer sb = new StringBuffer();
		System.out.println("length:"+sb.length());
		System.out.println("容器的初始容量:"+sb.capacity()); 		//容器的初始容量
		
		StringBuffer sb1 = new StringBuffer(10);
		System.out.println("length:"+sb1.length());
		System.out.println("容器的容量:"+sb1.capacity());
		
		StringBuffer sb2 = new StringBuffer("lvhaoguang");
		System.out.println("length:"+sb2.length());
		System.out.println("Capacity:"+sb2.capacity());				//length + 初始容量
		
	}
}
