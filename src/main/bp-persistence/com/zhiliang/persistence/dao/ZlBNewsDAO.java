package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.repast.core.util.CommonUtil;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBNews;
import com.zhiliang.persistence.entity.ZlBNewsAttach;
import com.zhiliang.persistence.entity.ZlBNewsCategory;

@Component("ZlBNewsDAO")
public class ZlBNewsDAO extends BaseDao {

	public final static String QueryTableSql = "SELECT T.* FROM zl_b_news T WHERE 1=1 ";

	private JDBCHelper makeSearch(ZlBNews entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
			jdbcHelper.putParam(JDBCHelper.AND, "T. newsid", JDBCHelper.EQ,
					entiy.getNewsid());
			jdbcHelper.putParam(JDBCHelper.AND, "T. newstitle", JDBCHelper.LIKE,
					entiy.getNewstitle());
			jdbcHelper.putParam(JDBCHelper.AND, "T. newscontent",
					JDBCHelper.EQ, entiy.getNewscontent());
			jdbcHelper.putParam(JDBCHelper.AND, "T. categoryid", JDBCHelper.EQ,
					entiy.getCategoryid());
			
			jdbcHelper.putParam(JDBCHelper.AND, "T. parentid", JDBCHelper.EQ,
					entiy.getParentid());
			
			jdbcHelper.putParam(JDBCHelper.AND, "C. permissions", JDBCHelper.EQ,
					entiy.getPermissions());
			
			jdbcHelper.putParam(JDBCHelper.AND, "T. publishtime", JDBCHelper.GTQ,
					entiy.getStime());
			
			jdbcHelper.putParam(JDBCHelper.AND, "T. publishtime", JDBCHelper.LTQ,
					entiy.getEtime());
			
			jdbcHelper.putParam(JDBCHelper.AND, "T. publishtime",
					JDBCHelper.EQ, entiy.getPublishtime());
			jdbcHelper.putParam(JDBCHelper.AND, "T. publisherid",
					JDBCHelper.EQ, entiy.getPublisherid());
			jdbcHelper.putParam(JDBCHelper.AND, "T. mainimgpath",
					JDBCHelper.EQ, entiy.getMainimgpath());
			jdbcHelper.putParam(JDBCHelper.AND, "T. isHomePage", JDBCHelper.EQ,
					entiy.getIsHomePage());
			jdbcHelper.putParam(JDBCHelper.AND, "T. istop", JDBCHelper.EQ,
					entiy.getIstop());
			jdbcHelper.putParam(JDBCHelper.AND, "T.ishot", JDBCHelper.EQ,
					entiy.getIshot());
			jdbcHelper.putParam(JDBCHelper.AND, "T.prominent", JDBCHelper.EQ,
					entiy.getProminent());
			jdbcHelper.putParam(JDBCHelper.AND, "T. templateid", JDBCHelper.EQ,
					entiy.getTemplateid());
			jdbcHelper.putParam(JDBCHelper.AND, "T. ordernum", JDBCHelper.EQ,
					entiy.getOrdernum());
			
			jdbcHelper.putOrder( " CAST(T.publishtime AS DATETIME) DESC " );
		}
		return jdbcHelper;
	}
	private JDBCHelper makeSearch_praise(ZlBNews entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
			jdbcHelper.putParam(JDBCHelper.AND, "T. newsid", JDBCHelper.EQ,
					entiy.getNewsid());
			jdbcHelper.putParam(JDBCHelper.AND, "T. newstitle", JDBCHelper.LIKE,
					entiy.getNewstitle());
			jdbcHelper.putParam(JDBCHelper.AND, "T. newscontent",
					JDBCHelper.EQ, entiy.getNewscontent());
			jdbcHelper.putParam(JDBCHelper.AND, "T. categoryid", JDBCHelper.EQ,
					entiy.getCategoryid());
			jdbcHelper.putParam(JDBCHelper.AND, "T. parentid", JDBCHelper.EQ,
					entiy.getParentid());
			
			jdbcHelper.putParam(JDBCHelper.AND, "C. permissions", JDBCHelper.EQ,
					entiy.getPermissions());
			
			
		 
			jdbcHelper.putParam(JDBCHelper.AND, "T. publisherid",
					JDBCHelper.EQ, entiy.getPublisherid());
			jdbcHelper.putParam(JDBCHelper.AND, "T. mainimgpath",
					JDBCHelper.EQ, entiy.getMainimgpath());
			jdbcHelper.putParam(JDBCHelper.AND, "T. isHomePage", JDBCHelper.EQ,
					entiy.getIsHomePage());
			jdbcHelper.putParam(JDBCHelper.AND, "T. istop", JDBCHelper.EQ,
					entiy.getIstop());
			jdbcHelper.putParam(JDBCHelper.AND, "T.ishot", JDBCHelper.EQ,
					entiy.getIshot());
			jdbcHelper.putParam(JDBCHelper.AND, "T.prominent", JDBCHelper.EQ,
					entiy.getProminent());
			jdbcHelper.putParam(JDBCHelper.AND, "T. templateid", JDBCHelper.EQ,
					entiy.getTemplateid());
			jdbcHelper.putParam(JDBCHelper.AND, "T. ordernum", JDBCHelper.EQ,
					entiy.getOrdernum());
			
			jdbcHelper.putParam(JDBCHelper.AND, "T. publishtime", JDBCHelper.GTQ,
					entiy.getStime());
			
			jdbcHelper.putParam(JDBCHelper.AND, "T. publishtime", JDBCHelper.LTQ,
					entiy.getEtime());
			
			jdbcHelper.putOrder( " praisenum DESC " );
		}
		return jdbcHelper;
	}
	/**
	 * 分页查询entity List
	 * 
	 */
	public Pagination<ZlBNews> queryZlBNewsList(ZlBNews entity, int pageIndex,int pageSize,Processor processor) {
		String sql = "SELECT B.categoryname as parentname,S.username as sysname, T.*,C.categoryname ,d.departmentname as departmentname,u.departmentuser as departmentusername ,"
				+ "(SELECT COUNT(*) from zl_b_news_praise where newsid=T.newsid) as praisenum FROM zl_b_news T "
				+ "LEFT JOIN sys_user_info S ON T.updateuserid=S.userid "
				+ "left JOIN zl_b_department d ON T.department=d.id   "
				+ "LEFT JOIN zl_b_department_user u on T.departmentuser=u.id,"
				+ "zl_b_news_category C LEFT JOIN zl_b_news_category B ON C.parentid=B.categoryid "
				+ "WHERE T.categoryid=C.categoryid  ";
		if (!"1".equals(processor.getShopid())) {
			 sql = "SELECT B.categoryname as parentname,S.username as sysname, T.*,C.categoryname ,d.departmentname as departmentname,u.departmentuser as departmentusername,"
			 		+ "(SELECT COUNT(*) from zl_b_news_praise where newsid=T.newsid) as praisenum "
			 		+ "FROM zl_b_news T "
			 		+ " LEFT JOIN sys_user_info S ON T.updateuserid=S.userid "
			 		+ " left JOIN zl_b_department d ON T.department=d.id   "
			 		+ "LEFT JOIN zl_b_department_user u on T.departmentuser=u.id,"
			 		+ "zl_b_news_category C LEFT JOIN zl_b_news_category B ON C.parentid=B.categoryid "
			 		+ "WHERE T.categoryid=C.categoryid and T.adduserid='"+processor.getCurrentUserId()+"'  ";
		}
		
		 JDBCHelper helper = makeSearch(entity, sql);
		 return getPage(helper.getSql(), helper.getParam(), ZlBNews.class, pageIndex, pageSize);
	}
	
	/**
	 * 分页查询entity List
	 * 
	 */
	public List<ZlBNews> queryZlBNewsPageListExcel(ZlBNews entity,Processor processor) {
		String sql = "SELECT B.categoryname as parentname,S.username as sysname, T.*,C.categoryname ,d.departmentname as departmentname,u.departmentuser as departmentusername ,"
				+ "(SELECT COUNT(*) from zl_b_news_praise where newsid=T.newsid) as praisenum FROM zl_b_news T "
				+ "LEFT JOIN sys_user_info S ON T.updateuserid=S.userid "
				+ "left JOIN zl_b_department d ON T.department=d.id   "
				+ "LEFT JOIN zl_b_department_user u on T.departmentuser=u.id,"
				+ "zl_b_news_category C LEFT JOIN zl_b_news_category B ON C.parentid=B.categoryid "
				+ "WHERE T.categoryid=C.categoryid  ";
		if (!"1".equals(processor.getShopid())) {
			 sql = "SELECT B.categoryname as parentname,S.username as sysname, T.*,C.categoryname ,d.departmentname as departmentname,u.departmentuser as departmentusername,"
			 		+ "(SELECT COUNT(*) from zl_b_news_praise where newsid=T.newsid) as praisenum "
			 		+ "FROM zl_b_news T "
			 		+ " LEFT JOIN sys_user_info S ON T.updateuserid=S.userid "
			 		+ " left JOIN zl_b_department d ON T.department=d.id   "
			 		+ "LEFT JOIN zl_b_department_user u on T.departmentuser=u.id,"
			 		+ "zl_b_news_category C LEFT JOIN zl_b_news_category B ON C.parentid=B.categoryid "
			 		+ "WHERE T.categoryid=C.categoryid and T.adduserid='"+processor.getCurrentUserId()+"'  ";
		}
		
		 JDBCHelper helper = makeSearch(entity, sql);
		 return super.queryForList(helper.getSql(),  helper.getParam(),ZlBNews.class);
	}
	
	
	/**
	 * 分页查询entity List
	 * 
	 * @author 齐建军
	 */
	public Pagination<ZlBNews> queryZlBNewsListByPraise(ZlBNews entity, int pageIndex,int pageSize,Processor processor) {
		String sql = "SELECT T.*,C.categoryname,f.username as username,(SELECT COUNT(*) from zl_b_news_praise where newsid=T.newsid) as praisenum FROM zl_b_news T LEFT JOIN sys_user_info f ON T.adduserid=f.userid,zl_b_news_category C WHERE T.categoryid=C.categoryid  ";
		 JDBCHelper helper = makeSearch_praise(entity, sql);
		 return getPage(helper.getSql(), helper.getParam(), ZlBNews.class, pageIndex, pageSize);
	}
	/**
	 * 保存实体对象entity
	 * 
	 * @author 齐建军
	 */
	public int saveZlBNews(ZlBNews entity) {
		if (entity.getNewsid() == null)
			entity.setNewsid(this.getUUId());

		int flag = this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * 
	 * @author 齐建军
	 */
	public int updateZlBNews(ZlBNews entity) {
		int flag = this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 * 
	 * @author 齐建军
	 */
	public int deleteZlBNews(ZlBNews entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * 
	 * @author 齐建军
	 */
	public ZlBNews getZlBNewsById(String id) {
		return this.getEntityById(id, ZlBNews.class);
	}

	/**
	 * 获取新闻分类名
	 * 
	 * @return
	 */
	public List<ZlBNewsCategory> getZlBNewsCategory() {
		String sql = "select  * from zl_b_news_category   where parentid='0'";

		return super.queryForList(sql, ZlBNewsCategory.class);
	}
	/**
	 * 获取新闻分类名
	 * 
	 * @return
	 */
	public List<ZlBNewsCategory> getZlBNewsCategoryByUserid(String userid) {
		String sql = "select  c.* from zl_b_news_category c,sys_userid_categoryid s  where c.parentid='0' AND c.categoryid=s.categoryid  AND s.userid='"+userid+"'";
		return super.queryForList(sql, ZlBNewsCategory.class);
	}
	/**
	 * 获取新闻分类名
	 * 
	 * @return
	 */
	public List<ZlBNewsCategory> getZlBNewsCategoryByParentid(String parentid) {
		String sql = "select  * from zl_b_news_category   where parentid='"+parentid+"'";

		return super.queryForList(sql, ZlBNewsCategory.class);
	}
	/**
	 * 获取新闻分类名
	 * 
	 * @return
	 */
	public List<ZlBNewsCategory> getZlBNewsCategoryByParentidAndUserid(String parentid,String userid) {
		String sql = "select  c.* from zl_b_news_category c,sys_userid_categoryid s  where c.parentid='"+parentid+"' AND c.categoryid=s.categoryid  AND s.userid='"+userid+"'";

		return super.queryForList(sql, ZlBNewsCategory.class);
	}
	/**
	 * 新闻总数量
	 * 
	 * @author zll
	 */
	public ZlBNews queryZlBNewsCount(ZlBNews entity) {
		String sql = "SELECT count(*) AS count FROM zl_b_news B,zl_b_news_category C WHERE B.categoryid=C.categoryid AND C.client='pc' ";
		if (entity.getNewstitle() != null && !"".equals(entity.getNewstitle())) {
			sql = sql + " and B.newstitle like '%" + entity.getNewstitle()+ "%' ";
		}
		if (entity.getCategoryid() != null && !"".equals(entity.getCategoryid())) {
			sql = sql + " and B.categoryid='" + entity.getCategoryid() + "' ";
		}
		JDBCHelper helper = new JDBCHelper(sql);
		return this.queryObject(helper.getSql(), helper.getParam(), ZlBNews.class);
	}
	
	/**
	 * 新闻总阅读量
	 * 
	 * @author zll
	 */
	public ZlBNews queryZlBNewsVisitcount(ZlBNews entity) {
		String sql = "SELECT round(sum(0+B.visitnum),0) AS visitcount FROM zl_b_news B,zl_b_news_category C WHERE B.categoryid=C.categoryid AND C.client='pc' ";
		if (entity.getNewstitle() != null && !"".equals(entity.getNewstitle())) {
			sql = sql + " and B.newstitle like '%" + entity.getNewstitle()+ "%' ";
		}
		if (entity.getCategoryid() != null && !"".equals(entity.getCategoryid())) {
			sql = sql + " and B.categoryid='" + entity.getCategoryid() + "' ";
		}
		JDBCHelper helper = new JDBCHelper(sql);
		return this.queryObject(helper.getSql(), helper.getParam(), ZlBNews.class);
	}
	
	/**
	 * 新闻阅读量百分比
	 * 
	 * @author zll
	 */
	public ZlBNews queryZlBNewsPercent(ZlBNews entity) {
		String sql = " SELECT ROUND( "+entity.getVisitcount()+" / num.visitcount * 100,2) AS percent from (SELECT round(sum(0+B.visitnum),0) AS visitcount FROM zl_b_news B,zl_b_news_category C WHERE B.categoryid=C.categoryid AND C.client='pc' ) as num ";
		JDBCHelper helper = new JDBCHelper(sql);
		return this.queryObject(helper.getSql(), helper.getParam(), ZlBNews.class);
	}
	
	/**
	 * 更新新闻
	 * @param entrepotid
	 * @param traderid
	 * @return
	 */
	public int saveUpdateNewsByistop(String categoryid){
		String sql="update zl_b_news set istop='0' where istop='1' and categoryid='"+categoryid+"' ";
		return this.executeSQL(sql);
	}
	/**
	 * 根据parentid查询一条最新的置顶信息
	 * 
	 * @author wy
	 */
	public ZlBNews queryZlBNewsByParentidOrderByIstop(String categoryid) {
		String sql = " SELECT * FROM zl_b_news   WHERE categoryid='"+categoryid+"' ORDER BY istop desc,ordernum+0 desc,CAST(publishtime as DATETIME) DESC limit 1  ";
		JDBCHelper helper = new JDBCHelper(sql);
		return this.queryObject(helper.getSql(), helper.getParam(), ZlBNews.class);
	}
	/**
	 * 根据分类获取新闻
	 * 
	 * @return
	 */
	public List<ZlBNews> getZlBNewslistByParentid(String parentid,int num) {
		String sql = "select  T.*,DATE_FORMAT(T.publishtime,'%Y-%m-%d') as ctime from zl_b_news T   where categoryid='"+parentid+"' ORDER BY  ordernum+0 desc,CAST(publishtime as DATETIME) DESC limit "+num+"";
		return super.queryForList(sql, ZlBNews.class);
	}
	/**
	 * 根据父级别id查询置顶新闻
	 * 
	 * @return
	 */
	public List<ZlBNews> queryZlBNewsListByParentid(String parentid,int num) {
		String sql = "select  T.*,DATE_FORMAT(T.publishtime,'%Y-%m-%d') as ctime from zl_b_news T,zl_b_news_category C   where T.categoryid=C.categoryid and  C.parentid='"+parentid+"' ORDER BY T.istop desc, T.ordernum+0 desc,CAST(T.publishtime as DATETIME) DESC limit "+num+"";
		return super.queryForList(sql, ZlBNews.class);
	}
	/**
	 * 根据分类获取新闻
	 * 
	 * @return
	 */
	public List<ZlBNewsAttach> getZlBNewsAttachByNewsid(String newsid) {
		String sql = "select  * from zl_b_news_attach    where newsid='"+newsid+"' ORDER BY  ordernum+0 asc";
		return super.queryForList(sql, ZlBNewsAttach.class);
	}

	/**
	 * 删除公告关联图片
	 */
	public int deleteZlBNewsAttachById(String newsid){
		String sql="delete from zl_b_news_attach where newsid='"+newsid+"'";
		return this.executeSQL(sql);
	}
}