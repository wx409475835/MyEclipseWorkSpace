package cn.itcast.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Category;
import cn.itcast.utils.JdbcUtils;

public class CategoryDao {

	public List<Category> getAll(){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select child.id,child.name,count(child.name) depth from category parent,category child  where parent.lft<=child.lft and parent.rgt>=child.rgt group by child.name order by child.lft";
			
			List list = (List) runner.query(sql, new BeanListHandler(Category.class));
		return list;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Category find(String id) {
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from category where id=?";
			Category c = (Category) runner.query(sql, id, new BeanHandler(Category.class));
		
			sql = "select * from category where lft<? and rgt>? order by lft";
			Object params[] = {c.getLft(),c.getRgt()};
			List list = (List) runner.query(sql, params, new BeanListHandler(Category.class));
			c.setParents(list);
			return c;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void insertUpdate(int rgt) {  //7
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql1 = "update category set lft=lft+2 where lft>=?";
			String sql2 = "update category set rgt=rgt+2 where rgt>=?";
			
			runner.update(sql1, rgt);
			runner.update(sql2, rgt);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void add(Category child) {
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into category(id,name,lft,rgt) values(?,?,?,?)";
			Object params[] = {child.getId(),child.getName(),child.getLft(),child.getRgt()};
			runner.update(sql, params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
}
