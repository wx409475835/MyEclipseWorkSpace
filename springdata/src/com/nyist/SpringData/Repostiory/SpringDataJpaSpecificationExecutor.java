package com.nyist.SpringData.Repostiory;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nyist.SpringData.Entity.Person;

public interface SpringDataJpaSpecificationExecutor extends PagingAndSortingRepository,JpaSpecificationExecutor<Person>{
	
}
