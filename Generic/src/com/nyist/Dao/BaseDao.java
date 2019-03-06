package com.nyist.Dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

//限定
public class BaseDao<T extends Serializable>{
	
	//private Session session;
	private Class clazz;
	public BaseDao(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getAnnotatedSuperclass();			//BaseDao
		clazz = (Class) pt.getActualTypeArguments()[0];
	}
	public void find(T t){
		
	}
	
	public void update(T t){
		
	}
	
	public void delete(T t){
		
	}
}
