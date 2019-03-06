package nyist.net.Library.Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	@Test
	public void testJDBC(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object object = ctx.getBean("dataSource");
		System.out.println(object);
	}
}
