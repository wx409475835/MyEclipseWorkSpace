package com.nyist.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.dao.ProductDao;
import com.nyist.dao.impl.ProductDaoImpl;
import com.nyist.domain.PageBean;
import com.nyist.domain.Product;
import com.nyist.service.ProductService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> findNew() throws Exception {
		//2.查询最新商品 热门商品
		// 3.最新商品 首先查看缓存中是否有最新商品
		// 创建创建缓存管理器
		CacheManager cacheManager = CacheManager.create(ProductServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		// 指定缓存名称
		Cache cache = cacheManager.getCache("newProducts");
		Element newelement = cache.get("newList");
		List<Product> newList = null;
		if (newelement == null) {
			// 缓存为空 查询数据库
			ProductDao dao = new ProductDaoImpl();
			newList = dao.findNew();
			// 放入缓存中
			cache.put(new Element("newList", newList));
		} else {
			newList = (List<Product>) newelement.getObjectValue();
		}
		return newList;
	}

	@Override
	public List<Product> findHot() throws Exception {
		//4.热门商品	 首先查看缓存中查看是否有热门商品
		CacheManager cacheManager = CacheManager.create(ProductServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		Cache cache = cacheManager.getCache("hotProducts");
		Element hotelement = cache.get("hotList");
		List<Product> hotList = null;
		if (hotelement == null) {
			// 缓存为空 查询数据库
			ProductDao dao = new ProductDaoImpl();
			hotList = dao.findHot();
			// 放入缓存中
			cache.put(new Element("hotList", hotList));
		} else {
			hotList = (List<Product>) hotelement.getObjectValue();
		}
		return hotList;
	}

	@Override
	public Product getProductById(String pid) throws Exception {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.getProductById(pid);
	}

	/**
	 * 按照类别分页查询商品
	 * @throws Exception 
	 * */
	@Override
	public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		PageBean<Product> pageBean = new PageBean<Product>();
		//当前页
		List<Product> list = dao.findByPage(currPage,pageBean,cid,pageSize);
		//总条数
		int totalCount = dao.getTotalCount(cid);
		pageBean.setList(list);
		pageBean.setCurrPage(currPage);
		pageBean.setTotalCount(totalCount);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(pageBean.getTotalPage());
		return pageBean;
	}
	
	
	//管理员 分页查询商品
	@Override
	public PageBean<Product> findByPageCategory(int currPage, int i) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		PageBean<Product> pageBean = new PageBean<Product>();
		//当前页
		List<Product> list = dao.findByPageCategory(currPage,i);
		int totalcount = dao.getTotalCount();
		pageBean.setCurrPage(currPage);
		pageBean.setList(list);
		pageBean.setPageSize(i);
		pageBean.setTotalCount(totalcount);
		pageBean.getTotalPage();
		return pageBean;
	}

	@Override
	public void addProduct(Product product) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		dao.addProduct(product);
	}

	@Override
	public void delete(String pid) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		dao.delete(pid);
	}

	@Override
	public String getcIdBypId(String pid) throws Exception {
		return new ProductDaoImpl().getcIdBypId(pid);
	}

	@Override
	public void update(Product product) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		dao.update(product);
	}
}
