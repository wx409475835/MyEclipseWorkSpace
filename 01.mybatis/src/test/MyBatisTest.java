package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.nyist.mybatis.pojo.User;

public class MyBatisTest {
	@Test
	public void testGetUserById() throws IOException{
		//1.创建SqlSessionFactoryBuilder类 
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		System.out.println("41111111111");
		//创建核心配置文件输入流  /01.mybatis/config/SqlMapConfig.xml
		InputStream resources = Resources.getResourceAsStream("SqlMapConfig.xml");
		System.out.println("resources:"+resources);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = sfb.build(resources);
		//创建sqlSession   该对象有一系列的API
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行查询
		User user = sqlSession.selectOne("User.getUserById",1);
		System.out.println(user);
		sqlSession.close();
	}
}
