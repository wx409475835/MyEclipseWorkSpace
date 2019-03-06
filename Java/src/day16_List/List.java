package day16_List;

import java.util.ArrayList;
import java.util.Iterator;

public class List {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		//test1();
		//test2();
		//test3();
		
	}

	private static void test3() {
		//2.迭代器删除
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		Iterator it = list.iterator();
		while(it.hasNext()){
			if("b".equals(it.next())){
				it.remove();
			}
		}
		System.out.println(list);
	}

	private static void test2() {
		//1.普通for循环的删除
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		for(int i=0;i<list.size();i++){
			if("b".equals(list.get(i))){
				list.remove(i--);
			}
		}
		System.out.println(list);
	}

	private static void test1() {
		//去除List里边的重复字符串
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		ArrayList arraylist = getSignal(list);
		System.out.println("ArrayList:"+arraylist);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static ArrayList getSignal(ArrayList list){
		ArrayList arrayList = new ArrayList();				//New  一个新的List集合
		Iterator it = list.iterator();						//定义一个迭代器 
		while(it.hasNext()){
			Object obj = it.next();
			if(!arrayList.contains(obj)){
				arrayList.add(obj);
			}
		}
		return arrayList;
	}
}
