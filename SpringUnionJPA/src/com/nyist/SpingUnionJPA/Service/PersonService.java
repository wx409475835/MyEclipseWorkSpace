package com.nyist.SpingUnionJPA.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nyist.SpingUnionJPA.Dao.PersonDao;
import com.nyist.SpingUnionJPA.Entity.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Transactional
	public void savePerson(Person person1,Person person2){
		personDao.save(person1);
		personDao.save(person2);
	}
}
