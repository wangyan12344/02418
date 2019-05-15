package com.zhiliang.business.controller;

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
import com.zhiliang.business.service.ZlBAppActivityServince;
import com.zhiliang.persistence.entity.ZlBAppActivity;

@Controller
@RequestMapping("/ZlBAppActivityController")
public class ZlBAppActivityController {
	
	@Resource
	private ZlBAppActivityServince zlBAppActivityServince;
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBAppActivity/ZlBAppAvtivity_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBAppActivity/ZlBAppAvtivity_add";
	}
	
	/**
	 * @description 转向修改页面
	 * @author zhouhaifeng
	 * @updateAuthor zhouhaifeng
	 * @param 
	 * @return String
	 * @created 2015年9月29日 下午1:19:21
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBAppActivity/ZlBAppAvtivity_update";
	}

	
	/**
	 * 获得最新活动
	 * @param entity
	 * @return
	 */
	@RequestMapping("/getZlBAppActivity.json")
	public @ResponseBody JSONMap<String, Object> getZlBAppAvtivity(@FormModel ZlBAppActivity entity) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			
			ZlBAppActivity zlBAppActivity=zlBAppActivityServince.getZlBAppActivity(entity);
			if(zlBAppActivity!=null && !"".equals(zlBAppActivity)){
				model.put(SysConstant.OP_FLAG, true);
				model.put("zlBAppActivity",zlBAppActivity);
				}else
				{
					model.put(SysConstant.OP_FLAG, false);
					model.put(SysConstant.OP_MESSAGE, "暂无活动");
				}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	/**
	 * 查询信息
	 * @param 
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBAppActivityPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBAppActivityPageList(@FormModel ZlBAppActivity zlBAppActivity,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBAppActivity> list = zlBAppActivityServince.queryZlBAppActivityPageList(zlBAppActivity,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<zlBAppActivity>");
			
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
	 * @description 删除信息
	 * @author zhouhaifeng
	 * @updateAuthor zhouhaifeng
	 * @param 
	 * @return JSONMap<String,Object>
	 * @created 2015年9月29日 下午2:54:09
	 */
	@RequestMapping("/deleteZlBAppActivity.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBAppAvtivity(@FormModel ZlBAppActivity zlBAppActivity, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   int flag = zlBAppActivityServince.deleteZlBAppActivity(zlBAppActivity);
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
	
	/**
	 * 新增活动
	 * @param zlBAppActivity
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBAppActivity.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBAppAvtivity(@FormModel ZlBAppActivity zlBAppActivity, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   int flag = zlBAppActivityServince.saveAddZlBAppActivity(zlBAppActivity);
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
	
	
	@RequestMapping("/loadZlBAppActivity.json")
	public @ResponseBody JSONMap<String, Object> loadZlBAppActivity(@FormModel ZlBAppActivity zlBAppActivity) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
			ZlBAppActivity entity = zlBAppActivityServince.getZlBAppActivityById(zlBAppActivity);
			model.put("entity", entity);
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.FAIL);
		}
		return model;
	}
	
	@RequestMapping("/saveUpdateZlBAppActivity.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBAppActivity(@FormModel ZlBAppActivity zlBAppActivity) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
			int flag = zlBAppActivityServince.saveUpdateZlBAppActivity(zlBAppActivity);
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
