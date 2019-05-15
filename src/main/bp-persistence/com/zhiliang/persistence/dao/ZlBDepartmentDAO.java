package com.zhiliang.persistence.dao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.zhiliang.persistence.dto.departmentDTO;
import com.zhiliang.persistence.entity.ZlBDepartment;
import com.zhiliang.persistence.entity.ZlBDepartmentUser;

/**
 * 
 * 表ZlBDepartment 的DAO类
 * @author 
 */

@Component("ZlBDepartmentDAO")
public class ZlBDepartmentDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.* FROM zl_b_department T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBDepartment entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.departmentname", JDBCHelper.EQ, entiy.getDepartmentname());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.num", JDBCHelper.EQ, entiy.getNum());
				jdbcHelper.putOrder( " T.num+0 asc " );
		}
		return jdbcHelper;
	}
 
	private JDBCHelper makeSearch_list(ZlBDepartment entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.departmentname", JDBCHelper.EQ, entiy.getDepartmentname());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.num", JDBCHelper.EQ, entiy.getNum());
				
				jdbcHelper.putOrder( " T.num+0 asc " );
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询B端app首页活动列表
	 * @author 
	 */
	public Pagination<ZlBDepartment> queryZlBDepartmentPageList(ZlBDepartment entity, int pageIndex, int pageSize) {
		String sql = "SELECT T.*,IFNULL((SELECT COUNT(*) FROM zl_b_news where department= T.id),0) AS newsnum FROM zl_b_department T WHERE 1=1 ";
		
		if (!"".equals(entity.getStime()) && entity.getStime()!=null && !"".equals(entity.getEtime()) && entity.getEtime()!=null) {
			sql = "SELECT T.*,IFNULL((SELECT COUNT(*) FROM zl_b_news where department= T.id AND CAST(publishtime as DATETIME)>='"+entity.getStime()+"' and CAST(publishtime as DATETIME)<='"+entity.getEtime()+"'),0) AS newsnum FROM zl_b_department T WHERE 1=1 ";
		}
		 
		JDBCHelper helper = makeSearch_list(entity, sql);
		return getPage(helper.getSql(), helper.getParam(), ZlBDepartment.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询B端app首页活动集合
	 * @author 
	 */
	public List<ZlBDepartment> queryZlBDepartmentListExcel(ZlBDepartment entity,String stime,String etime) {
			String sql = "SELECT T.*,IFNULL((SELECT COUNT(*) FROM zl_b_news where department= T.id),0) AS newsnum FROM zl_b_department T WHERE 1=1 ";
		
		if (!"".equals(stime) && stime!=null && !"".equals(etime) && etime!=null) {
			sql = "SELECT T.*,IFNULL((SELECT COUNT(*) FROM zl_b_news where department= T.id AND CAST(publishtime as DATETIME)>='"+stime+"' and CAST(publishtime as DATETIME)<='"+etime+"'),0) AS newsnum FROM zl_b_department T WHERE 1=1 ";
		}
		JDBCHelper helper = makeSearch(entity, sql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBDepartment.class);
	}
	/**
	 * 查询B端app首页活动集合
	 * @author 
	 */
	public List<ZlBDepartment> queryZlBDepartmentList(ZlBDepartment entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBDepartment.class);
	}
	
	/**
	 * 获取月份
	 * @author 
	 */
	public List<departmentDTO> queryDataMonth(ZlBDepartment entity) {
		String sql = "SELECT   DATE_FORMAT(s.publishtime,'%Y-%m') as months,s.*   FROM zl_b_news s GROUP BY  DATE_FORMAT(s.publishtime,'%m-%Y') order BY months";
		return queryForList(sql, departmentDTO.class);
	}
	/**
	 * 保存B端app首页活动实体对象
	 * @author 
	 */
	public int saveAddZlBDepartment(ZlBDepartment entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改B端app首页活动实体对象
	 * @author 
	 */
	public int saveUpdateZlBDepartment(ZlBDepartment entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除B端app首页活动实体对象
	 * @author 
	 */
	public int deleteZlBDepartment(ZlBDepartment entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询B端app首页活动实体对象
	 * @author 
	 */
	public ZlBDepartment getZlBDepartmentById(String id) {
		return this.getEntityById(id, ZlBDepartment.class);
	}
	/**
	 * 查询B端app首页活动集合
	 * @author 
	 */
	public List<ZlBDepartment> queryOrderDataForMapBar(ZlBDepartment entity) {
		String sql = "SELECT T.*,(SELECT COUNT(*) FROM zl_b_news where department= T.id) AS newsnum FROM zl_b_department T WHERE 1=1 ";
		JDBCHelper helper = makeSearch(entity, sql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBDepartment.class);
	}
	/**
	 * @author 
	 */
	public List<ZlBDepartment> queryOrderDataForMapBarMonth(ZlBDepartment entity) {
		String sql = "SELECT T.*,(SELECT COUNT(*) FROM zl_b_news where department= T.id) AS newsnum FROM zl_b_department T WHERE 1=1 order by T.id desc ";
		return queryForList(sql, ZlBDepartment.class);
	}
	/**
	 * @author 
	 */
	public List<ZlBDepartment> queryNewsNumByMonth(ZlBDepartment entity) {
		String sql = "SELECT  (SELECT COUNT(*) FROM zl_b_news where department= p.id and DATE_FORMAT(publishtime,'%Y-%m')=DATE_FORMAT('"+entity.getStime()+"','%Y-%m') ) as newsnum,p.* from zl_b_department p   order by p.id desc ";
		return queryForList(sql, ZlBDepartment.class);
	}
	/**
	 按部门各个月份数量
	 * @author 
	 */
	public List<ZlBDepartment> queryNewsNumBydepartment(ZlBDepartment entity) {
		String sql = "SELECT   COUNT(*) as newsnum,rs.stime as stime from (SELECT    DATE_FORMAT(s.publishtime,'%Y-%m') as stime   FROM zl_b_news s LEFT JOIN zl_b_department p ON s.department=p.id where s.department='"+entity.getId()+"' ) rs GROUP BY  rs.stime ";
		return queryForList(sql, ZlBDepartment.class);
	}
	
}