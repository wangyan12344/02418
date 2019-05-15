package com.zhiliang.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiliang.business.service.ZlBCountIpService;
import com.zhiliang.persistence.entity.ZlBCountIp;
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
@RequestMapping("/manager/ZlBCountIpController")
public class ZlBCountIpController {

	@Resource
	private ZlBCountIpService zlBCountIpService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBCountIp/ZlBCountIp_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "zhiliang/manager/ZlBCountIp/ZlBCountIp_add";
	}
	
	/**
	 * @description 转向交易商银行子账号流水修改页面
	 * @author wy
	 * @updateAuthor wy
	 * @param 
	 * @return String
	 * @created 2015年9月29日 下午1:19:21
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "zhiliang/manager/ZlBCountIp/ZlBCountIp_update";
	}

	/**
	 * 查询交易商银行子账号流水信息
	 * @param ZlBCountIp
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBCountIpPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBCountIpPageList(@FormModel ZlBCountIp zlBCountIp,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBCountIp> list = zlBCountIpService.queryZlBCountIpPageList(zlBCountIp,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBCountIp>");
			
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
	 * 保存交易商银行子账号流水信息
	 * @param ZlBCountIp
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBCountIp.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBCountIp(@FormModel ZlBCountIp zlBCountIp,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBCountIpService.saveAddZlBCountIp(zlBCountIp);
			if(flag>0){
				model.put("data", zlBCountIp, "ZlBCountIp");
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
	 * 读取指定的交易商银行子账号流水信息
	 * @param ckGoods
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadZlBCountIp.json")
	public @ResponseBody JSONMap<String,Object> loadZlBCountIp(@FormModel ZlBCountIp zlBCountIp, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBCountIp entity = zlBCountIpService.getZlBCountIpById(zlBCountIp);
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
	 * 修改交易商银行子账号流水信息
	 * @param ZlBCountIp
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBCountIp.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBCountIp(@FormModel ZlBCountIp zlBCountIp, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBCountIpService.saveUpdateZlBCountIp(zlBCountIp);
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
	 * @description 删除交易商银行子账号流水信息
	 * @author wy
	 * @updateAuthor wy
	 * @param 
	 * @return JSONMap<String,Object>
	 * @created 2015年9月29日 下午2:54:09
	 */
	@RequestMapping("/deleteZlBCountIp.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBCountIp(@FormModel ZlBCountIp zlBCountIp, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   zlBCountIp = zlBCountIpService.getZlBCountIpById(zlBCountIp);
			int flag = zlBCountIpService.deleteZlBCountIp( zlBCountIp);
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
