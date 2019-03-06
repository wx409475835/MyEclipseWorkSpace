package com.nyist.SpringData.Repostiory;

import org.springframework.data.repository.Repository;

import com.nyist.SpringData.Entity.Person;

public interface PersonDaoRepository extends Repository<Person,Integer>,PersonDao{	
}
