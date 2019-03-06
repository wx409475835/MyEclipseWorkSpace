package com.nyist.cn.dao.impl;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.nyist.cn.dao.ResultSetHandler;

public class BeanHandler implements ResultSetHandler{

	private Class clazz;				//定义一个Class  用来将数据封装到指定对象中
	public BeanHandler(Class clazz){
		this.clazz = clazz;
	}
	
	@Override
	public Object handler(ResultSet rs) {
		/**
		 * 1.首先判断 结果集 rs 是否为空 如果为空则返回Null
		 */
		try {
			if(!rs.next()){
				return null;
			}
			//如果不为空  则将数据封装到clazz类中
			//2.生成该类的对象
			Object bean = clazz.newInstance();
			//3.拿到结果集数据
			ResultSetMetaData rm = rs.getMetaData();					//拿到结果集的元数据
			int column = rm.getColumnCount();
			for(int i=0;i<column;i++){
				//拿到列名  通过列名获得数值
				String name = rm.getColumnName(i+1);					//拿到列明  name
				Object value = rs.getObject(name);						//id
				
				//有了 列名 和  列名的值   相当于  id  1  有了  组合成id=1  使用反射技术可以实现
				Field fd = bean.getClass().getDeclaredField(name);		//反射的变量通常是private 所以使用getDeclaredField()
				fd.setAccessible(true);
				fd.set(bean, value);									//id = 1
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}	

}
