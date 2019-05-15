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
import com.zhiliang.business.service.ZlBNewClassService;
import com.zhiliang.persistence.entity.ZlBNewsCategory;

@Controller
@RequestMapping("/manager/ZlBNewsClassController")
public class ZlBNewsClassController {
	@Resource
	private ZlBNewClassService zlBNewClassService;
	

	@RequestMapping("/list")//新闻分类主页
	public String forwardListPage()
	{
		return "/zhiliang/manager/ZlBNewsClass/ZlBNewsClass_list";
	
	}
	/**
	 * @description 转向新闻分类信息修改页面
	 * @author 马骞
	 * 
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBNewsClass/ZlBNewsClass_update";
	}
	/**
	 * 添加新闻分类信息
	 * @return
	 */
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBNewsClass/ZlBNewsClass_add";
	}
	
	
	/**
	 * 查询新闻分类信息
	 * @param ZlBTrader
	 * @param processor
	 * @return
	 */
	
	@RequestMapping("/queryZlBNewsClassList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBNewsCategoryPageList(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {		 
			
			Pagination<ZlBNewsCategory> list = zlBNewClassService.queryZlBNewsCategoryPageList(zlBNewsCategory,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBNewsCategory>");
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
	 * 保存修改后的新闻分类信息
	 * @param ZlBTrader
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBNewsCategory.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBNewsCategory(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBNewClassService.saveUpdateZlBNewsCategory(zlBNewsCategory);
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
	
	/***
	 * 读取指定的新闻信息
	 * @param ckGoods
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadZlBNewsCategory.json")
	public @ResponseBody JSONMap<String,Object> loadZlBNewsCategory(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBNewsCategory entity = zlBNewClassService.getZlBNewsCategoryById(zlBNewsCategory);
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
	 * 保存新闻信息
	 * @param ZlBTrader
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBNewsCategory.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBNewsCategory(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBNewClassService.saveAddZlBNewsCategory(zlBNewsCategory);
			if(flag>0){
				model.put("data", zlBNewsCategory, "ZlBNewsCategory");
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
	 * @description 删除交易商信息信息
	 * @author 马骞
	 * @updateAuthor 马骞
	 */
	@RequestMapping("/deleteZlBNewsCategory.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBNewsCategory(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
			zlBNewsCategory = zlBNewClassService.getZlBNewsCategoryById(zlBNewsCategory);
			int flag = zlBNewClassService.deleteZlBNewsCategory( zlBNewsCategory);
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
	 * 新增分类,附加终端选择
	 * @author Wy	
	 * @param zlGoodsType
	 * @param processor
	 * @return
	 */

	@RequestMapping("/beforeAddEntitySelectterminal.json")
	public @ResponseBody JSONMap<String,Object> beforeAddEntitySelectterminal(@FormModel ZlBNewsCategory zlBNewsCategory,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{	
			ZlBNewsCategory entity = zlBNewClassService.getZlBNewsCategoryById(zlBNewsCategory);
			model.put("entity", entity);
//			List<ZlMallTerminalType> zlMallTerminalTypeList =zlGoodTypeService.getZlGoodTypeByIdSelectterminal(zlGoodType);
//			model.put("zlMallTerminalTypeList", zlMallTerminalTypeList);
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
