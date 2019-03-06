package com.nyist.Jpa.Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.QueryHint;

import org.hibernate.ejb.QueryHints;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nyist.Jpa.Entity.Customer;

public class TestJPQL {
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
	public void testJPQL(){
		String jpql = "from Customer c where c.age > ?";
		Query query = entityManager.createQuery(jpql);
		//占位符的索引 是从1 开始的
		query.setParameter(1,1);
		List<Customer> customers = query.getResultList();
		System.out.println(customers);
	}
	
	//在默认情况下,若只查询部分属性,则将返回Object[]类型的结果,或者Object[] 类型的List
	//也可以在实体类中创建对应的构造器,然后再JPQL语句中利用对应的构造器返回实体类的对象
	@Test
	public void testPartlyProperties(){
		String jpql = "SELECT c.lastName,c.age FROM Customer c WHERE c.age> ?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, 1);
		List<Customer> customers = query.getResultList();
		System.out.println(customers.toString());
	}
	
	//createNameQuery 适用于在实体类 前使用@NamedQuery 标记的查询语句
	@Test
	public void testNameQuery(){
		Object customer =entityManager.createNamedQuery("testNameQuery").setParameter(1, 1).getResultList();
		System.out.println(customer);
	}
	
	//createNativeQuery 是查询的本地数据库  指定的本地查询
	@Test
	public void testNaviceQuery(){
		String jpql = "select * from jpa_customer where jpa_id = ?1";
		Query query = entityManager.createNativeQuery(jpql);
		query.setParameter(1,1);
		Object customer = query.getSingleResult();
		System.out.println(customer);
	}
	
	//查询缓存  使用hibnernate 查询缓存
	//前提是 我们在配置文件里边  配置 启用了 查询缓存
	@Test
	public void testQueryCache(){
		String jpql = "From Customer c where c.age >?1";
		//开启缓存
		Query query = entityManager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE,true);
		
		query.setParameter(1,1);
		List<Customer> customers = query.getResultList();
		System.out.println(customers.size());
		
		query = entityManager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE,true);
		query.setParameter(1,1);
		List<Customer> cs = query.getResultList();
		System.out.println(cs.size());
		
	}
	
	/********************************************子查询***********************************************/
	@Test
	public void testSubQuery(){
		String jpql = "select o from Order o where o.customer = (select c from Customer c where c.lastName = ?1)";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1,"SS");
		Object object = query.getResultList();
		System.out.println(object);
	}
	
	/**********************************************JPQL*************************************************/
	//使用JPQL　内建函数　　　upper() 将小写变为大写　　
	@Test
	public void testJPQLFuncation(){
		String sql = "select upper(c.email) from Customer c";
		List<String> emails = entityManager.createQuery(sql).getResultList();
		System.out.println(emails);
	}
	
	@Test
	public void testExecuteUpdate(){
		String sql = "update jpa_customer c set c.jpa_last_name = ?1 where c.jpa_id = ?2";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1,"LQPJ");
		query.setParameter(2,1);
		query.executeUpdate();
	}
	
	@Test
	public void testExecuteDelete(){
		String sql = "delete from jpa_customer where jpa_id = ?1";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1,3);
		
	}
}
