package com.nyist.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
public class BeanFactory {
	public static Object getBean(String id) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		//通过ID获得实现类
		//1.获取document 对象
		Document document = new SAXReader().read(BeanFactory.class.getClassLoader().getResourceAsStream("Beans.xml"));
		System.out.println("document:"+document.toString());
		//2.获取指定的bean 对象
		// 写入singleNode 表达式  //bean[@id=]
		Element e = (Element) document.selectSingleNode("//bean[@id='"+id+"']");
		System.out.println("e:"+e);
		//3.获取bean 对象的属性
		String value = e.attributeValue("class");
		System.out.println("value:"+value);
		//4.反射
		return Class.forName(value).newInstance();
	}
	
	@Test
	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException{
		System.out.println(getBean("ProductDao"));
	}
}
