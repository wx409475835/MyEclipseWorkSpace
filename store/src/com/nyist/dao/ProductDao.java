package com.nyist.dao;
import java.util.List;

import com.nyist.domain.PageBean;
import com.nyist.domain.Product;

public interface ProductDao {

	List<Product> findNew() throws Exception;
	//

	List<Product> findHot() throws Exception;

	Product getProductById(String pid) throws Exception;

	int getTotalCount(String cid) throws Exception;

	List<Product> findByPage(int currPage, PageBean<Product> pageBean, String cid, int pageSize) throws Exception;

	List<Product> findByPageCategory(int currPage, int i) throws Exception;

	int getTotalCount() throws Exception;

	void addProduct(Product product) throws Exception;

	void delete(String pid) throws Exception;

	String getcIdBypId(String pid) throws Exception;

	void update(Product product) throws Exception;
}
