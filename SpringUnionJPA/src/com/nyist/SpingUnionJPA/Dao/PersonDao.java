package com.nyist.SpingUnionJPA.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.nyist.SpingUnionJPA.Entity.Person;
//@Repository  将PersonDao 交给Spring容器管理  注入到容器中去
@Repository
public class PersonDao {
	
	/**
	 * 如何获取和当前事务关联的EntityManager 对象呢？
	 * 通过 @PersistenceContext
	 */
	//注入 EntityManagerFactory
	@PersistenceContext
	private  EntityManager entityManager;
	
	public void save(Person person){
		entityManager.persist(person);
	}
}
