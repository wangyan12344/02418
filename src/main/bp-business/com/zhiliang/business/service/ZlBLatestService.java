package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiliang.persistence.dao.ZlBLatestDAO;
import com.zhiliang.persistence.entity.ZlBLatest;
import com.repast.core.system.Pagination;

/**
 * 最新动态
 * ZlBLatest 的Service
 * @author superma
 */
@Service("ZlBLatestService")
public class ZlBLatestService {
	
	@Resource
	private ZlBLatestDAO zlBLatestDAO;
	

	/**
	 * 查询实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBLatest> queryZlBLatestPageList(ZlBLatest entity, int pageIndex, int pageSize) {
		return zlBLatestDAO.queryZlBLatestPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBLatest> queryZlBLatestList(ZlBLatest entity) {
		return zlBLatestDAO.queryZlBLatestList(entity);
	}
	

	
	/**
	 * 保存实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBLatest(ZlBLatest entity)
	{
		Date curdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		entity.setPublistime(sdf.format(curdate));
		entity.setId(zlBLatestDAO.getUUId());
		return zlBLatestDAO.saveAddZlBLatest(entity);
	}
	
	/**
	 * 删除实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBLatest(ZlBLatest entity)
	{
		return zlBLatestDAO.deleteZlBLatest(entity);
	}
	
	/**
	 * 查询实体信息
	 * @param entity
	 * @return
	 */
	public ZlBLatest getZlBLatestById(ZlBLatest entity)
	{
		return zlBLatestDAO.getZlBLatestById(entity.getId());
	}
	
	/**
	 * 修改实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBLatest(ZlBLatest entity)
	{
		return zlBLatestDAO.saveUpdateZlBLatest(entity);
	}
	
	
}
