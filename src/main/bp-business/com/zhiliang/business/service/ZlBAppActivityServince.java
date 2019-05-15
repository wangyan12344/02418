package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.system.Pagination;
import com.zhiliang.persistence.dao.ZlBAppActivityDAO;
import com.zhiliang.persistence.entity.ZlBAppActivity;

@Service("ZlBAppActivityServince")
public class ZlBAppActivityServince {
	
	@Resource
	private ZlBAppActivityDAO zlBAppActivityDAO;
	
	/**
	 * 获得最新活动
	 * @param entity
	 * @return
	 */
	public ZlBAppActivity getZlBAppActivity(ZlBAppActivity entity)
	{
		return zlBAppActivityDAO.getZlBAppActivity(entity);
	}

	
	public Pagination<ZlBAppActivity> queryZlBAppActivityPageList(ZlBAppActivity entity, int pageIndex, int pageSize) {
		return zlBAppActivityDAO.queryZlBAppActivityPageList(entity, pageIndex, pageSize);
	}
	
	public int deleteZlBAppActivity(ZlBAppActivity entity){
		return zlBAppActivityDAO.deleteZlBAppActivity(entity);
	}
	
	public int saveAddZlBAppActivity(ZlBAppActivity entity){
		entity.setCtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return zlBAppActivityDAO.saveAddZlBAppActivity(entity);
		
	}
	
	public ZlBAppActivity getZlBAppActivityById(ZlBAppActivity entity){
		return zlBAppActivityDAO.getZlBAppActivityById(entity.getId());
		
	}
	
	public int saveUpdateZlBAppActivity(ZlBAppActivity entity){
		return zlBAppActivityDAO.saveUpdateZlBAppActivity(entity);
		
	}
}
