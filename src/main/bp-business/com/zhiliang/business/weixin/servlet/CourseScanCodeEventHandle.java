package com.zhiliang.business.weixin.servlet;

import java.util.Date;

import com.repast.core.tool.ApplicationContextUtil;
import com.repast.weixin.fastweixin.api.OauthAPI;
import com.repast.weixin.fastweixin.api.config.ApiConfig;
import com.repast.weixin.fastweixin.api.enums.OauthScope;
import com.repast.weixin.fastweixin.handle.EventHandle;
import com.repast.weixin.fastweixin.message.Article;
import com.repast.weixin.fastweixin.message.BaseMsg;
import com.repast.weixin.fastweixin.message.NewsMsg;
import com.repast.weixin.fastweixin.message.req.ScanCodeEvent;
/**
 * 扫码结算处理类
 * @author luandong
 *
 */
public class CourseScanCodeEventHandle implements EventHandle<ScanCodeEvent> {

	@Override
	public BaseMsg handle(ScanCodeEvent event) {
//		CarMemberCardService carMemberCardService = (CarMemberCardService) ApplicationContextUtil.getBean("CarMemberCardService");
//		CarOrderService carOrderService = (CarOrderService)ApplicationContextUtil.getBean("CarOrderService");
//		CarMemberCard carMemberCard = carMemberCardService.getCarMemberCardByQrcodeurl(event.getScanResult());
		NewsMsg resMsg = new NewsMsg();
//		OauthAPI oauthAPI = new OauthAPI((ApiConfig) ApplicationContextUtil.getBean("apiConfig"));
//		String desc = "";
//		String status = "";
//		String shopid = "";
//		if(null != carMemberCard){
//			status = carMemberCard.getStatus();
//			shopid = carMemberCard.getShopid();
//		}
//		if(!"0".equals(status)){
//			desc = "优惠券已失效";
//			Article article = new Article(desc, "","", "");
//			resMsg.add(article);
//		}else {
//			desc = "优惠券可以使用";
//			String doCheckUrl = oauthAPI.getOauthPageUrl(WeixinToolsController.USECARD+"?shopid="+shopid+"&qrcodeurl="+event.getScanResult(),
//					 OauthScope.SNSAPI_BASE, "");
//			Article article = new Article(desc, "点击进入确认页！","", doCheckUrl);
//			resMsg.add(article);
//		}
//		
//		resMsg.setCreateTime(new Date().getTime());
		return resMsg;
	}

	@Override
	public boolean beforeHandle(ScanCodeEvent event) {

		if ("doaccount".equals(event.getEventKey())) {
			return true;
		}

		return false;
	}

}
