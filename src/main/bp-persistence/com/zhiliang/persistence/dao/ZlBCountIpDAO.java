package com.zhiliang.persistence.dao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBCountIp;

/**
 * 
 * Application name: Application describing:交易商银行子账号流水DAO类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBCountIp 的DAO类
 * @author wy
 */

@Component("ZlBCountIpDAO")
public class ZlBCountIpDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_count_ip T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBCountIp entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.ipaddress", JDBCHelper.EQ, entiy.getIpaddress());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.updatetime", JDBCHelper.EQ, entiy.getUpdatetime());
		 		
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询交易商银行子账号流水列表
	 * @author wy
	 */
	public Pagination<ZlBCountIp> queryZlBCountIpPageList(ZlBCountIp entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBCountIp.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询交易商银行子账号流水集合
	 * @author wy
	 */
	public List<ZlBCountIp> queryZlBCountIpList(ZlBCountIp entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBCountIp.class);
	}
	
	/**
	 * 保存交易商银行子账号流水实体对象
	 * @author wy
	 */
	public int saveAddZlBCountIp(ZlBCountIp entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改交易商银行子账号流水实体对象
	 * @author wy
	 */
	public int saveUpdateZlBCountIp(ZlBCountIp entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除交易商银行子账号流水实体对象
	 * @author wy
	 */
	public int deleteZlBCountIp(ZlBCountIp entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询交易商银行子账号流水实体对象
	 * @author wy
	 */
	public ZlBCountIp getZlBCountIpById(String id) {
		return this.getEntityById(id, ZlBCountIp.class);
	}

}