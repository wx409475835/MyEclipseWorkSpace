package day18_Map;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import java.util.Set;
import java.util.TreeSet;

import Model.Student;

public class Demo {

	public static void main(String[] args){
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		//test9();
		//test10();
		//test11();
		
		
	}

	private static void test11() {
		/**
		 * 案例:模拟斗地主,随机发牌,牌的顺序从小到大排列
		 */
		//1.生成扑克牌
		String[] s1 = {"3","4","5","6","7","8","9","10","J","Q","K","A","1","2"};
		String[] s2 = {"红桃","黑桃","方片","梅花"};
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index =0 ;
		for (String str1 : s1) {
			for (String str2 : s2) {
				list.add(index);
				map.put(index++,str2.concat(str1));
			}
		}
		//2.洗牌
		map.put(index++,"小王");
		map.put(index++,"大王");
		Collections.shuffle(list);
		//3.发牌
		TreeSet<Integer> xiongda = new TreeSet<Integer>();
		TreeSet<Integer> xionger = new TreeSet<Integer>();
		TreeSet<Integer> guangtouqiang = new TreeSet<Integer>();
		TreeSet<Integer> dipai = new TreeSet<Integer>();
		for (int i=0;i<list.size();i++) {
			if(i>=list.size()-3){
				dipai.add(list.get(i));
			}else if(i%3==0){
				xiongda.add(list.get(i));
			}else if(i%3==1){
				xionger.add(list.get(i));
			}else {
				guangtouqiang.add(list.get(i));
			}
		}
		//4.遍历输出牌
		getPoker(xiongda, map);
		getPoker(xionger, map);
		getPoker(guangtouqiang, map);
		getPoker(dipai, map);
	}

	private static void getPoker(TreeSet<Integer> set,Map<Integer,String> map){
		for(Integer integer : set){
			System.out.print(map.get(integer)+" ");
		}
		System.out.println("");
	}
	
