package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.system.Pagination;
import com.zhiliang.persistence.dao.ZlBAppAdvertisementDAO;
import com.zhiliang.persistence.entity.ZlBAdvertisement;

@Service("ZlBAppAdvertisementService")
public class ZlBAppAdvertisementService {
	
	@Resource
	private ZlBAppAdvertisementDAO zlBAppAdvertisementDAO;
	

	/**
	 * 查询实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBAdvertisement> queryZlBAdvertisementPageList(ZlBAdvertisement entity, int pageIndex, int pageSize) {
		return zlBAppAdvertisementDAO.queryZlBAdvertisementPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
//	public List<ZlBAdvertisement> queryZlBIndexPicList(ZlBAdvertisement entity) {
//		return zlBAppAdvertisementDAO.queryZlBIndexPicList(entity);
//	}
	

	
	/**
	 * 保存实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBAdvertisement(ZlBAdvertisement entity)
	{
		entity.setId(zlBAppAdvertisementDAO.getUUId());
		entity.setStatus("0");
		return zlBAppAdvertisementDAO.saveAddZlBAdvertisement(entity);
	}
	
	/**
	 * 删除实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBAdvertisement(ZlBAdvertisement entity)
	{
		return zlBAppAdvertisementDAO.deleteZlBAdvertisement(entity);
	}
	
	/**
	 * App B端查询广告位信息
	 * @param entity
	 * @return
	 */
	public ZlBAdvertisement loadIndxPicBAdvertisementByStatusAndTag(ZlBAdvertisement entity)
	{
		return zlBAppAdvertisementDAO.loadIndxPicBAdvertisementByStatusAndTag(entity);
	}
	
	/**
	 * 修改实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBAdvertisement(ZlBAdvertisement entity)
	{
		return zlBAppAdvertisementDAO.saveUpdateZlBAdvertisement(entity);
	}
	/**
	 * 是否启用
	 * @param entity
	 * @return
	 */
	public int isStopZlBAdvertisement(ZlBAdvertisement entity)
	{
		String status=entity.getStatus();  //启用状态
		if (status.equals("1")) {
			entity.setStatus("0");
			zlBAppAdvertisementDAO.updateZlBAdvertisementStatus(entity);   //根据端口 把所有状态置0
			entity.setStatus("1"); 
		} else {
			entity.setStatus("1");
			zlBAppAdvertisementDAO.updateZlBAdvertisementStatus(entity);
			entity.setStatus("0");
		}
		
		
		return zlBAppAdvertisementDAO.isStopZlBAdvertisement(entity);
	}
	/**
	 * 查询实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBAdvertisement> loadAdvertisementListByTag(ZlBAdvertisement entity) {
		return zlBAppAdvertisementDAO.loadAdvertisementListByTag(entity);
	}
	
}
