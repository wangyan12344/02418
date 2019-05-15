package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.codelist.SysCodelist;
import com.repast.core.codelist.SysCodelistDAO;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.zhiliang.persistence.dao.SysUserInfoDAO;
import com.zhiliang.persistence.dao.ZlBNewsCategoryDAO;
import com.zhiliang.persistence.dao.ZlBNewsDAO;
import com.zhiliang.persistence.entity.SysUserInfo;
import com.zhiliang.persistence.entity.ZlBNews;
import com.zhiliang.persistence.entity.ZlBNewsAttach;
import com.zhiliang.persistence.entity.ZlBNewsCategory;

@Service("ZlBNewsService")
public class ZlBNewsService {
	@Resource(name = "ZlBNewsDAO")
	private ZlBNewsDAO zlBNewsDAO;

	@Resource
	private SysCodelistDAO sysCodelistDAO;

	@Resource
	private ZlBNewsCategoryDAO zlBNewsCategoryDAO;
	@Resource
	private SysUserInfoDAO sysUserInfoDAO;
	/**
	 * 新闻列表查询
	 * 
	 * @param zlBNews
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBNews> queryZlBNewsPageList(ZlBNews zlBNews,
		int pageIndex, int pageSize,Processor processor) {
		String useridString=processor.getCurrentUserId();
		SysUserInfo entity=sysUserInfoDAO.getSysUserInfoById(useridString);
		if (entity!=null) {
//			processor.setShopid(entity.getShopid());
			processor.setShopid(entity.getUsertype());
		}
		return zlBNewsDAO.queryZlBNewsList(zlBNews, pageIndex, pageSize,processor);
	}
	public Pagination<ZlBNews> queryZlBNewsListByPraise(ZlBNews zlBNews,int pageIndex, int pageSize,Processor processor) {
			String useridString=processor.getCurrentUserId();
			SysUserInfo entity=sysUserInfoDAO.getSysUserInfoById(useridString);
			if (entity!=null) {
//				processor.setShopid(entity.getShopid());
				processor.setShopid(entity.getUsertype());
			}
			return zlBNewsDAO.queryZlBNewsListByPraise(zlBNews, pageIndex, pageSize,processor);
		}
	/**
	 * 
	 * @param zlBNews
	 * @param processor
	 * @return
	 */
	public List<ZlBNews> queryZlBNewsPageListExcel(ZlBNews zlBNews,Processor processor) {
			String useridString=processor.getCurrentUserId();
			SysUserInfo entity=sysUserInfoDAO.getSysUserInfoById(useridString);
			if (entity!=null) {
				processor.setShopid(entity.getUsertype());
			}
			return zlBNewsDAO.queryZlBNewsPageListExcel(zlBNews, processor);
		}
	/**
	 * 获取
	 * 
	 * @author
	 * @param sysCodelist
	 * @return
	 */
	public List<SysCodelist> getCodeList(SysCodelist sysCodelist) {
		return sysCodelistDAO.getCodeList(sysCodelist.getKindcode());
	}

	// 获取新闻分类
	public List<ZlBNewsCategory> getZlBNewsCategory() {

		return zlBNewsDAO.getZlBNewsCategory();
	}
	// 获取新闻分类
	public List<ZlBNewsCategory> getZlBNewsCategoryByUserid(String userid) {

		return zlBNewsDAO.getZlBNewsCategoryByUserid(userid);
	}
	
