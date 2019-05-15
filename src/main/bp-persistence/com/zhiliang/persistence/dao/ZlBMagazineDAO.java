package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBMagazine;

/**
 * 表ZlBMagazine 的DAO类
 */

@Component("ZlBMagazineDAO")
public class ZlBMagazineDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_magazine T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBMagazine entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.intro", JDBCHelper.EQ, entiy.getIntro());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.title", JDBCHelper.EQ, entiy.getTitle());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.ctime", JDBCHelper.EQ, entiy.getCtime());
				
				jdbcHelper.putOrder( " T.num desc,CAST(T.ctime AS DATETIME) DESC " );
		 		
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询列表
	 * @author wy
	 */
	public Pagination<ZlBMagazine> queryZlBMagazinePageList(ZlBMagazine entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBMagazine.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询集合
	 * @author wy
	 */
	public List<ZlBMagazine> queryZlBMagazineList(ZlBMagazine entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBMagazine.class);
	}
	
	/**
	 * 保存实体对象
	 * @author wy
	 */
	public int saveAddZlBMagazine(ZlBMagazine entity) {
		if (entity.getId() == null)
			entity.setId(this.getUUId());
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象
	 * @author wy
	 */
	public int saveUpdateZlBMagazine(ZlBMagazine entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象
	 * @author wy
	 */
	public int deleteZlBMagazine(ZlBMagazine entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询实体对象
	 * @author wy
	 */
	public ZlBMagazine getZlBMagazineById(String id) {
		return this.getEntityById(id, ZlBMagazine.class);
	}
 

}