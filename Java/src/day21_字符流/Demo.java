package day21_字符流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
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
		//test7();
		//test8();
		//test9();
		test10();
	}



	private static void test10() {
		/*
		 * 案例:打印从键盘中输入得路径下的所有得.java文件
		 */
		//1.拿到文件路径
		File dir = getDir();
		//2.遍历路径下的所有目录和文件
		printJavaFile(dir);
	}



	private static void printJavaFile(File dir) {
		File[] files = dir.listFiles();			//获得该目录下的所有文件夹和文件
		for (File file : files) {
			if(file.isFile() && file.getName().endsWith(".java")){
				System.out.println(file.getName());
			}else if(file.isDirectory()){
				//System.out.println("File:"+file);
				printJavaFile(file);
			}
		}
	}



	@SuppressWarnings("resource")
	private static File getDir() {	
		while(true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入需要查找的文件的路径:");
			String dir = scanner.nextLine();
			File file = new File(dir);
			if(!file.exists()){
				System.out.println("输入的路径名称不正确,请重新输入!");
			}else if(file.isFile()){
				System.out.println("对不起,请输入文件夹路径！");
			}else{
				return file;
			}
		}
	}



	private static void test9() {
		/**
		 * 装饰设计模式
		 * 		好处:降低类与类之间的耦合性
		 */
		University university = new University(new student());
		university.code();
	}

	
	
	private static void test8() throws FileNotFoundException, IOException {
		//LineNumberReader
		LineNumberReader reader = new LineNumberReader(new FileReader("src/a.txt"));
		String line;
		/*reader.setLineNumber(1000);					设置行号*/	
		while((line = reader.readLine())!=null){
			System.out.println(reader.getLineNumber()+":"+line);
		}
		reader.close();
		System.out.println("读写完毕！");
	}

	private static void test7() throws FileNotFoundException, IOException {
		/**
		 * 案例:将文本的数据反转
		 */
		BufferedReader reader = new BufferedReader(new FileReader("src/a.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/asd.txt"));
		String line;
		ArrayList<String> list = new ArrayList<String>();
		while((line = reader.readLine())!=null){
			list.add(line);
		}
		reader.close();
		for(int i = list.size() - 1;i>=0;i--){
			writer.write(list.get(i));
			writer.newLine();
		}
		writer.close();
		System.out.println("读写完毕！");
	}

	private static void test6() throws FileNotFoundException, IOException {
		//newLine readLine  和  \r\n
		BufferedReader reader = new BufferedReader(new FileReader("src/a.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/asd.txt"));
		String line ;
		while((line = reader.readLine())!=null){
			writer.write(line);
			writer.newLine();
		}
		reader.close();
		writer.close();
		System.out.println("读写完毕！");
	}

	private static void test5() throws FileNotFoundException, IOException {
		//BufferedReader     BufferedWriter
		BufferedReader reader = new BufferedReader(new FileReader("src/a.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/asd.txt"));
		int len ;
		while((len = reader.read())!=-1){
			writer.write(len);
		}
		reader.close();
		writer.close();
		System.out.println("读写完毕！");
	}

	private static void test4() throws FileNotFoundException, IOException {
		//自定义数组缓冲区
		FileReader reader = new FileReader("src/a.txt");
		FileWriter writer = new FileWriter("src/123.txt");
		int len;
		char[] c = new char[1024];
		while((len = reader.read(c))!=-1){
			writer.write(c,0,len);
		}
		reader.close();
		writer.close();
		System.out.println("读写完毕");
	}

	private static void test3() throws FileNotFoundException, IOException {
		FileReader reader = new FileReader("src/a.txt");
		FileWriter writer = new FileWriter("src/copy.txt");
		int c;
		while((c=reader.read())!=-1){
			writer.write(c);
		}
		
		reader.close();
		writer.close();   						//writer中维护了一个1024 2Kb的小缓冲区,如果不关流,数据将留在缓冲区
	}

	private static void test2() throws IOException {
		//FileWriter  
		FileWriter writer = new FileWriter("src/a.txt");
		writer.write("Hello,大家好,我是吕浩光,我想找一个漂亮身材好的女朋友！");
		writer.close();
	}

	private static void test1() throws FileNotFoundException, IOException {
		//FileReader 
		FileReader reader = new FileReader("src/a.txt");
		int x ;
		while((x=reader.read())!=-1){
			System.out.print((char)x);
		}
	}
}


interface Coder{
	public void code();
}

class student implements Coder{
	
	public student() {
		super();
	}
	
	@Override
	public void code() {
		System.out.println("Java基础");
		System.out.println("JavaWeb");
	}
}

class University implements Coder{

	private student stu;
	
	public University(student stu) {
		this.stu = stu;
	}
		
	public University() {
		super();
	}

	@Override
	public void code() {
		stu.code();
		System.out.println("Linux");
		System.out.println("ssh");
		System.out.println("ssm");
		System.out.println("jQuery");
		System.out.println("js");
		System.out.println("html");
		System.out.println("css");
		System.out.println("Ajax");
		System.out.println("...");
	}
	
}
