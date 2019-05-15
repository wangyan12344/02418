package com.zhiliang.business.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.zhiliang.business.service.ZlBTraderUserService;
import com.zhiliang.persistence.entity.ZlBTraderUser;

/**
 * 置粮网
 * Application name: Application describing:交易商用户信息控制层Copyright:Copyright copy;
 * Company:辽宁天富实业发展有限公司
 * WebSite:http://www.palacesun.com
 * ZlBTraderUser 的Controller
 * @author 周杨
 */
@Controller
@RequestMapping("/manager/ZlBTraderUserController")
public class ZlBTraderUserController {

	@Resource
	private ZlBTraderUserService zlBTraderUserService;
	
	
	@RequestMapping("/list")  //个人
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBTraderUser/ZlBTraderUser_list";
	}
	
	@RequestMapping("/list1")  //企业
	public String forwardListPage1()
	{
		return "zhiliang/manager/ZlBTraderUser/ZlBTraderUser_list_c";
	}
	
	@RequestMapping("/add")   //个人添加
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBTraderUser/ZlBTraderUser_add";
	}
	
	@RequestMapping("/add1")   //企业添加
	public String forwardAddPage1()
	{
		return "zhiliang/manager/ZlBTraderUser/ZlBTraderUser_add_c";
	}
	
	/**
	 * @description 转向交易商(个人)用户信息修改页面
	 * @author 周杨
	 * @updateAuthor 周杨
	 * @param 
	 * @return String
	 * @created 2015年9月29日 下午1:19:21
	 */
	@RequestMapping("/update")   //个人修改
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBTraderUser/ZlBTraderUser_update";
	}

	/**
	 * @description 转向交易商用户信息修改页面
	 * @author 周杨
	 * @updateAuthor 周杨
	 * @param 
	 * @return String
	 * @created 2015年9月29日 下午1:19:21
	 */
	@RequestMapping("/update1")  //企业修改
	public String forwardUpdatePage1(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBTraderUser/ZlBTraderUser_update_c";
	}
	
	/**
	 * 查询交易商(个人)用户信息信息
	 * @param ZlBTraderUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBTraderUserPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBTraderUserPageList(@FormModel ZlBTraderUser zlBTraderUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBTraderUser> list = zlBTraderUserService.queryZlBTraderUserPageList(zlBTraderUser,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBTraderUser>");
			
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
	 * 查询交易商(企业)用户信息信息
	 * @param ZlBTraderUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBTraderUserPageList1.json")
	public @ResponseBody JSONMap<String, Object> queryZlBTraderUserPageList1(@FormModel ZlBTraderUser zlBTraderUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBTraderUser> list = zlBTraderUserService.queryZlBTraderUserPageList1(zlBTraderUser,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBTraderUser>");
			
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
	 * 查询交易商(个人)用户信息信息
	 * @param ZlBTraderUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBTraderUserForList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBTraderUserForList(@FormModel ZlBTraderUser zlBTraderUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			List<ZlBTraderUser> list = zlBTraderUserService.queryZlBTraderUserForList(zlBTraderUser);
			model.put("data", list, "List<ZlBTraderUser>");
			
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
	 * 查询交易商(企业)用户信息信息
	 * @param ZlBTraderUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBTraderUserForList1.json")
	public @ResponseBody JSONMap<String, Object> queryZlBTraderUserForList1(@FormModel ZlBTraderUser zlBTraderUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			List<ZlBTraderUser> list = zlBTraderUserService.queryZlBTraderUserForList1(zlBTraderUser);
			model.put("data", list, "List<ZlBTraderUser>");
			
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
	 * 保存交易商(个人)用户信息信息
	 * @param ZlBTraderUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBTraderUser.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBTraderUser(@FormModel ZlBTraderUser zlBTraderUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBTraderUserService.saveAddZlBTraderUser(zlBTraderUser);
			if(flag>0){
				model.put("data", zlBTraderUser, "ZlBTraderUser");
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
	 * 保存交易商(企业)用户信息信息
	 * @param ZlBTraderUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBTraderUser1.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBTraderUser1(@FormModel ZlBTraderUser zlBTraderUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBTraderUserService.saveAddZlBTraderUser(zlBTraderUser);
			if(flag>0){
				model.put("data", zlBTraderUser, "ZlBTraderUser");
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
	 * 读取指定的交易商用户信息
	 * @param ckGoods
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadZlBTraderUser.json")
	public @ResponseBody JSONMap<String,Object> loadZlBTraderUser(@FormModel ZlBTraderUser zlBTraderUser, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBTraderUser entity = zlBTraderUserService.getZlBTraderUserById(zlBTraderUser);
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
	 * 修改交易商（个人）用户信息信息
	 * @param ZlBTraderUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBTraderUser.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBTraderUser(@FormModel ZlBTraderUser zlBTraderUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBTraderUserService.saveUpdateZlBTraderUser(zlBTraderUser);
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
	 * 修改交易商（企业）用户信息信息
	 * @param ZlBTraderUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBTraderUser1.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBTraderUser1(@FormModel ZlBTraderUser zlBTraderUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBTraderUserService.saveUpdateZlBTraderUser1(zlBTraderUser);
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
	 * 禁止企业商用户
	 */
	@RequestMapping("/inhibit.json")
	public @ResponseBody JSONMap<String, Object> inhibitZlBTrader(
			@FormModel ZlBTraderUser zlBTraderUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag=zlBTraderUserService.inhibitZlBTraderUserById(zlBTraderUser);
			model.put("flag",flag);						
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
	 * 启用交易商
	 * @param zlBTrader
	 * @param processor
	 * @return
	 */
	@RequestMapping("/start.json")
	public @ResponseBody JSONMap<String, Object> startZlBTrader(
			@FormModel ZlBTraderUser zlBTraderUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag=zlBTraderUserService.startZlBTraderUserById(zlBTraderUser);
			model.put("flag",flag);						
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
	 * @description 删除交易商用户信息信息
	 * @author 周杨
	 * @updateAuthor 周杨
	 * @param 
	 * @return JSONMap<String,Object>
	 * @created 2015年9月29日 下午2:54:09
	 */
	@RequestMapping("/deleteZlBTraderUser.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBTraderUser(@FormModel ZlBTraderUser zlBTraderUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   zlBTraderUser = zlBTraderUserService.getZlBTraderUserById(zlBTraderUser);
			int flag = zlBTraderUserService.deleteZlBTraderUser( zlBTraderUser);
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
