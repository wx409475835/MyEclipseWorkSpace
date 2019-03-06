package day27_Class;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException{
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		
	}

	private static void test5() throws FileNotFoundException, IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		/*
		 * 案例:已经知道一个类,定义如下:
		 * 		package day27_Class;
		 * 		public class DemoClass{
		 * 			public void run(){
		 * 				System.out.printf("欢迎你,你好!");
		 * 			}
		 * 		}
		 * (1)写一个Properties格式的配置文件,配置类的完整名称。
		 * (2)写一个程序,读取这个Properties配置文件,获得类的完整名称并加载这个类,用反射的方法运行run()方法
		 */
		BufferedReader reader = new BufferedReader(new FileReader("src/Mapper.properties"));
		String ClassName = reader.readLine();
		Class clazz = Class.forName(ClassName);
		Object obj = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("run");
		method.invoke(obj);
	}

	private static void test4() throws NoSuchFieldException, IllegalAccessException {
		//setProperty(Object obj,String propertyName,Object value);
		Person person = new Person("就啊哈",18);
		Tool tool = new Tool();
		tool.setProperty(person, "name","张三");
		tool.setProperty(person, "age",20);
		System.out.println(person);
	}

	private static void test3() throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		Class clazz = Class.forName("day27_Class.Person");
		/*Person per = (Person)clazz.newInstance();*/
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		Person per = (Person) constructor.newInstance("可可",16);
		Method m = clazz.getMethod("eat");
		m.invoke(per);
		System.out.println(per);
		Method me = clazz.getMethod("eat",int.class);
		me.invoke(per, 5);
	}

	private static void test2() throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		/**
		 * clazz.getDeclaredField("name");
		 * f.setAccessible(true);
		 */
		Class clazz = Class.forName("day27_Class.Person");
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		Person per = (Person) constructor.newInstance("张三",18);
		
		//Field field = clazz.getField("name");
		//field.set(per,"李四");
		
		Field f = clazz.getDeclaredField("name");							//获得私有属性的字段名称			
		f.setAccessible(true);												//打开私有属性
		f.set(per,"李四");
		System.out.println(per);
	}

	private static void test1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		/**
		 * 反射机制   Class.newInstance()
		 * 			Class.getConstructor()
		 */
		Class clazz = Class.forName("day27_Class.Person");
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		/*Person per = (Person) clazz.newInstance();
		per.setName("张三");
		per.setAge(18);*/
		Person per = (Person) constructor.newInstance("张三",18);
		System.out.println(per);
	}
}
