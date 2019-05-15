package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.SysMenuInfo;
import com.zhiliang.persistence.entity.SysRoleMenu;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author 齐建军
 */
@Component("SysRoleMenuDAO")
public class SysRoleMenuDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM sys_role_menu T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(SysRoleMenu entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. id", JDBCHelper.EQ, entiy.getId());
				jdbcHelper.putParam(JDBCHelper.AND, "T. roleid", JDBCHelper.EQ, entiy.getRoleid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. menucode", JDBCHelper.EQ, entiy.getMenucode());
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询entity List
	 * @author 齐建军
	 */
	public Pagination<SysRoleMenu> querySysRoleMenuList(SysRoleMenu entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysRoleMenu.class, pageIndex, pageSize);
	}
	
	/**
	 * 保存实体对象entity
	 * @author 齐建军
	 */
	public int saveSysRoleMenu(SysRoleMenu entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * @author 齐建军
	 */
	public int updateSysRoleMenu(SysRoleMenu entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 * @author 齐建军
	 */
	public int deleteSysRoleMenu(SysRoleMenu entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public SysRoleMenu getSysRoleMenuById(String id) {
		return this.getEntityById(id, SysRoleMenu.class);
	}
	
	/**
	 * zlb:置粮B端(PC)菜单,zlm:置粮c端(微信)菜单,zlmall:置粮c端商城菜单,zlc:用户及权限菜单
	 * @author lingy
	 * @date 2015年9月9日 下午2:10:29
	 * @param userid
	 * @param menutype
	 * @return
	 */
	public List<SysMenuInfo> queryMenuListByRoleIdAntType(String userid,String menutype,String parentcode){
		String sql = " select DISTINCT mi.* from sys_role_user ru,sys_role_info ri,sys_role_menu rm,sys_menu_info mi where ru.roleid = ri.roleid and ri.roleid = rm.roleid and rm.menucode = mi.menucode and ru.userid = ? and mi.menutype = ? and mi.parentmenucode = ?    ORDER BY mi.ordernum";
		return this.queryForList(sql, new Object[]{userid,menutype,parentcode}, SysMenuInfo.class);
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午9:44:10
	 * @param roleid
	 * @return
	 */
	public int batchDeleteRoleMenuByRoleid(String roleid){
		String sql = " delete from sys_role_menu where roleid = ? ";
		return this.executeSQL(sql,new Object[]{roleid});
	}

}