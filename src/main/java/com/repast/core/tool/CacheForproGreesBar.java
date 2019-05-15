package com.repast.core.tool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhouy
 * 缓存进队条数量
 */
public class CacheForproGreesBar {
	
	private static Map<String,Object> barcache = new HashMap<String, Object>();
	
	
	public static String getBarCount(String key){
		
		return (String) barcache.get(key);
	}
	
	public static void setBarCount(String key,Object barCount){
		
		barcache.put(key, barCount);
	}
	
	/**
	 * 删除对应map的Key值
	 */
	public static void removeMap(String sessionkey){
		Iterator<String> iterator = barcache.keySet().iterator();
		while (iterator.hasNext()) {  
		    String key = (String) iterator.next();  
		     if(sessionkey.equals(key)) 
		     {  
		       iterator.remove();        //添加该行代码  
		       barcache.remove(key);      
		     }  
		 } 
	}
}
