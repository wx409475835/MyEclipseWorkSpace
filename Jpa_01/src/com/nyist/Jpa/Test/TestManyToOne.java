package com.nyist.Jpa.Test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nyist.Jpa.Entity.Customer;
import com.nyist.Jpa.Entity.Order;

public class TestManyToOne {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	@Before
	public void init(){
		String persistenceUnitName = "Jpa_01";
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}
	
	@After
	public void destory(){
		//提交事务
		entityTransaction.commit();
		//关闭entityManager
		entityManager.close();
		//关闭entityManagerFactory
		entityManagerFactory.close();
	}
	
	
	@Test
	public void testDelete(){
		Customer customer = entityManager.find(Customer.class,7);
		entityManager.remove(customer);
	}
	
	@Test
	public void testManyToOne(){
		Customer cs = new Customer();
		cs.setAge(22);
		cs.setBirth(new Date());
		cs.setCreateTime(new Date());
		cs.setEmail("SS@qq.com");
		cs.setLastName("SS");
		
		Order order = new Order();
		order.setOrderName("A-SS-1");
		
		Order order2 = new Order();
		order2.setOrderName("A-SS-2");
		//设置关联关系 
		order.setCustomer(cs);
		order2.setCustomer(cs);
		order.setCustomer(cs);
		order2.setCustomer(cs);
		//持久化到数据表中
		entityManager.persist(cs);
		entityManager.persist(order);
		entityManager.persist(order2);
	}
}
