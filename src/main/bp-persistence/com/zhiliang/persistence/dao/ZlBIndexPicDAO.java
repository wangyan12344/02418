package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBIndexPic;

/**
 * 测试代码生成
 * Application name: Application describing:DAO类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBIndexPic 的DAO类
 * @author zhouhaifeng
 */

@Component("ZlBIndexPicDAO")
public class ZlBIndexPicDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_index_pic T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBIndexPic entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.imgurl", JDBCHelper.EQ, entiy.getImgurl());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.used", JDBCHelper.EQ, entiy.getUsed());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.position", JDBCHelper.EQ, entiy.getPosition());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.ordernum", JDBCHelper.EQ, entiy.getOrdernum());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.remark", JDBCHelper.EQ, entiy.getRemark());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.visiturl", JDBCHelper.EQ, entiy.getVisiturl());
		 		
		}
		jdbcHelper.putOrder("T.publishtime desc, T.used , T.position , T.ordernum ");
		return jdbcHelper;
	}
	
	/**
	 * 分页查询列表
	 * @author zhouhaifeng
	 */
	public Pagination<ZlBIndexPic> queryZlBIndexPicPageList(ZlBIndexPic entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBIndexPic.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询集合
	 * @author zhouhaifeng
	 */
	public List<ZlBIndexPic> queryZlBIndexPicList(ZlBIndexPic entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBIndexPic.class);
	}
	
	/**
	 * 保存实体对象
	 * @author zhouhaifeng
	 */
	public int saveAddZlBIndexPic(ZlBIndexPic entity) {
   			 
			
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象
	 * @author zhouhaifeng
	 */
	public int saveUpdateZlBIndexPic(ZlBIndexPic entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象
	 * @author zhouhaifeng
	 */
	public int deleteZlBIndexPic(ZlBIndexPic entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询实体对象
	 * @author zhouhaifeng
	 */
	public ZlBIndexPic getZlBIndexPicById(String id) {
		return this.getEntityById(id, ZlBIndexPic.class);
	}
	
	public int isStopZlBIndexPic(ZlBIndexPic entity) {
		
		String sql="update zl_b_index_pic set isstop='"+entity.getIsstop()+"' where id='"+entity.getId()+"'";
		
		return this.executeSQL(sql);
	}

}