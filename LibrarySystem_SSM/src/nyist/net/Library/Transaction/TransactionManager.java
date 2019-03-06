package nyist.net.Library.Transaction;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("transaction")
public class TransactionManager implements MethodInterceptor{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		SqlSession session=sessionFactory.getSqlSessionFactory().openSession();
		Object ret=null;
		try {
			System.out.println("============= tx 事务开启 ===========");
			ret=mi.proceed();
			session.commit();
			System.out.println("============== tx 事务完毕 =============");
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return ret;
	}
	
}
