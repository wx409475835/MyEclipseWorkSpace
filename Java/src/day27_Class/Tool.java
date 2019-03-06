package day27_Class;

import java.lang.reflect.Field;

public class Tool {
	
	public void setProperty(Object obj,String propertyName,Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Class clazz = obj.getClass();								//通过反射拿到字节码文件
		Field m  = clazz.getDeclaredField(propertyName);			//通过反射获得字段
		m.setAccessible(true);										//去除权限
		m.set(obj, value);
	}
}
