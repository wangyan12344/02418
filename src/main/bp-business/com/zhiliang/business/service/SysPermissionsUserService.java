package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiliang.persistence.dao.SysPermissionsUserDAO;
import com.zhiliang.persistence.entity.SysPermissionsUser;
import com.repast.core.system.Pagination;

/**
 * 测试代码生成
 * Application name: Application describing:角色用户信息服务层 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * SysPermissionsUser 的Service
 * @author 
 */
@Service("SysPermissionsUserService")
public class SysPermissionsUserService {
	
	@Resource
	private SysPermissionsUserDAO sysPermissionsUserDAO;
	

	/**
	 * 查询角色用户信息实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<SysPermissionsUser> querySysPermissionsUserPageList(SysPermissionsUser entity, int pageIndex, int pageSize) {
		return sysPermissionsUserDAO.querySysPermissionsUserPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询角色用户信息实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<SysPermissionsUser> querySysPermissionsUserList(SysPermissionsUser entity) {
		return sysPermissionsUserDAO.querySysPermissionsUserList(entity);
	}
	

	
	/**
	 * 保存角色用户信息实体
	 * @param entity
	 * @return
	 */
	public int saveAddSysPermissionsUser(SysPermissionsUser entity)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sysPermissionsUserDAO.saveAddSysPermissionsUser(entity);
	}
	
	/**
	 * 删除角色用户信息实体
	 * @param entity
	 * @return
	 */
	public int deleteSysPermissionsUser(SysPermissionsUser entity)
	{
		return sysPermissionsUserDAO.deleteSysPermissionsUser(entity);
	}
	
	/**
	 * 查询角色用户信息实体信息
	 * @param entity
	 * @return
	 */
	public SysPermissionsUser getSysPermissionsUserById(SysPermissionsUser entity)
	{
		return sysPermissionsUserDAO.getSysPermissionsUserById(entity.getId());
	}
	
	/**
	 * 修改角色用户信息实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateSysPermissionsUser(SysPermissionsUser entity)
	{
		return sysPermissionsUserDAO.saveUpdateSysPermissionsUser(entity);
	}
	
	
}
