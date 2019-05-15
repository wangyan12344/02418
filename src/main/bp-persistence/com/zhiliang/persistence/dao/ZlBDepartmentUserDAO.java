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
 * 表ZlBDepartmentUser 的DAO类
 * @author 
 */

@Component("ZlBDepartmentUserDAO")
public class ZlBDepartmentUserDAO extends BaseDao {

	
	
	public final static String QueryTableSql = "SELECT T.*,p.departmentname as departmentname FROM zl_b_department_user T LEFT JOIN zl_b_department p ON T.departmentid=p.id  WHERE 1=1 ";
	
	private JDBCHelper makeSearch(ZlBDepartmentUser entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.departmentid", JDBCHelper.EQ, entiy.getDepartmentid());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.num", JDBCHelper.EQ, entiy.getNum());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.departmentuser", JDBCHelper.EQ, entiy.getDepartmentuser());
				
				jdbcHelper.putOrder( " T.num+0 asc " );

		}
		return jdbcHelper;
	}
	private JDBCHelper makeSearch_list(ZlBDepartmentUser entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.id", JDBCHelper.EQ, entiy.getId());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.departmentid", JDBCHelper.EQ, entiy.getDepartmentid());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.num", JDBCHelper.EQ, entiy.getNum());
		 
				jdbcHelper.putParam(JDBCHelper.AND, "T.departmentuser", JDBCHelper.EQ, entiy.getDepartmentuser());

				jdbcHelper.putOrder( " T.num+0 asc " );
		}
		return jdbcHelper;
	}
	
	/**
	 * 分页查询B端app首页活动列表
	 * @author 
	 */
	public Pagination<ZlBDepartmentUser> queryZlBDepartmentUserPageList(ZlBDepartmentUser entity, int pageIndex, int pageSize) {
		
		String QueryTableSql = "SELECT T.*,(SELECT COUNT(*) FROM zl_b_news where departmentuser= T.id) AS newsnum,p.departmentname as departmentname FROM zl_b_department_user T LEFT JOIN zl_b_department p ON T.departmentid=p.id  WHERE 1=1 ";
		
		JDBCHelper helper = makeSearch_list(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), ZlBDepartmentUser.class, pageIndex, pageSize);
	}
	
	/**
	 * 查询B端app首页活动集合
	 * @author 
	 */
	public List<ZlBDepartmentUser> queryZlBDepartmentUserList(ZlBDepartmentUser entity) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBDepartmentUser.class);
	}
	/**
	 * 查询部门下人员集合
	 * @author 
	 */
	public List<ZlBDepartmentUser> queryOrderDataForMapBar(ZlBDepartmentUser entity) {
		String sql = "SELECT T.*,(SELECT COUNT(*) FROM zl_b_news where departmentuser= T.id) AS newsnum,p.departmentname as departmentname FROM zl_b_department_user T LEFT JOIN zl_b_department p ON T.departmentid=p.id  WHERE 1=1 ";
		JDBCHelper helper = makeSearch(entity, sql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBDepartmentUser.class);
	}
 
	/**
	 * 获取月份
	 * @author 
	 */
	public List<departmentDTO> queryDataMonth(ZlBDepartmentUser entity) {
		String sql = "SELECT   DATE_FORMAT(s.publishtime,'%Y-%m') as months ,s.*  FROM zl_b_news s GROUP BY  DATE_FORMAT(s.publishtime,'%m-%Y') order BY months";
		return queryForList(sql, departmentDTO.class);
	}
	
	/**
	 * 查询B端app首页活动集合
	 * @author 
	 */
	public List<ZlBDepartmentUser> queryZlBDepartmentUserlListExcel(ZlBDepartmentUser entity) {
		String sql = "SELECT T.*,(SELECT COUNT(*) FROM zl_b_news where departmentuser= T.id) AS newsnum,p.departmentname as departmentname FROM zl_b_department_user T LEFT JOIN zl_b_department p ON T.departmentid=p.id  WHERE 1=1 ";
		JDBCHelper helper = makeSearch(entity, sql);
		return queryForList(helper.getSql(), helper.getParam(), ZlBDepartmentUser.class);
	}
	/**
	 * 保存B端app首页活动实体对象
	 * @author 
	 */
	public int saveAddZlBDepartmentUser(ZlBDepartmentUser entity) {
   			 if(entity.getId()==null)
				entity.setId(this.getUUId());
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改B端app首页活动实体对象
	 * @author 
	 */
	public int saveUpdateZlBDepartmentUser(ZlBDepartmentUser entity) {
		int flag =  this.saveUpdate(entity);
		return flag;
	}

	/**
	 * 删除B端app首页活动实体对象
	 * @author 
	 */
	public int deleteZlBDepartmentUser(ZlBDepartmentUser entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据ID查询B端app首页活动实体对象
	 * @author 
	 */
	public ZlBDepartmentUser getZlBDepartmentUserById(String id) {
		return this.getEntityById(id, ZlBDepartmentUser.class);
	}

}