package com.zhiliang.business.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.repast.core.constant.SysConstant;
import com.repast.core.spring.auth.Author;
import com.repast.core.spring.auth.CheckType;
import com.repast.core.tool.zxing.client.QRcodeFactory;
import com.repast.weixin.fastweixin.api.OauthAPI;
import com.repast.weixin.fastweixin.api.config.ApiConfig;
import com.repast.weixin.fastweixin.api.enums.OauthScope;
import com.repast.weixin.fastweixin.api.response.GetUserInfoResponse;
import com.repast.weixin.fastweixin.api.response.OauthGetTokenResponse;
import com.repast.weixin.fastweixin.util.SignUtil;

/**
 * 微信操作处理工具类
 * 
 * @author luandong
 *
 */
@Controller
@RequestMapping("/WeixinToolsController")
public class WeixinToolsController {

	
	/**
	 * 认证后绑定教练的地址
	 */
	public static String REDIRECTURL_COACH_BIND = "http://hplush.qyhz.net.cn/hp/WeixinToolsController/weixin/oauth/bindcoach.do";
	
	/**
	 * 扫描后的教练确认处理
	 */
	public static String REDIRECTURL_COACH_DOCOACHCONFIRM = "http://hplush.qyhz.net.cn/hp/WeixinToolsController/weixin/oauth/docoachconfirm.do";
	
	/**
	 * 教练管理的请求地址
	 */
	public static String REDIRECTURL_MEMBER_Manager = "http://weixin.ggcgj.com/washcar/WeixinToolsController/weixin/oauth/forwardShopLogin.do";
	

	/**
	 * 绑定会员的请求地址---微信会员菜单
	 */
	public static String REDIRECTURL_MEMBER_BIND = "http://weixin.ggcgj.com/washcar/WeixinToolsController/weixin/oauth/bindmember.do";
	
	public static String REDIRECTURL_COACH_CONFIRM = "http://hplush.qyhz.net.cn/hp/upload/foodms/confirm.jpg";
	
	/**
	 * 扫描后使用优惠券跳转到商户列表页
	 */
	public static String TOSHOPLIST = "http://weixin.ggcgj.com/washcar/CarForMobileController/toshoplist.do";
	

	/**
	 * 扫描后使用优惠券跳转到确认页
	 */
	public static String USECARD = "http://weixin.ggcgj.com/washcar/CarForMobileController/usecard.do";
	
//	@Resource
	private ApiConfig apiConfig;// = (ApiConfig)
								// com.repast.core.tool.ApplicationContextUtil.getBean("apiConfig");

//	@Resource
//	private CarWeiXinUserService carWeiXinUserService;
//	
//	@Resource
//	private CmsMemberBaseInfoService cmsMemberBaseInfoService;

