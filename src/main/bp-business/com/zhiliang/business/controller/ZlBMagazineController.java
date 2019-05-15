package com.zhiliang.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiliang.business.service.ZlBMagazineService;
import com.zhiliang.persistence.entity.ZlBMagazine;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;

/**
 * 
 * @author wy
 */
@Controller
@RequestMapping("/ZlBMagazineController")
public class ZlBMagazineController {

	@Resource
	private ZlBMagazineService zlBMagazineService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBMagazine/ZlBMagazine_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBMagazine/ZlBMagazine_add";
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBMagazine/ZlBMagazine_update";
	}

	/**
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBMagazinePageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBMagazinePageList(@FormModel ZlBMagazine zlBMagazine,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBMagazine> list = zlBMagazineService.queryZlBMagazinePageList(zlBMagazine,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBMagazine>");
			
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
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBMagazine.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBMagazine(@FormModel ZlBMagazine zlBMagazine,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBMagazineService.saveAddZlBMagazine(zlBMagazine);
			if(flag>0){
				model.put("data", zlBMagazine, "ZlBMagazine");
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
	 * @return
	 */
	@RequestMapping("/loadZlBMagazine.json")
	public @ResponseBody JSONMap<String,Object> loadZlBMagazine(@FormModel ZlBMagazine zlBMagazine, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBMagazine entity = zlBMagazineService.getZlBMagazineById(zlBMagazine);
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
	 * @param ZlBMagazine
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBMagazine.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBMagazine(@FormModel ZlBMagazine zlBMagazine, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBMagazineService.saveUpdateZlBMagazine(zlBMagazine);
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
	 * @author wy
	 * @updateAuthor wy
	 */
	@RequestMapping("/deleteZlBMagazine.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBMagazine(@FormModel ZlBMagazine zlBMagazine, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
			zlBMagazine = zlBMagazineService.getZlBMagazineById(zlBMagazine);
			int flag = zlBMagazineService.deleteZlBMagazine(zlBMagazine);
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
