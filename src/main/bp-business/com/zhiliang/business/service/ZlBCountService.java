package com.zhiliang.business.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiliang.persistence.dao.ZlBCountDAO;
import com.zhiliang.persistence.entity.ZlBCount;
import com.repast.core.system.Pagination;

/**
 * 
 * Application name: Application describing:交易商银行子账号流水服务层 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * ZlBCount 的Service
 * @author wy
 */
@Service("ZlBCountService")
public class ZlBCountService {
	
	@Resource
	private ZlBCountDAO zlBCountDAO;
	

	/**
	 * 查询交易商银行子账号流水实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBCount> queryZlBCountPageList(ZlBCount entity, int pageIndex, int pageSize) {
		return zlBCountDAO.queryZlBCountPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询交易商银行子账号流水实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBCount> queryZlBCountList(ZlBCount entity) {
		return zlBCountDAO.queryZlBCountList(entity);
	}
	

	
	/**
	 * 保存交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBCount(ZlBCount entity)
	{
		return zlBCountDAO.saveAddZlBCount(entity);
	}
	
	/**
	 * 删除交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBCount(ZlBCount entity)
	{
		return zlBCountDAO.deleteZlBCount(entity);
	}
	
	/**
	 * 查询交易商银行子账号流水实体信息
	 * @param entity
	 * @return
	 */
	public ZlBCount getZlBCountById(ZlBCount entity)
	{
		return zlBCountDAO.getZlBCountById(entity.getId());
	}
	
	/**
	 * 修改交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBCount(ZlBCount entity)
	{
		return zlBCountDAO.saveUpdateZlBCount(entity);
	}
	
	
}
