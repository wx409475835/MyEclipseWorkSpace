package com.nyist.cn.Service;

import java.util.List;
import java.util.UUID;

import com.nyist.cn.Dao.TreeDao;
import com.nyist.cn.model.Tree;

public class TreeService {
	
	public List getAllTree(){
		TreeDao dao = new TreeDao();
		List<Tree> tree = dao.getAll();
		return tree;
	}
	
	public void addTree(String id,String name){
		TreeDao dao = new TreeDao();
		Tree tree = dao.find(id);			//获得父节点
		System.out.println("父节点右值:"+tree.getRgt());
		//生成一个节点
		Tree t = new Tree();
		t.setId(UUID.randomUUID().toString());
		t.setName(name);
		t.setLft(tree.getRgt());
		t.setRgt(tree.getRgt()+1);
		dao.addTree(t);
		dao.update(tree.getRgt());
	}
	
	public Tree findTrees(String id){
		TreeDao dao = new TreeDao();
		return dao.find(id);
	}
	
	public void updateTree(int rgt){
		TreeDao dao = new TreeDao();
		dao.update(rgt);
	}
}
