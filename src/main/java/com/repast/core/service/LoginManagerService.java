package com.repast.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.log.businesslog.Log;
import com.repast.core.log.businesslog.LogConstant;
import com.repast.core.system.Processor;
import com.zhiliang.persistence.dao.SysUserInfoDAO;
import com.zhiliang.persistence.entity.SysUserInfo;

@Service
public class LoginManagerService {
	
	@Resource
	private SysUserInfoDAO sysUserInfoDAO;
	
	/**
	 * 根据用户ID查询用户信息
	 * @author lingy
	 * @date 2015年9月9日 下午1:18:57
	 * @param id
	 * @return
	 */
	public SysUserInfo getSysUserInfoById(String id){
		return sysUserInfoDAO.getSysUserInfoById(id);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月9日 下午1:52:58
	 * @param sysUserInfo
	 * @param processor
	 * @return
	 */
	public SysUserInfo querySysUserInfo(SysUserInfo sysUserInfo, Processor processor){
		String account = sysUserInfo.getAccount();
		String password = sysUserInfo.getPassword();
		SysUserInfo userinfo = sysUserInfoDAO.querySysUserInfo(account,password);
		if(userinfo!=null){
			processor.setCurrentUserId(userinfo.getUserid());
			processor.setOrgid(userinfo.getOrgid());
			Log log = new Log(LogConstant.LoginModel,LogConstant.OP_QUERY,"用户"+sysUserInfo.getAccount()+"验证通过，合法登录！",processor);
			log.putOldAndNewObj(null, sysUserInfo);
			log.saveLog();
		}
		return userinfo;
	}
	

}
