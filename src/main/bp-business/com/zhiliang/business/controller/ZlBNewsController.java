package com.zhiliang.business.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.Now;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.domain.Data;
import com.repast.core.codelist.SysCodelist;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.repast.core.tool.EmptyUtilHelper;
import com.repast.core.tool.ExportExcelUtil;
import com.repast.core.uiview.format.IConvert;
import com.repast.core.uiview.format.UIDataConvert;
import com.repast.core.uiview.format.impl.SqlMapConvertImpl;
import com.zhiliang.business.service.ZlBNewsService;
import com.zhiliang.persistence.dao.SysUserInfoDAO;
import com.zhiliang.persistence.dao.ZlBDepartmentDAO;
import com.zhiliang.persistence.dao.ZlBDepartmentUserDAO;
import com.zhiliang.persistence.entity.SysUserInfo;
import com.zhiliang.persistence.entity.ZlBDepartment;
import com.zhiliang.persistence.entity.ZlBDepartmentUser;
import com.zhiliang.persistence.entity.ZlBNews;
import com.zhiliang.persistence.entity.ZlBNewsCategory;
import com.zhiliang.business.service.SysUserInfoService;
import com.zhiliang.business.service.ZlBNewClassService;

@Controller
@RequestMapping("/manager/ZlBNewsController")
public class ZlBNewsController {
	@Resource(name = "ZlBNewsService")
	private ZlBNewsService zlBNewsService;
	@Resource
	private ZlBNewClassService zlBNewClassService;
	@Resource
	private SysUserInfoService sysUserInfoService;
	@Resource
	private ZlBDepartmentDAO zlBDepartmentDAO;
	
