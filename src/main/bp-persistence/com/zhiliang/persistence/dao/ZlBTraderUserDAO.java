package com.zhiliang.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBTraderUser;

/**
 * 葫芦岛银行
 */

@Component("ZlBTraderUserDAO")
public class ZlBTraderUserDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_trader_user T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBTraderUser entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.traderuserid", JDBCHelper.EQ, entiy.getTraderuserid());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.traderid", JDBCHelper.EQ, entiy.getTraderid());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.username", JDBCHelper.LIKE, entiy.getUsername());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.account", JDBCHelper.LIKE, entiy.getAccount());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.password", JDBCHelper.EQ, entiy.getPassword());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.paypassword", JDBCHelper.EQ, entiy.getPaypassword());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.cardtype", JDBCHelper.EQ, entiy.getCardtype());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.cardnumber", JDBCHelper.EQ, entiy.getCardnumber());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.regdate", JDBCHelper.EQ, entiy.getRegdate());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.mobile", JDBCHelper.LIKE, entiy.getMobile());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.email", JDBCHelper.EQ, entiy.getEmail());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.address", JDBCHelper.EQ, entiy.getAddress());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.isadmin", JDBCHelper.EQ, entiy.getIsadmin());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.isfinance", JDBCHelper.EQ, entiy.getIsfinance());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.istrader", JDBCHelper.EQ, entiy.getIstrader());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.enable", JDBCHelper.EQ, entiy.getEnable());
		 		
		}
		jdbcHelper.putOrder(" CAST(regdate AS DATETIME) DESC ");
		return jdbcHelper;
	}
	
	/**
	 * 分页查询交易商（个人）用户信息列表
	 */
	public Pagination<ZlBTraderUser> queryZlBTraderUserPageList(ZlBTraderUser entity, int pageIndex, int pageSize) {
		String sql="SELECT T.* FROM zl_b_trader_user T where 1= 1  ";
		JDBCHelper helper = makeSearch(entity, sql);
		return getPage(helper.getSql(), helper.getParam(), ZlBTraderUser.class, pageIndex, pageSize);
	}
	
	/**
	 * 分页查询交易商（企业）用户信息列表
	 * @author 马骞
	 */
	public Pagination<ZlBTraderUser> queryZlBTraderUserPageList1(ZlBTraderUser entity, int pageIndex, int pageSize) {
		String sql="SELECT T.* FROM zl_b_trader_user T WHERE  1=1 ";
		JDBCHelper helper = makeSearch(entity, sql);
		return getPage(helper.getSql(), helper.getParam(), ZlBTraderUser.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询交易商（个人）用户信息列表
	 * @author 马骞
	 */
	public List<ZlBTraderUser> queryZlBTraderUserForList(ZlBTraderUser entity) {
		String sql="SELECT T.* FROM zl_b_trader_user T  WHERE    T.traderuserid != ? AND ( T.account = ? or  T.mobile = ? ) ";

		return queryForList(sql,new Object[]{entity.getTraderuserid(),entity.getAccount(),entity.getMobile()}, ZlBTraderUser.class);
	}
	
	/**
	 * 查询交易商（企业）用户信息列表
	 * @author 马骞
	 */
	public List<ZlBTraderUser> queryZlBTraderUserForList1(ZlBTraderUser entity) {
		String sql="SELECT T.* FROM zl_b_trader_user T WHERE   T.traderuserid != ? AND  (T.account = ? or  T.mobile = ? ) ";

		return queryForList(sql,new Object[]{entity.getTraderuserid(),entity.getAccount(),entity.getMobile()}, ZlBTraderUser.class);
	}
	
	/**
	 * 保存交易商(个人)用户信息实体对象
	 * @author 周杨
	 */
	public int saveAddZlBTraderUser(ZlBTraderUser entity) {
   			// if(entity.getTraderuserid()==null)
				entity.setTraderuserid(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 保存交易商(企业)用户信息实体对象
	 * @author 周杨
	 */
	public int saveAddZlBTraderUser1(ZlBTraderUser entity) {
   			 if(entity.getTraderuserid()==null)
				entity.setTraderuserid(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}
	
	/**
	 * 修改交易商用户信息实体对象
	 * @author 周杨
	 */
	public int saveUpdateZlBTraderUser(ZlBTraderUser entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除交易商用户信息实体对象
	 * @author 周杨
	 */
	public int deleteZlBTraderUser(ZlBTraderUser entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询交易商用户信息实体对象
	 * @author 周杨
	 */
	public ZlBTraderUser getZlBTraderUserById(String id) {
		return this.getEntityById(id, ZlBTraderUser.class);
	}

	/**
	 * 通过id禁止交易商用户
	 * @param id
	 * 表zl_b_trader_user
	 */
	public int updateinhibitZlBTraderUser(String id){
		String sql="update zl_b_trader_user as p set enable=0 where p.traderid=?";
		return this.executeSQL(sql,new Object[]{id});
	}
	
	/**
	 * 通过id启用交易商用户
	 * @param id
	 * 表zl_b_trader_user
	 */
	public int updatestartZlBTraderUser(String id){
		String sql="update zl_b_trader_user as p set enable=1 where p.traderid=?";
		return this.executeSQL(sql,new Object[]{id});
	}
	
}