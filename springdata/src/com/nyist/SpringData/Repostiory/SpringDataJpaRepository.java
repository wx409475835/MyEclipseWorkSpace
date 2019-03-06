package com.nyist.SpringData.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyist.SpringData.Entity.Person;

public interface SpringDataJpaRepository extends JpaRepository<Person,Integer>{
	
}
