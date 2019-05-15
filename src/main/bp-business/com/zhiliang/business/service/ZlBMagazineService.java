package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.zhiliang.persistence.dao.ZlBMagazineDAO;
import com.zhiliang.persistence.entity.ZlBMagazine;
import com.repast.core.system.Pagination;

/**
 * 
 * ZlBMagazine 的Service
 * @author wy
 */
@Service("ZlBMagazineService")
public class ZlBMagazineService {
	
	@Resource
	private ZlBMagazineDAO zlBMagazineDAO;
	

	/**
	 * 查询交易商银行子账号流水实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBMagazine> queryZlBMagazinePageList(ZlBMagazine entity, int pageIndex, int pageSize) {
		return zlBMagazineDAO.queryZlBMagazinePageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询交易商银行子账号流水实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBMagazine> queryZlBMagazineList(ZlBMagazine entity) {
		return zlBMagazineDAO.queryZlBMagazineList(entity);
	}
	

	
	/**
	 * 保存交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBMagazine(ZlBMagazine entity)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date now = new Date();
		String ctime=sdf.format(now);
		entity.setCtime(ctime);
		return zlBMagazineDAO.saveAddZlBMagazine(entity);
	}
	
	/**
	 * 删除交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBMagazine(ZlBMagazine entity)
	{
		return zlBMagazineDAO.deleteZlBMagazine(entity);
	}
	
	/**
	 * 查询交易商银行子账号流水实体信息
	 * @param entity
	 * @return
	 */
	public ZlBMagazine getZlBMagazineById(ZlBMagazine entity)
	{
		return zlBMagazineDAO.getZlBMagazineById(entity.getId());
	}
	
	/**
	 * 修改交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBMagazine(ZlBMagazine entity)
	{
		return zlBMagazineDAO.saveUpdateZlBMagazine(entity);
	}
	
	
}
