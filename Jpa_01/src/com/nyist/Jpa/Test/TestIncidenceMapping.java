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

//测试 关联映射
public class TestIncidenceMapping {
	
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
	
	/**
	 * 保存多对一时候,建议先保存1的一端,后保存n的端,这样不会额外多处update 语句
	 */
	//若是双向 一对多的关联关系  若先保存 n 的一端,再保存1的一端口。默认情况下,会多出4条Update语句
	//若先保存1的一段,则会多出2条update 语句
	//在进行双向 1-n关联映射的时,建议使用 n 的一方的来维护关联关系,而1的一方不维护关联关系。这样会有效的减少SQL语句
	
	@Test
	public void ManyToOne(){
		Customer cs = new Customer();
		cs.setAge(22);
		cs.setBirth(new Date());
		cs.setCreateTime(new Date());
		cs.setEmail("PP@qq.com");
		cs.setLastName("PQQP");
		
		Order order = new Order();
		order.setOrderName("OP-MM-1");
		
		Order order2 = new Order();
		order2.setOrderName("PO-MM2");
		//设置关联关系 
//		order.setCustomer(cs);
//		order2.setCustomer(cs);
		//持久化到数据表中
		entityManager.persist(cs);
		entityManager.persist(order);
		entityManager.persist(order2);
	}
	
	//默认情况下,使用左外连接的方式获取n的一端,和其关联的1 的一端的对象
	//@ManyToOne 使用fetch 方法来改变默认关联属性的加载策略
	/**fetch: 表示该属性的读取策略,有 EAGER 和 LAZY 两种,分别表示主支抓取和延迟加载,默认为 EAGER.
	 *  FetchType.LAZY：懒加载，加载一个实体时，定义懒加载的属性不会马上从数据库中加载。
　　		FetchType.EAGER：急加载，加载一个实体时，定义急加载的属性会立即从数据库中加载。
	 */
	@Test
	public void testManyToOneFind(){
//		Order order = entityManager.find(Order.class,1);
//		System.out.println(order.getOrderName());
		//不能直接删除 1 的一端,因为有外键约束
		Customer customer = entityManager.find(Customer.class,7);
		entityManager.remove(customer);
//		System.out.println(customer.getCustomer().getLastName());
	}
	
	@Test
	public void testManyToOneRemove(){
		Order order = entityManager.find(Order.class,1);
		entityManager.remove(order);
	}
	
//	@Test
//	public void testManyToOneUpdate(){
//		Order order = entityManager.find(Order.class,2);
//		order.getCustomer().setLastName("AAA");
//	}
	/*****************************************************一对多***********************************************/
	@Test
	public void testOneToMany(){
	}
	
	//单向 1-n  关联 关系执行保存的时候,一定会多出Update 语句。
	//因为 n 的 一端口,在插入的时候不会同时插入外键列
	@Test
	public void testOneToManyPersist(){
		Customer cs = new Customer();
		cs.setAge(18);
		cs.setBirth(new Date());
		cs.setCreateTime(new Date());
		cs.setEmail("XX@qq.com");
		cs.setLastName("XX");
		//处理关联映射
		Order order = new Order();
		order.setOrderName("DD-WW-ZZ");
		Order order2 = new Order();
		order2.setOrderName("XX-WW-DD"); 
		//建立关联关系
		cs.getOrders().add(order);
		cs.getOrders().add(order2);
		//持久化  到数据裤中
		entityManager.persist(cs);
		entityManager.persist(order);
		entityManager.persist(order2);
	}
	
	@Test
	public void testOnToManyFind(){
		Customer Customer = entityManager.find(Customer.class,8);
		System.out.println(Customer.getLastName());
		System.out.println(Customer.getOrders().size());
	}
	
	//删除
	//默认情况下,若删除 1 的一端,则会把关联的多的一端的外键置空,然后进行删除。
	@Test
	public void OneToManyRemove(){
		//删除  Customer
		Customer customer = entityManager.find(Customer.class,6);
		entityManager.remove(customer);
	} 
	
	//修改
	@Test
	public void testOneToManyUpdate(){
		Customer customer = entityManager.find(Customer.class,7);
		customer.getOrders().iterator().next().setOrderName("O-XXX-10");
	}
}
