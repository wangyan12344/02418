package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.SysRoleInfo;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author 齐建军
 */
@Component("SysRoleInfoDAO")
public class SysRoleInfoDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM sys_role_info T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(SysRoleInfo entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. roleid", JDBCHelper.EQ, entiy.getRoleid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. rolename", JDBCHelper.LIKE, entiy.getRolename());
				jdbcHelper.putParam(JDBCHelper.AND, "T. orgid", JDBCHelper.EQ, entiy.getOrgid());
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询entity List
	 * @author 齐建军
	 */
	public Pagination<SysRoleInfo> querySysRoleInfoList(SysRoleInfo entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysRoleInfo.class, pageIndex, pageSize);
	}
	
	/**
	 * 保存实体对象entity
	 * @author 齐建军
	 */
	public int saveSysRoleInfo(SysRoleInfo entity) {
   			 if(entity.getRoleid()==null)
				entity.setRoleid(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * @author 齐建军
	 */
	public int updateSysRoleInfo(SysRoleInfo entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 * @author 齐建军
	 */
	public int deleteSysRoleInfo(SysRoleInfo entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public SysRoleInfo getSysRoleInfoById(String id) {
		return this.getEntityById(id, SysRoleInfo.class);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月11日 上午10:49:36
	 * @param orgid
	 * @param userid
	 * @return
	 */
	public List<SysRoleInfo> getSysUserRoleListByOrgid(String orgid,String userid){
		String sql = " select ri.*,sru.roleid as checked from sys_role_info ri "
				+ "left join (select ru.roleid from sys_role_user ru where ru.userid = ?) as sru "
				+ "on ri.roleid = sru.roleid "
				+ "where ri.orgid = ? ";
		return this.queryForList(sql, new Object[]{userid,orgid}, SysRoleInfo.class);
		
	}
	/**
	 * 根据用户id获取用户的角色信息
	 * @author qijianjun
	 * @param userid
	 * @return
	 */
	public List<SysRoleInfo> getSysRoleInfoByUserid(String userid)
	{
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" select role.* ");
		sqlBuf.append(" from sys_role_user roleuser,sys_role_info role ");
		sqlBuf.append(" where roleuser.userid=? ");
		sqlBuf.append(" and roleuser.roleid=role.roleid ");
		return this.queryForList(sqlBuf.toString(), new Object[]{userid}, SysRoleInfo.class);
	}

}