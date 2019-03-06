package com.nyist.Jpa.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nyist.Jpa.Entity.Customer;

public class JPATest {
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
	public void testFind(){
		//find(需要查询的实体类,主键值)
		// find 查询的 数据 不存在 放回 null
		Customer customer = entityManager.find(Customer.class,1);
		System.out.println(customer);
	}
	
	@Test
	public void test1(){
		List<Customer> list = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setAge(11);
		customer.setBirth(new Date());
		Object object = new Object();
	}
	
	@Test
	public void testGetReference(){
		Customer cs = entityManager.getReference(Customer.class,1);
		System.out.println("这是一个代理对象:"+cs.getClass().getName());
		System.out.println("******************************************");
		System.out.println(cs);
	}
	
	//类似于 hibernate 的 save 方法
	//和 hibernate 的 save 方法的不同之处:若对象有id,则不能 执行insert 操作,而会在抛出异常。
	@Test
	public void Persistence(){
		Customer cs = new Customer();
		cs.setAge(18);
		cs.setBirth(new Date());
		cs.setCreateTime(new Date());
		cs.setEmail("40947535@qq.com");
		cs.setLastName("AA");
		//使的 对象的 临时状态  转变成 持久化 状态
		entityManager.persist(cs);
	}
	
	//类似于hibernate 的 delete 方法,把对象对应的记录从数据裤中移除
	//但注意:该方法只能移除持久化对象,而hibernate 的 delete 方法实际上可以移除游离对象
	@Test
	public void testRemove(){
		//尝试 移除 游离对象    结果:失败
		//所谓 游离对象 即是 自己new 出来的对象  不是从数据裤中获取的对象
//		Customer cs = new Customer();
//		cs.setId(2);
		
		//非游离状态  移除成功
		Customer cs = entityManager.find(Customer.class, 1);
		entityManager.remove(cs);
	}
	/***
	 * 总的来说:类似于hibernate Session 的 saveOrUpdate 方法。
	 * 1.若传入的都是一个临时对象
	 * 2.会创建一个新的对象,把临时对象的属性 复制到 新得对象中,然后对新得对象执行持久化操作。
	 * 3.新得对象中有ID,但以前的临时对象中没有Id.
	 *
	 *Hibernate: 
	    insert 
	    into
	        JPA_CUSTOMER
	        (jpa_age, jpa_birth, jap_createTime, jpa_email, jpa_last_name) 
	    values
	        (?, ?, ?, ?, ?)
		Customer [id=null, lastName=lvhaoguang0, email=409475835@qq.com, age=22]
		Customer [id=3, lastName=lvhaoguang0, email=409475835@qq.com, age=22]
	 */
	@Test
	public void testMerge(){
		// entity 的  临时 状态
		Customer cs = new Customer();
		cs.setAge(22);
		cs.setBirth(new Date());
		cs.setCreateTime(new Date());
		cs.setEmail("409475835@qq.com");
		cs.setLastName("lvhaoguang0");
		//em 缓存中 和 数据库中 不存在 该对象  持久化到数据库中
		Customer customer = entityManager.merge(cs);
		System.out.println(cs);
		System.out.println(customer);	
	}
	
	/**
	 * 游离状态:有Id
	 * 1.若传入的对象为游离对象,即传入的对象有OID
	 * 2.若在数据裤中也没有相应的记录
	 * 3.JPA 会创建一个新得对象,然后把当前对象的属性复制到新创建的对象中
	 * 4.对新对象执行 insert 操作
	 */
	@Test
	public void testMerge1(){
		//游离状态 有主键ID 
		//首先 判断 em缓存中是否存在 该对象 若不存在,判断数据裤中是否存在,若不存在,执行一条insert 操作
		Customer cs = new Customer();
		cs.setAge(22);
		cs.setBirth(new Date());
		cs.setCreateTime(new Date());
		cs.setEmail("qq@qq.com");
		cs.setLastName("LHG");
		cs.setId(101);
		Customer customer = entityManager.merge(cs);
		System.out.println(cs);
		System.out.println(customer);	
	}
	
	/**
	 * 游离状态:有Id
	 * 1.若传入的对象为游离对象,缓存中没有该对象
	 * 2.若在数据裤中0有相应的记录
	 * 3.JPA 会查询对应的记录,然后返回该记录的一个对象,再然后会把游离对象的属性复制到查询到的对象中
	 * 4.对查询到对象执行 update 操作
	 */
	@Test
	public void testMerge2(){
		//首先判断一下,em缓存中是否存在该对象,如果缓存中有该对象,将 cs 对象的属性赋值 给 查询的对象 customer 执行一条 update 语句
		Customer cs = new Customer();
		cs.setAge(21);
		cs.setBirth(new Date());
		cs.setCreateTime(new Date());
		cs.setEmail("132@qq.com");
		cs.setLastName("LHG");
		cs.setId(2);
		Customer customer = entityManager.merge(cs);
		System.out.println(cs);
		System.out.println(customer);
		System.out.println(cs==customer);		//false
	}
	
	/**
	 * 游离状态:有Id
	 * 1.若在EntityManger, 缓存中有对应的对象
	 * 2.若在数据裤中0有相应的记录
	 * 3.JPA 会把游离对象的属性复制到查询到EntityManager 缓存中的对象
	 * 4.EntityManger 缓存中的对象执行 UPDATE 操作
	 */
	@Test
	public void testMerge3(){
		Customer cs = new Customer();
		cs.setAge(21);
		cs.setBirth(new Date());
		cs.setCreateTime(new Date());
		cs.setEmail("132@qq.com");
		cs.setLastName("EE");
		cs.setId(4);
		Customer customer = entityManager.find(Customer.class, 4);
		entityManager.merge(cs);
		System.out.println(cs);
		System.out.println(customer);
		System.out.println(cs==customer);		//false
	}
	
	/**
	 * 同 hibernate 中 session 的 flush 
	 */
	@Test
	public void testflush(){
		Customer customer = entityManager.find(Customer.class,2);
//		System.out.println(customer);
		customer.setLastName("BB");
		entityManager.flush();
	}
	
	//同 Hibnernate 中的 reSession 一样
	@Test
	public void reflush(){
		Customer cs = entityManager.find(Customer.class, 1);
		cs = entityManager.find(Customer.class,1);
		entityManager.refresh(cs);
		
	}
}
