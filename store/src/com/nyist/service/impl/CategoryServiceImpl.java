package com.nyist.service.impl;

import java.io.InputStream;
import java.util.List;
import com.nyist.dao.CategoryDao;
import com.nyist.dao.impl.CategoryDaoImpl;
import com.nyist.domain.Category;
import com.nyist.service.CategoryService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CategoryServiceImpl implements CategoryService {

	//查询所有分类
	@Override
	public List<Category> findAll() throws Exception {
		//1.创建缓存管理器
		CacheManager chm = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//2.获取指定的 缓存
		Cache cache = chm.getCache("categoryCache");
		//3.通过缓存获取数据   将cache看成一个map集合
		Element e = cache.get("clist");
		List<Category> clist = null;
		//4.判断数据
		if(e==null){
			//从数据库中获取
			CategoryDao dao = new CategoryDaoImpl();
			clist = dao.findAll();
			//将list放入缓存
			cache.put(new Element("clist",clist));
		}else{
			//直接返回
			clist=(List<Category>)e.getObjectValue();	
		}
		
		return clist;
	}
	
	public static void main(){
		//加载配置文件   读取配置文件
		InputStream in = CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml");
	}

	@Override
	public void add(Category category) throws Exception {
		CategoryDao categoryDao = new CategoryDaoImpl();
		categoryDao.add(category);
	}

	@Override
	public Category getById(String cid) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		return dao.getById(cid);
	}

	@Override
	public void update(Category category) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		dao.update(category);
	}

	@Override
	public void delete(String cid) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		dao.delete(cid);
	}

	@Override
	public List<Category> findAllCategory() throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		return dao.findAllCategorya();
	}
}
