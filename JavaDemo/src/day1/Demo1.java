package day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo1 {
	public static void main(String argv[]){
		//1.5 
		Integer i = 1; //装箱子
		int j=1;		//拆箱
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			int k = (Integer)iterator.next();	//拆箱
		}
	}
	
	@Test
	public void test3(){
		
	}
}	
