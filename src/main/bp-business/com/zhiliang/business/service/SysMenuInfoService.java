package com.zhiliang.business.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiliang.persistence.dao.SysMenuInfoDAO;

/**
 * 系统菜单service
 * @author qijianjun
 *
 */
@Service("SysMenuInfoService")
public class SysMenuInfoService {
	@Resource
	private SysMenuInfoDAO sysMenuInfoDAO;
	
	/**
	 * 根据用户id获取用户在app端的可见菜单信息
	 * @param userId
	 * @return
	 */
//	public List<AppMenuInfoDTO> getSysMenuInfoListOfAppByUserId(String userId){
//		return sysMenuInfoDAO.getSysMenuInfoListOfAppByUserId(userId);
//	}

}
