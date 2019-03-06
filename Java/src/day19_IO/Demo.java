package day19_IO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException{
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		
		//FilenameFilter 文件过滤器
		File file = new File("F:\\");
		String[] s = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				File file = new File(dir,name);
				return file.isFile() && file.getName().endsWith(".zip");
			}
		});
		for (String string : s) {
			System.out.println(string);
		}
	}


	private static void test6() {
		/**
		 案例:判断F盘下是否有.jpg的文件,如果有,就输出该文件名称。
		 */
		File file = new File("D:\\");
		
		String[] s = file.list();						//拿到所有的文件和文件夹名称
		for (String string : s) {
			if(string.endsWith(".jpg")){
				System.out.println(string);
			}
		}
		System.out.println("=========================================================");
		File[] files = file.listFiles();
		for (File f : files) {
			if(f.isFile() && f.getName().endsWith(".jpg")){
				System.out.println(f);
			}
		}
	}

	
	private static void test5() {
		/**
		 String 								getAbsolutePath()					获取绝对路径
		 String								    getPath()							获取路径
		 String								    getName()							获得文件名称
		 long								    length()							获得长度,字节数
		 long								    lastModified()						获得最后一次的修改时间,毫秒值
		 String[]							    list()								获取指定目录下的所有文件或者文件夹的名称数组
		 File[]								    listFiles()							获取指定目录下的所有文件或者文件夹的File数组
	   */
		File file = new File("src/a.txt");
		File file2 = new File("F:\\Workspace 2016\\Java");
		System.out.println("getAbsoultPath:"+file.getAbsolutePath());
		System.out.println("getAbsoultPath:"+file2.getAbsolutePath());
		System.out.println("getPath:"+file.getPath());
		System.out.println("getName:"+file.getName());
		System.out.println("length:"+file.length());
		System.out.println("lastModified:"+file.lastModified());
		String[] f = file2.list();
		for (String string : f) {
			System.out.println(string);
		}
		System.out.println("===========================");
		File[] files = file2.listFiles();
		for (File fs : files) {
			System.out.println(fs.getName());
		}
	}

	private static void test4() {
		/**
		 boolean								isDirectory()						判断是否是目录
		 boolean								isFile()							判断是否是文件
		 boolean								exists()							判断是否存在
		 boolean								canRead()							判断是否可读
		 boolean								canWrite()							判断是否可写
		 boolean								isHidden()							判断是否隐藏
		 */
		File file = new File("src/a.txt");
		System.out.println("exists:"+file.exists());
		System.out.println("isDirectory:"+file.isDirectory());
		System.out.println("isFile:"+file.isFile());
		System.out.println("canRead:"+file.canRead());
		System.out.println("canWrite:"+file.canWrite());
		System.out.println("canExecute:"+file.canExecute());
		System.out.println("isHidden:"+file.isHidden());
	}

	private static void test3() {
		/**
		 boolean								renameTo(File dest)					把文件名重命名未指定的文件路径
		 boolean								delete()							删除文件或文件夹
		注意:重命名注意事项:
				如果路径名相同,就是改名字。
				如果路径名不同,就是改名并剪切。
			 删除注意事项:
			 	Java中删除不进入回收站
			 	要删除一个文件夹,文件夹中不能包含东西。
		 */
		File file = new File("src/a.jpg");
		File file2 = new File("src/a.txt");
		System.out.println(file.renameTo(file2));
		
		File file3 = new File("src/a");
		System.out.println(file3.delete());
	}

	private static void test2() throws IOException {
		/**
		 	boolean								createNewFile()						如果没有该文件就创建,如果有就不创建了
			boolean								mkdir()								创建文件夹,如果存在就不创建了
			boolean								mkdirs()							创建文件夹,如果父文件夹存在就不创建了,父文件夹不存在,帮你创建出来
		 */
		File file = new File("src/a.jpg");
		System.out.println(file.createNewFile());
		File file2 = new File("src/a");
		System.out.println(file2.mkdir());
		File file3 = new File("src/a/v/s.txt");
		System.out.println(file3.mkdirs());
	}

	private static void test1() {
		/**
		 File(String pathname);								根据当前路径得到一个File对象
		 File(String parent,String child)					根据一个目录和一个子文件/目录得到File对象
		 File(File parent,String child)						根据一个父File对象和一个子文件/目录得到File对象
		 */
		File file = new File("F:\\01-JavaSE知识(学习27天)\\day19(异常&IO(File类))\\day19(异常&IO(File类))\\day19(异常&IO(File类))\\day19_video");
		System.out.println(file.exists());		
		File file2 = new File("src/xxx.txt");
		System.out.println(file2.exists());
		
		String parent = "F:\\01-JavaSE知识(学习27天)\\day19(异常&IO(File类))\\day19(异常&IO(File类))";
		String child = "day19(异常&IO(File类))\\day19_video";
		File file3 = new File(parent, child);
		System.out.println(file3.exists());
		System.out.println("===============-------------------------------=====================");
		File parent1 = new File("F:\\01-JavaSE知识(学习27天)\\day19(异常&IO(File类))\\day19(异常&IO(File类))");
		String child2 = "day19(异常&IO(File类))\\day19_video";
		File file4 = new File(parent1,child2);
		System.out.println(file4.exists());
	}
}
