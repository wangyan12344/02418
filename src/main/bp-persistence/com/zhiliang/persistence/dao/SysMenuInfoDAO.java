package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.dto.MenuTreeDTO;
import com.zhiliang.persistence.entity.SysMenuInfo;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author 齐建军
 */
@Component("SysMenuInfoDAO")
public class SysMenuInfoDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM sys_menu_info T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(SysMenuInfo entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. menuid", JDBCHelper.EQ, entiy.getMenuid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. menucode", JDBCHelper.EQ, entiy.getMenucode());
				jdbcHelper.putParam(JDBCHelper.AND, "T. menuname", JDBCHelper.EQ, entiy.getMenuname());
				jdbcHelper.putParam(JDBCHelper.AND, "T. menutype", JDBCHelper.EQ, entiy.getMenutype());
				jdbcHelper.putParam(JDBCHelper.AND, "T. parentmenucode", JDBCHelper.EQ, entiy.getParentmenucode());
				jdbcHelper.putParam(JDBCHelper.AND, "T. menupath", JDBCHelper.EQ, entiy.getMenupath());
				jdbcHelper.putParam(JDBCHelper.AND, "T. ordernum", JDBCHelper.EQ, entiy.getOrdernum());
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询entity List
	 * @author 齐建军
	 */
	public Pagination<SysMenuInfo> querySysMenuInfoList(SysMenuInfo entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysMenuInfo.class, pageIndex, pageSize);
	}
	
	/**
	 * 保存实体对象entity
	 * @author 齐建军
	 */
	public int saveSysMenuInfo(SysMenuInfo entity) {
   			 if(entity.getMenuid()==null)
				entity.setMenuid(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * @author 齐建军
	 */
	public int updateSysMenuInfo(SysMenuInfo entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 * @author 齐建军
	 */
	public int deleteSysMenuInfo(SysMenuInfo entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public SysMenuInfo getSysMenuInfoById(String id) {
		return this.getEntityById(id, SysMenuInfo.class);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午8:45:04
	 * @param userid
	 * @return
	 */
	public List<MenuTreeDTO> getMenuTreeListByUserid(String userid){
		String sql = " select mi.menucode as id,mi.parentmenucode as pId,mi.menuname as name,rm.menucode as checked from sys_menu_info mi LEFT JOIN (select t.menucode from sys_role_menu t where t.roleid = ?) rm on mi.menucode = rm.menucode order by mi.parentmenucode ,mi.ordernum ";
		return this.queryForList(sql, new Object[]{userid}, MenuTreeDTO.class);
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午8:45:04
	 * @param userid
	 * @return
	 */
	public List<MenuTreeDTO> getNewsClassTree(String userid){
		String sql = " SELECT	mi.categoryid AS id,mi.parentid AS pId,	mi.categoryname AS NAME,rm.categoryid AS checked FROM	zl_b_news_category mi LEFT JOIN (	SELECT		t.categoryid	FROM		sys_userid_categoryid t	WHERE		t.userid = ?) rm ON mi.categoryid = rm.categoryid ORDER BY 	mi.parentid,mi.ordernum ";
		return this.queryForList(sql, new Object[]{userid}, MenuTreeDTO.class);
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午8:45:04
	 * @param userid
	 * @return
	 */
	public List<MenuTreeDTO> getClassMenuTreeListByUserid(String userid){
		String sql = " SELECT	mi.categoryid AS id,mi.parentid AS pId,	mi.categoryname AS NAME,rm.categoryid AS checked FROM	zl_b_news_category mi LEFT JOIN (	SELECT		t.categoryid	FROM		sys_userid_categoryid t	WHERE		t.userid = ?) rm ON mi.categoryid = rm.categoryid ORDER BY 	mi.parentid,mi.ordernum ";
		return this.queryForList(sql, new Object[]{userid}, MenuTreeDTO.class);
	}
}