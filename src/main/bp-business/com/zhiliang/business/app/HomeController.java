package com.zhiliang.business.app;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.domain.Data;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.auth.Author;
import com.repast.core.spring.auth.CheckType;
import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.JSONMap;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.sun.org.apache.bcel.internal.generic.I2F;
import com.zhiliang.business.service.ZlBAppNewsService;
import com.zhiliang.business.service.ZlBMagazineService;
import com.zhiliang.business.service.ZlBAppAdvertisementService;
import com.zhiliang.business.service.ZlBNewClassService;
//import com.zhiliang.business.service.ZlBAppTradingRecodeService;
import com.zhiliang.persistence.entity.ZlBAdvertisement;
import com.zhiliang.persistence.entity.ZlBCount;
import com.zhiliang.persistence.entity.ZlBCountIp;
import com.zhiliang.persistence.entity.ZlBMagazine;
import com.zhiliang.persistence.entity.ZlBNews;
import com.zhiliang.persistence.entity.ZlBNewsCategory;
import com.zhiliang.persistence.entity.ZlBNewsPraise;
import com.zhiliang.persistence.entity.ZlBTradingRecode;

/**
 * 首页相关信息
 * @author 王炎
 *
 */
@Controller
@RequestMapping("/HomeController")
public class HomeController 
{	
	
