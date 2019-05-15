package com.repast.core.cache;

import java.util.List;
import java.util.Set;
/**
 * 统一缓存处理接口
 * @author luandong
 *
 * @param <T>
 */
public interface ICache<T> {
	
	/**
	 * 向cache中写入数据
	 * @param defID     缓存定义ID
	 * @param cacheKey  缓存中的KEY，类似defID的实例标识
	 * @param data      缓存数据
	 */
	public void putCacheList(final String defID,final String cacheKey, final List<T> data);
	
	/**
	 * 向缓存中写入String类型的数据
	 * @param cacheKey
	 * @param value
	 */
	public void putCacheString(final String defID,final String cacheKey,String value);
	
	/**
	 * 向公共KEY中写入defID的实例数据
	 * @param defID
	 * @param cacheKey
	 */
	public void putDefId(final String defID,final String cacheKey);
	
	/**
	 * 根据缓存定义ID获取缓存key的实例
	 * @param defID
	 * @return
	 */
	public Set<String> getCacheKeysByDefID(final String defID);
	
	/**
	 * 根据cacheKey取得JSON串数据
	 * @param cacheKey
	 * @return
	 */
	public String getCacheValue(final String cacheKey);
	
	/**
	 * 根据cacheKey取得List数据
	 * @param cacheKey
	 * @return
	 */
	public List<T> getCacheData(final String cacheKey);


	/**
	 * 根据缓存定义ID清空所有与此defID对应的cacheKEY
	 * @param defID
	 */
	public void flushCacheByDefID(final String defID);
	
	/**
	 * 批量清空缓存中与defID对应的cacheKEY
	 * @param defIDs
	 */
	public void flushCacheByDefIDs(Set<String> defIDs);
	
	/**
	 * 根据cacheKey删除指定的缓存实例
	 * @param cacheKey
	 */
	public void deleteCacheKey(String cacheKey);

	/**
	 * 向cache中写入数据
	 * @param defID     缓存定义ID
	 * @param cacheKey  缓存中的KEY，类似defID的实例标识
	 * @param data      缓存数据
	 */
	public void putCacheObject(String defID, String cacheKey, Object data);
}
