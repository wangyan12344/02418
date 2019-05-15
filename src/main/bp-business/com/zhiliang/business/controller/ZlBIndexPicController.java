package com.zhiliang.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.zhiliang.business.service.ZlBIndexPicService;
import com.zhiliang.persistence.entity.ZlBIndexPic;

/**
 * @author zhouhaifeng
 */
@Controller
@RequestMapping("/zlb/ZlBIndexPicController")
public class ZlBIndexPicController {

	@Resource
	private ZlBIndexPicService zlBIndexPicService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBIndexPic/ZlBIndexPic_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBIndexPic/ZlBIndexPic_add";
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
		return "zhiliang/manager/ZlBIndexPic/ZlBIndexPic_update";
	}

	/**
	 * 查询信息
	 * @param ZlBIndexPic
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBIndexPicPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBIndexPicPageList(@FormModel ZlBIndexPic zlBIndexPic,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBIndexPic> list = zlBIndexPicService.queryZlBIndexPicPageList(zlBIndexPic,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBIndexPic>");
			
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
	@RequestMapping("/saveAddZlBIndexPic.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBIndexPic(@FormModel ZlBIndexPic zlBIndexPic,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBIndexPicService.saveAddZlBIndexPic(zlBIndexPic);
			if(flag>0){
				model.put("data", zlBIndexPic, "ZlBIndexPic");
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
	@RequestMapping("/loadZlBIndexPic.json")
	public @ResponseBody JSONMap<String,Object> loadZlBIndexPic(@FormModel ZlBIndexPic zlBIndexPic, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBIndexPic entity = zlBIndexPicService.getZlBIndexPicById(zlBIndexPic);
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
	@RequestMapping("/saveUpdateZlBIndexPic.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBIndexPic(@FormModel ZlBIndexPic zlBIndexPic, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBIndexPicService.saveUpdateZlBIndexPic(zlBIndexPic);
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
	 * @author zhouhaifeng
	 * @updateAuthor zhouhaifeng
	 * @param 
	 * @return JSONMap<String,Object>
	 * @created 2015年9月29日 下午2:54:09
	 */
	@RequestMapping("/deleteZlBIndexPic.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBIndexPic(@FormModel ZlBIndexPic zlBIndexPic, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   zlBIndexPic = zlBIndexPicService.getZlBIndexPicById(zlBIndexPic);
			int flag = zlBIndexPicService.deleteZlBIndexPic( zlBIndexPic);
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
	
	@RequestMapping("/isStopZlBIndexPic.json")
	public @ResponseBody JSONMap<String, Object> isStopZlBIndexPic(@FormModel ZlBIndexPic zlBIndexPic) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBIndexPicService.isStopZlBIndexPic(zlBIndexPic);
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
