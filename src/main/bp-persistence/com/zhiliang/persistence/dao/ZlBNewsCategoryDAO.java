package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBNewsCategory;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author 马骞
 */
@Component("ZlBNewsCategoryDAO")
public class ZlBNewsCategoryDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_news_category T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBNewsCategory entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. categoryid", JDBCHelper.EQ, entiy.getCategoryid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. categoryname", JDBCHelper.EQ, entiy.getCategoryname());
				jdbcHelper.putParam(JDBCHelper.AND, "T. ordernum", JDBCHelper.EQ, entiy.getOrdernum());
				jdbcHelper.putParam(JDBCHelper.AND, "T. picturepath", JDBCHelper.EQ, entiy.getPicturepath());
				jdbcHelper.putParam(JDBCHelper.AND, "T. client", JDBCHelper.EQ, entiy.getClient());
				jdbcHelper.putParam(JDBCHelper.AND, "T. level", JDBCHelper.EQ, entiy.getLevel());
				jdbcHelper.putParam(JDBCHelper.AND, "T. parentid", JDBCHelper.EQ, entiy.getParentid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. imgurl", JDBCHelper.EQ, entiy.getImgurl());
				jdbcHelper.putParam(JDBCHelper.AND, "T. rootid", JDBCHelper.EQ, entiy.getRootid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. indeximgurl", JDBCHelper.EQ, entiy.getIndeximgurl());
				jdbcHelper.putParam(JDBCHelper.AND, "T. status", JDBCHelper.EQ, entiy.getStatus());
				jdbcHelper.putOrder( " T.permissions +0 asc, T.rootid +0 asc,T.ordernum+0  asc " );
				
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询entity List
	 */
	public Pagination<ZlBNewsCategory> queryZlBNewsCategoryList(ZlBNewsCategory entity, int pageIndex, int pageSize) {
		String sql="SELECT T.*,s.pname FROM zl_b_news_category T left join sys_permissions_user s on T.permissions=s.id  WHERE 1=1    ";
		JDBCHelper helper = makeSearch(entity, sql);
		return getPage(helper.getSql(), helper.getParam(), ZlBNewsCategory.class, pageIndex, pageSize);
	}
	
	/**
	 * 保存实体对象entity
	 */
	public int saveZlBNewsCategory(ZlBNewsCategory entity) {
   			 if(entity.getCategoryid()==null)
				entity.setCategoryid(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 */
	public int updateZlBNewsCategory(ZlBNewsCategory entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 */
	public int deleteZlBNewsCategory(ZlBNewsCategory entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 */
	public ZlBNewsCategory getZlBNewsCategoryById(String id) {
		return this.getEntityById(id, ZlBNewsCategory.class);
	}
	
	/**
	 * 修改新闻信息实体对象
	 */
	public int saveUpdateZlBNewsCategory(ZlBNewsCategory entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}
	
	/**
	 * 保存新闻分类添加信息
	 */
	public int saveAddZlBNewsCategory(ZlBNewsCategory entity) {
		entity.setCategoryid(this.getUUId());
		int flag =  this.saveNew(entity);
		return flag;
	}
	/**
	 * 根据rootidid重新排序所有大于传入值数据
	 * @author Wy 
	 */
	public int  updateZlBNewsCategoryOrdernumByrootid(String rootid,String num11,String num22){
	
		String sql="update  zl_b_news_category set ordernum=? where rootid=? and ordernum=?";		
		
	 return this.executeSQL(sql, new Object[]{num22,rootid,num11});
	}
	/**
	 * 根据rootid查询rootid最大排序值
	 * @author Wy 
	 */
	public ZlBNewsCategory  getZlBNewsCategoryMaxrootidByRootid(String rootid){
		String sql="SELECT  max(CAST(rootid AS signed)) as rootid FROM zl_b_news_category where rootid=?";
	 return this.queryObject(sql, new Object[]{rootid}, ZlBNewsCategory.class);
	}
	/**
	 * 查询rootid最大排序值
	 * @author Wy 
	 */
	public ZlBNewsCategory  getZlBNewsCategoryMaxrootidByRootidNull(){
		String sql="SELECT  max(CAST(rootid AS signed)) as rootid FROM zl_b_news_category where 1=1";
	 return this.queryObject(sql, new Object[]{}, ZlBNewsCategory.class);
	}
	/**
	 * 获取子分类个数
	 * @author Wy
	 * 
	 */
	public List<ZlBNewsCategory> getEntityNumByid(String id) {
		String sql="SELECT  *  FROM zl_b_news_category where parentid=?  ";
	 
		return this.queryForList(sql, new Object[]{id}, ZlBNewsCategory.class);
	}
	/**
	 * 获取分类下商品数量
	 * @author Wy
	 * 
	 */
	/*public List<ZlGoodsInfo> getZlGoodsInfoNumByid(String id) {
		String sql="SELECT  *  FROM zl_goods_info where goodtypes=?  or  goodtypet=? ";
	 
		return this.queryForList(sql, new Object[]{id,id}, ZlGoodsInfo.class);
	}*/
	/**
	 * 根据Parentid查询ordernum最大排序值
	 * @author Wy 
	 */
	public ZlBNewsCategory  getZlBNewsCategoryMaxOrdernumByParentid(String parentid){
		String sql="SELECT  *  FROM zl_b_news_category where parentid=? order by  ordernum+0 desc limit 1";
	 return this.queryObject(sql, new Object[]{parentid}, ZlBNewsCategory.class);
	}
	/**
	 * 根据parentid获取下级分类
	 * @author Wy
	 * @param parentid
	 * @return
	 */
	public List<ZlBNewsCategory> getZlBNewsCategoryListByParentid(String parentid){
		String sql="";
		  sql="SELECT T.* FROM zl_b_news_category T    WHERE "
				+ "T.parentid=? and T.status=1   order by CAST(T.ordernum AS signed) asc";		
		return this.queryForList(sql, new Object[]{parentid}, ZlBNewsCategory.class);
	}
	/**
	 * 根据parentid获取下级分类
	 * @author Wy
	 * @param parentid
	 * @return
	 */
	public List<ZlBNewsCategory> getZlBNewsCategoryListByParentidAndUserid(String parentid,String userid){
		String sql="SELECT T.* FROM zl_b_news_category T ,sys_userid_categoryid s   WHERE T.parentid=? and T.status=1 AND   T.categoryid=s.categoryid AND   s.userid=?  order by CAST(T.ordernum AS signed) asc";		
		return this.queryForList(sql, new Object[]{parentid,userid}, ZlBNewsCategory.class);
	}
	/**
	 * 根据parentid获取下级分类
	 * @author Wy
	 * @param parentid
	 * @return
	 */
	public List<ZlBNewsCategory> queryNewClassListByParentid(String parentid,int num){
		String sql="";
		  sql="SELECT T.* FROM zl_b_news_category T    WHERE "
				+ "T.parentid=? and T.status=1   order by CAST(T.ordernum AS signed) asc limit ?";		
		return this.queryForList(sql, new Object[]{parentid,num}, ZlBNewsCategory.class);
	}
	/**
	 * 根据rootidid重新排序所有大于传入值数据
	 * @author Wy 
	 */
	public int  updateZlBNewsCategoryPermissionsByParentid(String parentid,String permissions){
	
		String sql="update  zl_b_news_category set permissions=? where parentid=? ";		
		
	 return this.executeSQL(sql, new Object[]{permissions,parentid});
	}
}