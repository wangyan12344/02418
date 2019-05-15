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
import com.zhiliang.business.service.ZlBAdvertisementService;
import com.zhiliang.persistence.entity.ZlBAdvertisement;

/**
 * @author zhouhaifeng
 */
@Controller
@RequestMapping("/zlb/ZlBAdvertisementController")
public class ZlBAdvertisementController {

	@Resource
	private ZlBAdvertisementService zlBAdvertisementService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBAdvertisement/ZlBAdvertisement_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBAdvertisement/ZlBAdvertisement_add";
	}
	
	/**
	 * @description 转向修改页面
	 * @created 2015年9月29日 下午1:19:21
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBAdvertisement/ZlBAdvertisement_update";
	}

	/**
	 * 查询信息
	 * @param ZlBIndexPic
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBAdvertisementPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBAdvertisementPageList(@FormModel ZlBAdvertisement zlBAdvertisement,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBAdvertisement> list = zlBAdvertisementService.queryZlBAdvertisementPageList(zlBAdvertisement,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBAdvertisement>");
			
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
	 * 保存信息
	 * @param ZlBIndexPic
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBAdvertisement.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBAdvertisement(@FormModel ZlBAdvertisement zlBAdvertisement) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBAdvertisementService.saveAddZlBAdvertisement(zlBAdvertisement);
			if(flag>0){
				model.put("data", zlBAdvertisement, "ZlBAdvertisement");
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
	 * 读取指定的信息
	 * @param ckGoods
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadZlBAdvertisement.json")
	public @ResponseBody JSONMap<String,Object> loadZlBAdvertisement(@FormModel ZlBAdvertisement zlBAdvertisement) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBAdvertisement entity = zlBAdvertisementService.getZlBAdvertisementById(zlBAdvertisement);
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
	 * 修改信息
	 * @param ZlBIndexPic
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBAdvertisement.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBAdvertisement(@FormModel ZlBAdvertisement zlBAdvertisement) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBAdvertisementService.saveUpdateZlBAdvertisement(zlBAdvertisement);
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
	 * @description 删除信息
	 */
	@RequestMapping("/deleteZlBAdvertisement.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBAdvertisement(@FormModel ZlBAdvertisement zlBAdvertisement) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
			zlBAdvertisement = zlBAdvertisementService.getZlBAdvertisementById(zlBAdvertisement);
			int flag = zlBAdvertisementService.deleteZlBAdvertisement( zlBAdvertisement);
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
	 * 是否启用广告图
	 * @param zlBAdvertisement
	 * @return
	 */
	@RequestMapping("/isStopZlBAdvertisement.json")
	public @ResponseBody JSONMap<String, Object> isStopZlBAdvertisement(@FormModel ZlBAdvertisement zlBAdvertisement) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBAdvertisementService.isStopZlBAdvertisement(zlBAdvertisement);
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
}