	@Resource
	private ZlBDepartmentUserDAO zlBDepartmentUserDAO;
	/**
	 * 进入新闻列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String forwardNewslist() {

		return "zhiliang/manager/ZlBNews/ZlBNews_list";
	}
	/**
	 * 进入新闻列表页面
	 * 
	 * @return
	 */
	@RequestMapping("/praiselist")
	public String forwardNewspraiselist() {

		return "zhiliang/manager/ZlBNews/ZlBNews_list_praise";
	}
	/**
	 * 分页查询新闻列表
	 * 
	 * @param zlBNews
	 * @param processor
	 * @return
	 * @update wy 增加缓存功能
	 */
	@RequestMapping("/queryZlBNewsPageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBNewsPageList(
			@FormModel ZlBNews zlBNews, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			
			
			Pagination<ZlBNews> list = zlBNewsService.queryZlBNewsPageList(
					zlBNews, processor.getPageIndex(), processor.getPageSize(),processor);
			model.put("data", list);
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
	 * 分页查询新闻列表，按点赞数排序
	 * 
	 * @param zlBNews
	 * @param processor
	 * @return
	 * @update wy 增加缓存功能
	 */
	@RequestMapping("/queryZlBNewsPageListByPraise.json")
	public @ResponseBody JSONMap<String, Object> queryZlBNewsPageListByPraise(@FormModel ZlBNews zlBNews, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			
			Pagination<ZlBNews> list = zlBNewsService.queryZlBNewsListByPraise(zlBNews, processor.getPageIndex(), processor.getPageSize(),processor);
			model.put("data", list);
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
	 * 进入添加新闻页面
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public String forwardAddlist() {
		return "zhiliang/manager/ZlBNews/ZlBNews_add";
	}

	/**
	 * 获取初始化添加页面下拉框选项
	 * 
	 * @param processor
	 * @return
	 */
	@RequestMapping("/beforeAddEntity.json")
	public @ResponseBody JSONMap<String, Object> beforeAddEntity(
			@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			SysCodelist sysCodelist = new SysCodelist();
			SysCodelist sysCodelist2 = new SysCodelist();
			SysCodelist sysCodelist3 = new SysCodelist();
			sysCodelist.setKindcode("YES_NO");
			sysCodelist2.setKindcode("NEWS_MODEL");
			sysCodelist3.setKindcode("GRAINTYPE");
			
			String userid=processor.getCurrentUserId();
			SysUserInfo entity=new SysUserInfo();
			entity.setUserid(userid);
			String usertype="";
			SysUserInfo entity1=sysUserInfoService.getSysUserInfoById(entity);
			if (entity1!=null) {
				usertype=entity1.getUsertype();
			}
			List<SysCodelist> yeorno = zlBNewsService.getCodeList(sysCodelist);
			List<SysCodelist> newsmodel = zlBNewsService
					.getCodeList(sysCodelist2);
			List<SysCodelist> graintype = zlBNewsService
					.getCodeList(sysCodelist3);
			//查询部门列表
			List<ZlBDepartment> zlBDepartmentlist=new ArrayList<>();
			ZlBDepartment entityzlbdepartment=new ZlBDepartment();
			zlBDepartmentlist=zlBDepartmentDAO.queryZlBDepartmentList(entityzlbdepartment);
			
			List<ZlBNewsCategory> newscategory = zlBNewsService.getZlBNewsCategory();
			if (!"1".equals(usertype)){
				newscategory=zlBNewsService.getZlBNewsCategoryByUserid(userid);
			}
			
			model.put("zlBDepartmentlist", zlBDepartmentlist);
			model.put("newscategory", newscategory);
			model.put("newsmodel", newsmodel);
			model.put("yeorno", yeorno);
			model.put("graintype", graintype);
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
	 * 新建新闻
	 * 
	 * @param zlBNewsDTO
	 * @param processor
	 * @return
	 */
	@RequestMapping("/addEntityData.json")
	public @ResponseBody JSONMap<String, Object> addEntityData(
			@FormModel ZlBNews zlBNews, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();

		try {
			int flag = zlBNewsService.saveZlBNews(zlBNews, processor);
			model.put("flag", flag);
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
	 * 请求修改页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/update")
	public String forwordUpdatePage(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String opid = request.getParameter("opid");
		model.addAttribute("opid", opid);
		return "zhiliang/manager/ZlBNews/ZlBNews_update";
	}

	/**
	 * 根据id查询新闻详情
	 * 
	 * @param zlBNewsDTO
	 * @param processor
	 * @return
	 */
	@RequestMapping("/loadZlBNews.json")
	public @ResponseBody JSONMap<String, Object> loadZlBNews(
			@FormModel ZlBNews zlBNews, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			SysCodelist sysCodelist = new SysCodelist();
			SysCodelist sysCodelist2 = new SysCodelist();
			SysCodelist sysCodelist3 = new SysCodelist();
			sysCodelist.setKindcode("YES_NO");
			sysCodelist2.setKindcode("NEWS_MODEL");
			sysCodelist3.setKindcode("GRAINTYPE");
			List<SysCodelist> yeorno = zlBNewsService.getCodeList(sysCodelist);
			List<SysCodelist> newsmodel = zlBNewsService
					.getCodeList(sysCodelist2);
			List<SysCodelist> graintype = zlBNewsService
					.getCodeList(sysCodelist3);
			ZlBNews entity = zlBNewsService.loadZlBNews(zlBNews);
			String parentid="";
			if (entity!=null && !"".equals(entity.getParentid())) {
				parentid=entity.getParentid();
			}
			List<ZlBNewsCategory> newscategory = zlBNewsService
					.getZlBNewsCategory();
			List<ZlBNewsCategory> newscategorychild = zlBNewsService
					.getZlBNewsCategoryByParentid(parentid);	
			
			
			String userid=processor.getCurrentUserId();
			SysUserInfo entityuser=new SysUserInfo();
			entityuser.setUserid(userid);
			String usertype="";
			SysUserInfo entity1=sysUserInfoService.getSysUserInfoById(entityuser);
			if (entity1!=null) {
				usertype=entity1.getUsertype();
			} 
			if (!"1".equals(usertype)){
				newscategorychild = zlBNewsService.getZlBNewsCategoryByParentidAndUserid(parentid,userid);	
				newscategory=zlBNewsService.getZlBNewsCategoryByUserid(userid);
			}
			
			//查询部门列表
			List<ZlBDepartment> zlBDepartmentlist=new ArrayList<>();
			ZlBDepartment entityzlbdepartment=new ZlBDepartment();
			zlBDepartmentlist=zlBDepartmentDAO.queryZlBDepartmentList(entityzlbdepartment);
			
			
			List<ZlBDepartmentUser> zlBDepartmentUserlist=new ArrayList<>();
			ZlBDepartmentUser zlBDepartmentUser=new ZlBDepartmentUser();
			zlBDepartmentUser.setDepartmentid(entity.getDepartment());
			zlBDepartmentUserlist=zlBDepartmentUserDAO.queryZlBDepartmentUserList(zlBDepartmentUser);
			
			model.put("zlBDepartmentlist", zlBDepartmentlist);
			model.put("zlBDepartmentUserlist", zlBDepartmentUserlist);
			model.put("entity", entity);
			model.put("newsmodel", newsmodel);
			model.put("newscategory", newscategory);
			model.put("newscategorychild", newscategorychild);
			model.put("yeorno", yeorno);
			model.put("graintype", graintype);
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
	 * 修改新闻
	 * 
	 * @param zlBNews
	 * @param processor
	 * @return
	 */
	@RequestMapping("/update.json")
	public @ResponseBody JSONMap<String, Object> update(
			@FormModel ZlBNews zlBNews, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			zlBNews.setUpdateuserid(processor.getCurrentUserId());
			int flag = zlBNewsService.update(zlBNews);
			model.put("flag", flag);
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
	 * 删除新闻
	 * 
	 * @param zlBNews
	 * @param processor
	 * @return
	 */
	@RequestMapping("/deleteZlBNews.json")
	public @ResponseBody JSONMap<String, Object> deleteZlBNews(
			@FormModel ZlBNews zlBNews, @FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			int flag = zlBNewsService.deleteZlBNews(zlBNews);
			model.put("flag", flag);
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
	 * 新闻总数量
	 * @author zll
	 */
	@RequestMapping("/queryZlBNewsCount.json")
	public @ResponseBody JSONMap<String, Object> queryZlBNewsCount(@FormModel ZlBNews zlBNews){
		JSONMap<String , Object> model=new JSONMap<String, Object>();
		try {
			ZlBNews entity=zlBNewsService.queryZlBNewsCount(zlBNews); 
			model.put("entity", entity);
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
	 * 新闻总阅读量
	 * @author zll
	 */
	@RequestMapping("/queryZlBNewsVisitcount.json")
	public @ResponseBody JSONMap<String, Object> queryZlBNewsVisitcount(@FormModel ZlBNews zlBNews){
		JSONMap<String , Object> model=new JSONMap<String, Object>();
		try {
			ZlBNews entity=zlBNewsService.queryZlBNewsVisitcount(zlBNews); 
			model.put("entity", entity);
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
	 * 新闻阅读量百分比
	 * @author zll
	 */
	@RequestMapping("/queryZlBNewsPercent.json")
	public @ResponseBody JSONMap<String, Object> queryZlBNewsPercent(@FormModel ZlBNews zlBNews){
		JSONMap<String , Object> model=new JSONMap<String, Object>();
		try {
			ZlBNews entity=zlBNewsService.queryZlBNewsPercent(zlBNews); 
			model.put("entity", entity);
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
 * 根据parentid获取子栏目
 * @author Wy	
 * @param zlGoodsType
 * @param processor
 * @return
 *  分类菜单，终端选择判断
 */
@RequestMapping("/getZlBNewsCategoryListByParentid.json")	
public @ResponseBody JSONMap<String,Object> getZlBNewsCategoryListByParentid(@FormModel ZlBNewsCategory zlBNewsCategory,@FormModel Processor processor) 
	{
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try {
			SysUserInfo entity=new SysUserInfo();
			entity.setUserid(processor.getCurrentUserId());
			SysUserInfo entity1=sysUserInfoService.getSysUserInfoById(entity);
			String usertype="";
			if (entity1!=null) {
				usertype=entity1.getUsertype();
			}
			ZlBNewsCategory zlGoodType1=zlBNewClassService.getZlBNewsCategoryById(zlBNewsCategory);
		    if(zlGoodType1!=null){
			List<ZlBNewsCategory> zlBNewsCategoryList=zlBNewClassService.getZlBNewsCategoryListByParentid(zlBNewsCategory);
			
			if (!"1".equals(usertype)){
			  zlBNewsCategoryList=zlBNewClassService.getZlBNewsCategoryListByParentidAndUserid(zlBNewsCategory,entity1.getUserid());
			}
			
			model.put("zlBNewsCategoryList", zlBNewsCategoryList);	
		    }
		    
		    
		    
			model.put("entity", zlGoodType1);	
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
 public void exportProject(HttpServletResponse response,HttpServletRequest request,@FormModel ZlBNews zlBNews,String rowname, @FormModel Processor processor) throws Exception {
	
	
	String rowentityname =request.getParameter("rowname");  
//	String rowentityname =String.valueOf(rowname);
	rowname = URLDecoder.decode(rowentityname , "utf-8");
	
	String newFileName="新闻统计";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date now = new Date();
	if (!"".equals(zlBNews.getStime()) && zlBNews.getStime()!=null &&  ( "".equals(zlBNews.getEtime()) || zlBNews.getEtime()==null )) {
		newFileName=zlBNews.getStime()+"至"+sdf.format(now)+"新闻统计";
	}
	
	if ( ( zlBNews.getStime()==null || "".equals(zlBNews.getStime())) && zlBNews.getEtime()!=null  && !"".equals(zlBNews.getEtime())) {
		newFileName="至"+zlBNews.getEtime()+"新闻统计";
	}
	
	if( (!"".equals(zlBNews.getStime()) && zlBNews.getStime()!=null &&  !"".equals(zlBNews.getEtime()) && zlBNews.getEtime()!=null )) {
		newFileName=zlBNews.getStime()+"至"+zlBNews.getEtime()+"新闻统计";
	}
	
  String[] headers=EmptyUtilHelper.headerTitle(rowname); 
	
  String arryentity = EmptyUtilHelper.arryEntity(rowname);  
  
  String[] rowentity=EmptyUtilHelper.atrEntity(rowname);   
  String[] splitentity=new String[rowentity.length];
  for (int i=0;i<rowentity.length;i++ ) {
	  String[] arry=rowentity[i].split("\\.");
	  splitentity[i]=arry[1];
  }
  List<ZlBNews> list = zlBNewsService.queryZlBNewsPageListExcel(zlBNews,processor);
//  List<ZlBDepartment> list = zlBDepartmentService.queryZlBDepartmentListExcel(zlBDepartment,stime,etime);
 try {
	  ExportExcelUtil<ZlBNews> ex = new ExportExcelUtil<ZlBNews>();
	   OutputStream outputStream = response.getOutputStream();
	  ex.exportExcel(headers,splitentity,list, outputStream,newFileName,response);
	  outputStream.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

}
