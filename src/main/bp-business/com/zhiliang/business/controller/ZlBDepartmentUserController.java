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
import com.zhiliang.business.service.ZlBDepartmentUserService;
import com.zhiliang.persistence.dto.departmentDTO;
import com.zhiliang.persistence.entity.ZlBDepartment;
import com.zhiliang.persistence.entity.ZlBDepartmentUser;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.repast.core.tool.EmptyUtilHelper;
import com.repast.core.tool.ExportExcelUtil;

/**
 * 
 * @author 
 */
@Controller
@RequestMapping("/ZlBDepartmentUserController")
public class ZlBDepartmentUserController {

	@Resource
	private ZlBDepartmentUserService zlBDepartmentUserService;
	@Resource
	private ZlBDepartmentService zlBDepartmentService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "/zhiliang/manager/ZlBDepartmentUser/ZlBDepartmentUser_list";
	}
	
	@RequestMapping("/add")
	public String forwardAddPage()
	{
		return "/zhiliang/manager/ZlBDepartmentUser/ZlBDepartmentUser_add";
	}
	@RequestMapping("/datacount")
	public String forwardDatacount()
	{
		return "/zhiliang/manager/ZlBOrderDataStatistics/zl_b_department_user";
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
		return "/zhiliang/manager/ZlBDepartmentUser/ZlBDepartmentUser_update";
	}

	/**
	 * 查询B端app首页活动信息
	 * @param ZlBDepartmentUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBDepartmentUserPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBDepartmentUserPageList(@FormModel ZlBDepartmentUser zlBDepartmentUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBDepartmentUser> list = zlBDepartmentUserService.queryZlBDepartmentUserPageList(zlBDepartmentUser,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBDepartmentUser>");
			
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
	 * @param ZlBDepartmentUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveAddZlBDepartmentUser.json")
	public @ResponseBody JSONMap<String, Object> saveAddZlBDepartmentUser(@FormModel ZlBDepartmentUser zlBDepartmentUser,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBDepartmentUserService.saveAddZlBDepartmentUser(zlBDepartmentUser);
			if(flag>0){
				model.put("data", zlBDepartmentUser, "ZlBDepartmentUser");
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
	@RequestMapping("/loadZlBDepartmentUser.json")
	public @ResponseBody JSONMap<String,Object> loadZlBDepartmentUser(@FormModel ZlBDepartmentUser zlBDepartmentUser, @FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			//被修改的实体
			ZlBDepartmentUser entity = zlBDepartmentUserService.getZlBDepartmentUserById(zlBDepartmentUser);
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
	 * @param ZlBDepartmentUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/saveUpdateZlBDepartmentUser.json")
	public @ResponseBody JSONMap<String, Object> saveUpdateZlBDepartmentUser(@FormModel ZlBDepartmentUser zlBDepartmentUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBDepartmentUserService.saveUpdateZlBDepartmentUser(zlBDepartmentUser);
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
	@RequestMapping("/deleteZlBDepartmentUser.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBDepartmentUser(@FormModel ZlBDepartmentUser zlBDepartmentUser, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
		   zlBDepartmentUser = zlBDepartmentUserService.getZlBDepartmentUserById(zlBDepartmentUser);
			int flag = zlBDepartmentUserService.deleteZlBDepartmentUser( zlBDepartmentUser);
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
	 * 按月份
	 * @param zlBDepartment
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryOrderDataForMapBar.json")	
	public @ResponseBody JSONMap<String,Object> queryOrderDataForMapBar(@FormModel ZlBDepartment zlBDepartment,@FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try {
			 
			List<ZlBDepartment> zlBDepartmentList=zlBDepartmentService.queryOrderDataForMapBarMonth(zlBDepartment);//部门列表
//			List<ZlBDepartment> zlBDepartmentUserList=zlBDepartmentUserService.queryOrderDataForMapBar(zlBDepartmentUser);
			List<departmentDTO> monthslist=zlBDepartmentService.queryDataMonth(zlBDepartment);//月份列表
			
			
			model.put("zlBDepartmentList", zlBDepartmentList);	
			model.put("monthslist", monthslist);	
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
	 * 按人
	 * @param zlBDepartmentUser
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryOrderDataForMapBarByper.json")	
	public @ResponseBody JSONMap<String,Object> queryOrderDataForMapBarByper(@FormModel ZlBDepartmentUser zlBDepartmentUser,@FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try {
			 
//			List<ZlBDepartment> zlBDepartmentList=zlBDepartmentService.queryOrderDataForMapBarMonth(zlBDepartment);//部门列表
			List<ZlBDepartmentUser> zlBDepartmentUserList=zlBDepartmentUserService.queryOrderDataForMapBar(zlBDepartmentUser);
			ZlBDepartment zlBDepartment=new ZlBDepartment();
			List<departmentDTO> monthslist=zlBDepartmentService.queryDataMonth(zlBDepartment);//月份列表
			model.put("zlBDepartmentUserList", zlBDepartmentUserList);	
			model.put("monthslist", monthslist);	
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
	 public void exportProject(HttpServletResponse response,HttpServletRequest request,@FormModel ZlBDepartmentUser zlBDepartmentUser,String rowname) throws Exception {
		String rowentityname =request.getParameter("rowname");  //瀵瑰墠鍙颁紶鍊艰繘琛岃В瀵�

		rowname = URLDecoder.decode(rowentityname , "utf-8");
		String departmentname = URLDecoder.decode(zlBDepartmentUser.getDepartmentname() , "utf-8");
		String newFileName="全部投稿统计";
		if (!"请选择".equals(departmentname) && !"".equals(departmentname) &&  departmentname!=null) {
			newFileName=departmentname+"投稿统计";
		}
		
	  String[] headers=EmptyUtilHelper.headerTitle(rowname); 
		
	  String arryentity = EmptyUtilHelper.arryEntity(rowname);  
	  
	  String[] rowentity=EmptyUtilHelper.atrEntity(rowname);   
	  String[] splitentity=new String[rowentity.length];
	  for (int i=0;i<rowentity.length;i++ ) {
		  String[] arry=rowentity[i].split("\\.");
		  splitentity[i]=arry[1];
	  }
	  List<ZlBDepartmentUser> list = zlBDepartmentUserService.queryZlBDepartmentUserlListExcel(zlBDepartmentUser);
	 try {
		  ExportExcelUtil<ZlBDepartmentUser> ex = new ExportExcelUtil<ZlBDepartmentUser>();
		   OutputStream outputStream = response.getOutputStream();
		  ex.exportExcel(headers,splitentity,list, outputStream,newFileName,response);
		  outputStream.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }
}
