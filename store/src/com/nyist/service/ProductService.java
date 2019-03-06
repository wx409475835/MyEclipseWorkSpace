package com.nyist.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.domain.PageBean;
import com.nyist.domain.Product;

public interface ProductService {

	List<Product> findNew() throws Exception;

	List<Product> findHot() throws Exception;

	Product getProductById(String pid) throws Exception;

	PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

	PageBean<Product> findByPageCategory(int currPage, int i) throws Exception;

	void addProduct(Product product) throws Exception;

	void delete(String pid) throws Exception;
	String getcIdBypId(String pid) throws Exception;

	void update(Product product) throws Exception;
}
