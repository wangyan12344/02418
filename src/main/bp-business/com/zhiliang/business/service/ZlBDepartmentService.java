package com.zhiliang.business.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiliang.persistence.dao.ZlBDepartmentDAO;
import com.zhiliang.persistence.dto.departmentDTO;
import com.zhiliang.persistence.entity.ZlBDepartment;
import com.zhiliang.persistence.entity.ZlBDepartmentUser;
import com.repast.core.system.Pagination;

/**
 * 
 * ZlBDepartment 的Service
 * @author 
 */
@Service("ZlBDepartmentService")
public class ZlBDepartmentService {
	
	@Resource
	private ZlBDepartmentDAO zlBDepartmentDAO;
	

	/**
	 * 查询B端app首页活动实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBDepartment> queryZlBDepartmentPageList(ZlBDepartment entity, int pageIndex, int pageSize) {
		return zlBDepartmentDAO.queryZlBDepartmentPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 查询B端app首页活动实体列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBDepartment> queryZlBDepartmentList(ZlBDepartment entity) {
		return zlBDepartmentDAO.queryZlBDepartmentList(entity);
	}
	

	
	/**
	 * 保存B端app首页活动实体
	 * @param entity
	 * @return
	 */
	public int saveAddZlBDepartment(ZlBDepartment entity)
	{
		return zlBDepartmentDAO.saveAddZlBDepartment(entity);
	}
	
	/**
	 * 删除B端app首页活动实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBDepartment(ZlBDepartment entity)
	{
		return zlBDepartmentDAO.deleteZlBDepartment(entity);
	}
	
	/**
	 * 查询B端app首页活动实体信息
	 * @param entity
	 * @return
	 */
	public ZlBDepartment getZlBDepartmentById(ZlBDepartment entity)
	{
		return zlBDepartmentDAO.getZlBDepartmentById(entity.getId());
	}
	
	/**
	 * 修改B端app首页活动实体
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBDepartment(ZlBDepartment entity)
	{
		return zlBDepartmentDAO.saveUpdateZlBDepartment(entity);
	}
	
	
	/**
	 * 部门投稿统计
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBDepartment> queryOrderDataForMapBar(ZlBDepartment entity) {
		return zlBDepartmentDAO.queryOrderDataForMapBar(entity);
	}
	/**
	 * 部门投稿统计
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBDepartment> queryZlBDepartmentListExcel(ZlBDepartment entity,String stime,String etime) {
		return zlBDepartmentDAO.queryZlBDepartmentListExcel(entity,stime,etime);
	}
	
 
	/**
	 * 获取新闻月份
	 * @param entity
	 * @return
	 */
	public List<departmentDTO> queryDataMonth(ZlBDepartment entity) {
		List<departmentDTO> list=zlBDepartmentDAO.queryDataMonth(entity);
		for (int i = 0; i < list.size(); i++) {
			entity.setStime(list.get(i).getMonths());
			List<ZlBDepartment> list2=zlBDepartmentDAO.queryNewsNumBydepartment(entity);
			list.get(i).setZlBDepartmentlist(list2);
		}
		return list;
	}
	 
		/**
		 * 获取新闻月份
		 * @param entity
		 * @return
		 */
		public List<ZlBDepartment> queryNewsNumBydepartment(ZlBDepartment entity) {
			List<ZlBDepartment> list2=zlBDepartmentDAO.queryNewsNumBydepartment(entity);
			return list2;
		}
	/**
	 * 部门投稿统计
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<ZlBDepartment> queryOrderDataForMapBarMonth(ZlBDepartment entity) {
		
		List<ZlBDepartment>list= zlBDepartmentDAO.queryOrderDataForMapBarMonth(entity);
		for (int i = 0; i < list.size(); i++) {
			ZlBDepartment entitynew=new ZlBDepartment();
			entitynew.setId(list.get(i).getId());
			List<ZlBDepartment> list2=zlBDepartmentDAO.queryNewsNumBydepartment(entitynew);
			list.get(i).setZlBDepartmentlist(list2);
		}		
		return list;
	}
	
 
}
