package com.nyist.Jpa.main;

import java.util.Date;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.collections.map.HashedMap;

import com.nyist.Jpa.Entity.Customer;

public class Main {
	
	public static void main(String[] args){
		//1. 创建EntityManagerFactory
		String persistenceUnitName  = "Jpa_01";				//持久化单元得名称
		Map<String,Object> properties = new HashedMap();
		properties.put("hibernate.format_sql",true);
		EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory(persistenceUnitName,properties);
		//2.创建EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//3.开启事务
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		//4.进行持久化操作
		Customer customer = new Customer();
		customer.setAge(10);
		customer.setEmail("1245@qq.com");
		customer.setLastName("Lvhaoguang");
		customer.setCreateTime(new Date());
		customer.setBirth(new Date());
		//持久化到数据库
		entityManager.persist(customer);
		//5.提交事务
		entityTransaction.commit();
		//6.关闭EntityManager
		entityManager.close();
		//7.关闭EntityManagerFactory
		entityManagerFactory.close();
	}
}
