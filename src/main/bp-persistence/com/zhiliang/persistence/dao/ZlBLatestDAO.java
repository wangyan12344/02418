package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBLatest;

/**
 * 网站公告
 * Application name: Application describing:DAO类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBLatest 的DAO类
 * @author superma
 */

@Component("ZlBLatestDAO")
public class ZlBLatestDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_latest T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBLatest entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.intro", JDBCHelper.EQ, entiy.getIntro());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.comment", JDBCHelper.EQ, entiy.getComment());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.publistime", JDBCHelper.EQ, entiy.getPublistime());
		 		
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询列表
	 * @author superma
	 */
	public Pagination<ZlBLatest> queryZlBLatestPageList(ZlBLatest entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBLatest.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询集合
	 * @author superma
	 */
	public List<ZlBLatest> queryZlBLatestList(ZlBLatest entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBLatest.class);
	}
	
	/**
	 * 保存实体对象
	 * @author superma
	 */
	public int saveAddZlBLatest(ZlBLatest entity) {
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象
	 * @author superma
	 */
	public int saveUpdateZlBLatest(ZlBLatest entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象
	 * @author superma
	 */
	public int deleteZlBLatest(ZlBLatest entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询实体对象
	 * @author superma
	 */
	public ZlBLatest getZlBLatestById(String id) {
		return this.getEntityById(id, ZlBLatest.class);
	}

}