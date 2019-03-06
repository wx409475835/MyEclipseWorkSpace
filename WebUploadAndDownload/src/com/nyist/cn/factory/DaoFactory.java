package com.nyist.cn.factory;

import java.io.IOException;
import java.util.Properties;

import com.nyist.cn.dao.upfileDao;

public class DaoFactory {
	
	private static Properties daoconfig = new Properties();
	static{
		try {
			daoconfig.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static DaoFactory instance = new DaoFactory();
	public static DaoFactory getInstance(){
		return instance;
	}
	
	public <T> T createDao(Class<T> interfaceClass){
		String name = interfaceClass.getSimpleName();
		String daoClassname = daoconfig.getProperty(name);
		try {
			return (T) Class.forName(daoClassname).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	private upfileDao dao = DaoFactory.getInstance().createDao(upfileDao.class);
}
