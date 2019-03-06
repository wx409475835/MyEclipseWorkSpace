package com.nyist.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nyist.dao.ProductDao;
import com.nyist.domain.PageBean;
import com.nyist.domain.Product;
import com.nyist.utils.DataSourceUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findNew() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by pdate limit 13";
		return queryRunner.query(sql, new BeanListHandler<>(Product.class));
	}

	@Override
	public List<Product> findHot() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot = 1 order by pdate limit 13";
		return queryRunner.query(sql, new BeanListHandler<>(Product.class));
	}

	@Override
	public Product getProductById(String pid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid= ? limit 1";
		return queryRunner.query(sql,new BeanHandler<>(Product.class),pid);
	}
	
	@Override
	public String getcIdBypId(String pid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select cid from product where pid= ? limit 1";
		return (String) queryRunner.query(sql,new ScalarHandler(),pid);
	}

	@Override
	public int getTotalCount(String cid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid = ? limit 12";
		return ((Long)queryRunner.query(sql,new ScalarHandler(),cid)).intValue();
	}

	@Override
	public List<Product> findByPage(int currPage, PageBean<Product> pageBean, String cid,int pagesize) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid = ? limit ?,?";
		return queryRunner.query(sql,new BeanListHandler<>(Product.class),cid,(currPage-1)*pagesize,pagesize);
	}

	@Override
	public List<Product> findByPageCategory(int currPage, int i) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product limit ?,?";
		return queryRunner.query(sql,new BeanListHandler<>(Product.class),(currPage-1)*i,i);
	}

	@Override
	public int getTotalCount() throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		return ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
	}

	
	//管理员 添加商品
	@Override
	public void addProduct(Product product) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product(pid,pname,market_price,shop_price,pimage,pdate,is_hot,pdesc,pflag,cid) values(?,?,?,?,?,?,?,?,?,?)";
		queryRunner.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid());
	}

	@Override
	public void delete(String pid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid = ?";
		queryRunner.update(sql,pid);
	}

	@Override
	public void update(Product product) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid = ?";
		queryRunner.update(sql,product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid(),product.getPid());
	}	
}
