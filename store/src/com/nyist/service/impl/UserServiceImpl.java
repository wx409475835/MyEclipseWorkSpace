package com.nyist.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.apache.commons.dbutils.QueryRunner;
import com.nyist.dao.UserDao;
import com.nyist.dao.impl.UserDaoImpl;
import com.nyist.domain.PageBean;
import com.nyist.domain.User;
import com.nyist.service.UserService;
import com.nyist.utils.DataSourceUtils;
import com.nyist.utils.MailUtils;

public class UserServiceImpl implements UserService {

	//用户注册

	@Override
	public void register(User user) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		userDao.add(user);
		//发送邮件
		//收件人地址   邮件内容
		String msg="【图灵工作室】尊敬的用户:欢迎您成为我们的一员,您的验证码为:"+user.getCode()+" 工作人员不会索取，请勿泄漏。&nbsp;&nbsp;<a href='http://localhost:8888/store/user?method=active&code="+user.getCode()+"'>点此激活</a>";
		try {
			MailUtils.sendMail(user.getEmail(),msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	
	//用户激活
	@Override
	public User active(String code){
		UserDao userDao = new UserDaoImpl();
		//1.通过code 获得一个用户.
		User user = userDao.getByCode(code);
		//2.判断用户是否为空
		if(user==null){
			return null;
		}
		//3.修改用户转
		user.setStat(1);
		try {
			userDao.update(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public User login(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getByUserNameAndPassWord(username,password);
		return user;
	}


	public PageBean<User> findAll(Integer currPage, int pageSize) throws SQLException {
		PageBean<User> oBean = new PageBean<User>();
		UserDao dao = new UserDaoImpl();
		List<User> users = dao.findAll(currPage,pageSize);
		int totalCount = dao.getTotalCount();
		oBean.setCurrPage(currPage);
		oBean.setTotalCount(totalCount);
		oBean.setList(users);
		oBean.setPageSize(pageSize);
		oBean.getTotalPage();
		return oBean;
	}


	@Override
	public User getUserByUid(String uid) throws Exception {
		UserDao dao = new UserDaoImpl();
		return dao.getUserByUid(uid);
	}


	@Override
	public void update(User user) throws Exception {
		UserDao dao = new UserDaoImpl();
		dao.update(user);
	}


	@Override
	public void updateUser(User user) throws SQLException {
		UserDao dao = new UserDaoImpl();
		dao.updateUser(user);
	}


	@Override
	public void delete(String uid) throws Exception {
		UserDao dao = new UserDaoImpl();
		dao.delete(uid);
	}


	@Override
	public void addUser(User user) throws Exception {
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	}

}
