package com.zhiliang.persistence.dao;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBAppActivity;

@Component("ZlBAppActivityDAO")
public class ZlBAppActivityDAO extends BaseDao {

	public final static String QueryTableSql = "SELECT T.* FROM zl_b_app_activity T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBAppActivity entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.ishas", JDBCHelper.EQ, entiy.getIshas());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.activityname", JDBCHelper.EQ, entiy.getActivityname());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.ctime", JDBCHelper.EQ, entiy.getCtime());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.remark", JDBCHelper.EQ, entiy.getRemark());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.remark1", JDBCHelper.EQ, entiy.getRemark1());
				jdbcHelper.putParam(JDBCHelper.AND, "T.type", JDBCHelper.EQ, entiy.getType());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.activityurl", JDBCHelper.EQ, entiy.getActivityurl());
		 		
		}
		jdbcHelper.putOrder( "  T.ishas DESC, DATE_FORMAT(T.ctime,'%Y %m %d %T:%l:%s') DESC " );
		return jdbcHelper;
	}
	
	/**
	 * 分页查询列表
	 * @author zhouhaifeng
	 */
	public Pagination<ZlBAppActivity> queryZlBAppActivityPageList(ZlBAppActivity entity, int pageIndex, int pageSize) {
		String sqlString="SELECT T.*,a.pname as typename FROM zl_b_app_activity T left join zl_b_app_activity_tag a on T.type=a.id WHERE 1=1 ";
		JDBCHelper helper = makeSearch(entity, sqlString);
		return getPage(helper.getSql(), helper.getParam(), ZlBAppActivity.class, pageIndex, pageSize);
	}
	
	
	/**
	 * 保存实体对象
	 * @author zhouhaifeng
	 */
	public int saveAddZlBAppActivity(ZlBAppActivity entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象
	 * @author zhouhaifeng
	 */
	public int saveUpdateZlBAppActivity(ZlBAppActivity entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象
	 * @author zhouhaifeng
	 */
	public int deleteZlBAppActivity(ZlBAppActivity entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询实体对象
	 * @author zhouhaifeng
	 */
	public ZlBAppActivity getZlBAppActivityById(String id) {
		return this.getEntityById(id, ZlBAppActivity.class);
	}

	
	/**
	 * 获得最新活动
	 * @param entity
	 * @return
	 */
	public ZlBAppActivity getZlBAppActivity(ZlBAppActivity entity)
	{
		String sql=" select T.* FROM zl_b_app_activity T WHERE T.ishas=? ORDER BY DATE_FORMAT(T.ctime,'%Y %m %d %T:%l:%s') DESC limit 1 ";
		
		return this.queryObject(sql, new Object[]{entity.getIshas()}, ZlBAppActivity.class);
	}

}
