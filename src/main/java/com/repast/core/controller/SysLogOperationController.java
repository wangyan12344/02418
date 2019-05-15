package com.repast.core.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.repast.core.constant.SysConstant;
import com.repast.core.service.SysLogOperationService;
import com.repast.core.spring.auth.Author;
import com.repast.core.spring.auth.CheckType;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.repast.core.uiview.Select;
import com.repast.core.uiview.format.IConvert;
import com.repast.core.uiview.format.UIDataConvert;
import com.repast.core.uiview.format.impl.SqlMapConvertImpl;
import com.repast.persistence.entity.SysLogOperation;
import com.repast.persistence.entity.SysUser;

@Controller
@RequestMapping("/SysLogOperationController")
public class SysLogOperationController {

	@Resource
	private SysLogOperationService sysLogOperationService;
	
	
	@RequestMapping("/forwardSysLogOperationList")
	public String forwardSysLogOperationList(Model model, HttpServletRequest request,HttpServletResponse response, HttpSession session) 
	{
		return "/foodms/syslogoperation/syslogoperation_list";
	}
	
	
	
	@Author(type=CheckType.CHECK_LOGIN)
	@RequestMapping("/querySysLogOperationList.json")
	public @ResponseBody JSONMap<String,Object> querySysLogOperationList(@FormModel SysLogOperation sysLogOperation,@FormModel Processor processor) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			Pagination<SysLogOperation> list = sysLogOperationService.querySysLogOperationPageList(sysLogOperation, processor.getPageIndex(),processor.getPageSize());
			
			UIDataConvert<SysLogOperation> convert = new UIDataConvert<SysLogOperation>();
		//	SQL 查询方式转换
			IConvert useNameConvert = new SqlMapConvertImpl("operationUserId","operationUserName","sys_user","username","id",null);
			convert.addConvert(useNameConvert);
		
		//  CodeList方式转换	
		//	IConvert codeList = new CodeListConvertImpl("operationUserId","operationUserName", "AREA_CITY");
		//	convert.addConvert(codeList);
			
		//  处定义Map方式转换	
		//	Map userMap = new HashMap();
		//	userMap.put("001", "abc");
		//	IConvert usemapConvert = new UserMapConvertImpl("operationUserId","operationUserName", userMap);
		//	convert.addConvert(usemapConvert);
			convert.format(list);
			
			
			model.put("data", list);
			model.put(SysConstant.OP_FLAG, true);
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	@RequestMapping("/querySysLogOperationDetailByLogID.json")
	public @ResponseBody JSONMap<String,Object> querySysLogOperationDetailByLogID(@FormModel SysLogOperation sysLogOperation,@FormModel Processor processor){
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			SysLogOperation obj = sysLogOperationService.querySysLogOperationDetailByLogID(sysLogOperation.getLogid());
			model.put("data", obj);
			model.put(SysConstant.OP_FLAG, true);
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	@RequestMapping("/loadBusinessSelect.json")
	public @ResponseBody JSONMap<String,Object> loadBusinessSelect(@FormModel Processor processor){
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			List<SysLogOperation> options = sysLogOperationService.queryBusinessNameList();
			Select<SysLogOperation> select = new Select<SysLogOperation>();
			select.setOptions(options);
			model.put("data", select);
			model.put(SysConstant.OP_FLAG, true);
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	@RequestMapping("/truncateLog.json")
	public @ResponseBody JSONMap<String,Object> TruncateLog(@FormModel Processor processor){
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try{
			sysLogOperationService.TruncateLog();
			model.put(SysConstant.OP_FLAG, true);
		}catch(Exception e){
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
	
	

	
	
	@RequestMapping("/testList.json")
	public @ResponseBody JSONMap<String,Object> testList(@FormModel("list") List<SysLogOperation> list,@FormModel("users") List<SysUser> users,@FormModel Processor processor){
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		model.put("list", list);
		model.put("users", users);
		return model;
	}
}