package com.zhiliang.business.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.zhiliang.business.service.SysRoleInfoService;
import com.zhiliang.persistence.dto.MenuTreeDTO;
import com.zhiliang.persistence.entity.SysRoleInfo;
import com.zhiliang.persistence.entity.SysRoleMenu;

/**
 * 
 * @author lingy
 * SysRoleInfoController.java
 */
@Controller
@RequestMapping("/SysRoleInfoController")
public class SysRoleInfoController {

	@Resource
	private SysRoleInfoService sysRoleInfoService;
	
	
	/**
	 * 人员列表页
	 * @author lingy
	 * @date 2015年9月14日 上午9:38:01
	 * @return
	 */
	@RequestMapping("/defaultJsp")
	public String defaultJsp()
	{
		return "repair/sysroleinfo/sysroleinfo_list";
	}
	
	/**
	 * 查询数据
	 * @param 
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryDataList.json")
	public @ResponseBody JSONMap<String,Object> queryDataList(@FormModel SysRoleInfo sysRoleInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysRoleInfo.setOrgid(processor.getOrgid());
			Pagination<SysRoleInfo> roleList = sysRoleInfoService.querySysRoleInfoList(sysRoleInfo, processor.getPageIndex(),processor.getPageSize());
//			UIDataConvert<SysRoleInfo> convert = new UIDataConvert<SysRoleInfo>();
//			IConvert orgid = new SqlMapConvertImpl("orgid", "orgid", "cs_organization_info", "orgname", "orgid", "");
//			convert.addConvert(orgid);
//			convert.format(roleList);
			model.put("data", roleList);
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
	 * 
	 * @author lingy
	 * @date 2015年9月14日 下午4:51:36
	 * @param sysRoleInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/beforeAddEntity.json")
	public @ResponseBody JSONMap<String,Object> beforeAddEntity(@FormModel SysRoleInfo sysRoleInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			List<MenuTreeDTO> menuTreeList = sysRoleInfoService.getMenuTreeListByUserid("");
			model.put("zNodes", menuTreeList);
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
	 * 新增系统角色信息
	 * @author lingy
	 * @date 2015年9月15日 上午9:30:41
	 * @param sysRoleInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/addEntityData.json")
	public @ResponseBody JSONMap<String,Object> addEntityData(@FormModel SysRoleInfo sysRoleInfo,@FormModel("roleMenuList") List<SysRoleMenu> roleMenuList,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			String orgid = processor.getOrgid();
			sysRoleInfo.setOrgid(orgid);
			sysRoleInfoService.saveSysUserRoleAndRoleMenu(sysRoleInfo,roleMenuList);
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
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午9:47:00
	 * @param sysRoleInfo
	 * @param roleMenuList
	 * @param processor
	 * @return
	 */
	@RequestMapping("/updateEntityData.json")
	public @ResponseBody JSONMap<String,Object> updateEntityData(@FormModel SysRoleInfo sysRoleInfo,@FormModel("roleMenuList") List<SysRoleMenu> roleMenuList,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			String orgid = processor.getOrgid();
			sysRoleInfo.setOrgid(orgid);
			sysRoleInfoService.updateSysUserRoleAndRoleMenu(sysRoleInfo,roleMenuList);
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
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午9:40:21
	 * @param sysRoleInfo
	 * @param roleMenuList
	 * @param processor
	 * @return
	 */
	@RequestMapping("/deleteEntityData.json")
	public @ResponseBody JSONMap<String,Object> deleteEntityData(@FormModel SysRoleInfo sysRoleInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysRoleInfoService.deleteSysRoleInfo(sysRoleInfo);
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
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午9:44:44
	 * @param sysRoleInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/beforeUpdateEntity.json")
	public @ResponseBody JSONMap<String,Object> beforeUpdateEntity(@FormModel SysRoleInfo sysRoleInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			String roleid = sysRoleInfo.getRoleid();
			List<MenuTreeDTO> menuTreeList = sysRoleInfoService.getMenuTreeListByUserid(roleid);
			SysRoleInfo entity = sysRoleInfoService.getSysRoleInfoByRoleid(roleid);
			model.put("zNodes", menuTreeList);
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
	 * 
	 * @author lingy
	 * @date 2015年9月14日 下午4:51:36
	 * @param sysRoleInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/getNewsClassTree.json")
	public @ResponseBody JSONMap<String,Object> getNewsClassTree(@FormModel SysRoleInfo sysRoleInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			String userid=processor.getCurrentUserId();
			List<MenuTreeDTO> menuTreeList = sysRoleInfoService.getNewsClassTree(userid);
			model.put("zNodes", menuTreeList);
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
}
