package com.zby.comfig;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 如果redis使用主从架构，可以用来配置两个RedisConnectionFactory,读取缓存从从服务器读取，写缓存从主服务器写
 * @author zhoubaiyun
 *
 * @param <K>
 * @param <V>
 */
public class CustomRedisTemplate<K, V> extends RedisTemplate<K, V> {
	private RedisConnectionFactory evictConnectionFactory;

	ThreadLocal<Boolean> currentThread = new ThreadLocal<Boolean>();
	@Override
	public <T> T execute(RedisCallback<T> action, boolean exposeConnection, boolean pipeline) {
		if(action!=null&&action.getClass().getName()!=null&&action.getClass().getName().contains("RedisCacheEvictCallback")){
			currentThread.set(true);
		}else if(action!=null&&action.getClass().getName()!=null&&action.getClass().getName().contains("RedisCachePutCallback"))
		{
			currentThread.set(true);
		}
		else{
			currentThread.set(false);
		}
		
		return super.execute(action, exposeConnection, pipeline);
	}

	@Override
	public RedisConnectionFactory getConnectionFactory() {
		if(currentThread.get()!=null&&currentThread.get()){
			return evictConnectionFactory;
		}
		return super.getConnectionFactory();
	}

	public RedisConnectionFactory getEvictConnectionFactory() {
		return evictConnectionFactory;
	}

	public void setEvictConnectionFactory(RedisConnectionFactory evictConnectionFactory) {
		this.evictConnectionFactory = evictConnectionFactory;
	}

}
