package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBFeedBack;

/**
 * 意见反馈
 * Application name: Application describing:意见反馈DAO类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBFeedback 的DAO类
 * @author superma
 */

@Component("ZlBFeedbackDAO")
public class ZlBFeedbackDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_feedback T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBFeedBack entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.comment", JDBCHelper.EQ, entiy.getComment());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.name", JDBCHelper.EQ, entiy.getName());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.tel", JDBCHelper.EQ, entiy.getTel());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.createtime", JDBCHelper.EQ, entiy.getCreatetime());
		 		
		}
		jdbcHelper.putOrder(" T.createtime DESC ");
		return jdbcHelper;
	}
	
	/**
	 * 分页查询意见反馈列表
	 * @author superma
	 */
	public Pagination<ZlBFeedBack> queryZlBFeedbackPageList(ZlBFeedBack entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBFeedBack.class, pageIndex, pageSize);
	}
	

	/**
	 * 删除意见反馈实体对象
	 * @author superma
	 */
	public int deleteZlBFeedback(ZlBFeedBack entity) {
		return this.saveRemove(entity);
	}


}