package com.zhiliang.persistence.dao;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.SysRoleUser;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author 齐建军
 */
@Component("SysRoleUserDAO")
public class SysRoleUserDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM sys_role_user T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(SysRoleUser entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. id", JDBCHelper.EQ, entiy.getId());
				jdbcHelper.putParam(JDBCHelper.AND, "T. roleid", JDBCHelper.EQ, entiy.getRoleid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. userid", JDBCHelper.EQ, entiy.getUserid());
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询entity List
	 * @author 齐建军
	 */
	public Pagination<SysRoleUser> querySysRoleUserList(SysRoleUser entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysRoleUser.class, pageIndex, pageSize);
	}
	
	/**
	 * 保存实体对象entity
	 * @author 齐建军
	 */
	public int saveSysRoleUser(SysRoleUser entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * @author 齐建军
	 */
	public int updateSysRoleUser(SysRoleUser entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 * @author 齐建军
	 */
	public int deleteSysRoleUser(SysRoleUser entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public SysRoleUser getSysRoleUserById(String id) {
		return this.getEntityById(id, SysRoleUser.class);
	}
	
	/**
	 * 批量删除用户角色信息，根据用户ID
	 * @author lingy
	 * @date 2015年9月11日 下午2:02:00
	 * @param userid
	 * @return
	 */
	public int batchDeleteByUserid(String userid){
		String sql = " delete from sys_role_user where userid = ? ";
		return this.executeSQL(sql, new Object[]{userid});
	}
	
	/**
	 * 批量删除用户角色信息，根据用户ID
	 * @author lingy
	 * @date 2015年9月11日 下午2:02:00
	 * @param userid
	 * @return
	 */
	public int batchDeleteRoleMenuByUserid(String userid){
		String sql = " delete from sys_userid_categoryid where userid = ? ";
		return this.executeSQL(sql, new Object[]{userid});
	}
}