	private static void test10() {
		/**
		 * 案例:模拟斗地主,随机发牌
		 */
		//1.生成扑克牌
		String[] s1 = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] s2 = {"红桃","黑桃","方片","梅花"};
		ArrayList<String> poker = new ArrayList<String>();
		for(String str1 :s1){
			for(String str2 :s2){
				poker.add(str2.concat(str1));
			}
		}
		poker.add("大王");
		poker.add("小王");
		//2.洗牌
		Collections.shuffle(poker);
		//3.发牌
		ArrayList<String> xiongda = new ArrayList<String>();
		ArrayList<String> xionger = new ArrayList<String>();
		ArrayList<String> guangtouqiang = new ArrayList<String>();
		ArrayList<String> dipai = new ArrayList<String>();
		for(int i=0;i<poker.size();i++){
			if(i>=poker.size()-3){
				dipai.add(poker.get(i));
			}else if(i%3==0){
				xiongda.add(poker.get(i));
			}else if(i%3==1){
				xionger.add(poker.get(i));
			}else {
				guangtouqiang.add(poker.get(i));
			}
		}
		System.out.println(xiongda);
		System.out.println(xionger);
		System.out.println(guangtouqiang);
		System.out.println(dipai);
	}

	private static void test9() {
		/**
		 *  void 							sort();								排序
		    int								binarySearch(List<?> list,T key)	搜索
		    T								max(Collection<?> coll)				返回最大值
		    void							reverse(List<?> list)				反转
		    void 							shuffle(List<?> list)				随机替换		 
		 */
		ArrayList list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("z");
		list.add("f");
		list.add("g");
		System.out.println(Collections.binarySearch(list, "c"));
		System.out.println(Collections.binarySearch(list, "f"));
		System.out.println(Collections.min(list));
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}

	private static void test8() {
		//HashMap 嵌套 HashMap
		HashMap<Student,String> map = new HashMap<Student, String>();
		map.put(new Student("张三",12),"北京");
		map.put(new Student("李四",13),"上海");
		map.put(new Student("王五",14),"广州");
		map.put(new Student("赵六",15),"深圳");
		
		HashMap<Student,String> map1 = new HashMap<Student, String>();
		map1.put(new Student("刘大",16),"武汉");
		map1.put(new Student("孔二",17),"南京");
		map1.put(new Student("秦七",18),"浙江");
		map1.put(new Student("宋八",19),"珠江");
		
		HashMap<HashMap<Student,String>,String> map2 = new HashMap<HashMap<Student,String>, String>();
		map2.put(map,"第一个Map集合");
		map2.put(map1,"第二个Ma集合");
		
		for (Entry<HashMap<Student, String>, String> string : map2.entrySet()) {
			System.out.println(string);
		}
		System.out.println("======================================");
		for (HashMap<Student,String> string : map2.keySet()) {
			System.out.println(string+":"+map2.get(string));
		}
	}

	private static void test7() {
		/**
		 * 案例:统计字符串出现的个数
		 * aaaabbbcccsssdddd
		 */
		LinkedHashMap<Character,Integer> lhm = new LinkedHashMap<Character, Integer>();
		Scanner s = new Scanner(System.in);
		System.out.println("请输入字符串:");
		String string = s.nextLine();
		char[] c = string.toCharArray();
		for(Character ch : c){
			if(lhm.containsKey(ch)){
				lhm.replace(ch, lhm.get(ch)+1);
			}else {
				lhm.put(ch,1);
			}
		}
		System.out.println(lhm);
	}

	private static void test6() {
		//LinkedHashMap
		LinkedHashMap<String,Integer> lhm = new LinkedHashMap<String,Integer>();
		lhm.put("张三",12);
		lhm.put("李四",13);
		lhm.put("赵六",15);
		lhm.put("王五",14);		
		System.out.println(lhm);
	}

	private static void test5() {
		HashMap<Student,String> map = new HashMap<Student,String>();
		map.put(new Student("张三",12),"北京");
		map.put(new Student("李四",13),"上海");
		map.put(new Student("张三",12),"广州");
		map.put(new Student("王五",14),"深圳");
		System.out.println(map);
	}

	private static void test4() {
		//Map.Set(String Key)  Map.get(String key);
		//4种Map集合的遍历方式
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("张三",13);
		map.put("李四",24);
		map.put("王五",25);
		map.put("赵六",26);	
		
		//1.Set()和get()结合使用   获取键值
		Set<String> strings = map.keySet();
		for (String string : strings) {
			System.out.println(string+":"+map.get(string));
		}
		System.out.println("==========Map.Set And Iterator==========");
		//2.使用Map.Set() 和 Iterator
		Set<String> set1 = map.keySet();
		Iterator<String> it = set1.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Object value = map.get(key);
			System.out.println(key+"="+value);
		}
		System.out.println("==========Map.Set<Map<String,Integer>>==========");
		//3.使用Map.Set<Map<String,Integer>> entrySet();
		for (Entry<String,Integer> entry :map.entrySet()) {
			System.out.println(entry);
		}
		//4.使用Map.Set<Map<String,Integer>> entrySet();   Iterator
		System.out.println("==========Map.Set<Map<String,Integer>> And Iterator==========");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		Iterator<Map.Entry<String,Integer>> itset = entry.iterator();
		while(itset.hasNext()){
			Map.Entry<String,Integer> entryset = itset.next();
			String entryKey = entryset.getKey();
			Object entryValue = entryset.getValue();
			System.out.println(entryKey+":"+entryValue);
		}
	}

	private static void test3() {
		//Map.containsKey()		Map.containsValue() Map.values()
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("张三",13);
		map.put("李四",24);
		map.put("王五",25);
		map.put("赵六",26);	
		System.out.println(map.containsKey("张三"));
		System.out.println(map.containsValue(24));
		
		Collection<Integer> collection =  map.values();
		for (Integer integer : collection) {
			System.out.println(integer);
		}
		
	}

	private static void test2() {
		//clear	 删除所有得集合键值对
		//remove 根据键值删除Map集合中得键值对 
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("张三",13);
		map.put("李四",24);
		map.put("王五",25);
		map.put("赵六",26);	
		map.clear();
		//map.remove("张三");
		map.clear();
		System.out.println(map);
	}

	private static void test1() {
		//Map集合底层是使用Hash算法来计算地址的,所以不是怎么存就是怎么取得类型
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("张三",13);
		map.put("李四",24);
		map.put("王五",25);
		map.put("赵六",26);	
		System.out.println(map);
	}
}
