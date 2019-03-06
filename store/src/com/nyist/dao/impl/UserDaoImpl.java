package com.nyist.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nyist.dao.UserDao;
import com.nyist.domain.User;
import com.nyist.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?) ";
		qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getStat(),user.getCode());
	}

	@Override
	public void update(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set username = ?,password=?,name=?,email=?,birthday=?,state=?,code=null where uid=?";
		queryRunner.update(sql, user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getBirthday(),user.getStat(),user.getUid());
	}

	@Override
	public void updateUser(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set username = ?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
		queryRunner.update(sql, user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getStat(),user.getCode(),user.getUid());
	}
	/**
	 * 通过激活码 获取一个用户
	 */
	@Override
	public User getByCode(String code) {
		QueryRunner qur = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where code = ? limit 1";
		try {
			return qur.query(sql,new BeanHandler<>(User.class),code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getByUserNameAndPassWord(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username =? and password = ? limit 1";
		return queryRunner.query(sql, new BeanHandler<>(User.class),username,password);
	}

	@Override
	public List<User> findAll(Integer currPage, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		return queryRunner.query(sql, new BeanListHandler<>(User.class));
	}

	@Override
	public int getTotalCount() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select count(*) from user";
		return ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
	}

	@Override
	public User getUserByUid(String uid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where uid=?";
		return queryRunner.query(sql, new BeanHandler<>(User.class),uid);
	}

	@Override
	public void delete(String uid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from user where uid= ? ";
		queryRunner.update(sql,uid);
	}
	
}
