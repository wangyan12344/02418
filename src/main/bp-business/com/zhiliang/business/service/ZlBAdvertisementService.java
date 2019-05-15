package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.system.Pagination;
import com.zhiliang.persistence.dao.ZlBAdvertisementDAO;
import com.zhiliang.persistence.entity.ZlBAdvertisement;

@Service("ZlBAdvertisementService")
public class ZlBAdvertisementService {
	
	@Resource
	private ZlBAdvertisementDAO zlBAdvertisementDAO;
	

	/**
	 * 查询实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBAdvertisement> queryZlBAdvertisementPageList(ZlBAdvertisement entity, int pageIndex, int pageSize) {
		return zlBAdvertisementDAO.queryZlBAdvertisementPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
//	public List<ZlBAdvertisement> queryZlBIndexPicList(ZlBAdvertisement entity) {
//		return zlBAdvertisementDAO.queryZlBIndexPicList(entity);
//	}
	

	
	/**
	 * 保存实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBAdvertisement(ZlBAdvertisement entity)
	{
		entity.setId(zlBAdvertisementDAO.getUUId());
//		entity.setStatus("0");
		return zlBAdvertisementDAO.saveAddZlBAdvertisement(entity);
	}
	
	/**
	 * 删除实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBAdvertisement(ZlBAdvertisement entity)
	{
		return zlBAdvertisementDAO.deleteZlBAdvertisement(entity);
	}
	
	/**
	 * 查询实体信息
	 * @param entity
	 * @return
	 */
	public ZlBAdvertisement getZlBAdvertisementById(ZlBAdvertisement entity)
	{
		return zlBAdvertisementDAO.getZlBAdvertisementById(entity.getId());
	}
	
	/**
	 * 修改实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBAdvertisement(ZlBAdvertisement entity)
	{
		return zlBAdvertisementDAO.saveUpdateZlBAdvertisement(entity);
	}
	/**
	 * 是否启用
	 * @param entity
	 * @return
	 */
	public int isStopZlBAdvertisement(ZlBAdvertisement entity)
	{
//		String status=entity.getStatus();  //启用状态
//		if (status.equals("1")) {
//			entity.setStatus("0");
//			zlBAdvertisementDAO.updateZlBAdvertisementStatus(entity);   //根据端口 把所有状态置0
//			entity.setStatus("1"); 
//		} else {
//			entity.setStatus("1");
//			zlBAdvertisementDAO.updateZlBAdvertisementStatus(entity);
//			entity.setStatus("0");
//		}
		
		return zlBAdvertisementDAO.isStopZlBAdvertisement(entity);
	}
	
	
}
