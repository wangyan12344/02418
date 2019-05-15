package com.zhiliang.persistence.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;




import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.entity.ZlBTradingRecode;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author 齐建军
 */
@Component("ZlBTradingRecodeDAO")
public class ZlBTradingRecodeDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_trading_recode T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBTradingRecode entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND,  JDBCHelper.LIKE, entiy.getTradename(),"T. tradename","T. settlement","T. tradevolume","T. planttype","T.price","T.recodetime");
				jdbcHelper.putParam(JDBCHelper.AND, "T. settlement", JDBCHelper.EQ, entiy.getSettlement());
				jdbcHelper.putParam(JDBCHelper.AND, "T. tradevolume", JDBCHelper.EQ, entiy.getTradevolume());
				jdbcHelper.putParam(JDBCHelper.AND, "T. planttype", JDBCHelper.EQ, entiy.getPlanttype());
		}
		jdbcHelper.putOrder(" T.ctime desc ");
		
		return jdbcHelper;
	}
	
	/**
	 * 分页查询entity List
	 * @author superma
	 */
	public Pagination<ZlBTradingRecode> queryZlBTradingRecodeList(ZlBTradingRecode entity, int pageIndex, int pageSize) {
		
		
		String sqlString="SELECT T.*,s.newstitle as newstitle,u.username as username FROM zl_b_trading_recode T "
				+ "left join zl_b_news s on T.newsid=s.newsid "
				+ "left join zl_b_trader_user u on T.userid=u.traderuserid WHERE 1=1 ";
		
		if (!"".equals(entity.getUsername())) {
			sqlString=sqlString+ " and ( u.username like '%"+entity.getUsername()+"%' or s.newstitle like '%"+entity.getUsername()+"%') ";
		}
		
		JDBCHelper helper = makeSearch(entity, sqlString);
		return getPage(helper.getSql(), helper.getParam(), ZlBTradingRecode.class, pageIndex, pageSize);
	}
	
	/**
	 * 保存实体对象entity
	 * @author superma
	 */
	public int saveTradingRecode(ZlBTradingRecode entity) {
   			 
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * @author 齐建军
	 */
	public int saveUpdateZlBTradingRecode(ZlBTradingRecode entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除实体对象entity
	 * @author 齐建军
	 */
	public int deleteZlBTradingRecode(ZlBTradingRecode entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public ZlBTradingRecode getZlBTradingRecodeById(String id) {
		return this.getEntityById(id, ZlBTradingRecode.class);
	}
	
}