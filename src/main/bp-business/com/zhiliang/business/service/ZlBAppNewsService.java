package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.asm.Type;
import com.repast.core.codelist.SysCodelist;
import com.repast.core.codelist.SysCodelistDAO;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.zhiliang.persistence.dao.ZlBAppNewsCategoryDAO;
import com.zhiliang.persistence.dao.ZlBAppNewsDAO;
import com.zhiliang.persistence.dao.ZlBNewsDAO;
import com.zhiliang.persistence.entity.ZlBCount;
import com.zhiliang.persistence.entity.ZlBCountIp;
import com.zhiliang.persistence.entity.ZlBNews;
import com.zhiliang.persistence.entity.ZlBNewsAttach;
import com.zhiliang.persistence.entity.ZlBNewsCategory;
import com.zhiliang.persistence.entity.ZlBNewsPraise;

@Service("ZlBAppNewsService")
public class ZlBAppNewsService {
	@Resource(name = "ZlBAppNewsDAO")
	private ZlBAppNewsDAO zlBAppNewsDAO;
	@Resource(name = "ZlBNewsDAO")
	private ZlBNewsDAO zlBNewsDAO;
 

@Resource
private SysCodelistDAO sysCodelistDAO;

public List<ZlBNewsCategory> getZlBNewsCategory(){
	
	return zlBAppNewsDAO.getZlBNewsCategory();
}
	
/**
 * 获取新闻列表(分页)
 * @param zlBNews
 * @param processor
 * @return
 */
public Pagination<ZlBNews>queryNewsList(ZlBNews zlBNews,Processor processor){
	
	return zlBAppNewsDAO.queryZlBNewsList(zlBNews, processor.getPageIndex(), processor.getPageSize());
	
}	

/**
 * 获取新闻列表(不分页)
 * @param zlBNews
 * @param processor
 * @return
 */
public List<ZlBNews>queryNewsList2(ZlBNews zlBNews){
	
	return zlBAppNewsDAO.queryZlBNewsList2(zlBNews);
	
}

/**
 * 详情页
 * @param zlBNews
 * @return
 */
public ZlBNews detailed(ZlBNews zlBNews){
	
	zlBNews=zlBAppNewsDAO.getZlBNewsById2(zlBNews.getNewsid());
	if (zlBNews!=null) {
		List<ZlBNewsAttach> zlBNewsAttach=zlBNewsDAO.getZlBNewsAttachByNewsid(zlBNews.getNewsid());
		if (zlBNewsAttach.size()>0) {
			zlBNews.setZlbnewsattachlist(zlBNewsAttach);
		}
	}
	return zlBNews;
}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public ZlBNews detailedUpAndDown(ZlBNews zlBNews,String type){
	
	
	return zlBAppNewsDAO.detailedUpAndDown(zlBNews.getPublishtime(),zlBNews.getCategoryid(),type);
}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public ZlBNewsCategory getZlBNewsCategoryByCategory(String  id){
	
	return zlBAppNewsDAO.getZlBNewsCategoryByCategory(id);
}
/*
 * 查询热点新闻
 */

public List<ZlBNews>queryhotnews(ZlBNews zlBNews){
	
	return zlBAppNewsDAO.queryhotnews();
	
}

/**
 * 搜索新闻
 * @param zlBNews
 * @param processor
 * @return
 */
public Pagination<ZlBNews> serchNewsList(ZlBNews zlBNews,Processor processor){
	
	return zlBAppNewsDAO.queryZlBNewsListByserch(zlBNews, processor.getPageIndex(), processor.getPageSize());
}

/**
 * 周海峰
 * @param sysCodelist
 * @return
 */
public List<SysCodelist> getCodeList(SysCodelist sysCodelist){
	String kind = sysCodelist.getKindcode();
	return sysCodelistDAO.getCodeList(kind);
}

/**
 * 更新新闻访问量
 * @param entity
 * @return
 */
public int updateVisitnum(ZlBNews zlBNews){
	return zlBAppNewsDAO.updateVisitnum(zlBNews);	
}
public int updateVisitnumOfuser(String id){
	return zlBAppNewsDAO.updateVisitnumOfuser(id);	
}
/**
 * 获取新闻列表(不分页)
 * @param zlBNews
 * @param processor
 * @return
 */
public List<ZlBNews>queryNewsListByCategoryid(ZlBNews zlBNews,int num){
	
	return zlBAppNewsDAO.queryNewsListByCategoryid(zlBNews,num);
	
}
/**
 * 获取新闻列表(不分页)
 * @param zlBNews
 * @param processor
 * @return
 */
public List<ZlBNews>queryNewsListByParentCategoryid(ZlBNews zlBNews,int num){
	
	return zlBAppNewsDAO.queryNewsListByParentCategoryid(zlBNews,num);
	
}
/**
 * 获取新闻列表(不分页)
 * @param zlBNews
 * @param processor
 * @return
 */
public List<ZlBNews> queryNewsListTopByCategoryid(ZlBNews zlBNews,int num){
	
	return zlBAppNewsDAO.queryNewsListTopByCategoryid(zlBNews,num);
	
}
/**
 * 根据父级别分类，查询置顶一条 获取新闻列表(不分页)
 * @param zlBNews
 * @param processor
 * @return
 */
public List<ZlBNews> queryNewsListTopByParentCategoryid(ZlBNews zlBNews,int num){
	
	return zlBAppNewsDAO.queryNewsListTopByParentCategoryid(zlBNews,num);
	
}
/**
 * 根据父级别分类，查询置顶一条 获取新闻列表(不分页)
 * @param zlBNews
 * @param processor
 * @return
 */
public List<ZlBNewsCategory> queryNewsCategoryListByParentCategoryid(ZlBNewsCategory zlBNewsCategory,int num){
	
	return zlBAppNewsDAO.queryNewsCategoryListByParentCategoryid(zlBNewsCategory,num);
	
}
/**
 * 菜单
 * @param zlBNews
 * @param processor
 * @return
 */
public List<ZlBNewsCategory> queryNewsCategoryListByParentCategoryidForMenu(ZlBNewsCategory zlBNewsCategory,int num){
	
	return zlBAppNewsDAO.queryNewsCategoryListByParentCategoryidForMenu(zlBNewsCategory,num);
	
}
public List<ZlBNews> queryNewsListTopOfhavepic(ZlBNews zlBNews,int num){
	
	return zlBAppNewsDAO.queryNewsListTopOfhavepic(zlBNews,num);
	
}
public List<ZlBNews> queryNewsBannerOfhavepic(ZlBNews zlBNews,int num){
	
	return zlBAppNewsDAO.queryNewsBannerOfhavepic(zlBNews,num);
	
}

/**
 * 根据父级别分类，查询置顶一条 获取新闻列表(不分页)
 * @param zlBNews
 * @param processor
 * @return
 */
public List<ZlBNewsCategory> queryNewsCategoryListAndNewslistByParentCategoryid(ZlBNewsCategory zlBNewsCategory,int classnum,int newsnum){
	List<ZlBNewsCategory> list=zlBAppNewsDAO.queryNewsCategoryListByParentCategoryid(zlBNewsCategory,classnum);
	if (list.size()>0) {
		for (int i = 0; i < list.size(); i++) {
			String calssidString=list.get(i).getCategoryid();
			ZlBNews entity=new ZlBNews();
			entity.setCategoryid(calssidString);
			List<ZlBNews> newslist=zlBAppNewsDAO.queryNewsListByCategoryid(entity, newsnum);
			list.get(i).setZlBNewslist(newslist);
		}
	}
	return list;
	
}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public ZlBNewsCategory ZlBNewsCategoryByParentid(String  id){
	
	return zlBAppNewsDAO.ZlBNewsCategoryByParentid(id);
}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public int queryZlBNewsPraiseByIpaddress(String ipaddress,String newsid){
	
	return zlBAppNewsDAO.queryZlBNewsPraiseByIpaddress(ipaddress,newsid);
	}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public int queryPraiseByNewsid(String newsid){
	
	return zlBAppNewsDAO.queryPraiseByNewsid(newsid);
	}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public ZlBCount queryZlBCountOfToday(String ctime){
	
	return zlBAppNewsDAO.queryZlBCountOfToday(ctime);
	}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public int saveAddZlBNewsPraise(ZlBNewsPraise entity){
	
	return zlBAppNewsDAO.saveZlBNewsPraise(entity);
	}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public int saveAddZlBCount(ZlBCount entity){
	
	return zlBAppNewsDAO.saveAddZlBCount(entity);
	}
/**
 * 详情页
 * @param zlBNews
 * @return
 */
public int saveAddZlBCountIp(ZlBCountIp entity){
	return zlBAppNewsDAO.saveAddZlBCountIp(entity);
	}
/**
 * 保存修改后新闻信息
 * @param entity
 * @return
 */
public int saveUpdateZlBCountIp(ZlBCountIp entity)
{
	return zlBAppNewsDAO.saveUpdateZlBCountIp(entity);
}
/**
 * 查询当天ip是否登录过
 * @param zlBNews
 * @return
 */
public ZlBCountIp queryZlBCountOfTodayAndIp(String ctime,String ip){
	
	return zlBAppNewsDAO.queryZlBCountOfTodayAndIp(ctime,ip);
	}
/**
 * 保存修改后新闻信息
 * @param entity
 * @return
 */
public int updateDaycountByid(String id)
{
	return zlBAppNewsDAO.updateDaycountByid(id);
}
}