	@Resource(name="ZlBAppNewsService")
	private ZlBAppNewsService zlBAppNewsService;
	@Resource(name="ZlBNewClassService")
	private ZlBNewClassService zlBNewClassService;
	@Resource(name="ZlBAppAdvertisementService")
	private  ZlBAppAdvertisementService zlBAppAdvertisementService;
//	@Resource(name="ZlBTradingRecodeService")
//	private  ZlBTradingRecodeService zlBTradingRecodeService;
	@Resource
	private ZlBMagazineService zlBMagazineService;
	/**
	 * 首页
	 * @author wy
	 * @return
	 */
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/index")
	public String showindexPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/index";
	}	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/indexdetail")//新闻详细
	public String showdindexdetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/indexlist")//新闻详细
	public String showindexlistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/news")//总行要闻
	public String shownewsPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/news";
	}	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/officedynamic")//部室动态
	public String showintegrityPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/news";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/officedynamiclist")//新闻详细
	public String showdofficedynamiclistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/officedynamicdetail")//新闻详细
	public String showdofficedynamicdetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	
	
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/party")//党团建设
	public String showrulesPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/news";
	}	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/partylist")//新闻详细
	public String showdpartylistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/partydetail")//新闻详细
	public String showdpartydetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/alarm")//党团建设
	public String showalarmPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/alarm";
	}	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/alarmlist")//新闻详细
	public String showdalarmlistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/alarmdetail")//新闻详细
	public String showdalarmdetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/business")//经营信息
	public String showtrainingPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/news";
	}	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/businesslist")//新闻详细
	public String showdbusinesslistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/businessdetail")//新闻详细
	public String showdbusinessdetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/basicstyle")//基层风采
	public String showwarehousePage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/news";
	}	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/basicstylelist")//新闻详细
	public String showdbasicstylelistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/basicstyledetail")//新闻详细
	public String showdbasicstyledetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/industryobserve")//行业观察
	public String showtaxPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/news";
	}	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/industryobservelist")//新闻详细
	public String showdindustryobservelistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/industryobservedetail")//新闻详细
	public String showdindustryobservedetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	
	
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/employees")//员工天地
	public String showdynamicPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/news";
	}	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/employeeslist")//新闻详细
	public String showdemployeeslistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/employeesdetail")//新闻详细
	public String showdemployeesdetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	
	
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/training")//培训之窗
	public String showdisclosurePage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/news";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/traininglist")//新闻详细
	public String showdtraininglistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/trainingdetail")//新闻详细
	public String showdtrainingdetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/newslist")//新闻详细
	public String showdnewslistPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newslist";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/newsdetail")//新闻详细
	public String showdnewsdetailPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/newsdetail";
	}
	
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/branch")//部室及分行
	public String showdbranchPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/branch";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/leader")//新闻详细
	public String showdleaderPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/leader";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/branches")//新闻详细
	public String showdbranchesPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/branches";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/jubao")//新闻详细
	public String showdjubaoPage(HttpServletRequest request, HttpServletResponse response,Model model){
	return "/index/jubao";
	}
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/honor")//新闻详细
	public String showdhonorPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/honor";
	}
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/magazine")//新闻详细
	public String showdmagazinePage(HttpServletRequest request, HttpServletResponse response,Model model){
	return "/index/magazine";
	}
	
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/book")//新闻详细
	public String showdbookPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/index/book";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/search")//搜索
	public String showsearchPage(HttpServletRequest request, HttpServletResponse response,Model model){
		String newstitle = request.getParameter("newstitle");
		model.addAttribute("newstitle",newstitle);
	return "/index/search";
	}
	/*@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/reference")//信息公开
	public String showreferencePage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/gsj/news/news_reference";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/notice")//信息公开
	public String shownoticePage(HttpServletRequest request, HttpServletResponse response,Model model){
		String opid = request.getParameter("opid");
		model.addAttribute("opid",opid);
	return "/gsj/news/notice";
	}

	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/reg")//注册
	public String showRegPage(HttpServletRequest request,HttpServletResponse response){
	return "/gsj/news/reg";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/login")//登录
	public String showloginPage(HttpServletRequest request,HttpServletResponse response){
	return "/gsj/news/login";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/speak")//登录
	public String showspeakPage(HttpServletRequest request,HttpServletResponse response){
	return "/gsj/news/news_speak";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/password")//修改密码
	public String showpasswordPage(HttpServletRequest request,HttpServletResponse response){
	return "/gsj/center/password";
	}
	@Author(type=CheckType.NO_CHECK)
	@RequestMapping("/recode")//浏览记录
	public String showrecodePage(HttpServletRequest request,HttpServletResponse response){
	return "/gsj/center/recode";
	}*/
	/**
	 * 不分页查询新闻列表,首页调用，内页不能用
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryNewsListByCategoryid.json")
	public @ResponseBody JSONMap<String,Object> queryNewsListByCategoryid(@FormModel("zlBNews") ZlBNews zlBNews,int num,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			ZlBNewsCategory category=zlBAppNewsService.getZlBNewsCategoryByCategory(zlBNews.getCategoryid());
			List<ZlBNews> newslist=zlBAppNewsService.queryNewsListByCategoryid(zlBNews,num);
			List<ZlBNews> newslisttop=zlBAppNewsService.queryNewsListTopByCategoryid(zlBNews,1);
			model.put("category",category);
			model.put("newslisttop",newslisttop);
			model.put("data",newslist);
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
	 * 按父级分类 不分页查询新闻列表,首页调用，内页不能用
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryNewsListByParentCategoryid.json")
	public @ResponseBody JSONMap<String,Object> queryNewsListByParentCategoryid(@FormModel("zlBNews") ZlBNews zlBNews,int num,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			
			ZlBNewsCategory category=zlBAppNewsService.getZlBNewsCategoryByCategory(zlBNews.getCategoryid());
			List<ZlBNews> newslisttop=zlBAppNewsService.queryNewsListTopByParentCategoryid(zlBNews,1);
			//新闻列表
			List<ZlBNews> newslist=zlBAppNewsService.queryNewsListByParentCategoryid(zlBNews,num);
			model.put("category",category);
			model.put("newslisttop",newslisttop);
			model.put("data",newslist);
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
	 * 按父级分类 查询子分类
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryNewsCategoryListByParentCategoryid.json")
	public @ResponseBody JSONMap<String,Object> queryNewsCategoryListByParentCategoryid(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory,int num,String type,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			ZlBNewsCategory category=new ZlBNewsCategory();
			category=zlBAppNewsService.getZlBNewsCategoryByCategory(zlBNewsCategory.getCategoryid());
			ZlBNewsCategory parentcategory=new ZlBNewsCategory();
			if ("0".equalsIgnoreCase(type)) {
				 zlBNewsCategory.setCategoryid(category.getParentid());
				 
				 parentcategory=zlBAppNewsService.getZlBNewsCategoryByCategory(category.getParentid());
			}
			List<ZlBNewsCategory> list=zlBAppNewsService.queryNewsCategoryListByParentCategoryid(zlBNewsCategory,num);
			//新闻分类列表
			model.put("data",list);
			model.put("category",category);
			model.put("parentcategory",parentcategory);
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
	 * @param zlBNewsCategory
	 * @param num
	 * @param type
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryNewsCategoryListByParentCategoryidForMenu.json")
	public @ResponseBody JSONMap<String,Object> queryNewsCategoryListByParentCategoryidForMenu(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory,int num,String type,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			ZlBNewsCategory category=new ZlBNewsCategory();
			category=zlBAppNewsService.getZlBNewsCategoryByCategory(zlBNewsCategory.getCategoryid());
			ZlBNewsCategory parentcategory=new ZlBNewsCategory();
			if ("0".equalsIgnoreCase(type)) {
				 zlBNewsCategory.setCategoryid(category.getParentid());
				 
				 parentcategory=zlBAppNewsService.getZlBNewsCategoryByCategory(category.getParentid());
			}
			List<ZlBNewsCategory> list=zlBAppNewsService.queryNewsCategoryListByParentCategoryidForMenu(zlBNewsCategory,num);
			//新闻分类列表
			model.put("data",list);
			model.put("category",category);
			model.put("parentcategory",parentcategory);
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
	 * 按父级分类 查询子分类及新闻列表
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryNewsCategoryListAndNewslistByParentCategoryid.json")
	public @ResponseBody JSONMap<String,Object> queryNewsCategoryListAndNewslistByParentCategoryid(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory,int classnum,int newsnum,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			ZlBNewsCategory category=zlBAppNewsService.getZlBNewsCategoryByCategory(zlBNewsCategory.getCategoryid());
			List<ZlBNewsCategory> list=zlBAppNewsService.queryNewsCategoryListAndNewslistByParentCategoryid(zlBNewsCategory,classnum,newsnum);
			//新闻分类列表
			model.put("category",category);
			model.put("data",list);
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
	 * 获取横幅广告
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryadvlist.json")
	public @ResponseBody JSONMap<String,Object> queryadvlist(@FormModel("zlBAdvertisement") ZlBAdvertisement zlBAdvertisement,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			zlBAdvertisement.setTag("1");
			List<ZlBAdvertisement> list1=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("2");
			List<ZlBAdvertisement> list2=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("3");
			List<ZlBAdvertisement> list3=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("4");
			List<ZlBAdvertisement> list4=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("5");
			List<ZlBAdvertisement> list5=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("6");
			List<ZlBAdvertisement> list6=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("7");
			List<ZlBAdvertisement> list7=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("8");
			List<ZlBAdvertisement> list8=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("9");
			List<ZlBAdvertisement> list9=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("10");
			List<ZlBAdvertisement> list10=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("11");
			List<ZlBAdvertisement> list11=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("12");
			List<ZlBAdvertisement> list12=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			zlBAdvertisement.setTag("13");
			List<ZlBAdvertisement> list13=zlBAppAdvertisementService.loadAdvertisementListByTag(zlBAdvertisement);
			model.put("list1",list1);
			model.put("list2",list2);
			model.put("list3",list3);
			model.put("list4",list4);
			model.put("list5",list5);
			model.put("list6",list6);
			model.put("list7",list7);
			model.put("list8",list8);
			model.put("list9",list9);
			model.put("list10",list10);
			model.put("list11",list11);
			model.put("list12",list12);
			model.put("list13",list13);
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
	 * 加载热点新闻
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("queryNewsListTopOfhavepic.json")
	public @ResponseBody JSONMap<String,Object> queryNewsListTopOfhavepic(@FormModel("zlBNews") ZlBNews zlBNews,int num,
			@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			List<ZlBNews> newslist=zlBAppNewsService.queryNewsListTopOfhavepic(zlBNews,num);
			model.put("data",newslist);
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
	 * 浏览记录
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
/*	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryZlBTradingRecodeList.json")
	public @ResponseBody JSONMap<String,Object> queryZlBTradingRecodeList(@FormModel("ZlBTradingRecode") ZlBTradingRecode zlBTradingRecode,
			@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			if (!"".equals(processor.getCurrentUserId()) && processor.getCurrentUserId()!=null) {
				zlBTradingRecode.setUserid(processor.getCurrentUserId());
			}			
			Pagination<ZlBTradingRecode> list=zlBTradingRecodeService.queryTradingRecodeList(zlBTradingRecode, processor.getPageIndex(),processor.getPageSize());
			
			model.put("data",list);
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
					
		}
		
		return model;
	}*/
	/**
	 * 根据parentid读取分类主页内容
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("queryNewsClassListByParentid.json")
	public @ResponseBody JSONMap<String,Object> queryNewsClassListByParentid(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory,int num,
			@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			ZlBNewsCategory entity=new ZlBNewsCategory();
			entity.setCategoryid(zlBNewsCategory.getParentid());
			entity=zlBNewClassService.getZlBNewsCategoryById(entity);
			List<ZlBNewsCategory> list=zlBNewClassService.queryNewClassListByParentid(zlBNewsCategory,num);
			model.put("entity",entity);
			model.put("data",list);
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
	 * 根据parentid获取置顶新闻（分类首页热点新闻）
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("queryIstopNewsListByParentid.json")
	public @ResponseBody JSONMap<String,Object> queryIstopNewsListByParentid(@FormModel("zlBNewsCategory") ZlBNewsCategory zlBNewsCategory,int num,
			@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			List<ZlBNews> list=zlBNewClassService.queryZlBNewsListByParentid(zlBNewsCategory.getParentid(),num);
			model.put("data",list);
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
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/updateVisitnum.json")
	public @ResponseBody JSONMap<String,Object> updateVisitnum(@FormModel("zlBNews") ZlBNews zlBNews,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			int flag=zlBAppNewsService.updateVisitnum(zlBNews);
			
			model.put("data",flag);
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
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/detailed.json")
	public @ResponseBody JSONMap<String,Object> detailed(@FormModel("zlBNews") ZlBNews zlBNews,
			@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();
		try {
			ZlBNews entity2=zlBAppNewsService.detailed(zlBNews);
			ZlBNews entity_up=new ZlBNews();
			ZlBNews entity_down=new ZlBNews();
			//查询上下一条信息
			if (entity2!=null) {
				  entity_up=zlBAppNewsService.detailedUpAndDown(entity2,"up");
				  entity_down=zlBAppNewsService.detailedUpAndDown(entity2,"down");
			}
			ZlBNewsCategory category=new ZlBNewsCategory();
			ZlBNewsCategory parentcategory=new ZlBNewsCategory();
			if (entity2!=null) {
				//父级别名称
				 category=zlBAppNewsService.ZlBNewsCategoryByParentid(entity2.getCategoryid());
				 parentcategory=zlBAppNewsService.ZlBNewsCategoryByParentid(category.getParentid());
			}
			model.put("category",category);
			model.put("parentcategory",parentcategory);
			model.put("entity_up",entity_up);
			model.put("entity_down",entity_down);
			model.put("entity",entity2);
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		
		
		return model;
	}
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryNewsList.json")
	public @ResponseBody JSONMap<String,Object> queryNewsList(@FormModel("zlBNews") ZlBNews zlBNews,
			@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
//			SysCodelist sysCodelist = new SysCodelist();
//			sysCodelist.setKindcode("GRAINTYPE");
//			List<SysCodelist> graintype = zlBNewsService.getCodeList(sysCodelist);//绮绉嶇被锛堢帀绫炽�佹按绋汇�佸ぇ璞嗭級
			ZlBNewsCategory category=zlBAppNewsService.getZlBNewsCategoryByCategory(zlBNews.getCategoryid());
			Pagination<ZlBNews> newslist=zlBAppNewsService.queryNewsList(zlBNews, processor);
			model.put("category",category );
			model.put("data",newslist);
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
	 * 点赞
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/updatePraise.json")
	public @ResponseBody JSONMap<String,Object> updatePraise(@FormModel("zlBNews") ZlBNews zlBNews,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			
			String ip = request.getHeader("x-forwarded-for");
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			      ip = request.getHeader("Proxy-Client-IP");
			   }
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			      ip = request.getHeader("WL-Proxy-Client-IP");
			   }
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			      ip = request.getRemoteAddr();
			   }
			   ZlBNewsPraise entity=new ZlBNewsPraise();
			   entity.setIpaddress(ip);
			   entity.setNewsid(zlBNews.getNewsid());
			   int flag=zlBAppNewsService.queryZlBNewsPraiseByIpaddress(ip,zlBNews.getNewsid());
			   if (flag<1) {
				   flag= zlBAppNewsService.saveAddZlBNewsPraise(entity);
			   	}
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
	/**
	 * 查询点赞数量
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryPraiseByNewsid.json")
	public @ResponseBody JSONMap<String,Object> queryPraiseByNewsid(@FormModel("zlBNews") ZlBNews zlBNews,@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			String ip = request.getHeader("x-forwarded-for");
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			      ip = request.getHeader("Proxy-Client-IP");
			   }
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			      ip = request.getHeader("WL-Proxy-Client-IP");
			   }
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			      ip = request.getRemoteAddr();
			   }
			int flag=zlBAppNewsService.queryPraiseByNewsid(zlBNews.getNewsid());
			int flag1=zlBAppNewsService.queryZlBNewsPraiseByIpaddress(ip,zlBNews.getNewsid());
			model.put("flag",flag);
			model.put("flag1",flag1);
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
	 * 查询当日访问情况
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/getCount.json")
	public @ResponseBody JSONMap<String,Object> getCount(@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ctime=sdf.format(now);
			ZlBCount entity=zlBAppNewsService.queryZlBCountOfToday(ctime);
//			if (entity==null) {
//				entity=new ZlBCount();
//				entity.setCtime(ctime);
//				entity.setDaycount("1");
//				entity.setPcount("1");
//				entity.setTotalcount("1");
//				zlBAppNewsService.saveAddZlBCount(entity);
//			}
			model.put("entity",entity);
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
	 * 更新在线时间，更新当日人数
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/updateCount.json")
	public @ResponseBody JSONMap<String,Object> updateCount(@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			String ctime=sdf.format(now);
			String ctime1=sdf1.format(now);
			
			//更新当日访问量
			ZlBCount entity=zlBAppNewsService.queryZlBCountOfToday(ctime1);
			String ip = request.getHeader("x-forwarded-for");
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			      ip = request.getHeader("Proxy-Client-IP");
			   }
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			      ip = request.getHeader("WL-Proxy-Client-IP");
			   }
			   if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			     
				   ip = request.getRemoteAddr();
			   }
			   //查询ip今天是否访问
			   ZlBCountIp entityCountIp=new ZlBCountIp();
			   entityCountIp=zlBAppNewsService.queryZlBCountOfTodayAndIp(ctime1,ip);
			  
					if (entity==null) {
						entity=new ZlBCount();
						entity.setCtime(ctime1);
						entity.setDaycount("1");
						entity.setPcount("1");
						entity.setTotalcount("1");
						zlBAppNewsService.saveAddZlBCount(entity);
					}else {
						 if (entityCountIp==null) {   
						zlBAppNewsService.updateDaycountByid(entity.getId());
						 }
					}
			  
			
				
			
			   if (entityCountIp==null) {
				   entityCountIp=new ZlBCountIp();
				   entityCountIp.setIpaddress(ip);
				   entityCountIp.setUpdatetime(ctime);
				   zlBAppNewsService.saveAddZlBCountIp(entityCountIp);
			   	}else {
			   		entityCountIp.setUpdatetime(ctime);
			   		zlBAppNewsService.saveUpdateZlBCountIp(entityCountIp);
			   	}
		 
			model.put("entity",entity);
			model.put("entityCountIp",entityCountIp);
//			model.put("flag1",flag1);
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
	 * 新闻分类主页图片轮播图
	 * @param zlBNews
	 * @param processor
	 * @param request
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("queryNewsBannerOfhavepic.json")
	public @ResponseBody JSONMap<String,Object> queryNewsBannerOfhavepic(@FormModel("zlBNews") ZlBNews zlBNews,int num,
			@FormModel Processor processor,HttpServletRequest request) {
		JSONMap<String,Object> model = new JSONMap<String,Object>();	
		try {
			List<ZlBNews> newslist=zlBAppNewsService.queryNewsBannerOfhavepic(zlBNews,num);
			model.put("data",newslist);
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
	 * 分页查询杂志信息
	 * @param processor
	 * @return
	 */
	@Author(type = CheckType.NO_CHECK)
	@RequestMapping("/queryZlBMagazinePageList.json")
	public @ResponseBody JSONMap<String, Object> queryZlBMagazinePageList(@FormModel ZlBMagazine zlBMagazine,@FormModel Processor processor) {
		JSONMap<String, Object> model = new JSONMap<String, Object>();
		try {
			Pagination<ZlBMagazine> list = zlBMagazineService.queryZlBMagazinePageList(zlBMagazine,processor.getPageIndex(),processor.getPageSize());
			model.put("data", list, "List<ZlBMagazine>");
			model.put(SysConstant.OP_FLAG, true);
			model.put(SysConstant.OP_MESSAGE, SysConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(SysConstant.OP_FLAG, false);
			model.put(SysConstant.OP_MESSAGE, SysConstant.Exception);
		}
		return model;
	}
}
