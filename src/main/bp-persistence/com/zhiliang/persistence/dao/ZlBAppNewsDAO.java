package com.zhiliang.persistence.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBCount;
import com.zhiliang.persistence.entity.ZlBCountIp;
import com.zhiliang.persistence.entity.ZlBNews;
import com.zhiliang.persistence.entity.ZlBNewsCategory;
import com.zhiliang.persistence.entity.ZlBNewsPraise;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 */
@Component("ZlBAppNewsDAO")
public class ZlBAppNewsDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_news T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBNews entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. newsid", JDBCHelper.EQ, entiy.getNewsid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. newstitle", JDBCHelper.EQ, entiy.getNewstitle());
				jdbcHelper.putParam(JDBCHelper.AND, "T. newscontent", JDBCHelper.EQ, entiy.getNewscontent());
				jdbcHelper.putParam(JDBCHelper.AND, "T. categoryid", JDBCHelper.EQ, entiy.getCategoryid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. publishtime", JDBCHelper.EQ, entiy.getPublishtime());
				jdbcHelper.putParam(JDBCHelper.AND, "T. publisherid", JDBCHelper.EQ, entiy.getPublisherid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. mainimgpath", JDBCHelper.EQ, entiy.getMainimgpath());
				jdbcHelper.putParam(JDBCHelper.AND, "T. isHomePage", JDBCHelper.EQ, entiy.getIsHomePage());
				jdbcHelper.putParam(JDBCHelper.AND, "T. istop", JDBCHelper.EQ, entiy.getIstop());
				jdbcHelper.putParam(JDBCHelper.AND, "T. templateid", JDBCHelper.EQ, entiy.getTemplateid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. ordernum", JDBCHelper.EQ, entiy.getOrdernum());
				jdbcHelper.putParam(JDBCHelper.AND, "T. visitnum", JDBCHelper.EQ, entiy.getVisitnum());
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询entity List
	 * @author 齐建军
	 */
	public Pagination<ZlBNews> queryZlBNewsList(ZlBNews entity, int pageIndex, int pageSize) {
		String sql="SELECT B.*,IFNULL(C.permissions,1) as permissions FROM zl_b_news B,zl_b_news_category C WHERE B.categoryid=C.categoryid  ";
		
		if(entity.getCategoryid()!=null&&!"".equals(entity.getCategoryid())){
			if (!"".equals(entity.getType()) && entity.getType()!=null) {
				if ("1".equals(entity.getType())) {
				sql=sql+" and C.parentid='"+entity.getCategoryid()+"' ";
				}else if ("0".equals(entity.getType())) {
					 sql=sql+" and B.categoryid='"+entity.getCategoryid()+"' ";
				}
			}
		 }
		
		if(entity.getNewstitle()!=null && !"".equals(entity.getNewstitle())){
			sql=sql+" and B.newstitle like '%"+entity.getNewstitle()+"%' ";
		}
		if(entity.getTemplateid()!=null && !"".equals(entity.getTemplateid())){
			sql=sql+" and B.templateid='"+entity.getTemplateid()+"' ";
		}
		
		sql=sql+"ORDER BY B.ordernum+0 desc ,CAST(B.publishtime as DATETIME) DESC";
		return getPage(sql, new Object[]{}, ZlBNews.class, pageIndex, pageSize);
	}
	
	/**
	 * 不分页查询entity List
	 * @author 
	 */
	public List<ZlBNews> queryZlBNewsList2(ZlBNews entity) {
		String sql="SELECT T.* FROM zl_b_news T WHERE categoryid='"+entity.getCategoryid()+"' ";
		if(!"".equals(entity.getGraintype()) && entity.getGraintype()!=null){
			
			sql=sql+" AND graintype='"+entity.getGraintype()+"' ";
		}
			sql=sql	+ "AND isHomePage=1 ORDER BY T.ordernum+0 desc ,CAST(publishtime as DATETIME) DESC LIMIT 5;";
		return super.queryForList(sql, new Object[]{}, ZlBNews.class);
	}
	
	/**
	 * 保存实体对象entity
	 * @author 齐建军
	 */
	public int saveZlBNews(ZlBNews entity) {
   			 if(entity.getNewsid()==null)
				entity.setNewsid(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * @author 齐建军
	 */
	public int updateZlBNews(ZlBNews entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 * @author 齐建军
	 */
	public int deleteZlBNews(ZlBNews entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public ZlBNews getZlBNewsById(String id) {
		return this.getEntityById(id, ZlBNews.class);
	}
	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public ZlBNewsCategory getZlBNewsCategoryByCategory(String id) {
		return this.getEntityById(id, ZlBNewsCategory.class);
	}
	/**
	 * 
	 */
	public ZlBNews getZlBNewsById2(String id) {
		String sql="select B.*,"
				+ " c.categoryname AS categoryname,p.url as classurl ,p.categoryname as parentidclassname,u.username as username,d.departmentname as departmentname,us.departmentuser as departmentusername   from zl_b_news B left JOIN zl_b_department d ON B.department=d.id   LEFT JOIN zl_b_department_user us on B.departmentuser=us.id,zl_b_news_category c,zl_b_news_category p,sys_user_info u   where c.categoryid=B.categoryid and c.parentid=p.categoryid and B.newsid='"+id+"' and u.userid=B.updateuserid ";
		return super.queryObject(sql, new Object[]{},ZlBNews.class);
	}
	/**
	 * 
	 */
	public ZlBNews detailedUpAndDown(String publishtime,String categoryid,String type) {
		String sql="select B.*,"
				+ " N.categoryname AS categoryname "
				+ " from zl_b_news B left join zl_b_news_category N on N.categoryid=B.categoryid where 1=1 and B.categoryid='"+categoryid+"' ";
		if("up".equals(type)) {
			sql=sql+" and str_to_date(B.publishtime,'%Y-%m-%d %H:%i:%s') - str_to_date('"+publishtime+"','%Y-%m-%d %H:%i:%s')> 0  order by str_to_date(B.publishtime,'%Y-%m-%d %H:%i:%s') asc  ";
		}else {
			sql=sql+" and  str_to_date('"+publishtime+"','%Y-%m-%d %H:%i:%s')-str_to_date(B.publishtime,'%Y-%m-%d %H:%i:%s')> 0 order by str_to_date(B.publishtime,'%Y-%m-%d %H:%i:%s') desc ";
		}
		
		
		sql=sql+"   limit 1 ";
		return super.queryObject(sql, new Object[]{},ZlBNews.class);
	}
	
	/**
	 * 获取新闻分类名
	 * @return
	 */
		public List<ZlBNewsCategory> getZlBNewsCategory(){
			String sql="select  C.categoryid,C.categoryname,C.picturepath from zl_b_news_category C order by C.ordernum+0 asc ";
			
			return super.queryForList(sql, ZlBNewsCategory.class);
		}
	
/*
 * 查询热点新闻
 * 	
 */
		public List<ZlBNews> queryhotnews(){
			String sql="SELECT B.*,IFNULL(C.permissions,1) as permissions FROM zl_b_news B,zl_b_news_category C WHERE B.categoryid=C.categoryid    ORDER BY CAST(B.publishtime AS DATETIME) DESC,B.visitnum DESC LIMIT 10 ";
			return super.queryForList(sql, ZlBNews.class);
		}
		
		/**
		 * 搜索新闻
		 * @param entity
		 * @param pageIndex
		 * @param pageSize
		 * @return
		 */
		public Pagination<ZlBNews> queryZlBNewsListByserch(ZlBNews entity, int pageIndex, int pageSize){
			
			String sql="SELECT B.* FROM zl_b_news B,zl_b_news_category C WHERE B.categoryid=C.categoryid  ";
			
			if(entity.getCategoryid()!=null&&!"".equals(entity.getCategoryid())){
				 sql=sql+" and B.categoryid="+entity.getCategoryid()+" ";
			 }
			

			if(entity.getGraintype()!=null && !"".equals(entity.getGraintype())){
				sql=sql+" and B.graintype='"+entity.getGraintype()+"' ";
			}
			
			if(entity.getTemplateid()!=null && !"".equals(entity.getTemplateid())){
				sql=sql+" and B.templateid='"+entity.getTemplateid()+"' ";
			}
			
			sql=sql+" and B.newstitle LIKE '%"+entity.getNewstitle()+"%' ";
			sql=sql+"ORDER BY B.ordernum+0 desc,CAST(B.publishtime as DATETIME) DESC";
			return getPage(sql, new Object[]{}, ZlBNews.class, pageIndex, pageSize);
		}
		
		/**
		 * 更新新闻访问量
		 * @param entity
		 * @return
		 */
		public int updateVisitnum(ZlBNews entity){
			String sql="update zl_b_news set visitnum = visitnum +"+1+" where newsid='"+entity.getNewsid()+"'";
			return this.executeSQL(sql);
		}
	
		
		/**
		 * 不分页查询entity List
		 * @author 
		 */
		public List<ZlBNews> queryNewsListByCategoryid(ZlBNews entity,int num) {
			String sql="SELECT T.*,IFNULL(c.permissions,1) as permissions, "
					+ "DATE_FORMAT(T.publishtime,'%m-%d') as ctime, "
					+ "DATE_FORMAT(T.publishtime,'%m') as mm, "
					+ "DATE_FORMAT(T.publishtime,'%d') as dd, "
					+ "c.categoryname as categoryname ,p.url as classurl ,p.categoryname as parentidclassname "
					+ "FROM zl_b_news T,zl_b_news_category c,zl_b_news_category p "
					+ "  WHERE T.categoryid=c.categoryid and c.parentid=p.categoryid and  T.categoryid=? ";
				   sql=sql	+ "AND isHomePage=1 ORDER BY T.ordernum+0 desc,CAST(T.publishtime as DATETIME) DESC LIMIT ?";
			return super.queryForList(sql, new Object[]{entity.getCategoryid(),num}, ZlBNews.class);
		}
		
		/**
		 * 置顶，不分页查询entity List
		 * @author 
		 */
		public List<ZlBNews> queryNewsListTopByCategoryid(ZlBNews entity,int num) {
			String sql="SELECT T.*, IFNULL(c.permissions,1) as permissions,DATE_FORMAT(T.publishtime,'%m-%d') as ctime,DATE_FORMAT(T.publishtime,'%m') as mm,DATE_FORMAT(T.publishtime,'%d') as dd, "
					+ "c.categoryname as categoryname ,p.url as classurl ,p.categoryname as parentidclassname "
					+ "FROM zl_b_news T,zl_b_news_category c,zl_b_news_category p  "
					+ "  WHERE T.categoryid=c.categoryid and  c.parentid=p.categoryid and c.categoryid=? ";
				   sql=sql	+ " AND T.isHomePage='1' and T.istop='1' ORDER BY  T.ordernum+0 desc,CAST(T.publishtime as DATETIME) DESC LIMIT ?";
			return super.queryForList(sql, new Object[]{entity.getCategoryid(),num}, ZlBNews.class);
		}
		/**
		 *按父级Id 不分页查询entity List
		 * @author 
		 */
		public List<ZlBNews> queryNewsListByParentCategoryid(ZlBNews entity,int num) {
			String sql="SELECT T.*,IFNULL(c.permissions,1) as permissions, DATE_FORMAT(T.publishtime,'%m-%d') as ctime,DATE_FORMAT(T.publishtime,'%m') as mm,DATE_FORMAT(T.publishtime,'%d') as dd,  "
					+ "c.categoryname as categoryname ,p.url as classurl ,p.categoryname as parentidclassname "
					+ " FROM zl_b_news T,zl_b_news_category c,zl_b_news_category p "
					+ "    WHERE T.categoryid=c.categoryid and  c.parentid=p.categoryid and c.parentid=? ";
				   sql=sql	+ "AND isHomePage=1 ORDER BY T.ordernum+0 desc,CAST(T.publishtime as DATETIME) DESC LIMIT ?";
			return super.queryForList(sql, new Object[]{entity.getCategoryid(),num}, ZlBNews.class);
		}
		
		
		/**
		 * 置顶，不分页查询entity List
		 * @author 
		 */
		public List<ZlBNews> queryNewsListTopByParentCategoryid(ZlBNews entity,int num) {
			String sql="SELECT T.*,IFNULL(c.permissions,1) as permissions, "
					+ "DATE_FORMAT(T.publishtime,'%m-%d') as ctime, "
					+ "DATE_FORMAT(T.publishtime,'%m') as mm, "
					+ "DATE_FORMAT(T.publishtime,'%d') as dd, "
					+ "c.categoryname as categoryname ,p.url as classurl ,p.categoryname as parentidclassname "
					+ "FROM zl_b_news T,zl_b_news_category c,zl_b_news_category p "
					+ " WHERE T.categoryid=c.categoryid and  c.parentid=p.categoryid  and c.parentid=? ";
				   sql=sql	+ " AND isHomePage=1 ORDER BY T.ordernum+0 desc,CAST(T.publishtime as DATETIME) DESC LIMIT ?";
			return super.queryForList(sql, new Object[]{entity.getCategoryid(),num}, ZlBNews.class);
		}
		/**
		 * 置顶，不分页查询entity List
		 * @author 
		 */
		public List<ZlBNewsCategory> queryNewsCategoryListByParentCategoryid(ZlBNewsCategory entity,int num) {
			String sql="SELECT T.*"
					+ " FROM zl_b_news_category T WHERE 1=1 and T.parentid=? and T.status='1' ";
				   sql=sql	+ "  ORDER BY T.ordernum+0 asc   LIMIT ?";
			return super.queryForList(sql, new Object[]{entity.getCategoryid(),num}, ZlBNewsCategory.class);
		}
		public List<ZlBNewsCategory> queryNewsCategoryListByParentCategoryidForMenu(ZlBNewsCategory entity,int num) {
			String sql="SELECT T.*"
					+ " FROM zl_b_news_category T WHERE 1=1 and T.parentid=? and T.status='1' and permissions='1' ";
				   sql=sql	+ "  ORDER BY T.urlnum+0 asc   LIMIT ?";
			return super.queryForList(sql, new Object[]{entity.getCategoryid(),num}, ZlBNewsCategory.class);
		}
		/**
		 * 
		 */
		public ZlBNewsCategory ZlBNewsCategoryByParentid(String id) {
			String sql="select  * from   zl_b_news_category where  categoryid='"+id+"' limit 1";
			return super.queryObject(sql, new Object[]{},ZlBNewsCategory.class);
		}
		
		/**
		 * 置顶，查询有图新闻 按首页显示排序
		 * @author 
		 */
		public List<ZlBNews> queryNewsListTopOfhavepic(ZlBNews entity,int num) {
			String sql="SELECT T.*, IFNULL(c.permissions,1) as permissions,DATE_FORMAT(T.publishtime,'%m-%d') as ctime,DATE_FORMAT(T.publishtime,'%m') as mm,DATE_FORMAT(T.publishtime,'%d') as dd, "
					+ "c.categoryname as categoryname ,p.url as classurl ,p.categoryname as parentidclassname "
					+ "FROM zl_b_news T,zl_b_news_category c,zl_b_news_category p  "
					+ "  WHERE  T.categoryid=c.categoryid and   c.parentid=p.categoryid  ";
				   sql=sql	+ "   AND   T.ishot='1' ORDER BY T.ordernum+0 desc,CAST(T.publishtime as DATETIME) DESC LIMIT ?";
			return super.queryForList(sql, new Object[]{num}, ZlBNews.class);
		}
		/**
		 * 新闻分类主页图片轮播图
		 * @author 
		 */
		public List<ZlBNews> queryNewsBannerOfhavepic(ZlBNews entity,int num) {
			String sql="SELECT T.*, IFNULL(c.permissions,1) as permissions,DATE_FORMAT(T.publishtime,'%m-%d') as ctime,DATE_FORMAT(T.publishtime,'%m') as mm,DATE_FORMAT(T.publishtime,'%d') as dd, "
					+ "c.categoryname as categoryname ,p.url as classurl ,p.categoryname as parentidclassname "
					+ "FROM zl_b_news T,zl_b_news_category c,zl_b_news_category p  "
					+ "  WHERE  T.categoryid=c.categoryid and   c.parentid=p.categoryid  ";
				   sql=sql	+ " AND p.categoryid='"+entity.getCategoryid()+"' AND T.istop=1  AND T.templateid=1 ORDER BY T.ordernum+0 desc,CAST(T.publishtime as DATETIME) DESC LIMIT ?";
			return super.queryForList(sql, new Object[]{num}, ZlBNews.class);
		}
		/**
		 * 更新新闻访问量
		 * @param entity
		 * @return
		 */
		public int updateVisitnumOfuser(String id){
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String timesString=sf.format(new Date());
			
			String sql="update zl_b_trading_recode set num = num +"+1+" ,ctime='"+timesString+"'  where tradingid='"+id+"' ";
			return this.executeSQL(sql);
		}
		/**
		 * 获取是否点赞
		 * @param entity
		 * @return
		 */
		public int queryZlBNewsPraiseByIpaddress(String ipaddress ,String newsid){
			String sql="select count(*)  from zl_b_news_praise   where ipaddress=? and newsid=?";
			return this.queryForInt(sql, new Object[]{ipaddress,newsid});
		}
		/**
		 * 获取点赞数量
		 * @param entity
		 * @return
		 */
		public int queryPraiseByNewsid(String newsid){
			String sql="select count(*)  from zl_b_news_praise   where newsid=?";
			return this.queryForInt(sql, new Object[]{newsid});
		}
		/**
		 * 保存实体对象entity
		 */
		public int saveZlBNewsPraise(ZlBNewsPraise entity) {
	   			 if(entity.getId()==null)
					entity.setId(this.getUUId());
			
			int flag =  this.saveNew(entity);
			return flag;
		}
		/**
		 * 保存实体对象entity
		 */
		public int saveAddZlBCount(ZlBCount entity) {
	   			 if(entity.getId()==null)
					entity.setId(this.getUUId());
			
			int flag =  this.saveNew(entity);
			return flag;
		}
		/**
		 * 保存实体对象entity
		 */
		public int saveAddZlBCountIp(ZlBCountIp entity) {
	   			 if(entity.getId()==null)
					entity.setId(this.getUUId());
			
			int flag =  this.saveNew(entity);
			return flag;
		}
		/**
		 * 修改新闻信息实体对象
		 */
		public int saveUpdateZlBCountIp(ZlBCountIp entity) {
			int flag =  this.saveUpdate(entity);
			return flag;
		}
		/**
		 * 获取当日统计数据
		 * @param entity
		 * @return
		 */
		public ZlBCount queryZlBCountOfToday(String ctime){
			String sql="select T.id,T.daycount,(SELECT COUNT(*) from zl_b_count_ip where updatetime>DATE_SUB(NOW(),INTERVAL 10 MINUTE) )as pcount,T.ctime,(select sum(daycount) from zl_b_count ) as totalcount from zl_b_count T  where T.ctime=? limit 1";
			return super.queryObject(sql, new Object[]{ctime},ZlBCount.class);
		}
		/**
		 * 获取当日统计数据
		 * @param entity
		 * @return
		 */
		public ZlBCountIp queryZlBCountOfTodayAndIp(String ctime,String ip){
			String sql="select T.* from zl_b_count_ip T  where T.updatetime like '%"+ctime+"%' and ipaddress like '%"+ip+"%' limit 1";
			return super.queryObject(sql, new Object[]{},ZlBCountIp.class);
		}
		/**
		 * 更新新闻访问量
		 * @param entity
		 * @return
		 */
		public int updateDaycountByid(String id){
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			String timesString=sf.format(new Date());
			String sql="update zl_b_count set daycount = daycount +"+1+" ,ctime='"+timesString+"'  where id='"+id+"' ";
			return this.executeSQL(sql);
		}
}