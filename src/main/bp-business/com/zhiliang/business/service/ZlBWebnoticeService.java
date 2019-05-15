package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiliang.persistence.dao.ZlBWebnoticeDAO;
import com.zhiliang.persistence.entity.ZlBWebNotice;
import com.repast.core.system.Pagination;

/**
 * 网站公告
 * Application name: Application describing:服务层 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * ZlBWebnotice 的Service
 * @author superma
 */
@Service("ZlBWebnoticeService")
public class ZlBWebnoticeService {
	
	@Resource
	private ZlBWebnoticeDAO zlBWebnoticeDAO;
	

	/**
	 * 查询实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBWebNotice> queryZlBWebnoticePageList(ZlBWebNotice entity, int pageIndex, int pageSize) {
		return zlBWebnoticeDAO.queryZlBWebnoticePageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBWebNotice> queryZlBWebnoticeList(ZlBWebNotice entity) {
		return zlBWebnoticeDAO.queryZlBWebnoticeList(entity);
	}
	

	
	/**
	 * 保存实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBWebnotice(ZlBWebNotice entity)
	{
		Date curdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		entity.setPublistime(sdf.format(curdate));
		entity.setId(zlBWebnoticeDAO.getUUId());
		return zlBWebnoticeDAO.saveAddZlBWebnotice(entity);
	}
	
	/**
	 * 删除实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBWebnotice(ZlBWebNotice entity)
	{
		return zlBWebnoticeDAO.deleteZlBWebnotice(entity);
	}
	
	/**
	 * 查询实体信息
	 * @param entity
	 * @return
	 */
	public ZlBWebNotice getZlBWebnoticeById(ZlBWebNotice entity)
	{
		return zlBWebnoticeDAO.getZlBWebnoticeById(entity.getId());
	}
	
	/**
	 * 修改实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBWebnotice(ZlBWebNotice entity)
	{
		return zlBWebnoticeDAO.saveUpdateZlBWebnotice(entity);
	}
	/**
	 * 查询实体信息
	 * @param entity
	 * @return
	 */
	public ZlBWebNotice getZlBWebnoticeForlast(ZlBWebNotice entity)
	{
		return zlBWebnoticeDAO.getZlBWebnoticeForlast(entity);
	}
	
}
