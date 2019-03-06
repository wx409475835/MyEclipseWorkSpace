package day23_递归;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws IOException{
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		
	}

	private static void test6() {
		/**
		 * 案例:约瑟夫环
		 * 获取幸运数字
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入容器大小:");
		if(scanner.hasNextInt()){
			int num = scanner.nextInt();
			int lunck = getLuckly(num);
			System.out.println("Luckly:"+lunck);
		}
	}

	private static int getLuckly(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=num;i++){
			list.add(i);
		}
		int count = 1;
		for(int i=0;list.size()!=1;i++){
			if(i==list.size()){
				i=0;
			}
			if(count%3==0){
				list.remove(i--);
			}
			count++;
		}
		return list.get(0);
	}

	private static void test5() {
		/**
		 * 案例:求1000的阶乘有多少个0
		 */
		BigInteger in = new BigInteger("1");
		for(int i=1;i<=1232;i++){
			BigInteger interger = new BigInteger(String.valueOf(i));
			in = in.multiply(interger);
		}
		System.out.println(in);
		String s = String.valueOf(in);
		char[] ch = s.toCharArray();
		BigInteger count = new BigInteger("1");
		BigInteger sum = new BigInteger("0");
		for(int j=0;j<ch.length;j++){
			if(ch[j]=='0'){
				sum = sum.add(count);
			}
		}
		System.out.println("Count:"+sum);
	}

	private static void test4() {
		//递归  斐波那契数列
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入求第几个月的兔子的对数:");
		if(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int m = sum(n);
			System.out.println("兔子总共 "+m+" 对");
		}
	}

	private static int sum(int n) {
		if(n==1||n==2)
			return 1;
		else
			return sum(n-2) + sum(n-1);
	}

	private static void test3() {
		//斐波那契数列		数组形式
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入求第几个月的兔子的对数:");
		if(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int[] arr = new int[n];
			arr[0]=1;
			arr[1]=1;
			int i;
			for(i=2;i<arr.length;i++){
				arr[i]=arr[i-1]+arr[i-2];
			}
			System.out.println("兔子总共 "+arr[arr.length-1]+" 对!");
		}
	}

	private static void test2() throws FileNotFoundException, IOException {
		//接收一个文件夹路径,将一个文件夹中的数据拷贝到另一个文件夹中去
		File dir = getDir();
		//拷贝文件
		File out = getDir();
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(out));
		copyFile(dir,out,outputStream);
		System.out.println("复制完毕!");
	}

	private static void copyFile(File dir,File out,BufferedOutputStream outputStream) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if(file.isFile()){
				int len;
				FileInputStream in = new FileInputStream(file);
				while((len = in.read())!=-1){
					outputStream.write(len);
				}
			}else if(file.isDirectory()){
				copyFile(file, out, outputStream);
			}
		}
	}

	private static void test1() {
		/**
		 * 案例:从键盘中输入一个文件路径,统计文件家的大小
		 */
		//1.获得文件夹路径
		long size =0 ;
		File dir = getDir();
		//2.统计文件个小
		size = getFileRealSize(dir,size);
		System.out.println(dir+"文件大小为--->"+size+"字节");
	}

	private static long getFileRealSize(File dir, long size) {
		//3.得到目录下的所有文件
		File[] files = dir.listFiles();
		//4.遍历数组 
		for (File file : files) {
			if(file.isFile()){
				size+=file.length();
			}else if(file.isDirectory()){
				System.out.println("File:"+file.getName());
				getFileRealSize(dir, size);
			}
		}	
		return size;
	}

	private static File getDir() {
		
		while(true){
			//从键盘中读入一组数据
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入一个文件夹路径:");
			String dir = scanner.nextLine();
			File file = new File(dir);
			if(file.exists() && file.isDirectory()){
				return file;
			}else if(file.isFile()){
				System.out.println("您输入的为文件,请输入文件夹路径!");
			}else {
				System.out.println("输入不正确,请重新输入!");
			}
		}
	}
}
