package com.zby.service.impl;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zby.po.User;
import com.zby.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Cacheable(value = "userCache", condition = "#id<2", key = "#id")
	@Override
	public User queryUser(Integer id) {
		System.out.println("real query account." + id);
		return getFromDB(id);
	}

	private User getFromDB(Integer id) {
		System.out.println("real querying db..." + id);
		return new User(id, "zby", new Date());
	}

	@CachePut(value = "userCache", key = "#user.getId()") // 执行这个方法后，缓存返回值
	@Override
	public User updateDB(User user) {
		System.out.println("updateDB Execute!");
		user.setName("zzz");
		return user;
	}

	@CacheEvict(value = "userCache", allEntries = true, beforeInvocation = true) // 这个方法执行前清空缓存
	@Override
	public void reload() {
	}
}
