package com.zhiliang.business.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.repast.core.codelist.SysCodelist;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.repast.core.uiview.format.IConvert;
import com.repast.core.uiview.format.UIDataConvert;
import com.repast.core.uiview.format.impl.SqlMapConvertImpl;
import com.zhiliang.business.service.SysRoleInfoService;
import com.zhiliang.business.service.SysUserInfoService;
import com.zhiliang.persistence.dto.MenuTreeDTO;
import com.zhiliang.persistence.entity.SysRoleInfo;
import com.zhiliang.persistence.entity.SysRoleMenu;
import com.zhiliang.persistence.entity.SysRoleUser;
import com.zhiliang.persistence.entity.SysUserInfo;
import com.zhiliang.persistence.entity.SysUserShop;
import com.zhiliang.persistence.entity.SysUseridCategoryid;

/**
 * 
 * @author lingy
 * CsUserInfoController.java
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/SysUserInfoController")
public class SysUserInfoController {

	@Resource
	private SysUserInfoService sysUserInfoService;
	
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
		return "repair/systemuser/systemuser_list";
	}
	@RequestMapping("/defaultJspuser")
	public String defaultJspuser()
	{
		return "repair/systemuser/systemuser_list_user";
	}
	/**
	 * 信息发布统计
	 * @author lingy
	 * @date 2015年9月14日 上午9:38:01
	 * @return
	 */
	@RequestMapping("/countlist")
	public String countlist()
	{
		return "repair/systemuser/systemuser_list_countlist";
	}
	/**
	 * 用户可管理店铺
	 * @author lingy
	 * @date 2015年9月14日 上午9:37:16
	 * @return
	 */
	@RequestMapping("/addManageShop")
	public String addManageShop()
	{
		return "repair/systemuser/user_mshop_add";
	}
	
	/**
	 * @description 转向商城用户密码修改页面
	 * @author 马骞
	 * @param 
	 * @return String
	 */
	@RequestMapping("/changpw") 
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model,Processor processor) {
		
		
		return "zhiliangshop/ShopUserChangePw/shopuserchangepw_update";
	}
	/**
	 * 查询数据
	 * @param 
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryDataList.json")
	public @ResponseBody JSONMap<String,Object> queryDataList(@FormModel SysUserInfo sysUserInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//sysUserInfo.setOrgid(processor.getOrgid());
			Pagination<SysUserInfo> userList = sysUserInfoService.querySysUserInfoList(sysUserInfo, processor.getPageIndex(),processor.getPageSize());
			UIDataConvert<SysUserInfo> convert = new UIDataConvert<SysUserInfo>();
//			IConvert orgid = new SqlMapConvertImpl("orgid", "orgid", "cs_organization_info", "orgname", "orgid", "");
//			IConvert shopid = new SqlMapConvertImpl("shopid", "shopid", "cs_shop_info", "shopname", "shopid", "");
			IConvert sex = new SqlMapConvertImpl("gender", "gender", "sys_codelist", "codename", "codevalue", " and T.kindCode = 'sex' ");
			IConvert yesorno = new SqlMapConvertImpl("userstatus", "userstatus", "sys_codelist", "codename", "codevalue", " and T.kindCode = 'yesorno' ");
//			convert.addConvert(orgid);
			convert.addConvert(yesorno);
			convert.addConvert(sex);
//			convert.addConvert(shopid);
			convert.format(userList);
			model.put("data", userList);
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
	 * @date 2015年9月10日 下午3:53:12
	 * @param processor
	 * @return
	 */
	@RequestMapping("/beforeAddEntity.json")
	public @ResponseBody JSONMap<String,Object> beforeAddEntity(@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			String orgid = processor.getOrgid();
//			List<CsShopInfo> shopList = sysUserInfoService.getCsShopInfoListByOrgid(orgid);
			SysCodelist sysCodelist = new SysCodelist();
			sysCodelist.setKindcode("sex");
			List<SysCodelist> sex = sysUserInfoService.getCodeList(sysCodelist);
			sysCodelist.setKindcode("yesorno");
			List<SysCodelist> yesorno = sysUserInfoService.getCodeList(sysCodelist);
			sysCodelist.setKindcode("USER_TYPE");
			List<SysCodelist> USERTYPE = sysUserInfoService.getCodeList(sysCodelist);
			List<SysRoleInfo> roleList = sysUserInfoService.getSysUserRoleListByOrgid(orgid,"");
//			model.put("shopList", shopList);
			model.put("sex", sex);
			model.put("yesorno", yesorno);
			model.put("USERTYPE", USERTYPE);
			model.put("roleList", roleList);
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
	 * @date 2015年9月11日 上午11:53:30
	 * @param sysUserInfo
	 * @param roleUserList
	 * @param processor
	 * @return
	 */
	@RequestMapping("/addEntityData.json")
	public @ResponseBody JSONMap<String,Object> addEntityData(@FormModel SysUserInfo sysUserInfo,@FormModel("roleMenuList") List<SysUseridCategoryid> roleMenuList,@FormModel("roleUserList") List<SysRoleUser> roleUserList,
			@FormModel("userShopList") List<SysUserShop> userShopList, @FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			String orgid = processor.getOrgid();
			sysUserInfo.setOrgid(orgid);
			sysUserInfoService.saveSysUserInfoAndUserRole(sysUserInfo,roleUserList,userShopList,roleMenuList);
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
	 * @date 2015年9月11日 下午1:34:25
	 * @param sysUserInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/beforeUpdateEntity.json")
	public @ResponseBody JSONMap<String,Object> beforeUpdateEntity(@FormModel SysUserInfo sysUserInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			String orgid = processor.getOrgid();
//			List<CsShopInfo> shopList = sysUserInfoService.getCsShopInfoListByOrgid(orgid);
			SysCodelist sysCodelist = new SysCodelist();
			sysCodelist.setKindcode("sex");
			List<SysCodelist> sex = sysUserInfoService.getCodeList(sysCodelist);
			sysCodelist.setKindcode("yesorno");
			List<SysCodelist> yesorno = sysUserInfoService.getCodeList(sysCodelist);
			sysCodelist.setKindcode("USER_TYPE");
			List<SysCodelist> USERTYPE = sysUserInfoService.getCodeList(sysCodelist);
			
			String userid = sysUserInfo.getUserid();
			List<SysRoleInfo> roleList = sysUserInfoService.getSysUserRoleListByOrgid(orgid,userid);
			SysUserInfo entity = sysUserInfoService.getSysUserInfoById(sysUserInfo);
//			List<SysUserShop> userShopList = sysUserInfoService.getSysUserShopListByUserid(orgid,userid);
			List<MenuTreeDTO> menuTreeList = sysRoleInfoService.getClassMenuTreeListByUserid(userid);
			model.put("zNodes", menuTreeList);
			model.put("entity", entity);
//			model.put("shopList", shopList);
			model.put("USERTYPE", USERTYPE);
			model.put("sex", sex);
			model.put("yesorno", yesorno);
			model.put("roleList", roleList);
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
	 * @date 2015年9月11日 下午1:52:44
	 * @param sysUserInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/updateEntityData.json")
	public @ResponseBody JSONMap<String,Object> updateEntityData(@FormModel SysUserInfo sysUserInfo,@FormModel("roleUserList") List<SysRoleUser> roleUserList,
			@FormModel("userShopList") List<SysUserShop> userShopList,@FormModel("roleMenuList") List<SysUseridCategoryid> roleMenuList,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysUserInfo.setOrgid(processor.getOrgid());
			sysUserInfoService.updateSysUserInfo(sysUserInfo,roleUserList,userShopList,roleMenuList);
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
	 * 停用用户信息
	 * @author lingy
	 * @date 2015年9月11日 下午1:54:04
	 * @param sysUserInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/stopEntityData.json")
	public @ResponseBody JSONMap<String,Object> stopEntityData(@FormModel SysUserInfo sysUserInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysUserInfoService.stopSysUserInfo(sysUserInfo);
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
	 * 删除用户信息
	 * @author lingy
	 * @date 2015年9月11日 下午1:54:00
	 * @param sysUserInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/deleteEntityData.json")
	public @ResponseBody JSONMap<String,Object> deleteEntityData(@FormModel SysUserInfo sysUserInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysUserInfoService.deleteSysUserInfo(sysUserInfo);
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
	 * @author lingy
	 * @date 2015年9月25日 下午2:43:27
	 * @param sysUserInfo
	 * @param processor
	 * @return
	 */
	@RequestMapping("/checkAccountUnique.json")
	public @ResponseBody JSONMap<String,Object> checkAccountUnique(@FormModel SysUserInfo sysUserInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			int flag = sysUserInfoService.checkAccountUnique(sysUserInfo);
			if(flag<=0){
				model.put(SysConstant.OP_FLAG, true);
				model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
			}else{
				model.put(SysConstant.OP_FLAG, false);
				model.put(SysConstant.OP_MESSAGE, "账号已存在，请重新输入！");
			}
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	/**
	 * 商城用户密码更改
	 * @param sysUserInfo
	 * @param processor
	 * @return
	 * @author 马骞
	 */

	@RequestMapping("/beforeUpdatePassWordEntity.json")
	public @ResponseBody JSONMap<String,Object> beforeUpdatePassWordEntity(@FormModel SysUserInfo sysUserInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			String orgid = processor.getOrgid();
			String userid=processor.getCurrentUserId();
			List<SysRoleInfo> roleList = sysUserInfoService.getSysUserRoleListByOrgid(orgid,userid);
			SysUserInfo entity = sysUserInfoService.getSysUserInfoDataById(sysUserInfo,processor);
			model.put("entity", entity);
			model.put("roleList", roleList);
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
	 * 修改商城用户密码
	 * @param sysUserInfo
	 * @param roleUserList
	 * @param userShopList
	 * @param processor
	 * @return
	 * @author 马骞
	 */
	@RequestMapping("/updateShopUserData.json")
	public @ResponseBody JSONMap<String,Object> updateShopUserData(@FormModel SysUserInfo sysUserInfo,
			@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysUserInfoService.updateShopUserData(sysUserInfo);
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	@RequestMapping("/updateEntityDataPassword.json")
	public @ResponseBody JSONMap<String,Object> updateEntityDataPassword(@FormModel SysUserInfo sysUserInfo,
			@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysUserInfoService.updateEntityDataPassword(sysUserInfo);
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
	 * 查询数据20180909
	 * @param 
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryCountDataList.json")
	public @ResponseBody JSONMap<String,Object> queryCountDataList(@FormModel SysUserInfo sysUserInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			Pagination<SysUserInfo> userList = sysUserInfoService.querySysUserInfoListForCount(sysUserInfo, processor.getPageIndex(),processor.getPageSize());
			UIDataConvert<SysUserInfo> convert = new UIDataConvert<SysUserInfo>();
			IConvert sex = new SqlMapConvertImpl("gender", "gender", "sys_codelist", "codename", "codevalue", " and T.kindCode = 'sex' ");
			IConvert yesorno = new SqlMapConvertImpl("userstatus", "userstatus", "sys_codelist", "codename", "codevalue", " and T.kindCode = 'yesorno' ");
			convert.addConvert(yesorno);
			convert.addConvert(sex);
			convert.format(userList);
			model.put("data", userList);
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
	 * 查询登录账户信息数据
	 * @param 
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryDataListByUserid.json")
	public @ResponseBody JSONMap<String,Object> queryDataListByUserid(@FormModel SysUserInfo sysUserInfo,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysUserInfo.setUserid(processor.getCurrentUserId());
			Pagination<SysUserInfo> userList = sysUserInfoService.querySysUserInfoList(sysUserInfo, processor.getPageIndex(),processor.getPageSize());
			UIDataConvert<SysUserInfo> convert = new UIDataConvert<SysUserInfo>();
			IConvert yesorno = new SqlMapConvertImpl("userstatus", "userstatus", "sys_codelist", "codename", "codevalue", " and T.kindCode = 'yesorno' ");
			convert.addConvert(yesorno);
			convert.format(userList);
			model.put("data", userList);
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
