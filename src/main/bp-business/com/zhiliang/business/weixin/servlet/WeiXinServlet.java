package com.zhiliang.business.weixin.servlet;

import javax.servlet.annotation.WebServlet;

import com.repast.weixin.fastweixin.servlet.WeixinServletSupport;
import com.repast.weixin.fastweixin.servlet.WeixinSupport;

/**
 * 微信接入类
 * 
 * @author luandong
 *
 */
@WebServlet("/servlet/weixin.action")
public class WeiXinServlet extends WeixinServletSupport {
	private static final long serialVersionUID = 2829528121209399547L;

	@Override
	protected WeixinSupport getWeixinSupport() {
		return new MyServletWeixinSupport();
	}
}
