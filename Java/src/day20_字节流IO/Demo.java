package day20_字节流IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException, InterruptedException{
		//test1();
		//test2();
		//test3();
		//test4();
		
		//图片加密   将读取图片的每个字节 都 亦或上一个自然数  最后图片读取完毕肯定也是亦或自然数之后的
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/2.jpg"));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/12.jpg"));
		int len; 
		while((len=in.read())!=-1){
			out.write(len ^ 123);
		}
		in.close();
		out.close();
		System.out.println("读取结束！");
	}

	private static void test4() throws FileNotFoundException, IOException {
		//BufferInputStream 和 BufferOutputStream 
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\1.jpg"));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/1.jpg"));
		
		int len;
		while((len = in.read())!=-1){
			out.write(len);
		}
		in.close();
		out.close();
	}

	private static void test3() throws FileNotFoundException, IOException {
		//读取图片
		FileInputStream inputStream  = new FileInputStream("D:\\1.jpg");
		FileOutputStream out = new FileOutputStream("E:\\FileOutput.jpg");
		int len;
		byte[] buffer = new byte[1024];
		while((len = inputStream.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		inputStream.close();
		out.close();
		System.out.println("读取完毕!");
	}

	private static void test2() throws FileNotFoundException, IOException {
		/**
		 * FileOutputStream 字节输出流,如果没有该文件,会自动创建该输出流文件
		 */
		FileOutputStream fileOutputStream = new FileOutputStream("src/b.txt");
		fileOutputStream.write(97);
		fileOutputStream.write(98);
		fileOutputStream.write(99);
		fileOutputStream.close();
		System.out.println("输出完毕!");
	}

	private static void test1() throws IOException {
		//FileInputStream	文件流对象	文件的结束标记为-1
		try {
			FileInputStream fileInputStream = new FileInputStream("src/a.txt");			//创建一个流对象
			int b;
			while((b = fileInputStream.read())!=-1){
				System.out.println(b);
			}
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
