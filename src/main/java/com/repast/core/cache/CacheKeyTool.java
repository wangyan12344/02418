package com.repast.core.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.repast.core.system.BaseEntity;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.repast.core.tool.ApplicationContextUtil;

/**
 * 
 * @description 调用缓存接口，提供缓存数据的清除，获取，刷新
 * @author lingy
 *
 */
public class CacheKeyTool {
	
	private static CacheKeyTool cacheKeyTool = null;
	
	ICache iCache = null;
	
	private final static String ROOTKEY = "rootKey";
	
	private final static String CACHEKEY = "cacheKey";
	
	
	private CacheKeyTool() {

	}
	
	/**
	 * 单例模式
	 * @return
	 */
	public static CacheKeyTool getInstance() {
		if (cacheKeyTool == null) {
			cacheKeyTool = new CacheKeyTool();
			cacheKeyTool.iCache = (ICache)ApplicationContextUtil.getContext().getBean("redisCache");
		}
		return cacheKeyTool;
	}
	
	/**
	 * 初始化方法
	 */
	public void init(){
		
	}
	
	/**
	 * 根据定义 cacheconfig.xml 中定义的 cachekeyid 和 methodId 获取 defID 缓存定义ID
	 * @param cacheKeyId
	 * @param methodId
	 * @return
	 */
	private String getCacheRootKey(String methodId){
		Map<String,String> cacheRootKeyMap = CacheKeyDefineManager.getInstance().getCacheKeyMap();
		if (cacheRootKeyMap!=null) {
			return cacheRootKeyMap.get(methodId);
		}
		return "";
	}
	
	/**
	 * 根据table名获取与表名有关的defID（ 缓存定义ID ）
	 * @param tablename
	 * @return
	 */
	private Set<String> getTableRootKeyRelation(String tablename){
		Map<String, Set<String>> relationMap = CacheKeyDefineManager.getInstance().getTableAndRootkeyMap();
		return relationMap.get(tablename);
	}

	/**
	 * 获取缓存cachekey
	 * @author lingy
	 * @param cacheKeyId
	 * @param methodId
	 * @param paraEntity
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	private Map<String,String> getCacheKey(String methodId, Object paraEntity, int pageindex,int pagesize){
		Map<String,String> keyMap = getCacheKey(methodId, paraEntity);
		String cacheKey = keyMap.get(CACHEKEY);
		String paginationKey = "[pagination.pageindex=" + pageindex + "pagination.pagesize=" + pagesize + "]";
		cacheKey = cacheKey + paginationKey;
		keyMap.put(CACHEKEY, cacheKey);
		return keyMap;
	}
	
	/**
	 * 多个实体作为参数时，获得实体key
	 * @author lingy
	 * @param methodId
	 * @param pageindex
	 * @param pagesize
	 * @param paraEntitys
	 * @return
	 */
	private Map<String,String> getCacheKey(String methodId, int pageindex, int pagesize, Object... paraEntitys){
		Map<String,String> keyMap = getCacheKey(methodId, paraEntitys);
		String cacheKey = keyMap.get(CACHEKEY);
		String paginationKey = "[pagination.pageindex=" + pageindex + "pagination.pagesize=" + pagesize + "]";
		cacheKey = cacheKey + paginationKey;
		keyMap.put(CACHEKEY, cacheKey);
		return keyMap;
	}
	
	/**
	 * 获取缓存cachekey
	 * @author lingy
	 * @param cacheKeyId
	 * @param methodId
	 * @param paraEntity
	 * @return
	 */
	private Map<String,String> getCacheKey(String methodId, Object paraEntity){
		Map<String,String> keyMap = new HashMap<String, String>();
		String rootKey = getCacheRootKey(methodId);
		String entityParams = getEntityParams(paraEntity);
		String cacheKey = rootKey + entityParams;
		keyMap.put(ROOTKEY, rootKey);
		keyMap.put(CACHEKEY, cacheKey);
		return keyMap;
	}
	
	/**
	 * 多个实体作为参数时
	 * @param methodId
	 * @param paraEntitys
	 * @return
	 */
	private Map<String,String> getCacheKey(String methodId, Object... paraEntitys){
		Map<String,String> keyMap = new HashMap<String, String>();
		String rootKey = getCacheRootKey(methodId);
		StringBuffer entityParams = new StringBuffer();
		if(paraEntitys!=null&&paraEntitys.length>0){
			for (Object object : paraEntitys) {
				String entityParam = getEntityParams(object);
				entityParams.append(entityParam);
			}
		}
		String cacheKey = rootKey + entityParams.toString();
		keyMap.put(ROOTKEY, rootKey);
		keyMap.put(CACHEKEY, cacheKey);
		return keyMap;
	}
	
	/**
	 * 获取缓存cachekey
	 * @author lingy
	 * @param cacheKeyId
	 * @param methodId
	 * @param paraEntity
	 * @param pagination
	 * @return
	 */
	private Map<String,String> getCacheKey(String methodId, Object paraEntity,Processor processor){
		Map<String,String> keyMap = getCacheKey(methodId, paraEntity);
		String cacheKey = keyMap.get(CACHEKEY);
		String paginationKey = null;
		if(processor != null){
			paginationKey = "[pagination.pageindex=" + processor.getPageIndex() + "pagination.pagesize=" + processor.getPageSize() + "]";
		}else{
			paginationKey = "";
		}
		cacheKey = cacheKey + paginationKey;
		keyMap.put(CACHEKEY, cacheKey);
		return keyMap;
	}
	
