package com.nyist.dao;

import java.util.List;

import com.nyist.domain.Category;

public interface CategoryDao {

	List<Category> findAll() throws Exception;

	void add(Category category) throws Exception;

	Category getById(String cid) throws Exception;

	void update(Category category) throws Exception;

	void delete(String cid) throws Exception;

	List<Category> findAllCategorya() throws Exception;
	
}
