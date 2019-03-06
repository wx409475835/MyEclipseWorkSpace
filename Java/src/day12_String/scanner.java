package day12_String;

import java.util.Scanner;

public class scanner {
	public static void main(String[] argc){
		Scanner scanner = new Scanner(System.in);				//从键盘中输入字符
		if(scanner.hasNextInt()){								//判断输入的是否是int类型
			int i = scanner.nextInt();
			System.out.print("I:"+i);
		}else {
			String iString = scanner.next();					//保存其他输入数据
			System.out.print("Other:"+iString);
		}
	}
}
