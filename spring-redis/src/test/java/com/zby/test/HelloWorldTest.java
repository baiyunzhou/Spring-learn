package com.zby.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class HelloWorldTest {
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;
	@Resource(name = "redisTemplate")
	private ListOperations<String, Object> listOps;
	@Resource(name = "redisTemplate")
	private SetOperations<String, Object> setOps;
	@Resource(name = "redisTemplate")
	private ZSetOperations<String, Object> zSetOps;
	@Resource(name = "redisTemplate")
	private GeoOperations<String, Object> geoOps;
//	@Resource(name = "redisTemplate")
//	private HyperLogLogOperations<String, Object> hllOps;

	@Test
	public void test() {
		listOps.leftPush("zzz", new Date());
		Object leftPop = listOps.leftPop("zzz");
		System.out.println(leftPop);
	}
	@Test
	public void testBound(){
		BoundValueOperations<String, Object> boundValueOperations = redisTemplate.boundValueOps("fv");
		boundValueOperations.set(new Date());
		Date date = (Date)boundValueOperations.get();
		System.out.println(date);
	}
	@Test
	public void testHash(){
		BoundHashOperations<String, Object, Object> boundHashOps = redisTemplate.boundHashOps("hash");
		boundHashOps.put("key2", new Date());
		Date now =(Date) boundHashOps.get("key2");
		System.out.println(now);
	}
}
