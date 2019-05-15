package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.system.Pagination;
import com.zhiliang.persistence.dao.ZlBIndexPicDAO;
import com.zhiliang.persistence.entity.ZlBIndexPic;

/**
 * 测试代码生成
 * Application name: Application describing:服务层 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * ZlBIndexPic 的Service
 * @author zhouhaifeng
 */
@Service("ZlBIndexPicService")
public class ZlBIndexPicService {
	
	@Resource
	private ZlBIndexPicDAO zlBIndexPicDAO;
	

	/**
	 * 查询实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBIndexPic> queryZlBIndexPicPageList(ZlBIndexPic entity, int pageIndex, int pageSize) {
		return zlBIndexPicDAO.queryZlBIndexPicPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBIndexPic> queryZlBIndexPicList(ZlBIndexPic entity) {
		return zlBIndexPicDAO.queryZlBIndexPicList(entity);
	}
	

	
	/**
	 * 保存实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBIndexPic(ZlBIndexPic entity)
	{
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		entity.setPublishtime(sf.format(new Date()));
		entity.setId(entity.getId());
		entity.setIsstop("1");
		return zlBIndexPicDAO.saveAddZlBIndexPic(entity);
	}
	
	/**
	 * 删除实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBIndexPic(ZlBIndexPic entity)
	{
		return zlBIndexPicDAO.deleteZlBIndexPic(entity);
	}
	
	/**
	 * 查询实体信息
	 * @param entity
	 * @return
	 */
	public ZlBIndexPic getZlBIndexPicById(ZlBIndexPic entity)
	{
		return zlBIndexPicDAO.getZlBIndexPicById(entity.getId());
	}
	
	/**
	 * 修改实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBIndexPic(ZlBIndexPic entity)
	{
		return zlBIndexPicDAO.saveUpdateZlBIndexPic(entity);
	}
	
	public int isStopZlBIndexPic(ZlBIndexPic entity)
	{
		return zlBIndexPicDAO.isStopZlBIndexPic(entity);
	}
}
