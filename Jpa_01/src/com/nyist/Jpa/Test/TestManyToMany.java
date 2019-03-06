package com.nyist.Jpa.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nyist.Jpa.Entity.Category;
import com.nyist.Jpa.Entity.Item;

public class TestManyToMany {

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
	public void testManyToMany(){
		
	}
	
	@Test
	public void testManyToManyPersistence(){
		Item item = new Item();
		item.setItemName("I-AA");
		Item item2 = new Item();
		item2.setItemName("I—BB");
		
		Category category = new Category();
		category.setCategoryName("C-AA");
		Category category2 = new Category();
		category2.setCategoryName("C-BB");
		
		//设置关联关系映射
		item.getCategories().add(category);
		item.getCategories().add(category2);
		
		item2.getCategories().add(category);
		item2.getCategories().add(category2);
		
		category.getSet().add(item);
		category.getSet().add(item2);
		
		category2.getSet().add(item);
		category2.getSet().add(item2);
		
		//持久化 到数据裤中
		entityManager.persist(item);
		entityManager.persist(item2);
		entityManager.persist(category);
		entityManager.persist(category2);
	}
	
	//对于关联的集合对象 默认使用懒加载策略
	//使用维护关联关系的一方获取,还是使用不维护关系一方获取,SQL 语句相同。
	@Test
	public void testManyToManyFind(){
//		Item item = entityManager.find(Item.class,1);
//		System.out.println(item.getItemName());
//		System.out.println(item.getCategories().size());
		Category category = entityManager.find(Category.class,1);
		System.out.println(category.getCategoryName());
		System.out.println(category.getSet().size());
	}
}
