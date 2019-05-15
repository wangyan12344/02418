package com.zhiliang.business.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiliang.persistence.dao.ZlBCountIpDAO;
import com.zhiliang.persistence.entity.ZlBCountIp;
import com.repast.core.system.Pagination;

/**
 * 
 * Application name: Application describing:交易商银行子账号流水服务层 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * ZlBCountIp 的Service
 * @author wy
 */
@Service("ZlBCountIpService")
public class ZlBCountIpService {
	
	@Resource
	private ZlBCountIpDAO zlBCountIpDAO;
	

	/**
	 * 查询交易商银行子账号流水实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBCountIp> queryZlBCountIpPageList(ZlBCountIp entity, int pageIndex, int pageSize) {
		return zlBCountIpDAO.queryZlBCountIpPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询交易商银行子账号流水实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBCountIp> queryZlBCountIpList(ZlBCountIp entity) {
		return zlBCountIpDAO.queryZlBCountIpList(entity);
	}
	

	
	/**
	 * 保存交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBCountIp(ZlBCountIp entity)
	{
		return zlBCountIpDAO.saveAddZlBCountIp(entity);
	}
	
	/**
	 * 删除交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBCountIp(ZlBCountIp entity)
	{
		return zlBCountIpDAO.deleteZlBCountIp(entity);
	}
	
	/**
	 * 查询交易商银行子账号流水实体信息
	 * @param entity
	 * @return
	 */
	public ZlBCountIp getZlBCountIpById(ZlBCountIp entity)
	{
		return zlBCountIpDAO.getZlBCountIpById(entity.getId());
	}
	
	/**
	 * 修改交易商银行子账号流水实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBCountIp(ZlBCountIp entity)
	{
		return zlBCountIpDAO.saveUpdateZlBCountIp(entity);
	}
	
	
}
