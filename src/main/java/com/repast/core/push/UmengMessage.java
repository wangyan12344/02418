package com.repast.core.push;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class UmengMessage {
	
	/**
	 * Android消息（组发送）
	 */
	public static void sendAndroidGroupcast
				(List<String> tagList,String ticker,String title,String text,String customValue,String customValue1,String customValue2) throws Exception {
		AndroidGroupcast groupcast = new AndroidGroupcast();
		groupcast.setAppMasterSecret("c44zdktyzkbytnahyjqqqavfcq9lomux");
		groupcast.setPredefinedKeyValue("appkey", "55c3118f67e58ec304004495");
		groupcast.setPredefinedKeyValue("timestamp", Integer.toString((int)(System.currentTimeMillis() / 1000)));
		/*  TODO
		 *  Construct the filter condition:
		 *  "where": 
		 *	{
    	 *		"and": 
    	 *		[
      	 *			{"tag":"test"},
      	 *			{"tag":"Test"}
    	 *		]
		 *	}
		 */
		
		
		JSONObject filterJson = new JSONObject();
		JSONObject whereJson = new JSONObject();
		JSONArray tagArray = new JSONArray();
		
		
		for(String tag : tagList){
			JSONObject tagJson = new JSONObject();
			tagJson.put("tag", tag);
			tagArray.put(tagJson);
		}
		
		whereJson.put("or", tagArray);
		filterJson.put("where", whereJson);
		System.out.println(filterJson.toString());
		
		groupcast.setPredefinedKeyValue("filter", filterJson);
		groupcast.setPredefinedKeyValue("ticker", ticker);
		groupcast.setPredefinedKeyValue("title",  title);
		groupcast.setPredefinedKeyValue("text",   text);
		groupcast.setPredefinedKeyValue("after_open", "go_custom");
		groupcast.setPredefinedKeyValue("display_type", "message");
		groupcast.setPredefinedKeyValue("custom", customValue);
		
		groupcast.setPredefinedKeyValue("key1", customValue1);
		groupcast.setPredefinedKeyValue("key2", customValue2);
		
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		groupcast.setPredefinedKeyValue("production_mode", "true");
		groupcast.send();
	}
	
	/**
	 * IOS消息推送（组发送）
	 */
	public static void sendIOSGroupcast(List<String> tagList, String text, String customValue1,String customValue2,String type) throws Exception {
		IOSGroupcast groupcast = new IOSGroupcast();
		groupcast.setAppMasterSecret("etosglcch0soqn4bgerxyy9dptqst7ok");
		groupcast.setPredefinedKeyValue("appkey", "55c311c967e58edb77000adc");
		groupcast.setPredefinedKeyValue("timestamp", Integer.toString((int)(System.currentTimeMillis() / 1000)));
		/*  TODO
		 *  Construct the filter condition:
		 *  "where": 
		 *	{
    	 *		"and": 
    	 *		[
      	 *			{"tag":"iostest"}
    	 *		]
		 *	}
		 */
		JSONObject filterJson = new JSONObject();
		JSONObject whereJson = new JSONObject();
		JSONArray tagArray = new JSONArray();
		
		for(String tag : tagList){
			JSONObject tagJson = new JSONObject();
			tagJson.put("tag", tag);
			tagArray.put(tagJson);
		}
		
		whereJson.put("or", tagArray);
		filterJson.put("where", whereJson);
		System.out.println(filterJson.toString());
		
		// Set filter condition into rootJson
		groupcast.setPredefinedKeyValue("filter", filterJson);
		groupcast.setPredefinedKeyValue("alert", text);
		groupcast.setPredefinedKeyValue("badge", 0);
		groupcast.setPredefinedKeyValue("sound", "chime");
		
		groupcast.setPredefinedKeyValue("key1", customValue1);
		groupcast.setPredefinedKeyValue("key2", customValue2);
		groupcast.setPredefinedKeyValue("key3", type);
		// TODO set 'production_mode' to 'true' if your app is under production mode
		groupcast.setPredefinedKeyValue("production_mode", "true");
		groupcast.send();
	}	
}