	/**
	 * 根据有数据变化表的表名刷新缓存
	 * @author lingy
	 * @param tablenames
	 */
	public void flushCache(String[] tablenames){
		try {
			for (String tablename : tablenames) {
				System.out.println("Flash Table Cache Data = "+tablename);
				Set<String> rootKeySet = getTableRootKeyRelation(tablename.toLowerCase());
				iCache.flushCacheByDefIDs(rootKeySet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据cacheKey取得List数据
	 * @author lingy
	 * @param cacheKey
	 * @return
	 */
	private <T> List<T> getCacheListData(Map<String, String> keyMap,Class<T> c){
		String resData = this.getCacheValue(keyMap);
		List<T> tempList = JSON.parseObject(resData,
				new TypeReference<List<T>>() {
				});
		return tempList;
	}
	
	/**
	 * 根据cacheKey取得List数据
	 * @param methodId
	 * @param paraEntity
	 * @param c
	 * @return
	 */
	public <T> List<T> getCacheListData(String methodId, Object paraEntity, Class<T> c){
		try {
			Map<String, String> keyMap = getCacheKey(methodId, paraEntity);
			return getCacheListData(keyMap, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据cacheKey取得Pagination数据
	 * @author lingy
	 * @param cacheKey
	 * @return
	 */
	private <T> Pagination<T> getCachePageData(Map<String, String> keyMap,Class<T> c){
		String resData = this.getCacheValue(keyMap);
		
		Pagination<T> tempList = JSON.parseObject(resData,
				new TypeReference<Pagination<T>>() {
		});
		return tempList;
	}
	
	/**
	 * 根据cacheKey取得Pagination数据
	 * @author lingy
	 * @param cacheKey
	 * @return
	 */
	public <T> Pagination<T> getCachePageData(String methodId, Object paraEntity, int pageindex,int pagesize,Class<T> c){
		try {
			Map<String, String> keyMap = getCacheKey(methodId, paraEntity, pageindex, pagesize);
			return getCachePageData(keyMap, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据cacheKey取得JSON串数据
	 * @author lingy
	 * @param cacheKey
	 * @return
	 */
	private String getCacheValue(Map<String, String> keyMap){
		String cacheKey = keyMap.get(CACHEKEY);
		String cacheValue = iCache.getCacheValue(cacheKey);
		return cacheValue;
	}
	
	/**
	 * 根据继承了BaseEntity的实体获得缓存Key的参数串
	 * @author lingy
	 * @param obj
	 * @return
	 */
	public String getEntityParams(Object obj){
		BaseEntity baseEntity = null;
		String entityParams = "";
		if (obj instanceof BaseEntity) {
			baseEntity = (BaseEntity) obj;
			
		}
		if (baseEntity != null) {
			entityParams = baseEntity.cacheEntityParams();
		}else{
			if(obj==null||"".equals(obj)){
				entityParams = "[defaultkey]";
			}else{
				entityParams = "["+obj.toString()+"]";
			}
		}
		return entityParams;
	}
	
	/**
	 * 
	 * @param methodId
	 * @param paraEntity
	 * @param pageindex
	 * @param pagesize
	 * @param data
	 */
	public void putCacheList(String methodId, Object paraEntity, List<?> data) {
		try {
			Map<String, String> keyMap = getCacheKey(methodId, paraEntity);
			String defID = keyMap.get(ROOTKEY);
			String cacheKey = keyMap.get(CACHEKEY);
			iCache.putCacheList(defID, cacheKey, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param methodId
	 * @param paraEntity
	 * @param pageindex
	 * @param pagesize
	 * @param data
	 */
	public void putCachePage(String methodId, Object paraEntity, int pageindex,int pagesize,Pagination<?> data) {
		try {
			Map<String, String> keyMap = getCacheKey(methodId, paraEntity, pageindex, pagesize);
			String defID = keyMap.get(ROOTKEY);
			String cacheKey = keyMap.get(CACHEKEY);
			iCache.putCacheObject(defID, cacheKey, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param methodId
	 * @param paraEntity
	 * @param data
	 */
	public void putCacheObject(String methodId, Object paraEntity,Object data){
		try {
			Map<String, String> keyMap = getCacheKey(methodId, paraEntity);
			String defID = keyMap.get(ROOTKEY);
			String cacheKey = keyMap.get(CACHEKEY);
			iCache.putCacheObject(defID, cacheKey, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取单个对象
	 * @param keyMap
	 * @param c
	 * @return
	 */
	public <T> T getCacheObjectData(String methodId, Object paraEntity,Class<T> c){
		try {
			Map<String, String> keyMap = getCacheKey(methodId, paraEntity);
			String resData = this.getCacheValue(keyMap);
			T tempList = JSON.parseObject(resData, c);
			return tempList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
