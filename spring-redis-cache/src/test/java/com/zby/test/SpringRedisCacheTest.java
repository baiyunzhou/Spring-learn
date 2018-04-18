package com.zby.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zby.po.User;
import com.zby.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringRedisCacheTest {
	
	@Autowired
	private UserService userService;
	@Test
	public void testSpringCache(){
		User user1 = userService.queryUser("zby");
		System.out.println(user1);
		User user2 = userService.queryUser("zby");
		System.out.println(user2);
		userService.updateDB(user1);
		User user3 = userService.queryUser("zby");
		System.out.println(user3);
		User user4 = userService.queryUser("zby");
		System.out.println(user4);
	}
}
