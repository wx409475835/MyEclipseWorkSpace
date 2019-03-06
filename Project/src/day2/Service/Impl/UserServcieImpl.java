package day2.Service.Impl;

import org.apache.ibatis.session.SqlSession;
import day2.Dao.UserMapper;
import day2.MybatisUtil.Util;
import day2.Service.UserService;

public class UserServcieImpl implements UserService{
	
	private UserMapper userMapper = null;
	
	public UserServcieImpl(){
		SqlSession session = Util.openSession();
		userMapper = session.getMapper(UserMapper.class);
	}
	
	@Override
	public String queryUserByName(String username) {	
		return userMapper.queryUserByName(username);
	}
}
