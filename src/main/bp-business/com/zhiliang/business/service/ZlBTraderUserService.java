package com.zhiliang.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.system.Pagination;
import com.zhiliang.persistence.dao.ZlBTraderUserDAO;
import com.zhiliang.persistence.entity.ZlBTraderUser;

/**
 * 置粮网
 * Application name: Application describing:交易商用户信息服务层 Copyright:Copyright copy;
 * Company:辽宁天富实业发展有限公司
 * WebSite:http://www.palacesun.com
 * ZlBTraderUser 的Service
 * @author 周杨
 */
@Service("ZlBTraderUserService")
public class ZlBTraderUserService {
	
	@Resource
	private ZlBTraderUserDAO zlBTraderUserDAO;
	

	/**
	 * 查询交易商(个人)用户信息实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBTraderUser> queryZlBTraderUserPageList(ZlBTraderUser entity, int pageIndex, int pageSize) {
		return zlBTraderUserDAO.queryZlBTraderUserPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询交易商(企业)用户信息实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBTraderUser> queryZlBTraderUserPageList1(ZlBTraderUser entity, int pageIndex, int pageSize) {
		return zlBTraderUserDAO.queryZlBTraderUserPageList1(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询交易商(个人)用户信息实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBTraderUser> queryZlBTraderUserForList(ZlBTraderUser entity) {
		return zlBTraderUserDAO.queryZlBTraderUserForList(entity);
	}
	
	/**
	 * 查询交易商(企业)用户信息实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBTraderUser> queryZlBTraderUserForList1(ZlBTraderUser entity) {
		return zlBTraderUserDAO.queryZlBTraderUserForList1(entity);
	}
	
	/**
	 * 保存交易商(个人)用户信息实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBTraderUser(ZlBTraderUser entity)
	{
		return zlBTraderUserDAO.saveAddZlBTraderUser(entity);
	}
	
	/**
	 * 保存交易商（企业）用户信息实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBTraderUser1(ZlBTraderUser entity)
	{
		return zlBTraderUserDAO.saveAddZlBTraderUser1(entity);
	}
	
	/**
	 * 删除交易商用户信息实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBTraderUser(ZlBTraderUser entity)
	{
		return zlBTraderUserDAO.deleteZlBTraderUser(entity);
	}
	
	/**
	 * 查询交易商用户信息实体信息
	 * @param entity
	 * @return
	 */
	public ZlBTraderUser getZlBTraderUserById(ZlBTraderUser entity)
	{
		return zlBTraderUserDAO.getZlBTraderUserById(entity.getTraderuserid());
	}
	
	/**
	 * 修改交易商（个人）用户信息实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBTraderUser(ZlBTraderUser entity)
	{
		return zlBTraderUserDAO.saveUpdateZlBTraderUser(entity);
	}
	
	/**
	 * 修改交易商（企业）用户信息实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBTraderUser1(ZlBTraderUser entity)
	{
		return zlBTraderUserDAO.saveUpdateZlBTraderUser(entity);
	}
	
	/**
	 * 禁止交易商用户
	 */
	public int inhibitZlBTraderUserById(ZlBTraderUser entity){
		int flag=zlBTraderUserDAO.updateinhibitZlBTraderUser(entity.getTraderid());
										 								
		return flag;
	}
	
	/**
	 * 启用交易商用户
	 */
	public int startZlBTraderUserById(ZlBTraderUser entity){
		int flag=zlBTraderUserDAO.updatestartZlBTraderUser(entity.getTraderid());
										 								
		return flag;
	}
	
	
	
}
