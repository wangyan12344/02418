package com.repast.core.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.repast.core.constant.SysConstant;
import com.repast.core.service.LoginManagerService;
import com.repast.core.service.SysResourceService;
import com.repast.core.service.SysRoleResourceService;
import com.repast.core.spring.auth.Author;
import com.repast.core.spring.auth.CheckType;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Processor;
import com.repast.core.util.CommonUtil;
import com.repast.core.util.NetworkUtil;
import com.repast.persistence.entity.TraderPauUrl;
import com.zhiliang.persistence.entity.SysMenuInfo;
import com.zhiliang.persistence.entity.SysUserInfo;

@Controller
@RequestMapping("/loginManagerController")
public class LoginManagerController {
	@Resource
	private LoginManagerService loginManagerService;
	
	@Resource
	private SysRoleResourceService sysRoleResourceService;
	
	@Resource
	private SysResourceService sysResourceService;
	@Resource(name="TraderPauUrl")
	private TraderPauUrl traderPauUrl;
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/showLoginPage")
	public String showLoginPage(HttpServletRequest request,HttpServletResponse response){
		request.getSession().setMaxInactiveInterval(1);
		return "/foodms/login/login";
	}
	
	/**
	 * 跳转到登录后首页
	 * @param request
	 * @param response
	 * @return
	 */
	@Author(type=CheckType.CHECK_LOGIN)
	@RequestMapping("/showManipage")
	public String showManipage(HttpServletRequest request,
			HttpServletResponse response,Model model){
		String shopid = request.getParameter("shopid");//店铺id
		String currentUserId = request.getParameter("currentUserId");//用户id
		String orgid = request.getParameter("orgid");//角色id
		//设置当前登录到前台中
		model.addAttribute("sys_hidden_currentUserId",currentUserId);
		model.addAttribute("sys_hidden_shopid",shopid);
		model.addAttribute("sys_hidden_orgid",orgid);

		model.addAttribute("sys_hidden_ipaddress", NetworkUtil.getRemoteHost(request));
		if(!StringUtils.isNullOrEmpty(currentUserId)){
			SysUserInfo user = loginManagerService.getSysUserInfoById(currentUserId);
			if(user!=null){
				model.addAttribute("sys_hidden_currentUsername", user.getUsername());
			}
		}
		
		return "/foodms/main/main";
	}
	
	/**
	 * 校验用户民／密码
	 * @param request
	 * @param response
	 * @return
	 */
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/checkSysUserInfo.json")
	public @ResponseBody JSONMap<String,Object> checkSysUserInfo(@FormModel SysUserInfo sysUserInfo,HttpServletRequest request,
			HttpServletResponse response,@FormModel Processor processor){
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			if(processor!=null)
			 processor.setIpaddress(NetworkUtil.getRemoteHost(request));
			 SysUserInfo sysUserinfo = loginManagerService.querySysUserInfo(sysUserInfo,processor);
			 List <SysMenuInfo> menuList = null;
			 if(sysUserinfo!=null){
				 
				 String userid = sysUserinfo.getUserid();
				 menuList = sysRoleResourceService.queryMenuListByRoleIdAntType(userid,"2","-1");
				 request.getSession().setAttribute(SysConstant.SESSION_LOGIN, SysConstant.SESSION_LOGIN_PASS);
				 request.getSession().setAttribute("WEBSITE",traderPauUrl.getUrl());
			 }
			 model.put(SysConstant.OP_FLAG, sysUserinfo==null?false:true);
			 model.put("sysResourcelist", menuList);
			 model.put("sysUserinfo", sysUserinfo);
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
		}
		return model;
	}
	
	/**
	 * 根据type（1为pc端，2为手机端）查询菜单内容
	 * @author lingy
	 * @date 2015年9月9日 下午5:19:39
	 * @param userid
	 * @param menutype
	 * @param processor
	 * @return
	 */
	@RequestMapping("/querySysResourceBytype.json")
	public @ResponseBody JSONMap<String,Object> querySysResourceBytype(@RequestParam String userid,@RequestParam String menutype,@FormModel Processor processor){
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			List<SysMenuInfo> menuList = sysRoleResourceService.queryMenuListByRoleIdAntType(userid,menutype,"-1");
			model.put("menuList", menuList);
		}catch(Exception e){
			model.put("message", SysConstant.Exception);
		}
		
		return model;
	}

	
}