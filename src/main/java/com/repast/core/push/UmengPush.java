package com.repast.core.push;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class UmengPush {
	
	public static void sendAndroidUnicast(String deviceTokens, String ticker, String title, String text, String customValue) throws Exception {
		AndroidUnicast unicast = new AndroidUnicast();
		unicast.setAppMasterSecret("0nkdtbgovxawibto7kzorxqanyhafeg0");
		unicast.setPredefinedKeyValue("appkey", "5667f2af67e58e17300006c9");
		unicast.setPredefinedKeyValue("timestamp", Integer.toString((int)(System.currentTimeMillis() / 1000)));
		// TODO Set your device token
		unicast.setPredefinedKeyValue("device_tokens", deviceTokens);
		unicast.setPredefinedKeyValue("ticker", ticker);
		unicast.setPredefinedKeyValue("title",  title);
		unicast.setPredefinedKeyValue("text",   text);
		unicast.setPredefinedKeyValue("after_open", "go_custom");
		unicast.setPredefinedKeyValue("custom", customValue);
		
		unicast.setPredefinedKeyValue("display_type", "notification");
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		unicast.setPredefinedKeyValue("production_mode", "true");
		// Set customized fields
		unicast.setExtraField("test", "helloworld");
		unicast.send();
	} 
	
	public static void sendAndroidGroupcast(List<String> tagList, String ticker, String title, String text, String customValue) throws Exception {
		AndroidGroupcast groupcast = new AndroidGroupcast();
		groupcast.setAppMasterSecret("0nkdtbgovxawibto7kzorxqanyhafeg0");
		groupcast.setPredefinedKeyValue("appkey", "5667f2af67e58e17300006c9");
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
		groupcast.setPredefinedKeyValue("custom", customValue);
		groupcast.setPredefinedKeyValue("display_type", "notification");
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		groupcast.setPredefinedKeyValue("production_mode", "true");
		groupcast.send();
	}
	
	public static void sendIOSGroupcast(List<String> tagList, String text, String customValue) throws Exception {
		IOSGroupcast groupcast = new IOSGroupcast();
		groupcast.setAppMasterSecret("etosglcch0soqn4bgerxyy9dptqst7ok");
		groupcast.setPredefinedKeyValue("appkey", "5667f38fe0f55aedcd0006a5");
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
		
		groupcast.setPredefinedKeyValue("key1", customValue);
		// TODO set 'production_mode' to 'true' if your app is under production mode
		groupcast.setPredefinedKeyValue("production_mode", "true");
		groupcast.send();
	}
	
	public static void sendIOSUnicast(String deviceTokens, String text, String customValue) throws Exception {
		IOSUnicast unicast = new IOSUnicast();
		unicast.setAppMasterSecret("etosglcch0soqn4bgerxyy9dptqst7ok");
		unicast.setPredefinedKeyValue("appkey", "5667f38fe0f55aedcd0006a5");
		unicast.setPredefinedKeyValue("timestamp", Integer.toString((int)(System.currentTimeMillis() / 1000)));
		// TODO Set your device token
		unicast.setPredefinedKeyValue("device_tokens", deviceTokens);
		unicast.setPredefinedKeyValue("alert", text);
		unicast.setPredefinedKeyValue("badge", 0);
		unicast.setPredefinedKeyValue("sound", "chime");
		
		unicast.setPredefinedKeyValue("key1", customValue);
		// TODO set 'production_mode' to 'true' if your app is under production mode
		unicast.setPredefinedKeyValue("production_mode", "true");
		// Set customized fields
		unicast.setCustomizedField("test", "helloworld");
		unicast.send();
	}
}
