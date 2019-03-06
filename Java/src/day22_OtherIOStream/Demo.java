package day22_OtherIOStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class Demo {

	public static void main(String[] args) throws IOException{
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		
		//Properties.store()			将修改后的数据映射到配置文件中
		//Properties.load()				加载配置文件		
		Properties pro = new Properties();
		System.out.println("读取前！");
		pro.load(new FileInputStream("src/config.properties"));
		System.out.println("读取后");
		System.out.println(pro);
		pro.setProperty("username","lhg");
		System.out.println("=====================");
		System.out.println(pro);
		pro.store(new FileOutputStream("src/config.properties"),"修改第二个参数");
		System.out.println(pro);
	}

	private static void test5() {
		//Properties
		/**
		  	public Object setProperties(String key,String value);
			public String getProperties(String key);
			public Enumeration<String> PropertyNames();
		 */
		Properties pt = new Properties();
		pt.setProperty("name","张三");
		pt.setProperty("tel","13839262654");
	
		Enumeration<String> en = (Enumeration<String>) pt.propertyNames();
		while((en.hasMoreElements())){
			//System.out.println(en.nextElement());
			String key = en.nextElement();
			String value = pt.getProperty(key);
			System.out.println(key+":"+value);
		}
	}

	private static void test4() throws FileNotFoundException, IOException {
		//ByteArrayOutputStream 内存输出流  内存中顶一个了一个字符数组缓冲区
		FileInputStream in = new FileInputStream("src/a.txt");
		ByteArrayOutputStream bt = new ByteArrayOutputStream();
		int len;
		while((len = in.read())!=-1){
			bt.write(len);
		}
		in.close();
		bt.close();
		System.out.println(bt.toString());
		System.out.println("读写完毕!");
	}

	private static void test3() throws FileNotFoundException, IOException {
		//SequenceInputStream(Enumeration)	合并多个流,将多个流关联的文件写入一个文件对象中
		FileInputStream in1 = new FileInputStream("src/1.txt");
		FileInputStream in2 = new FileInputStream("src/2.txt");
		FileInputStream in3 = new FileInputStream("src/3.txt");
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(in1);
		v.add(in2);
		v.add(in3);
		Enumeration<FileInputStream> enumer = v.elements();
		SequenceInputStream input = new SequenceInputStream(enumer);
		FileOutputStream out = new FileOutputStream("src/union.txt");
		int len;
		while((len = input.read())!=-1){
			out.write(len);
		}
		input.close();
		out.close();
		System.out.println("合并完毕!");
	}

	private static void test2() throws FileNotFoundException, IOException {
		//SequenceInputStream 序列流
		FileInputStream in = new FileInputStream("src/1.txt");
		FileInputStream inputStream = new FileInputStream("src/2.txt");
		SequenceInputStream sis = new SequenceInputStream(in, inputStream);
		FileOutputStream out = new FileOutputStream("src/3.txt");
		int len;
		while((len = sis.read())!=-1){
			out.write(len);
		}
		sis.close();
		out.close();
		System.out.println("读写完毕!");
	}

	private static void test1() throws FileNotFoundException, IOException {
		//FileInputStream流 FileOutputStream流
		FileInputStream in = new FileInputStream("src/1.txt");
		FileOutputStream out = new FileOutputStream("src/3.txt");
		int len;
		byte[] buffer = new byte[1024];
		while((len = in.read(buffer))!=-1){
			out.write(buffer,0,len);
		}
		in.close();
		FileInputStream inputStream = new FileInputStream("src/2.txt");
		int len1;
		while((len1 = inputStream.read(buffer))!=-1){
			out.write(buffer,0,len1);
		}
		inputStream.close();
		out.close();
		System.out.println("读写完毕");
	}
}
