package com.repast.core.entity;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;


public class SMSTools {

	private static String SERVER_PATH = "http://gw.api.taobao.com/router/rest";

//	private static String APP_CODE = "23321133";   //辽宁天富
	private static String APP_CODE = "23583289";   //中农置粮

//	private static String APP_SECRET_KEY = "83d0387aff36a7d4a2f73986b6b7db5f";  //辽宁天富
	private static String APP_SECRET_KEY = "393cb5ddbf8ce1cc8edc15241e5f36ca";  //中农置粮

	// 签名
	public static String SING_NAME_REG = "注册验证";
	
	// 签名
	public static String SING_NAME_ORDER = "订单提醒";

	// 用户注册
//	public static String TEMPLATE_CODE_TEMP = "SMS_5441169";   //辽宁天富
	public static String TEMPLATE_CODE_TEMP = "SMS_33365056";  //中农置粮
	
	//密码找回模版
//	public static String TEMPLATE_FIND_PASSWORD="SMS_5441167";   //辽宁天富
	public static String TEMPLATE_FIND_PASSWORD="SMS_33365054";  //中农置粮

	public static void sendSMS(String singName, String param,
			String cellNumber, String templateCode) throws ApiException {
		
		TaobaoClient client = new DefaultTaobaoClient(SERVER_PATH, APP_CODE,
				APP_SECRET_KEY);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		// req.setExtend("123456");
		req.setSmsType("normal");

		req.setSmsFreeSignName(singName);
		//req.setSmsParamString("{\"code\":\"哇哈哈哇哈哈哇哈哈\",\"product\":\"阿里大鱼\",\"item\":\"阿里大鱼\"}");
		req.setSmsParamString(param);
		req.setRecNum(cellNumber);
		req.setSmsTemplateCode(templateCode);
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
}
