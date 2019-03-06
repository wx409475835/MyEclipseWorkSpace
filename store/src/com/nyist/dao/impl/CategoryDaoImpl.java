package com.nyist.dao.impl;

import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nyist.dao.CategoryDao;
import com.nyist.domain.Category;
import com.nyist.utils.DataSourceUtils;

public class CategoryDaoImpl implements CategoryDao {
	
	//查询所有的分类
	
	public List<Category> findAll() throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return queryRunner.query(sql,new BeanListHandler<>(Category.class));
	}

	@Override
	public void add(Category category) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into category values(?,?)";
		queryRunner.update(sql, category.getCid(),category.getCname());
	}

	@Override
	public Category getById(String cid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category where cid=?";
		return queryRunner.query(sql, new BeanHandler<>(Category.class),cid);
	}

	@Override
	public void update(Category category) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update category set cname=? where cid=?";
		queryRunner.update(sql, category.getCname(),category.getCid());
	}

	@Override
	public void delete(String cid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource()); 
		String sql = "delete from category where cid = ?";
		queryRunner.update(sql,cid);
	}

	@Override
	public List<Category> findAllCategorya() throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return queryRunner.query(sql,new BeanListHandler<>(Category.class));
	}
}
