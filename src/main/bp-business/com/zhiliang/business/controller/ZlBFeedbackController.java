package com.zhiliang.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiliang.business.service.ZlBFeedbackService;
import com.zhiliang.persistence.entity.ZlBFeedBack;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;

/**
 * 意见反馈
 * Application name: Application describing:意见反馈控制层Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * ZlBFeedback 的Controller
 * @author superma
 */
@Controller
@RequestMapping("/ipm/ZlBFeedbackController")
public class ZlBFeedbackController {

	@Resource
	private ZlBFeedbackService zlBFeedbackService;
	
	
	@RequestMapping("/list")
	public String forwardListPage()
	{
		return "zhiliang/manager/ZlBFeedBack/ZlBFeedback_list";
	}
	
	

	/**
	 * 查询意见反馈信息
	 * @param ZlBFeedback
	 * @param processor
	 * @return
	 */
	@RequestMapping("/queryZlBFeedbackPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBFeedbackPageList(@FormModel ZlBFeedBack zlBFeedBack,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBFeedBack> list = zlBFeedbackService.queryZlBFeedbackPageList(zlBFeedBack,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBFeedBack>");
			
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
	 * @description 删除意见反馈信息
	 * @author superma
	 * @updateAuthor superma
	 */
	@RequestMapping("/deleteZlBFeedback.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBFeedback(@FormModel ZlBFeedBack zlBFeedBack, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
		
			int flag = zlBFeedbackService.deleteZlBFeedback( zlBFeedBack);
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
