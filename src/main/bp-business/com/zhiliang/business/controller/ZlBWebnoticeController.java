package com.zhiliang.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiliang.business.service.ZlBWebnoticeService;
import com.zhiliang.persistence.entity.ZlBWebNotice;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;

/**
 * 网站公告
 * Application name: Application describing:控制层Copyright:Copyright copy;
 * @author superma
 */
@Controller
@RequestMapping("/ipm/ZlBWebnoticeController")
public class ZlBWebnoticeController {

	@Resource
	private ZlBWebnoticeService zlBWebnoticeService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBWebnotice/ZlBWebnotice_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBWebnotice/ZlBWebnotice_add";
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
		return "zhiliang/manager/ZlBWebnotice/ZlBWebnotice_update";
	}

	/**
	 * 查询信息
	 * @param ZlBWebnotice
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBWebnoticePageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBWebnoticePageList(@FormModel ZlBWebNotice zlBWebNotice,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBWebNotice> list = zlBWebnoticeService.queryZlBWebnoticePageList(zlBWebNotice,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBWebnotice>");
			
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
	 * @param ZlBWebnotice
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBWebnotice.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBWebnotice(@FormModel ZlBWebNotice zlBWebNotice,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBWebnoticeService.saveAddZlBWebnotice(zlBWebNotice);
			if(flag>0){
				model.put("data", zlBWebNotice, "ZlBWebnotice");
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
	@RequestMapping("/loadZlBWebnotice.json")
	public @ResponseBody JSONMap<String,Object> loadZlBWebnotice(@FormModel ZlBWebNotice zlBWebNotice, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBWebNotice entity = zlBWebnoticeService.getZlBWebnoticeById(zlBWebNotice);
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
	 * @param ZlBWebnotice
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBWebnotice.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBWebnotice(@FormModel ZlBWebNotice zlBWebNotice, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBWebnoticeService.saveUpdateZlBWebnotice(zlBWebNotice);
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
	 * @param 
	 * @return JSONMap<String,Object>
	 * @created 2015年9月29日 下午2:54:09
	 */
	@RequestMapping("/deleteZlBWebnotice.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBWebnotice(@FormModel ZlBWebNotice zlBWebNotice, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   zlBWebNotice = zlBWebnoticeService.getZlBWebnoticeById(zlBWebNotice);
			int flag = zlBWebnoticeService.deleteZlBWebnotice( zlBWebNotice);
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
	/***
	 * 读取指定的信息
	 * @param ckGoods
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadZlBWebnoticeForlast.json")
	public @ResponseBody JSONMap<String,Object> loadZlBWebnoticeForlast(@FormModel ZlBWebNotice zlBWebNotice, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBWebNotice entity = zlBWebnoticeService.getZlBWebnoticeForlast(zlBWebNotice);
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
	
}
