package com.repast.weixin.fastweixin.api;

import com.repast.weixin.fastweixin.api.config.ApiConfig;
import com.repast.weixin.fastweixin.api.response.BaseResponse;
import com.repast.weixin.fastweixin.api.response.PayResponse;
import com.repast.weixin.fastweixin.message.util.MessageBuilder;
import com.repast.weixin.fastweixin.util.JSONUtil;
import com.zhiliang.weixin.pay.controller.TenpayUtil;

public class PayAPI extends BaseAPI{

	protected PayAPI(ApiConfig config) {
		super(config);
	}
	
	public void pay(){
		String weixinUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		PayResponse response = null;
	        String url = weixinUrl;
	        
	        String currTime = TenpayUtil.getCurrTime();
			//8位日期
			String strTime = currTime.substring(8, currTime.length());
			//四位随机数
			String strRandom = TenpayUtil.buildRandom(4) + "";
			
	        MessageBuilder param = new MessageBuilder();
	        param.addData("appid", "wxd6b686adcb8e8faf");
	        param.addData("mch_id", "1335518301");
	        param.addData("device_info", "WEB");
	        param.addData("nonce_str", strTime + strRandom);
	        param.addData("sign", "1791B05AED2E077F5026AA913F0838DA");
	        param.addData("body", "testbody11");
	     //   param.addData("detail", "");
	     //   param.addData("attach", "");
	        param.addData("out_trade_no", "201501601212111");
	     //   param.addData("fee_type", "");
	        param.addData("total_fee", "1");
	        param.addData("spbill_create_ip", "192.168.1.1");
//	        param.addData("time_start", "");
//	        param.addData("time_expire", "");
//	        param.addData("goods_tag", "");
	        param.addData("notify_url", "http://weixin.qyhz.net.cn/");
	        param.addData("trade_type", "NATIVE");
	        param.addData("product_id", "1234567890");
	        param.addData("openid", "o4-iajqknw4plA0Y__mlZ91WBJPQ");
	       
	        BaseResponse r = executePost(url, "<xml>"+param.toString()+"</xml>");
	        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
	        response = JSONUtil.toBean(resultJson, PayResponse.class);
	}
	public static void main(String[] args){
		ApiConfig config = new ApiConfig("wx7716b3d1dd94acbe", "e98bf4ae7b589560cbb34cf96e8efc61", true);
		PayAPI	pay = new PayAPI(config);
		pay.pay();
	}

}
