package com.nyist.Jpa.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nyist.Jpa.Entity.Department;
import com.nyist.Jpa.Entity.Manager;

public class TestOneToOne {
	
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
	public void testOneToOne(){}
	
	//双向 1-1 的关系映射,建议先保存不维护关联关系的一方,即没有外键的一方,这样不会多出UPDATE 语句
	@Test
	public void testOneToOnePersistence(){
		Manager manager = new Manager();
		manager.setMgrName("M-CC");
		Department department = new Department();
		department.setDeptName("D-CC");
		//设置 关联关系
		manager.setDept(department);
		department.setMgr(manager);
		//持久化 到数据裤
		entityManager.persist(manager);
		entityManager.persist(department);
	}
	
	//默认情况下
	//1.若获取维护关联关系的一方,则会通过左外连接获取关联对象
	//可以通过 @OneToOne fetch 的策略 改为 懒加载  可以改变
	@Test
	public void testOneToOneFind(){
		Manager manager = entityManager.find(Manager.class,1);
		System.out.println(manager.getMgrName());
		System.out.println(manager.getDept().getClass().getName());
	}
	
	//1.若获取维护关联关系的一方,则会通过左外连接获取关联对象
	//可以通过 @OneToOne fetch 的策略 改为 懒加载  可以改变,但以然会在发送SQL 语句来初始化其关联对象
	//这说明 在不维护关系的一方,不建议修改fetch 属性
	@Test
	public void testOneToOneFind1(){
		Department department = entityManager.find(Department.class,2);
		System.out.println(department.getDeptName());
		System.out.println(department.getMgr().getClass().getName());
	}
}
