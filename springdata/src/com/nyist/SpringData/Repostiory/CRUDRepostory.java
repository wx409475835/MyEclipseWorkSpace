package com.nyist.SpringData.Repostiory;

import org.springframework.data.repository.CrudRepository;

import com.nyist.SpringData.Entity.Person;

public interface CRUDRepostory extends CrudRepository<Person,Integer>{
	/**
	 * 所有接口:
	 * 
	* T save(T entity);//保存单个实体 
	* 
	Iterable<T> save(Iterable<? extends T> entities);//保存集合       
		* 
	T findOne(ID id);//根据id查找实体        
		* 
	boolean exists(ID id);//根据id判断实体是否存在        
		* 
	Iterable<T> findAll();//查询所有实体,不用或慎用!        
		* 
	long count();//查询实体数量        
		* 
	void delete(ID id);//根据Id删除实体        
		* 
	void delete(T entity);//删除一个实体 
		* 
	void delete(Iterable<? extends T> entities);//删除一个实体的集合        
		* 
	void deleteAll();//删除所有实体,不用或慎用! 


	 */
}
