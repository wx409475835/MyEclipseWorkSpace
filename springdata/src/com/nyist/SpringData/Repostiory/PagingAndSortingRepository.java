package com.nyist.SpringData.Repostiory;

import com.nyist.SpringData.Entity.Person;
public interface PagingAndSortingRepository extends org.springframework.data.repository.PagingAndSortingRepository<Person,Integer>{
	/***
	 *  Iterable<T> findAll(Sort sort); //排序 
		Page<T> findAll(Pageable pageable); //分页查询（含排序功能） 
	 */
}
