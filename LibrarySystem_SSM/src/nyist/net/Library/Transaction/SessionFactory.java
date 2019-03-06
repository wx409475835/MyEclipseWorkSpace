package nyist.net.Library.Transaction;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SessionFactory {
	public SqlSessionFactory getSqlSessionFactory(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory =(SqlSessionFactory)ctx.getBean("sqlSessionFactory");
		System.out.println(sqlSessionFactory);
		return sqlSessionFactory;
	}
}
