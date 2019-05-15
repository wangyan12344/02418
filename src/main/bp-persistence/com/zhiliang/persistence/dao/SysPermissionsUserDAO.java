package com.zhiliang.persistence.dao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.SysPermissionsUser;

/**
 * 测试代码生成
 * Application name: Application describing:角色用户信息DAO类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表SysPermissionsUser 的DAO类
 * @author 
 */

@Component("SysPermissionsUserDAO")
public class SysPermissionsUserDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM sys_permissions_user T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(SysPermissionsUser entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.pname", JDBCHelper.EQ, entiy.getPname());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.pid", JDBCHelper.EQ, entiy.getPid());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.num", JDBCHelper.EQ, entiy.getNum());
		 		
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询角色用户信息列表
	 * @author 
	 */
	public Pagination<SysPermissionsUser> querySysPermissionsUserPageList(SysPermissionsUser entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysPermissionsUser.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询角色用户信息集合
	 * @author 
	 */
	public List<SysPermissionsUser> querySysPermissionsUserList(SysPermissionsUser entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), SysPermissionsUser.class);
	}
	
	/**
	 * 保存角色用户信息实体对象
	 * @author 
	 */
	public int saveAddSysPermissionsUser(SysPermissionsUser entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改角色用户信息实体对象
	 * @author 
	 */
	public int saveUpdateSysPermissionsUser(SysPermissionsUser entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除角色用户信息实体对象
	 * @author 
	 */
	public int deleteSysPermissionsUser(SysPermissionsUser entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询角色用户信息实体对象
	 * @author 
	 */
	public SysPermissionsUser getSysPermissionsUserById(String id) {
		return this.getEntityById(id, SysPermissionsUser.class);
	}

}