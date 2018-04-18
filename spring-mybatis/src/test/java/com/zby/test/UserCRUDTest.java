package com.zby.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zby.po.UserPo;
import com.zby.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserCRUDTest {

	@Autowired
	private UserService userService;
	@Test
	public void testInsert() {
		UserPo userPo=new UserPo();
		userPo.setUsername("zby");
		userPo.setPassword("123456");
		userPo.setBirthday(new Date());
		int insert = userService.insert(userPo);
		System.out.println("testInsert:"+insert);
	}

	@Test
	public void testSelect() {
		UserPo userPo = userService.selectByPrimaryKey(1);
		System.out.println("testSelect:"+userPo);
	}

	@Test
	public void testUpdate() {
		UserPo userPo=new UserPo();
		userPo.setId(1);
		userPo.setUsername("ybz");
		userPo.setPassword("654321");
		userPo.setBirthday(new Date());
		int update = userService.updateByPrimaryKey(userPo);
		System.out.println("testUpdate:"+update);
	}
	@Test
	public void testDelete() {
		int delete=userService.deleteByPrimaryKey(1);
		System.out.println("testDelete:"+delete);
	}
}
