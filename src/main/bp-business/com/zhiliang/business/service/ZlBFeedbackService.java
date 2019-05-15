package com.zhiliang.business.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.zhiliang.persistence.dao.ZlBFeedbackDAO;
import com.zhiliang.persistence.entity.ZlBFeedBack;
import com.repast.core.system.Pagination;

/**
 * 意见反馈
 * Application name: Application describing:意见反馈服务层 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * ZlBFeedback 的Service
 * @author superma
 */
@Service("ZlBFeedbackService")
public class ZlBFeedbackService {
	
	@Resource
	private ZlBFeedbackDAO zlBFeedbackDAO;
	

	/**
	 * 查询意见反馈实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBFeedBack> queryZlBFeedbackPageList(ZlBFeedBack entity, int pageIndex, int pageSize) {
		return zlBFeedbackDAO.queryZlBFeedbackPageList(entity, pageIndex, pageSize);
	}
	
	/**
	 * 删除意见反馈实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBFeedback(ZlBFeedBack entity)
	{
		return zlBFeedbackDAO.deleteZlBFeedback(entity);
	}
	
	
	
}
