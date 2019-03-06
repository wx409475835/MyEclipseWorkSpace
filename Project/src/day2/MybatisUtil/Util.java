package day2.MybatisUtil;

import java.io.IOException;
import java.io.InputStream;
import javax.jms.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Util {
	private static SqlSessionFactory sqlSessionFactory;
	
	//使用静态代码块只加载一次
	static{
		//获得输入流
		InputStream inputStream =null;
		try {
			//使用输入流加载配置文件
			inputStream =Resources.getResourceAsStream("mybatis.xml");
			//通过加载的配置文件来创建sqlSessionFactory
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession openSession(){
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	
	public static void CloseSession(Session session){
		if(session!=null){
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
