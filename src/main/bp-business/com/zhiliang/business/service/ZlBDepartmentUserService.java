package com.zhiliang.business.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiliang.persistence.dao.ZlBDepartmentUserDAO;
import com.zhiliang.persistence.dto.departmentDTO;
import com.zhiliang.persistence.entity.ZlBDepartmentUser;
import com.repast.core.system.Pagination;

/**
 * 
 * ZlBDepartmentUser 的Service
 * @author 
 */
@Service("ZlBDepartmentUserService")
public class ZlBDepartmentUserService {
	
	@Resource
	private ZlBDepartmentUserDAO zlBDepartmentUserDAO;
	

	/**
	 * 查询B端app首页活动实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBDepartmentUser> queryZlBDepartmentUserPageList(ZlBDepartmentUser entity, int pageIndex, int pageSize) {
		return zlBDepartmentUserDAO.queryZlBDepartmentUserPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询B端app首页活动实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBDepartmentUser> queryZlBDepartmentUserList(ZlBDepartmentUser entity) {
		return zlBDepartmentUserDAO.queryZlBDepartmentUserList(entity);
	}
	

	
	/**
	 * 保存B端app首页活动实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBDepartmentUser(ZlBDepartmentUser entity)
	{
		return zlBDepartmentUserDAO.saveAddZlBDepartmentUser(entity);
	}
	
	/**
	 * 删除B端app首页活动实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBDepartmentUser(ZlBDepartmentUser entity)
	{
		return zlBDepartmentUserDAO.deleteZlBDepartmentUser(entity);
	}
	
	/**
	 * 查询B端app首页活动实体信息
	 * @param entity
	 * @return
	 */
	public ZlBDepartmentUser getZlBDepartmentUserById(ZlBDepartmentUser entity)
	{
		return zlBDepartmentUserDAO.getZlBDepartmentUserById(entity.getId());
	}
	
	/**
	 * 修改B端app首页活动实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBDepartmentUser(ZlBDepartmentUser entity)
	{
		return zlBDepartmentUserDAO.saveUpdateZlBDepartmentUser(entity);
	}
	
	
	/**
	 * 查询B端app首页活动实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBDepartmentUser> queryOrderDataForMapBar(ZlBDepartmentUser entity) {
		return zlBDepartmentUserDAO.queryOrderDataForMapBar(entity);
	}
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public List<departmentDTO> queryDataMonth(ZlBDepartmentUser entity) {
		List<departmentDTO> list=zlBDepartmentUserDAO.queryDataMonth(entity);
		for (int i = 0; i < list.size(); i++) {
			
		}
		return list;
	}
	/**
	 * 查询B端app首页活动实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBDepartmentUser> queryZlBDepartmentUserlListExcel(ZlBDepartmentUser entity) {
		return zlBDepartmentUserDAO.queryZlBDepartmentUserlListExcel(entity);
	}
}
