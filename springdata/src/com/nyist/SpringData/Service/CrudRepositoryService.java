package com.nyist.SpringData.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nyist.SpringData.Entity.Person;
import com.nyist.SpringData.Repostiory.CRUDRepostory;

@Service
public class CrudRepositoryService {
	
	@Autowired
	private CRUDRepostory crudRepository;
	
	@Transactional
	public void savePerson(List<Person> persons){
		crudRepository.save(persons);
	}
	
	//开启事务
	@Transactional
	public Person getById(Integer id){
		return crudRepository.findOne(id);
	}
	
	@Transactional
	public boolean isExistsId(Integer id){
		return crudRepository.exists(id);
	}
	
	@Transactional
	public List<Person> selectAll(){
		return (List<Person>) crudRepository.findAll();
	}
	
	@Transactional
	public int deleteById(Integer id){
		crudRepository.delete(id);
		return 0;
	}
}
