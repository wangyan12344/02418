package com.zhiliang.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.system.Pagination;
import com.zhiliang.persistence.dao.ZlBTradingRecodeDAO;
import com.zhiliang.persistence.entity.ZlBTradingRecode;

/**
 * 最新成交记录
 * @author superma
 */
@Service("ZlBTradingRecodeService")
public class ZlBTradingRecodeService {
	
	@Resource
	private ZlBTradingRecodeDAO zlBTradingRecodeDAO;
	
   /**
    * 保存成交记录
    * @param entity
    * @return
    */
	public int saveTradingRecode(ZlBTradingRecode entity){
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		entity.setCtime(sf.format(new Date()));
		entity.setTradingid(zlBTradingRecodeDAO.getUUId());
		
		return zlBTradingRecodeDAO.saveTradingRecode(entity);
		
	}
	/**
	 * 查询成交记录列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @author superma
	 */
	public Pagination<ZlBTradingRecode> queryTradingRecodeList(ZlBTradingRecode entity, int pageIndex, int pageSize) {
		
		return zlBTradingRecodeDAO.queryZlBTradingRecodeList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 删除成交记录
	 * @param entity
	 * @return
	 */
	public int deleteZlBTradingRecode(ZlBTradingRecode entity)
	{
		return zlBTradingRecodeDAO.deleteZlBTradingRecode(entity);
	}
	
	/**
	 * 查询记录
	 * @param entity
	 * @return
	 */
	public ZlBTradingRecode getZlBTradingRecodeById(ZlBTradingRecode entity)
	{
		return zlBTradingRecodeDAO.getZlBTradingRecodeById(entity.getTradingid());
	}
	
	/**
	 * 修改成交记录
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBTradingRecode(ZlBTradingRecode entity)
	{
		return zlBTradingRecodeDAO.saveUpdateZlBTradingRecode(entity);
	}
	
	
}