	/**
	 * 生成绑定地址的二维码图片 根据微信的oauth验证地址，生成二维码图片，引导用户进行授权
	 * bizId为业务表中用户ID，微信验证后将会把这个参数转发回来，根据这个参数进行业务数据表的更新操作
	 * 
	 * @param request
	 * @param response
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping(value = "/image/get")
	public void getBindQRImage(HttpServletRequest request, HttpServletResponse response) {

		String bizId = request.getParameter("bizId");
		String width = request.getParameter("width") == null ? "200" : request.getParameter("width");
		String height = request.getParameter("height") == null ? "200" : request.getParameter("height");

		String savePath = request.getSession().getServletContext().getRealPath("/") + "\\" + "upload\\";
		String imagePath = savePath + "temp_" + bizId + ".jpg";
		FileInputStream fis = null;
		response.setContentType("image/gif");
		try {

			OauthAPI oauthAPI = new OauthAPI(apiConfig);
			String returnURL = oauthAPI.getOauthPageUrl(REDIRECTURL_COACH_BIND, OauthScope.SNSAPI_USERINFO, bizId);

			QRcodeFactory.getInstance()
					.createQrCode(returnURL, Integer.parseInt(width), Integer.parseInt(height), imagePath);

			OutputStream out = response.getOutputStream();
			File file = new File(imagePath);
			fis = new FileInputStream(file);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			out.write(b);
			out.flush();
			// 删除二维码图片
			file.delete();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 转身到确认订单页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping(value = "/weixin/oauth/docoachconfirm")
	public String doCoachConfirm(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String code = request.getParameter("code");
		OauthAPI oauthAPI = new OauthAPI(apiConfig);
		OauthGetTokenResponse authToken = oauthAPI.getToken(code);
		String openId = authToken.getOpenid();
		
//		//加载教练信息
//		CmsWeiXinUser cmsWeiXinUser = new CmsWeiXinUser();
//		cmsWeiXinUser.setOpenid(openId);
//		cmsWeiXinUser.setUsertype(CmsWeiXinUserService.USER_TYPE_COCAH);
//		cmsWeiXinUser = cmsWeiXinUserService.getCmsWeiXinUserByEntiy(cmsWeiXinUser);
//		if(cmsWeiXinUser!=null){
//			model.addAttribute("COACH_OPENID", cmsWeiXinUser.getOpenid());
//			model.addAttribute("CURRENTUSERID", cmsWeiXinUser.getMemberid());
//		}
//		else 
//			model.addAttribute("COACH_OPENID", null);
//		
//		//加载会员信息
//		String[] concatStr = request.getParameter("state").split(",");
//		
//		String memger_memberId = concatStr[0]; // 传递教练基本信息表中的coachId
////		CmsMemberBaseinfo cmsMemberBaseinfo = new CmsMemberBaseinfo();
////		cmsMemberBaseinfo.setMemberid(memger_memberId);
////		cmsMemberBaseinfo = cmsMemberBaseInfoService.getMemberBaseInfo(cmsMemberBaseinfo);
////		model.addAttribute("cmsMemberBaseinfo", cmsMemberBaseinfo);
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String curDay = df.format(new java.util.Date());
//		model.addAttribute("curDay", curDay);
//		
//		model.addAttribute("curCheckCode", concatStr[1]);
		return "/weixin/coach/confirmClass";
	}
	

	/**
	 * 绑定教练，获取教练的微信信息
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping(value = "/weixin/oauth/bindcoach")
	public String bindCoach(HttpServletRequest request, HttpServletResponse response, Model model) {

		String code = request.getParameter("code");
		String state = request.getParameter("state"); // 传递教练基本信息表中的coachId
		String coachid = state;
		model.addAttribute("coachid", state);

		OauthAPI oauthAPI = new OauthAPI(apiConfig);
		OauthGetTokenResponse authToken = oauthAPI.getToken(code);
		String openId = authToken.getOpenid();

		GetUserInfoResponse userInfo = oauthAPI.getUserInfo(authToken.getAccessToken(), openId);
		model.addAttribute("userInfo", userInfo);
		
		
//		CmsWeiXinUser cmsWeiXinUser = new CmsWeiXinUser();
//		cmsWeiXinUser.setOpenid(openId);
//		cmsWeiXinUser.setUsertype(CmsWeiXinUserService.USER_TYPE_COCAH);
//		cmsWeiXinUser.setMemberid(coachid);
//		cmsWeiXinUser = cmsWeiXinUserService.getCmsWeiXinUserByEntiy(cmsWeiXinUser);
//		
//		model.addAttribute("coachInfo", cmsWeiXinUser);
		
		return "/weixin/coach/bindaccount";

	}
	
	
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping(value = "/weixin/oauth/bind")
	public String coachManager(HttpServletRequest request, HttpServletResponse response, Model model) {
		//request.getSession().setAttribute("COACH_OPENID", "o4-iajgzj4DJHq0Yz0a4-mMU33DA");

		String openId;
		OauthAPI oauthAPI = null;
		OauthGetTokenResponse authToken = null;
		
		request.getSession().setAttribute("USERTYPE","COACH");

		// 1 首先从session中获取OPENID，如果存在就以session中的openID为准，否则重新根据code获取
		if (request.getSession().getAttribute("COACH_OPENID") == null) {
			String code = request.getParameter("code");
			oauthAPI = new OauthAPI(apiConfig);
			authToken = oauthAPI.getToken(code);
			openId = authToken.getOpenid();
			request.getSession().setAttribute("COACH_OPENID", openId);
		} else {
			openId = (String) request.getSession().getAttribute("COACH_OPENID");
		}

		// 2 查询业务数据库，检查是否已经绑定此会员，如果绑定过了转向到个人信息页面，没绑定过的转至注册页面
//		CmsWeiXinUser cmsWeiXinUser = new CmsWeiXinUser();
//		cmsWeiXinUser.setOpenid(openId);
//		cmsWeiXinUser.setUsertype(CmsWeiXinUserService.USER_TYPE_COCAH);
//		cmsWeiXinUser = cmsWeiXinUserService.getCmsWeiXinUserByEntiy(cmsWeiXinUser);

//		if (cmsWeiXinUser != null && cmsWeiXinUser.getMemberid() != null) {
//
//			model.addAttribute("coachid", cmsWeiXinUser.getMemberid());
//			request.getSession().setAttribute("CURRENTUSERID", cmsWeiXinUser.getMemberid());
//			String forwardPage = "";
//			// 3 已经注册过了，根据state转向到不同的页面
//			switch (state) {
//			case "cancellation":
//				// 【预约处理页面】
//				forwardPage = "/weixin/coach/cancellation";
//				break;
//			case "doaccount":
//				// 【销课页面】
//				forwardPage = "/weixin/member/appointment";
//				break;
//			case "managermbr":
//				// 【会员页面】
//				forwardPage = "/weixin/member/myPay";
//				break;
//			default:
//				;
//			}
//
//			return forwardPage;
//
//		} else {
//			// 没有注册成为教练，转到不能使用的页面中
//			
			return "/weixin/coach/notcoach";
//		}
	}

	/**
	 * 绑定会员，获取会员信息
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping(value = "/weixin/oauth/bindmember")
	public String bindMember(HttpServletRequest request, HttpServletResponse response, Model model) {

		String openId;
		OauthAPI oauthAPI = null;
		OauthGetTokenResponse authToken = null;
		//String state = request.getParameter("state");
		request.getSession().setAttribute("USERTYPE","MEMBER");
		String forwardPage = "";
		// 1 首先从session中获取OPENID，如果存在就以session中的openID为准，否则重新根据code获取
		if (request.getSession().getAttribute("OPENID") == null) {
			String code = request.getParameter("code");
			oauthAPI = new OauthAPI(apiConfig);
			authToken = oauthAPI.getToken(code);
			openId = authToken.getOpenid();
			request.getSession().setAttribute("OPENID", openId);
		} else {
			openId = (String) request.getSession().getAttribute("OPENID");
		}
		
		//判断openid是否已经绑定
//		CarWeiXinUser weixinUser = new CarWeiXinUser();
//		weixinUser.setOpenid(openId);
//		weixinUser.setUsertype(CarWeiXinUserService.USER_TYPE_MEMBER);
//		weixinUser = carWeiXinUserService.getCarWeiXinUserByEntiy(weixinUser);
//		if (weixinUser != null && weixinUser.getMemberid() != null) {
//			model.addAttribute("memberid", weixinUser.getMemberid());	
//			request.setAttribute("memeberid", weixinUser.getMemberid());
//			request.getSession().setAttribute("CURRENTUSERID", weixinUser.getMemberid());
//			Map<String, String> ret = SignUtil.sign(apiConfig.getJsApiTicket(), "http://weixin.ggcgj.com");
//			  for (Map.Entry entry : ret.entrySet()) {
//		            request.setAttribute((String)entry.getKey(), entry.getValue());
//		        }
//			 
//			forwardPage = "/weixin/jsp/client/storelist";
//		}
//		else
//		{	
//
//			String code = request.getParameter("code");
//			oauthAPI = new OauthAPI(apiConfig);
//			if(authToken==null){
//			authToken = oauthAPI.getToken(code);
//			openId = authToken.getOpenid();
//			}
//			GetUserInfoResponse userInfo = oauthAPI.getUserInfo(authToken.getAccessToken(), openId);
//			userInfo.setOpenid(openId);
//			model.addAttribute("userInfo", userInfo);
//			forwardPage = "/weixin/jsp/client/login";
//			//model.addAttribute("state", state);
//		}
			return forwardPage;
	}
	
	/**
	 * 转向商户登陆
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping(value = "/weixin/oauth/forwardShopLogin")
	public String forwardShopLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		  String forwardPage = "";
		  if(SysConstant.SESSION_LOGIN_PASS.equals(request.getSession().getAttribute(SysConstant.SESSION_LOGIN)))
		  {
			  
			  forwardPage = "/weixin/jsp/shop/orderList.jsp?shopid="+(String)request.getSession().getAttribute("shopid");
		  }
		  else
		  {
			  forwardPage = "/weixin/jsp/shop/store_login";
		  }
		  return forwardPage;
	}
}
