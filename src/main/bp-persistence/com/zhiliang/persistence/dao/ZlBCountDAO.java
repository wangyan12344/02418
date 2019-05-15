package com.zhiliang.persistence.dao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBCount;

/**
 * 
 * Application name: Application describing:交易商银行子账号流水DAO类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBCount 的DAO类
 * @author wy
 */

@Component("ZlBCountDAO")
public class ZlBCountDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_count T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBCount entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.totalcount", JDBCHelper.EQ, entiy.getTotalcount());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.daycount", JDBCHelper.EQ, entiy.getDaycount());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.pcount", JDBCHelper.EQ, entiy.getPcount());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.ctime", JDBCHelper.EQ, entiy.getCtime());
		 		
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询交易商银行子账号流水列表
	 * @author wy
	 */
	public Pagination<ZlBCount> queryZlBCountPageList(ZlBCount entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBCount.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询交易商银行子账号流水集合
	 * @author wy
	 */
	public List<ZlBCount> queryZlBCountList(ZlBCount entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBCount.class);
	}
	
	/**
	 * 保存交易商银行子账号流水实体对象
	 * @author wy
	 */
	public int saveAddZlBCount(ZlBCount entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改交易商银行子账号流水实体对象
	 * @author wy
	 */
	public int saveUpdateZlBCount(ZlBCount entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除交易商银行子账号流水实体对象
	 * @author wy
	 */
	public int deleteZlBCount(ZlBCount entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询交易商银行子账号流水实体对象
	 * @author wy
	 */
	public ZlBCount getZlBCountById(String id) {
		return this.getEntityById(id, ZlBCount.class);
	}

}