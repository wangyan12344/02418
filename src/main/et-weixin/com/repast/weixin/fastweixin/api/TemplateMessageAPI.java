package com.repast.weixin.fastweixin.api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.repast.weixin.fastweixin.api.config.ApiConfig;
import com.repast.weixin.fastweixin.api.entity.TemplateMessage;
import com.repast.weixin.fastweixin.api.entity.TemplateMessageData;
import com.repast.weixin.fastweixin.api.response.BaseResponse;
import com.repast.weixin.fastweixin.api.response.TemplateMessageResponse;
import com.repast.weixin.fastweixin.util.JSONUtil;

/**
 * 消息模板相关API
 *
 * @author 栾冬
 * @since 1.2
 */

public class TemplateMessageAPI {
	
	public static String appid = "";
	public static String secret = "";

	//充值提示模板
	public static final String RECARGE_TEMPLATE_ID = "TkfSGTcOCbPoNtfuGqZC5dVA10nwA1vXgkHF_8zT4b8";
	//预约提示模板
	public static final String BOOKCOACH_TEMPLATE_ID = "Y3A807BGw9fwusOiHieNp_eVXSqYuMAj2cDrvaATF_w";
	//教练确认预约
	public static final String CONFIRMBOOK_TEMPLATE_ID = "QwiAUf9N0b7ovf-hBd4m2qDIamVCh7jYFsX8zeLqwOY";
	//教练确认销课
	public static final String WRITTENBACK_TEMPLATE_ID = "Y7FPYBtYw3_SltXUuXKwi8iM7YKSfxz-nZOZ7Voxu1A";
	public static final String topColor = "#E10511";
	public static final String contextColor = "#000000";
	
	public static void sendTemplateMessage(ApiConfig config,TemplateMessage templateMessage){
		new Thread(new TemplateMessageSend(config,templateMessage)).start();
	}
	
	public static void main(String[] args) {
		// JmFC51Ru8iaXEFfmErVGvl3-UThKgWEyM6ZvVZSh93s

		String template_id = "JmFC51Ru8iaXEFfmErVGvl3-UThKgWEyM6ZvVZSh93s";
		TemplateMessage t = new TemplateMessage();
		// t.setUrl("http://www.163.com");
		t.setTouser("o4-iajqknw4plA0Y__mlZ91WBJPQ");
		t.setTopcolor("#000000");
		t.setTemplate_id(template_id);

		Map<String, TemplateMessageData> m = new HashMap<String, TemplateMessageData>();

		TemplateMessageData first = new TemplateMessageData();
		first.setColor("#000000");
		first.setValue("栾冬");
		m.put("first", first);

		TemplateMessageData k1d = new TemplateMessageData();
		k1d.setColor("#000000");
		k1d.setValue("keynote1...");
		m.put("keynote1", k1d);

		TemplateMessageData k2d = new TemplateMessageData();
		k2d.setColor("#000000");
		k2d.setValue("keynote1...");
		m.put("keynote2", k2d);

		TemplateMessageData remarkd = new TemplateMessageData();
		remarkd.setColor("#000000");
		remarkd.setValue("re...");
		m.put("remark", remarkd);

		t.setData(m);

		ApiConfig config = new ApiConfig("wx7716b3d1dd94acbe", "e98bf4ae7b589560cbb34cf96e8efc61", true);
		TemplateMessageAPI.sendTemplateMessage(config,t);
		System.out.println("Hello");
		TemplateMessageAPI.sendTemplateMessage(config,t);
		System.out.println("Hello");
	}
}

class TemplateMessageSend extends BaseAPI implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(TemplateMessageAPI.class);

	private TemplateMessage template;

	public TemplateMessageSend(ApiConfig config) {
		super(config);
	}

	public TemplateMessageSend(ApiConfig config, TemplateMessage template) {
		super(config);
		this.template = template;
	}

	/**
	 * 发送模板消息通知
	 * 
	 * @return 消息模板对象
	 */
	private TemplateMessageResponse sendTemplateMessage(TemplateMessage template) {
		LOG.debug("发送模板消息.....");
		TemplateMessageResponse response = null;
		String url = BASE_API_URL + "cgi-bin/message/template/send?access_token=#";

		BaseResponse r = executePost(url, JSONUtil.toJson(template));
		String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
		response = JSONUtil.toBean(resultJson, TemplateMessageResponse.class);
		return response;
	}

	@Override
	public void run() {
		this.sendTemplateMessage(template);
	}

}
