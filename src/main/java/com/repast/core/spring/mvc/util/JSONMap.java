package com.repast.core.spring.mvc.util;

import java.util.HashMap;

/**
 * 向前台传递JSON数据
 * @author luandong
 *
 * @param <K>
 * @param <V>
 */
public class JSONMap<K, V>  extends HashMap<K, V> {

	private static final long serialVersionUID = -4647603063745934454L;

	public V put(K key, V value,String valueType) {
		
		String definedStr = "";
		if(this.containsKey("JsonDef")){
			definedStr = (String)this.get("JsonDef");
		}
		definedStr+= "【"+key+"="+valueType+"】";
		super.put((K) "JsonDef", (V)definedStr);
		
		return super.put(key, value);
	}
	
	@Deprecated
	/**
	 * 不推荐使用，只为兼容之前的写法，建议使用put方法
	 * @param key
	 * @param value
	 */
	public void addAttribute(K key, V value){
		this.put(key, value);
	}
}
