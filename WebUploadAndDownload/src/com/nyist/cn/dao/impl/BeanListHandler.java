package com.nyist.cn.dao.impl;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.nyist.cn.dao.ResultSetHandler;

public class BeanListHandler implements ResultSetHandler{

	private Class clazz;
	public BeanListHandler(Class clazz){
		this.clazz = clazz;
	}
	
	@Override
	public Object handler(ResultSet rs) {
		/**
		 * 1.定义一个List 集合
		 */
		List lt = new ArrayList();
		//2.将数据封装到 List集合中的对象中去
		try {
			while(rs.next()){
				Object bean = clazz.newInstance();							//生成对象
				//3.获得数据的列数,然后通过数据的名称得到数据的值，在通过反射技术引射到对应的实体中
				ResultSetMetaData meta = rs.getMetaData();						//获得结果集的元数据
				int column = meta.getColumnCount();								//获得结果集的个数
				for(int i = 0;i < column;i++){
					String name = meta.getColumnName(i+1);						//获得对应的名称
					Object value = rs.getObject(name);							//通过名称获得对象的值
					
					//将 结果  反射 bean 中
					Field field = bean.getClass().getDeclaredField(name);
					field.setAccessible(true); 									//打开私有保护
					field.set(bean,value);
				}
				lt.add(bean);
			}
			return lt;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
