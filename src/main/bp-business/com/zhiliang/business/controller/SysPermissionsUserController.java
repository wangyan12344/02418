package com.zhiliang.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiliang.business.service.SysPermissionsUserService;
import com.zhiliang.persistence.entity.SysPermissionsUser;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;

/**
 * SysPermissionsUser 的Controller
 * @author 
 */
@Controller
@RequestMapping("/SysPermissionsUserController")
public class SysPermissionsUserController {

	@Resource
	private SysPermissionsUserService sysPermissionsUserService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/SysPermissionsUser/SysPermissionsUser_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/SysPermissionsUser/SysPermissionsUser_add";
	}
	
	/**
	 * @description 转向角色用户信息修改页面
	 * @author 
	 * @updateAuthor 
	 * @param 
	 * @return String
	 * @created 2015年9月29日 下午1:19:21
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/SysPermissionsUser/SysPermissionsUser_update";
	}

	/**
	 * 查询角色用户信息信息
	 * @param SysPermissionsUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/querySysPermissionsUserPageList.json")
	public @ResponseBody JSONMap<String, Object> querySysPermissionsUserPageList(@FormModel SysPermissionsUser sysPermissionsUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<SysPermissionsUser> list = sysPermissionsUserService.querySysPermissionsUserPageList(sysPermissionsUser,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<SysPermissionsUser>");
			
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	/**
	 * 保存角色用户信息信息
	 * @param SysPermissionsUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddSysPermissionsUser.json")
	public @ResponseBody JSONMap<String, Object> saveAddSysPermissionsUser(@FormModel SysPermissionsUser sysPermissionsUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = sysPermissionsUserService.saveAddSysPermissionsUser(sysPermissionsUser);
			if(flag>0){
				model.put("data", sysPermissionsUser, "SysPermissionsUser");
				model.put(SysConstant.OP_FLAG, true);
				model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
			}else{
				model.put(SysConstant.OP_FLAG, false);
				model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	/***
	 * 读取指定的角色用户信息信息
	 * @param ckGoods
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadSysPermissionsUser.json")
	public @ResponseBody JSONMap<String,Object> loadSysPermissionsUser(@FormModel SysPermissionsUser sysPermissionsUser, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			SysPermissionsUser entity = sysPermissionsUserService.getSysPermissionsUserById(sysPermissionsUser);
			model.put("entity", entity);
			
			
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	/**
	 * 修改角色用户信息信息
	 * @param SysPermissionsUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateSysPermissionsUser.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateSysPermissionsUser(@FormModel SysPermissionsUser sysPermissionsUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = sysPermissionsUserService.saveUpdateSysPermissionsUser(sysPermissionsUser);
			if(flag>0){
				model.put(SysConstant.OP_FLAG, true);
				model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
			}else{
				model.put(SysConstant.OP_FLAG, false);
				model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	/**
	 * @description 删除角色用户信息信息
	 * @author 
	 * @updateAuthor 
	 * @param 
	 * @return JSONMap<String,Object>
	 * @created 2015年9月29日 下午2:54:09
	 */
	@RequestMapping("/deleteSysPermissionsUser.json")
	public @ResponseBody JSONMap<String, Object> deleteSysPermissionsUser(@FormModel SysPermissionsUser sysPermissionsUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   sysPermissionsUser = sysPermissionsUserService.getSysPermissionsUserById(sysPermissionsUser);
			int flag = sysPermissionsUserService.deleteSysPermissionsUser( sysPermissionsUser);
			model.put("flag", flag);
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.FAIL);
		}
		return model;
	}
	
	
}
