package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.SysUserShop;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author 齐建军
 */
@Component("SysUserShopDAO")
public class SysUserShopDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM sys_user_shop T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(SysUserShop entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. id", JDBCHelper.EQ, entiy.getId());
				jdbcHelper.putParam(JDBCHelper.AND, "T. orgid", JDBCHelper.EQ, entiy.getOrgid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. shopid", JDBCHelper.EQ, entiy.getShopid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. userid", JDBCHelper.EQ, entiy.getUserid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. isadmin", JDBCHelper.EQ, entiy.getIsadmin());
				jdbcHelper.putParam(JDBCHelper.AND, "T. ismember", JDBCHelper.EQ, entiy.getIsmember());
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询entity List
	 * @author 齐建军
	 */
	public Pagination<SysUserShop> querySysUserShopList(SysUserShop entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysUserShop.class, pageIndex, pageSize);
	}
	
	/**
	 * 保存实体对象entity
	 * @author 齐建军
	 */
	public int saveSysUserShop(SysUserShop entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * @author 齐建军
	 */
	public int updateSysUserShop(SysUserShop entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 * @author 齐建军
	 */
	public int deleteSysUserShop(SysUserShop entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public SysUserShop getSysUserShopById(String id) {
		return this.getEntityById(id, SysUserShop.class);
	}
	
	/**
	 * 根据用户ID批量删除
	 * @author lingy
	 * @date 2015年9月14日 上午10:14:36
	 * @param userid
	 * @return
	 */
	public int batchDeleteByUserid(String userid){
		String sql = " delete from sys_user_shop where userid = ? ";
		return this.executeSQL(sql, new Object[]{userid});
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月14日 下午2:39:53
	 * @param orgid
	 * @param userid
	 * @return
	 */
	public List<SysUserShop> getSysUserShopListByUserid(String orgid,String userid){
		String sql = " select us.*,si.shopname as shopname from sys_user_shop us,cs_shop_info si where us.shopid = si.shopid and us.orgid = ? and us.userid = ? ";
		return this.queryForList(sql, new Object[]{orgid,userid}, SysUserShop.class);
	}
}