package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBAdvertisement;


@Component("ZlBAppAdvertisementDAO")
public class ZlBAppAdvertisementDAO extends BaseDao {
	public final static String QueryTableSql = "SELECT T.* FROM zl_advertisement T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBAdvertisement entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.company", JDBCHelper.LIKE, entiy.getCompany());
		 
		 		
		}
		jdbcHelper.putOrder("T.tag,T.starttime desc ");
		return jdbcHelper;
	}
	
	/**
	 * 分页查询列表
	 * @author zhouhaifeng
	 */
	public Pagination<ZlBAdvertisement> queryZlBAdvertisementPageList(ZlBAdvertisement entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBAdvertisement.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询集合
	 * @author zhouhaifeng
	 */
//	public List<ZlBIndexPic> queryZlBIndexPicList(ZlBIndexPic entity) {
//		JDBCHelper helper = makeSearch(entity, QueryTableSql);
//		return queryForList(helper.getSql(), helper.getParam(), ZlBIndexPic.class);
//	}
	
	/**
	 * 保存实体对象
	 * @author zhouhaifeng
	 */
	public int saveAddZlBAdvertisement(ZlBAdvertisement entity) {
   			 
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象
	 * @author zhouhaifeng
	 */
	public int saveUpdateZlBAdvertisement(ZlBAdvertisement entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象
	 * @author zhouhaifeng
	 */
	public int deleteZlBAdvertisement(ZlBAdvertisement entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询实体对象
	 * @author zhouhaifeng
	 */
	public ZlBAdvertisement loadIndxPicBAdvertisementByStatusAndTag(ZlBAdvertisement entity) {
		
		String sql="SELECT starttime,endtime,second,img FROM zl_advertisement WHERE status='1' and tag='"+entity.getTag()+"' LIMIT 1 ";
		
		return this.queryObject(sql, ZlBAdvertisement.class);
	}
	
	
	
	public int isStopZlBAdvertisement(ZlBAdvertisement entity) {
		
		String sql="update zl_advertisement set status='"+entity.getStatus()+"' where id='"+entity.getId()+"'";
		
		return this.executeSQL(sql);
	}
	
    public int updateZlBAdvertisementStatus(ZlBAdvertisement entity) {
		
		String sql="update zl_advertisement set status='"+entity.getStatus()+"' where tag='"+entity.getTag()+"'";
		
		return this.executeSQL(sql);
	}
	/**
	 * 分页查询列表
	 * @author wy
	 */
	public List<ZlBAdvertisement> loadAdvertisementListByTag(ZlBAdvertisement entity) {
		String sql="SELECT * FROM zl_advertisement WHERE status='1' and tag=? ORDER BY DATE_FORMAT(starttime,'%Y %m %d %T:%l:%s') DESC";
		return this.queryForList(sql, new Object[]{entity.getTag()}, ZlBAdvertisement.class);
	 
	}
}