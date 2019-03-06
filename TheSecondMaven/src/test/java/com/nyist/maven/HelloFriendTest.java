package com.nyist.maven;	
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import com.nyist.soft.maven.Hello;
import com.nyist.maven.HelloFriend;

public class HelloFriendTest {
	@Test
	public void testHelloFriend(){
		HelloFriend helloFriend = new HelloFriend();
		String results = helloFriend.sayHelloToFriend("lhg");
		assertEquals("Hello lhg! I am John",results);	
	}
}