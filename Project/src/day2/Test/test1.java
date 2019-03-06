package day2.Test;

import org.junit.Test;

import day2.Service.UserService;
import day2.Service.Impl.UserServcieImpl;


public class test1 {
	@Test
	public void test2(){
		/*SqlSession session = Util.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		String username = "suns";
		String ps = userMapper.queryUserByName(username);*/
		String username = "suns ";
		UserService userService =new UserServcieImpl();
		String ps = userService.queryUserByName(username);
		System.out.println("ps="+ps);
	}
}
