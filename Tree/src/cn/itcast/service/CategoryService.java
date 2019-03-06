package cn.itcast.service;

import java.util.List;
import java.util.UUID;

import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;

public class CategoryService {

	CategoryDao dao = new CategoryDao();
	public List getAllCategory(){
		
		return dao.getAll();
	}

	public Category findCategory(String id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	public void addCategory(String parent_id, String name) {
		
		Category parent = dao.find(parent_id); //获得其父节点
		
		//生成子节点
		Category child = new Category();
		child.setName(name);
		child.setId(UUID.randomUUID().toString());
		child.setLft(parent.getRgt());
		child.setRgt(child.getLft()+1);
		dao.add(child);
		dao.insertUpdate(parent.getRgt());
		
	}
	
}
