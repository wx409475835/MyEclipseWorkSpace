package com.nyist.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;
import javax.security.auth.kerberos.KerberosKey;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.nyist.dao.OrderDao;
import com.nyist.domain.Order;
import com.nyist.domain.OrderItem;
import com.nyist.domain.PageBean;
import com.nyist.domain.Product;
import com.nyist.domain.User;
import com.nyist.utils.DataSourceUtils;
public class OrderDaoImpl implements OrderDao {

	@Override
	public void add(Order order) throws Exception {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		queryRunner.update(DataSourceUtils.getConnection(),sql,order.getOid(),new SimpleDateFormat("yyyy-MM-dd").format(order.getOrdertime()),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid());
	}

	@Override
	public void addItem(OrderItem item) throws Exception {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orderitem values(?,?,?,?,?)";
		queryRunner.update(DataSourceUtils.getConnection(),sql,item.getItemid(),item.getCount(),item.getSubtotal(),item.getProduct().getPid(),item.getOrder().getOid());
	}

	//查询我的订单
	@Override
	public List<Order> findAllPage(int currPage, int pageSize, User user) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders where uid=? limit ?,?";
		List<Order> list = queryRunner.query(sql,new BeanListHandler<>(Order.class),user.getUid(),(currPage-1)*pageSize,pageSize);
		//遍历订单集合
		sql = "select * from orderitem oi,product pd where oi.pid=pd.pid and oi.oid=?";
		for (Order order : list) {
			
			//当前订单包含的所有内容
			List<Map<String,Object>> map = queryRunner.query(sql,new MapListHandler(),order.getOid());
			for (Map<String, Object> m2: map) {
				for (String key : m2.keySet()) {
					System.out.println(key+":"+m2.get(key));
				}
			}
			for (Map<String, Object> m : map) {
				
				Product product = new Product();
				BeanUtils.populate(product,m);
				OrderItem oi = new OrderItem();
				oi.setProduct(product);
				//将map 的键值封装到 bean中
				BeanUtils.populate(oi,m);
				//向orderItems 集合中添加数据
				
				//将orderitem对象中添加到对应的order list中
				order.getItems().add(oi);
			}
			
		}
		return list;
	}
	//获取我的订单总条数
	@Override
	public int getTotalCount(String uid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from orders where uid=?";
		return ((Long) queryRunner.query(sql,new ScalarHandler(),uid)).intValue();
	}

	
	//通过oid 查询订单详情
	@Override
	public Order getById(String oid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders where oid = ?";
		Order order = queryRunner.query(sql, new BeanHandler<>(Order.class),oid);
		//封装OrderItems
		sql = "select * from orderitem oi,product pd where oi.pid = pd.pid and oi.oid = ?";
		List<Map<String,Object>> list = queryRunner.query(sql, new MapListHandler(),oid);
		for (Map<String, Object> map : list) {
			//封装product
			Product p = new Product();
			BeanUtils.populate(p,map);
			//封装orderitem
			OrderItem oi = new OrderItem();
			BeanUtils.populate(oi,map);
			oi.setProduct(p);
			//将oritem添加到order的items中
			order.getItems().add(oi);
		}
		return order;
	}

	//修改订单
	@Override
	public void update(Order order) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update orders set state=?,address=?,name=?,telephone=? where oid = ?";
		queryRunner.update(sql,order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getOid());
	}

	@Override
	public List<Order> findAllByPageOrder(Integer currPage, int i) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders limit ?,?";
		return queryRunner.query(sql,new BeanListHandler<>(Order.class),(currPage-1)*i,i);
	}

	@Override
	public int getTotalCount() throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from orders";
		return ((Long)queryRunner.query(sql, new ScalarHandler())).intValue();
	}

	public List<Order> Pay(int state, Integer currPage,int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders where state= ? limit ?,?";
		return queryRunner.query(sql,new BeanListHandler<>(Order.class),state,(currPage-1)*pageSize,pageSize);
	}

	@Override
	public int getTotalPayCount(int state) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from orders where state=?";
		return ((Long)queryRunner.query(sql,new ScalarHandler(),state)).intValue();
	}
}
