package com.nyist.SpringData.Repostiory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nyist.SpringData.Entity.Person;

public class PersonRepositoryImpl implements PersonDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void test() {
		Person person = entityManager.find(Person.class,11);
		System.out.println("-->"+person);
	}
}
