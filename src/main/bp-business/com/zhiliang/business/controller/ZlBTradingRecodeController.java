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
import com.zhiliang.business.service.ZlBTradingRecodeService;
import com.zhiliang.persistence.entity.ZlBTradingRecode;

/**
 * 最新成交记录
 * @author superma
 */
@Controller
@RequestMapping("/ipm/ZlBTradingRecodeController")
public class ZlBTradingRecodeController {

	@Resource
	private ZlBTradingRecodeService zlBTradingRecodeService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBTradingRecode/ZlBTradingRecode_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBTradingRecode/ZlBTradingRecode_add";
	}
	
	/**
	 * @description 最新成交修改页面
	 * @author superma
	 * @updateAuthor superma
	 * @param 
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBTradingRecode/ZlBTradingRecode_update";
	}

	/**
	 * 查询最新成交记录列表
	 * @param 
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryTradingRecodeList.json")
	public @ResponseBody JSONMap<String, Object> queryTradingRecodeList(@FormModel ZlBTradingRecode zlBTradingRecode,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBTradingRecode> list = zlBTradingRecodeService.queryTradingRecodeList(zlBTradingRecode,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBTradingRecode>");
			
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
	 * 保存成交记录
	 * @param ZlBServerNote
	 * @param processor
	 * @return
	 * @author superma
	 */
	@RequestMapping("/saveAddZlBTradingRecode.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBTradingRecode(@FormModel ZlBTradingRecode zlBTradingRecode,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBTradingRecodeService.saveTradingRecode(zlBTradingRecode);
			
			if(flag>0){
				model.put("data", zlBTradingRecode, "ZlBTradingRecode");
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
	 * 读取指定的客服短信发送信息
	 * @param ckGoods
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadZlBTradingRecode.json")
	public @ResponseBody JSONMap<String,Object> loadZlBTradingRecode(@FormModel ZlBTradingRecode zlBTradingRecode, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBTradingRecode entity = zlBTradingRecodeService.getZlBTradingRecodeById(zlBTradingRecode);
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
	 * 修改客服短信发送信息
	 * @param ZlBServerNote
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBTradingRecode.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBTradingRecode(@FormModel ZlBTradingRecode zlBTradingRecode) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBTradingRecodeService.saveUpdateZlBTradingRecode(zlBTradingRecode);
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
	 * @description 删除成交记录
	 * @author superma
	 * @updateAuthor superma
	 * @param 
	 * @return JSONMap<String,Object>
	 */
	@RequestMapping("/deleteZlBTradingRecode.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBServerNote(@FormModel ZlBTradingRecode zlBTradingRecode) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
			zlBTradingRecode = zlBTradingRecodeService.getZlBTradingRecodeById(zlBTradingRecode);
			int flag = zlBTradingRecodeService.deleteZlBTradingRecode( zlBTradingRecode);
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
