package day12_String;

public class Demo2_String {

	public static void main(String[] args){
		String str = "abcdef";							//abc可以看作是String 的一个对象
		String s = "abcdefghijk|lmnOpqrrstuvwxyzr ";
		System.out.println("/*======================================================================*/");
		System.out.println("/*============================String 字符串常用函数======================*/");
		System.out.println("str:"+str);
		System.out.println("charAt:"+s.charAt(25));
		System.out.println("compareTo:"+s.compareTo(str));
		System.out.println("concat:"+s.concat("123"));
		System.out.println("contains:"+s.contains(str));
		System.out.println("endsWith:"+s.endsWith("z"));
		System.out.println("format:"+s.format("Hello %s","老王"));
		System.out.println("getBytes:"+s.getBytes());
		System.out.println("HashCode:"+s.hashCode());
		System.out.println("indexOf:"+s.indexOf("k"));
		System.out.println("isEmpty:"+s.isEmpty());
		System.out.println("lashIndexOf:"+s.lastIndexOf("r"));
		System.out.println("length:"+s.length());
		System.out.println("replace:"+s.replace("r","R"));
		System.out.println("split-prefix:"+s.split("\\|")[0]+"  split-suffix:"+s.split("\\|")[1]);
		System.out.println("startsWidth:"+s.startsWith("ab"));
		System.out.println("substring:"+s.substring(s.indexOf("|")+1));
		System.out.println("toLowerCase:"+s.toLowerCase());
		System.out.println("tpUpperCase:"+s.toUpperCase());
		System.out.println("trim:"+s.trim());
		System.out.println("valueOf:"+s.valueOf(123.66));
		System.out.println("/*======================================================================*/");
	}
}
