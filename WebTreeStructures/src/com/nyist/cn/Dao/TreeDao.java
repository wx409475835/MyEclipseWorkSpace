package com.nyist.cn.Dao;

import java.util.List;

import javax.mail.Address;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nyist.cn.Utils.JDBCUtil;
import com.nyist.cn.model.Tree;

public class TreeDao {

	public List<Tree> getAll(){
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
			String sql="select child.id,child.name,child.lft,child.rgt,count(child.name) depth from category parent,category child where child.lft>=parent.lft and child.rgt<=parent.rgt group by(child.name) order by child.lft;";
			List<Tree> list = (List<Tree>)runner.query(sql, new BeanListHandler(Tree.class));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public void addTree(Tree tree){
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
			String sql = "insert into category(id,name,lft,rgt) values(?,?,?,?);";
			Object params[] = {tree.getId(),tree.getName(),tree.getLft(),tree.getRgt()};
			runner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Tree find(String id){
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
			String sql = "select * from category where id = ?";
			Tree t = (Tree) runner.query(sql, id,new BeanHandler(Tree.class));
			System.out.println("t:"+t.getId()+":"+t.getName());
			sql = "select * from category where lft <= ? and rgt >= ? order by lft;";
			Object params[]={t.getLft(),t.getRgt()};
			List<Tree> trees = (List<Tree>) runner.query(sql,params,new BeanListHandler(Tree.class));
			System.out.println("trees:"+trees.toString());
			t.setParent(trees);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	public void update(int rgt){
		try {
			QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
			String sql1 = "update category set lft=lft+2 where lft > ?";
			String sql2 = "update category set rgt=rgt+2 where rgt >= ?";
			String sql3 = "update category set rgt=rgt-2 where lft = ?";
			runner.update(sql1,rgt);
			runner.update(sql2,rgt);
			runner.update(sql3,rgt);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
