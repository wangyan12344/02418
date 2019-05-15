package com.repast.core.cache.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.repast.core.cache.ICache;

/**
 * redis缓存客户端实现
 * @author luandong
 *
 * @param <T>
 */
public class RedisCacheClient<T> implements ICache {

	private RedisTemplate redisTemplate;

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void putCacheList(final String defID, final String cacheKey,final List data) {
		String jsonData = JSON.toJSONString(data);
		putCacheString(defID, cacheKey, jsonData);
	}
	
	@Override
	public void putCacheObject(final String defID, final String cacheKey,final Object data) {
		String jsonData = JSON.toJSONString(data);
		putCacheString(defID, cacheKey, jsonData);
	}

	@Override
	public void putCacheString(final String defID, final String cacheKey,final String value) {
		// 记录defID同cacheKey的对应关系
		putDefId(defID, cacheKey);

		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection
						.set(redisTemplate.getStringSerializer().serialize(
								cacheKey), redisTemplate.getStringSerializer()
								.serialize(value));
				return null;
			}
		});
	}
	
	public void putDefId(final String defID, final String cacheKey) {
		redisTemplate.opsForSet().add(defID, cacheKey);
	}

	public Set<String> getCacheKeysByDefID(final String defID) {
		
		return redisTemplate.opsForSet().members(defID);
	}

	public String getCacheValue(final String id) {
		return (String) redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize(id);
				if (connection.exists(key)) {
					byte[] value = connection.get(key);
					Object name = redisTemplate.getStringSerializer()
							.deserialize(value);
					return (String) name;
				}
				return null;
			}
		});
	}




	@Override
	public List<T> getCacheData(String cacheKey) {
		String resData = this.getCacheValue(cacheKey);
		List<T> tempList = JSON.parseObject(resData,
				new TypeReference<List<T>>() {
				});
		return tempList;
	}

	@Override
	public void flushCacheByDefID(String defID) {
		Set<String> delKeys = this.getCacheKeysByDefID(defID);
		// 1.清空指定key的缓存数据
		redisTemplate.delete(delKeys);
		// 2.删除对应关系
		redisTemplate.delete(defID);
	}

	@Override
	public void flushCacheByDefIDs(Set defIDs) {
		try{
		Iterator it = defIDs.iterator();
		while (it.hasNext()) {
			String delKeyId = (String) it.next();
			this.flushCacheByDefID(delKeyId);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCacheKey(String cacheKey) {
		redisTemplate.delete(cacheKey);
	}

}
