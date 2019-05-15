package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBAdvertisement;


@Component("ZlBAdvertisementDAO")
public class ZlBAdvertisementDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_advertisement T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBAdvertisement entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
				jdbcHelper.putParam(JDBCHelper.AND, "T.tag", JDBCHelper.EQ, entiy.getTag());
		 
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
		String sqlString="SELECT T.*,a.pname as pname FROM zl_advertisement T left join zl_advertisement_tag a on T.tag=a.id WHERE 1=1 ";
		JDBCHelper helper = makeSearch(entity, sqlString);
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
	public ZlBAdvertisement getZlBAdvertisementById(String id) {
		return this.getEntityById(id, ZlBAdvertisement.class);
	}
	
	public int isStopZlBAdvertisement(ZlBAdvertisement entity) {
		
		String sql="update zl_advertisement set status='"+entity.getStatus()+"' where id='"+entity.getId()+"'";
		
		return this.executeSQL(sql);
	}
	
    public int updateZlBAdvertisementStatus(ZlBAdvertisement entity) {
		
		String sql="update zl_advertisement set status='"+entity.getStatus()+"' where tag='"+entity.getTag()+"'";
		
		return this.executeSQL(sql);
	}

}