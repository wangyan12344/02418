package com.zhiliang.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiliang.business.service.ZlBLatestService;
import com.zhiliang.persistence.entity.ZlBLatest;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;

/**
 * 最新动态
 * ZlBLatest 的Controller
 * @author superma
 */
@Controller
@RequestMapping("/ipm/ZlBLatestController")
public class ZlBLatestController {

	@Resource
	private ZlBLatestService zlBLatestService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBLatest/ZlBLatest_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBLatest/ZlBLatest_add";
	}
	
	/**
	 * @description 转向修改页面
	 * @author superma
	 * @updateAuthor superma
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBLatest/ZlBLatest_update";
	}

	/**
	 * 查询信息
	 * @param ZlBLatest
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBLatestPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBLatestPageList(@FormModel ZlBLatest zlBLatest,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBLatest> list = zlBLatestService.queryZlBLatestPageList(zlBLatest,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBLatest>");
			
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
	 * @param ZlBLatest
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBLatest.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBLatest(@FormModel ZlBLatest zlBLatest,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBLatestService.saveAddZlBLatest(zlBLatest);
			if(flag>0){
				model.put("data", zlBLatest, "ZlBLatest");
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
	@RequestMapping("/loadZlBLatest.json")
	public @ResponseBody JSONMap<String,Object> loadZlBLatest(@FormModel ZlBLatest zlBLatest, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBLatest entity = zlBLatestService.getZlBLatestById(zlBLatest);
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
	 * @param ZlBLatest
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBLatest.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBLatest(@FormModel ZlBLatest zlBLatest, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBLatestService.saveUpdateZlBLatest(zlBLatest);
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
	 * @author superma
	 * @updateAuthor superma
	 */
	@RequestMapping("/deleteZlBLatest.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBLatest(@FormModel ZlBLatest zlBLatest, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
			zlBLatest = zlBLatestService.getZlBLatestById(zlBLatest);
			int flag = zlBLatestService.deleteZlBLatest( zlBLatest);
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
