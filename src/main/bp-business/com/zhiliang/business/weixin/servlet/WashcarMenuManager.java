package com.zhiliang.business.weixin.servlet;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.repast.weixin.fastweixin.api.MenuAPI;
import com.repast.weixin.fastweixin.api.OauthAPI;
import com.repast.weixin.fastweixin.api.config.ApiConfig;
import com.repast.weixin.fastweixin.api.entity.Menu;
import com.repast.weixin.fastweixin.api.entity.MenuButton;
import com.repast.weixin.fastweixin.api.enums.MenuType;
import com.repast.weixin.fastweixin.api.enums.OauthScope;
import com.repast.weixin.fastweixin.api.enums.ResultType;
import com.zhiliang.business.controller.WeixinToolsController;

public class WashcarMenuManager {
	private static final Logger LOG = LoggerFactory.getLogger(WashcarMenuManager.class);


	private void createMenu(ApiConfig config) {
		
		OauthAPI oauthAPI = new OauthAPI(config);
		MenuAPI menuAPI = new MenuAPI(config);
		String returnURL ="";
		
		// 先删除之前的菜单
		menuAPI.deleteMenu();
		Menu request = new Menu();
		// 准备一级主菜单
		MenuButton main1 = new MenuButton();
		main1.setType(MenuType.CLICK);
		main1.setKey("main1");
		main1.setName("我要洗车");
		// 准备子菜单
		MenuButton sub0 = new MenuButton();
		sub0.setKey("sub0");
		sub0.setName("商户列表");
		sub0.setType(MenuType.VIEW);
	    returnURL = oauthAPI.getOauthPageUrl(WeixinToolsController.REDIRECTURL_MEMBER_BIND, OauthScope.SNSAPI_BASE, "shopinfo");
		sub0.setUrl(returnURL);
		
//		MenuButton sub1 = new MenuButton();
//		sub1.setKey("sub1");
//		sub1.setName("预约");
//		sub1.setType(MenuType.VIEW);
//	    returnURL = oauthAPI.getOauthPageUrl(WeixinToolsController.REDIRECTURL_MEMBER_BIND, OauthScope.SNSAPI_USERINFO, "booking");
//		sub1.setUrl(returnURL);
//		
//		MenuButton sub2 = new MenuButton();
//		sub2.setKey("sub1");
//		sub2.setName("课程");
//		sub2.setType(MenuType.VIEW);
//		returnURL = oauthAPI.getOauthPageUrl(WeixinToolsController.REDIRECTURL_MEMBER_BIND, OauthScope.SNSAPI_USERINFO, "course");
//		sub2.setUrl(returnURL);
//
//		MenuButton sub3 = new MenuButton();
//		sub3.setKey("sub1");
//		sub3.setName("健康");
//		sub3.setType(MenuType.VIEW);
//		returnURL = oauthAPI.getOauthPageUrl(WeixinToolsController.REDIRECTURL_MEMBER_BIND, OauthScope.SNSAPI_USERINFO, "health");
//		sub3.setUrl(returnURL);
		
		List<MenuButton> list = new ArrayList<MenuButton>();
		list.add(sub0);
		//list.add(sub1);
		//list.add(sub2);
		//list.add(sub3);
		
		// 将子菜单放入主菜单里
		main1.setSubButton(list);
		
		
		
		// 准备一级主菜单
		MenuButton main2 = new MenuButton();
		main2.setType(MenuType.CLICK);
		main2.setKey("main1");
		main2.setName("商户");
		
		MenuButton sub20 = new MenuButton();
		sub20.setKey("cancellation");
		sub20.setName("订单");
		sub20.setType(MenuType.VIEW);
	    returnURL = oauthAPI.getOauthPageUrl(WeixinToolsController.REDIRECTURL_MEMBER_Manager, OauthScope.SNSAPI_USERINFO, "orderinfo");
		sub20.setUrl(returnURL);
		
		MenuButton sub30 = new MenuButton();
		sub30.setKey("doaccount");
		sub30.setName("扫码");
		sub30.setType(MenuType.SCANCODE_WAITMSG);
//	    returnURL = oauthAPI.getOauthPageUrl(WeixinToolsController.REDIRECTURL_MEMBER_Manager, OauthScope.SNSAPI_BASE, "cancellation");
//	 	sub30.setUrl(returnURL);
//		
//		MenuButton sub40 = new MenuButton();
//		sub40.setKey("managermbr");
//		sub40.setName("会员");
//		sub40.setType(MenuType.VIEW);
//	    returnURL = oauthAPI.getOauthPageUrl(WeixinToolsController.REDIRECTURL_MEMBER_Manager, OauthScope.SNSAPI_USERINFO, "managermbr");
//		sub40.setUrl(returnURL);
		
		
		List<MenuButton> list2 = new ArrayList<MenuButton>();
		list2.add(sub20);
		list2.add(sub30);
	//	list2.add(sub40);
		
		main2.setSubButton(list2);
		
		
		
		MenuButton main3 = new MenuButton();
		main3.setType(MenuType.CLICK);
		main3.setKey("main1");
		main3.setName("更多");
		
		//关于我们
		MenuButton sub40 = new MenuButton();
		sub40.setKey("doaccount");
		sub40.setName("关于我们");
		sub40.setType(MenuType.MEDIA_ID);
		sub40.setMediaid("HpdnVyF885rAULHF1gr57zHm8wpei6wIfRX1X7ryZJY");
		
		//帮助中心
		MenuButton sub50 = new MenuButton();
		sub50.setKey("doaccount");
		sub50.setName("帮助中心");
		sub50.setType(MenuType.MEDIA_ID);
		sub50.setMediaid("koGl5gU6XCUctP4CCSVcOaFF4ffVY3nMJq2r2Yvr4w4");
		
		
		List<MenuButton> list3 = new ArrayList<MenuButton>();
		list3.add(sub40);
		list3.add(sub50);
		
		main3.setSubButton(list3);

		List<MenuButton> mainList = new ArrayList<MenuButton>();
		mainList.add(main1);
		mainList.add(main2);
		mainList.add(main3);
		// 将主菜单加入请求对象
		request.setButton(mainList);
		LOG.info(request.toJsonString());
		// 创建菜单
		ResultType resultType = menuAPI.createMenu(request);
		LOG.info(resultType.toString());
	}
	
	public static void main(String[] args){
		//ApiConfig config = new ApiConfig("wx7716b3d1dd94acbe","e98bf4ae7b589560cbb34cf96e8efc61",true);
		
		ApiConfig config = new ApiConfig("wx649e8ead28dafbc3","c438640006313c334be01c4012b0d16e",true);
		WashcarMenuManager hplushMenuManager = new WashcarMenuManager();
		hplushMenuManager.createMenu(config);
	}
}
