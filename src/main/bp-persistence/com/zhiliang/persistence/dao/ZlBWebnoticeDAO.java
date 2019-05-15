package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBCountIp;
import com.zhiliang.persistence.entity.ZlBWebNotice;

/**
 * 网站公告
 * Application name: Application describing:DAO类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBWebnotice 的DAO类
 * @author superma
 */

@Component("ZlBWebnoticeDAO")
public class ZlBWebnoticeDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_webnotice T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBWebNotice entiy, String sql) {
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
	public Pagination<ZlBWebNotice> queryZlBWebnoticePageList(ZlBWebNotice entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBWebNotice.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询集合
	 * @author superma
	 */
	public List<ZlBWebNotice> queryZlBWebnoticeList(ZlBWebNotice entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBWebNotice.class);
	}
	
	/**
	 * 保存实体对象
	 * @author superma
	 */
	public int saveAddZlBWebnotice(ZlBWebNotice entity) {
   			
				
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象
	 * @author superma
	 */
	public int saveUpdateZlBWebnotice(ZlBWebNotice entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象
	 * @author superma
	 */
	public int deleteZlBWebnotice(ZlBWebNotice entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询实体对象
	 * @author superma
	 */
	public ZlBWebNotice getZlBWebnoticeById(String id) {
		return this.getEntityById(id, ZlBWebNotice.class);
	}
	
	/**
	 * 获取当日统计数据
	 * @param entity
	 * @return
	 */
	public ZlBWebNotice getZlBWebnoticeForlast(ZlBWebNotice entity){
		String sql="select T.* from zl_b_webnotice T  order by CAST(publistime as DATETIME) desc limit 1";
		return super.queryObject(sql, new Object[]{},ZlBWebNotice.class);
	}

}