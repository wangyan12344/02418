package com.zhiliang.business.controller;

import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiliang.business.service.ZlBDepartmentService;
import com.zhiliang.persistence.entity.SysUserInfo;
import com.zhiliang.persistence.entity.ZlBDepartment;
import com.zhiliang.persistence.entity.ZlBNewsCategory;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.repast.core.tool.EmptyUtilHelper;
import com.repast.core.tool.ExportExcelUtil;

/**
 * 
 * ZlBDepartment 的Controller
 * @author 
 */
@Controller
@RequestMapping("/ZlBDepartmentController")
public class ZlBDepartmentController {

	@Resource
	private ZlBDepartmentService zlBDepartmentService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "/zhiliang/manager/ZlBDepartment/ZlBDepartment_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "/zhiliang/manager/ZlBDepartment/ZlBDepartment_add";
	}
	@RequestMapping("/datacount")
	public String forwardDatacount()
	{
		return "/zhiliang/manager/ZlBOrderDataStatistics/ZlBOrderDataStatisticsMap_list";
	}
	@RequestMapping("/datacountBytime")
	public String forwarddatacountBytime()
	{
		return "/zhiliang/manager/ZlBOrderDataStatistics/departmentDataOfMonth";
	}
	/**
	 * @description 转向B端app首页活动修改页面
	 * @author 
	 * @updateAuthor 
	 * @param 
	 * @return String
	 * @created 2015年9月29日 下午1:19:21
	 */
	@RequestMapping("/update")
	public String forwardUpdatePage(HttpServletRequest request, HttpServletResponse response,Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
		return "/zhiliang/manager/ZlBDepartment/ZlBDepartment_update";
	}

	/**
	 * 查询B端app首页活动信息
	 * @param ZlBDepartment
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBDepartmentPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBDepartmentPageList(@FormModel ZlBDepartment zlBDepartment,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBDepartment> list = zlBDepartmentService.queryZlBDepartmentPageList(zlBDepartment,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBDepartment>");
			
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
	 * 保存B端app首页活动信息
	 * @param ZlBDepartment
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBDepartment.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBDepartment(@FormModel ZlBDepartment zlBDepartment,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBDepartmentService.saveAddZlBDepartment(zlBDepartment);
			if(flag>0){
				model.put("data", zlBDepartment, "ZlBDepartment");
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
	 * 读取指定的B端app首页活动信息
	 * @param ckGoods
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadZlBDepartment.json")
	public @ResponseBody JSONMap<String,Object> loadZlBDepartment(@FormModel ZlBDepartment zlBDepartment, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBDepartment entity = zlBDepartmentService.getZlBDepartmentById(zlBDepartment);
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
	 * 修改B端app首页活动信息
	 * @param ZlBDepartment
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBDepartment.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBDepartment(@FormModel ZlBDepartment zlBDepartment, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBDepartmentService.saveUpdateZlBDepartment(zlBDepartment);
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
	 * @description 删除B端app首页活动信息
	 * @author 
	 * @updateAuthor 
	 * @param 
	 * @return JSONMap<String,Object>
	 * @created 2015年9月29日 下午2:54:09
	 */
	@RequestMapping("/deleteZlBDepartment.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBDepartment(@FormModel ZlBDepartment zlBDepartment, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   zlBDepartment = zlBDepartmentService.getZlBDepartmentById(zlBDepartment);
			int flag = zlBDepartmentService.deleteZlBDepartment( zlBDepartment);
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
	@RequestMapping("/queryOrderDataForMapBar.json")	
	public @ResponseBody JSONMap<String,Object> queryOrderDataForMapBar(@FormModel ZlBDepartment zlBDepartment,@FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try {
			 
			List<ZlBDepartment> zlBDepartmentList=zlBDepartmentService.queryOrderDataForMapBar(zlBDepartment);
			model.put("zlBDepartmentList", zlBDepartmentList);	
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
	 * 
	 * @param response
	 * @param request
	 * @param zlBDepartment
	 * @param stime
	 * @param etime
	 * @param rowname
	 * @throws Exception
	 */
	@RequestMapping("/exportProject.json")
	 public void exportProject(HttpServletResponse response,HttpServletRequest request,@FormModel ZlBDepartment zlBDepartment,String stime,String etime,String rowname) throws Exception {
		String rowentityname =request.getParameter("rowname");  //瀵瑰墠鍙颁紶鍊艰繘琛岃В瀵�

		rowname = URLDecoder.decode(rowentityname , "utf-8");
		
		String newFileName="投稿统计";
		if (!"".equals(stime) && !"".equals(etime)) {
			newFileName=stime+"至"+etime+"投稿统计";
		}
		
	  String[] headers=EmptyUtilHelper.headerTitle(rowname); 
		
	  String arryentity = EmptyUtilHelper.arryEntity(rowname);  
	  
	  String[] rowentity=EmptyUtilHelper.atrEntity(rowname);   
	  String[] splitentity=new String[rowentity.length];
	  for (int i=0;i<rowentity.length;i++ ) {
		  String[] arry=rowentity[i].split("\\.");
		  splitentity[i]=arry[1];
	  }
	  List<ZlBDepartment> list = zlBDepartmentService.queryZlBDepartmentListExcel(zlBDepartment,stime,etime);
	 try {
		  ExportExcelUtil<ZlBDepartment> ex = new ExportExcelUtil<ZlBDepartment>();
		   OutputStream outputStream = response.getOutputStream();
		  ex.exportExcel(headers,splitentity,list, outputStream,newFileName,response);
		  outputStream.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }
}