	// 获取新闻分类
	public List<ZlBNewsCategory> getZlBNewsCategoryByParentid(String parentid) {

		return zlBNewsDAO.getZlBNewsCategoryByParentid(parentid);
	}
	// 获取新闻分类
	public List<ZlBNewsCategory> getZlBNewsCategoryByParentidAndUserid(String parentid,String userid) {

		return zlBNewsDAO.getZlBNewsCategoryByParentidAndUserid(parentid,userid);
	}
	/**
	 * 保存新增新闻
	 * 
	 * @param zlBNews
	 * @param processor
	 * @return
	 */
	public int saveZlBNews(ZlBNews zlBNews, Processor processor) {
		//
		String newsid=zlBNewsDAO.getUUId();
		zlBNews.setNewsid(newsid);
		zlBNews.setPublisherid(processor.getCurrentUserId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		if("".equals(zlBNews.getPublishtime()) || zlBNews.getPublishtime()==null){
			zlBNews.setPublishtime(sdf.format(now));
		} 
		String str = Long.toString(System.currentTimeMillis());
		str = str.substring(str.length() - 3, str.length());
		int strint = Integer.parseInt(str);
//		zlBNews.setVisitnum(strint + "");
		zlBNews.setVisitnum("0");
		zlBNews.setIspush("0");
		zlBNews.setAdduserid(processor.getCurrentUserId());
		zlBNews.setUpdateuserid(processor.getCurrentUserId());
//		if ("1".equals(zlBNews.getIstop())) {
//			//把其他置顶文件取消置顶
//			zlBNewsDAO.saveUpdateNewsByistop(zlBNews.getCategoryid());
//		}
		if ( !"".equals(zlBNews.getPacktypes())&& zlBNews.getPacktypes()!=null && !"".equals(zlBNews.getPackprices()) && zlBNews.getPackprices()!=null) {
			String[] packtypes=zlBNews.getPacktypes().substring(1).split(",");
			String[] packprices=zlBNews.getPackprices().substring(1).split(",");
			for(int i=0;i<packprices.length;i++){
				if(packtypes[i].length()>0&&packprices[i].length()>0){
				ZlBNewsAttach zlBNewsAttach=new ZlBNewsAttach();
					zlBNewsAttach.setAttachid(zlBNewsDAO.getUUId());
					zlBNewsAttach.setAttachtype("0");
					zlBNewsAttach.setAttachtitle(packtypes[i]);
					zlBNewsAttach.setAttachpath(packprices[i]);
					zlBNewsAttach.setAttachsize("0");
					zlBNewsAttach.setOrdernum(toString().valueOf(i));
					zlBNewsAttach.setNewsid(newsid);
					zlBNewsDAO.saveNew(zlBNewsAttach);
				}
			}
		}
	
		
		
		int flag = zlBNewsDAO.saveZlBNews(zlBNews);

		return flag;
	}

 

	/**
	 * 查询新闻详情
	 * 
	 * @param id
	 * @return
	 */
	public ZlBNews loadZlBNews(ZlBNews zlBNews) {
		zlBNews=zlBNewsDAO.getEntityById(zlBNews.getNewsid(), ZlBNews.class);
		if (zlBNews!=null) {
			List<ZlBNewsAttach> zlBNewsAttach=zlBNewsDAO.getZlBNewsAttachByNewsid(zlBNews.getNewsid());
			if (zlBNewsAttach.size()>0) {
				zlBNews.setZlbnewsattachlist(zlBNewsAttach);
			}
		}
		return zlBNews;
	}

	/**
	 * 保存修改新闻
	 * 
	 * @param zlBNews
	 * @return
	 */
	public int update(ZlBNews zlBNews) {
		
		/*if ("1".equals(zlBNews.getIstop())) {
			//把其他置顶文件取消置顶
			zlBNewsDAO.saveUpdateNewsByistop(zlBNews.getCategoryid());
		}*/
		
		zlBNewsDAO.deleteZlBNewsAttachById(zlBNews.getNewsid());
		if ( !"".equals(zlBNews.getPacktypes())&& zlBNews.getPacktypes()!=null && !"".equals(zlBNews.getPackprices()) && zlBNews.getPackprices()!=null) {
		String[] packtypes=zlBNews.getPacktypes().substring(1).split(",");
		String[] packprices=zlBNews.getPackprices().substring(1).split(",");
		for(int i=0;i<packprices.length;i++){
			if(packtypes[i].length()>0&&packprices[i].length()>0){
			ZlBNewsAttach zlBNewsAttach=new ZlBNewsAttach();
				zlBNewsAttach.setAttachid(zlBNewsDAO.getUUId());
				zlBNewsAttach.setAttachtype("0");
				zlBNewsAttach.setAttachtitle(packtypes[i]);
				zlBNewsAttach.setAttachpath(packprices[i]);
				zlBNewsAttach.setAttachsize("0");
				zlBNewsAttach.setOrdernum(toString().valueOf(i));
				zlBNewsAttach.setNewsid(zlBNews.getNewsid());
				zlBNewsDAO.saveNew(zlBNewsAttach);
			}
		}
		}
		
		int flag = zlBNewsDAO.updateZlBNews(zlBNews);
		return flag;
	}

	/**
	 * 删除新闻
	 * 
	 * @param zlBNews
	 * @return
	 */

	public int deleteZlBNews(ZlBNews zlBNews) {

		return zlBNewsDAO.deleteZlBNews(zlBNews);
	}
	
	
	/**
	 * 新闻总数量
	 * @author zll
	 */
	public ZlBNews queryZlBNewsCount(ZlBNews entity){
		return zlBNewsDAO.queryZlBNewsCount(entity);
	}
	
	/**
	 * 新闻总阅读量
	 * @author zll
	 */
	public ZlBNews queryZlBNewsVisitcount(ZlBNews entity){
		return zlBNewsDAO.queryZlBNewsVisitcount(entity);
	}
	
	/**
	 * 新闻阅读量百分比
	 * @author zll
	 */
	public ZlBNews queryZlBNewsPercent(ZlBNews entity){
		entity.setVisitcount(zlBNewsDAO.queryZlBNewsVisitcount(entity).getVisitcount());
		return zlBNewsDAO.queryZlBNewsPercent(entity);
	}

}
