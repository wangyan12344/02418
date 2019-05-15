package com.zhiliang.business.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.repast.core.codelist.SysCodelist;
import com.repast.core.codelist.SysCodelistDAO;
import com.repast.core.entity.EasemobUser;
import com.repast.core.system.Pagination;
import com.repast.core.system.Processor;
import com.zhiliang.persistence.dao.SysRoleInfoDAO;
import com.zhiliang.persistence.dao.SysRoleUserDAO;
import com.zhiliang.persistence.dao.SysUserInfoDAO;
import com.zhiliang.persistence.dao.SysUserShopDAO;
import com.zhiliang.persistence.dto.SysUserInfoDTO;
import com.zhiliang.persistence.entity.SysRoleInfo;
import com.zhiliang.persistence.entity.SysRoleMenu;
import com.zhiliang.persistence.entity.SysRoleUser;
import com.zhiliang.persistence.entity.SysUserInfo;
import com.zhiliang.persistence.entity.SysUserShop;
import com.zhiliang.persistence.entity.SysUseridCategoryid;


/**
 * 
 * @author lingy
 * SysUserInfoService.java
 */
@Service("SysUserInfoService")
public class SysUserInfoService {
	
	@Resource
	private SysUserInfoDAO sysUserInfoDAO;
	
	@Resource
	private SysCodelistDAO sysCodelistDAO;
	
//	@Resource
//	private CsShopInfoDAO csShopInfoDAO;
	
	@Resource
	private SysRoleInfoDAO sysRoleInfoDAO;
	
	@Resource
	private SysRoleUserDAO sysRoleUserDAO;
	
	@Resource
	private SysUserShopDAO sysUserShopDAO;
//	@Resource
//	private CsOrganizationInfoDAO csOrganizationInfoDAO;
	
	/**
	 * 根据账号获取用户信息
	 * @author qijianjun
	 * @param account
	 * @return
	 */
	public SysUserInfo getSysUserInfoByAccount(String account)
	{
		return sysUserInfoDAO.getSysUserInfoByAccount(account);
	}
	/**
	 * 根据组织机构id获取用户信息列表
	 * @author qijianjun
	 * @param account
	 * @param password
	 * @return
	 */
	public Pagination<SysUserInfoDTO> getSysUserInfoDTOListByOrgId( Processor processor)
	{
		Pagination<SysUserInfoDTO> list = sysUserInfoDAO.getSysUserInfoDTOListByOrgId(processor.getOrgid(), processor.getPageIndex(),processor.getPageSize());
		if(list.getRecords()!=null)
		{
			for(int i=0;i<list.getRecords().size();i++)
			{
				SysUserInfoDTO dto = list.getRecords().get(i);
				//String orgid = dto.getOrgid();
				//CsOrganizationInfo orginfo = csOrganizationInfoDAO.getCsOrganizationInfoById(orgid);
				//if(orginfo!=null)
				//{
					//dto.setOrgname(orginfo.getOrgname());
				//}
				String userid=dto.getUserid();
				List<SysRoleInfo> rolelist = sysRoleInfoDAO.getSysRoleInfoByUserid(userid);
				String rolenamestr="";
				if(rolelist!=null&&rolelist.size()>0)
				{
					for(int j=0;j<rolelist.size();j++)
					{
						rolenamestr = rolelist.get(j).getRolename()+"  ";
					}
				}
				dto.setRolenamestr(rolenamestr);
			}
		}
		return list;
	}
	/**
	 * 根据账号密码获取用户信息
	 * @author qijianjun
	 * @param account
	 * @param password
	 * @return
	 */
	public SysUserInfoDTO getSysUserInfoDTOByAccountAndPassword(String account,String password)
	{
		SysUserInfoDTO dto = sysUserInfoDAO.getSysUserInfoDTO(account, password);
		if(dto!=null)
		{
			String orgid = dto.getOrgid();
//			CsOrganizationInfo orginfo = csOrganizationInfoDAO.getCsOrganizationInfoById(orgid);
//			if(orginfo!=null)
//			{
//				dto.setOrgname(orginfo.getOrgname());
//			}
			String userid=dto.getUserid();
			List<SysRoleInfo> rolelist = sysRoleInfoDAO.getSysRoleInfoByUserid(userid);
			String rolenamestr="";
			if(rolelist!=null&&rolelist.size()>0)
			{
				for(int j=0;j<rolelist.size();j++)
				{
					rolenamestr = rolelist.get(j).getRolename()+"  ";
				}
			}
			dto.setRolenamestr(rolenamestr);
		}
		return dto;
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月10日 下午2:50:20
	 * @param sysUserInfo
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<SysUserInfo> querySysUserInfoListForCount(SysUserInfo sysUserInfo,int pageIndex,int pageSize){
		return sysUserInfoDAO.querySysUserInfoListForCount(sysUserInfo, pageIndex, pageSize);
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月10日 下午2:50:20
	 * @param sysUserInfo
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<SysUserInfo> querySysUserInfoList(SysUserInfo sysUserInfo,int pageIndex,int pageSize){
		return sysUserInfoDAO.querySysUserInfoList(sysUserInfo, pageIndex, pageSize);
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月10日 下午4:00:43
	 * @param sysCodelist
	 * @return
	 */
	public List<SysCodelist> getCodeList(SysCodelist sysCodelist){
		String kind = sysCodelist.getKindcode();
		return sysCodelistDAO.getCodeList(kind);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月10日 下午4:02:27
	 * @param orgid
	 * @return
	 */
//	public List<CsShopInfo> getCsShopInfoListByOrgid(String orgid){
//		return csShopInfoDAO.getCsShopInfoListByOrgid(orgid);
//	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月10日 下午4:19:54
	 * @param orgid
	 * @return
	 */
	public List<SysRoleInfo> getSysUserRoleListByOrgid(String orgid,String userid){
		return sysRoleInfoDAO.getSysUserRoleListByOrgid(orgid, userid);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月11日 下午12:02:19
	 * @param sysUserInfo
	 * @param roleUserList
	 * @return
	 */
	public int saveSysUserInfoAndUserRole(SysUserInfo sysUserInfo,List<SysRoleUser> roleUserList,List<SysUserShop> userShopList,List<SysUseridCategoryid> roleMenuList){
		String userid = sysUserInfoDAO.getUUId();
		sysUserInfo.setUserid(userid);
		String orgid = sysUserInfo.getOrgid();
		
		//处理用户角色信息
		for (SysRoleUser sysRoleUser : roleUserList) {
			sysRoleUser.setId(sysRoleUserDAO.getUUId());
			sysRoleUser.setUserid(userid);
			sysRoleUser.setOptime(new Date());
		}
		
		sysRoleUserDAO.saveBatchObjects(roleUserList);
		
		for (SysUseridCategoryid sysUseridCategoryid : roleMenuList) {
			sysUseridCategoryid.setId(sysRoleUserDAO.getUUId());
			sysUseridCategoryid.setUserid(userid);
		}
		sysRoleUserDAO.saveBatchObjects(roleMenuList);
	/*	//处理用户可管理店铺信息
		for (SysUserShop sysUserShop : userShopList) {
			sysUserShop.setId(sysUserShopDAO.getUUId());
			sysUserShop.setUserid(userid);
			sysUserShop.setOrgid(orgid);
		}
		sysUserShopDAO.saveBatchObjects(userShopList);*/
		
		//保存用户基本信息
		sysUserInfo.setBirthday(sysUserInfo.getEntrytime());
		
		int flag = sysUserInfoDAO.saveSysUserInfo(sysUserInfo);
		return flag;
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月11日 下午1:37:36
	 * @param sysUserInfo
	 * @return
	 */
	public SysUserInfo getSysUserInfoById(SysUserInfo sysUserInfo){
		String id = sysUserInfo.getUserid();
		return sysUserInfoDAO.getSysUserInfoById(id);
	}
	
	/**
	 * 商城用户修改密码查询
	 * @param sysUserInfo
	 * @return
	 * @author 马骞
	 */
	public SysUserInfo getSysUserInfoDataById(SysUserInfo sysUserInfo,Processor processor){
		String id = processor.getCurrentUserId();
		return sysUserInfoDAO.getSysUserInfoDataById(id);
	}
	
	/**
	 * 删除用户信息及用户角色信息
	 * @author lingy
	 * @date 2015年9月11日 下午2:02:25
	 * @param entity
	 * @return
	 */
	public int deleteSysUserInfo(SysUserInfo entity){
		String userid = entity.getUserid();
//		sysUserShopDAO.batchDeleteByUserid(userid);
		sysRoleUserDAO.batchDeleteByUserid(userid);
		return sysUserInfoDAO.deleteSysUserInfo(entity);
	}
	
	/**
	 * 停用用户信息
	 * @author lingy
	 * @date 2015年9月11日 下午2:06:53
	 * @param entity
	 * @return
	 */
	public int stopSysUserInfo(SysUserInfo entity){
		String userid = entity.getUserid();
		SysUserInfo sysUserInfo = sysUserInfoDAO.getSysUserInfoById(userid);
		sysUserInfo.setUserstatus("0");
		return sysUserInfoDAO.updateSysUserInfo(sysUserInfo);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月11日 下午2:36:09
	 * @param sysUserInfo
	 * @param roleUserList
	 * @return
	 */
	public int updateSysUserInfo(SysUserInfo sysUserInfo,List<SysRoleUser> roleUserList,List<SysUserShop> userShopList ,List<SysUseridCategoryid> roleMenuList){
		String userid = sysUserInfo.getUserid();
		String orgid = sysUserInfo.getOrgid();
		//处理用户角色信息
		sysRoleUserDAO.batchDeleteByUserid(userid);
		for (SysRoleUser sysRoleUser : roleUserList) {
			sysRoleUser.setId(sysRoleUserDAO.getUUId());
			sysRoleUser.setUserid(userid);
			sysRoleUser.setOptime(new Date());
		}
		sysRoleUserDAO.saveBatchObjects(roleUserList);
		
		
		sysRoleUserDAO.batchDeleteRoleMenuByUserid(userid);
		
		for (SysUseridCategoryid sysUseridCategoryid : roleMenuList) {
			sysUseridCategoryid.setId(sysRoleUserDAO.getUUId());
			sysUseridCategoryid.setUserid(userid);
		}
		sysRoleUserDAO.saveBatchObjects(roleMenuList);
		
	/*	//处理用户可管理店铺信息
		sysUserShopDAO.batchDeleteByUserid(userid);
		for (SysUserShop sysUserShop : userShopList) {
			sysUserShop.setId(sysUserShopDAO.getUUId());
			sysUserShop.setUserid(userid);
			sysUserShop.setOrgid(orgid);
		}
		sysUserShopDAO.saveBatchObjects(userShopList);*/
		sysUserInfo.setBirthday(sysUserInfo.getEntrytime());
		return sysUserInfoDAO.updateSysUserInfo(sysUserInfo);
	}
	
	/**
	 * 商城用户修改密码
	 * @param sysUserInfo
	 * @param roleUserList
	 * @param userShopList
	 * @return
	 * @author 马骞
	 */
	public int updateShopUserData(SysUserInfo sysUserInfo){
		
		
		return sysUserInfoDAO.updateShopUserData(sysUserInfo);
	}
	
	public int updateEntityDataPassword(SysUserInfo sysUserInfo){
		
		
		return sysUserInfoDAO.updateEntityDataPassword(sysUserInfo);
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月14日 下午2:38:41
	 * @param orgid
	 * @param userid
	 * @return
	 */
	public List<SysUserShop> getSysUserShopListByUserid(String orgid,String userid){
		return sysUserShopDAO.getSysUserShopListByUserid(orgid,userid);
	}
	
	
	/**
	 * 校验账号唯一性
	 * @author lingy
	 * @date 2015年10月12日 上午11:49:12
	 * @param sysUserInfo
	 * @return
	 */
	public int checkAccountUnique(SysUserInfo sysUserInfo){
		String userid = sysUserInfo.getUserid();
		String account = sysUserInfo.getAccount();
		return sysUserInfoDAO.checkAccountUnique(userid,account);
	}
	
	/**
	 * 修改用户密码
	 * @author lingy
	 * @date 2015年10月12日 上午11:49:00
	 * @param userid
	 * @param originalPassword
	 * @param newPassword
	 * @return
	 */
	public int updatePassword(String userid,String originalPassword,String newPassword){
		int flag = 0;
		flag = sysUserInfoDAO.existUserInfoByUseridAndPassword(userid,originalPassword);
		if(flag > 0){
			SysUserInfo entity = sysUserInfoDAO.getSysUserInfoById(userid);
			entity.setPassword(newPassword);
			sysUserInfoDAO.updateSysUserInfo(entity);
		}
		return flag;
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年10月12日 上午11:50:11
	 * @param sysUserInfo
	 * @return
	 */
	public int appUpdateSysUserInfo(SysUserInfo sysUserInfo){
		String userid = sysUserInfo.getUserid();
		SysUserInfo entity = sysUserInfoDAO.getSysUserInfoById(userid);
		if(sysUserInfo!=null){
			String contacttelnumber = sysUserInfo.getContacttelnumber();
			String officetelnumber = sysUserInfo.getOfficetelnumber();
			String email = sysUserInfo.getEmail();
			String gender = sysUserInfo.getGender();
			Date birthday = sysUserInfo.getBirthday();
			Date entrytime = sysUserInfo.getEntrytime();
			String headpicpath = sysUserInfo.getHeadpicpath();
			if(!StringUtils.isNullOrEmpty(contacttelnumber)){
				entity.setContacttelnumber(contacttelnumber);
			}
			if(!StringUtils.isNullOrEmpty(officetelnumber)){
				entity.setOfficetelnumber(officetelnumber);
			}
			if(!StringUtils.isNullOrEmpty(email)){
				entity.setEmail(email);
			}
			if(!StringUtils.isNullOrEmpty(gender)){
				entity.setGender(gender);
			}
			if(birthday!=null){
				entity.setBirthday(birthday);
			}
			if(entrytime!=null){
				entity.setEntrytime(entrytime);
			}
			if(!StringUtils.isNullOrEmpty(headpicpath)){
				entity.setHeadpicpath(headpicpath);
			}
		}
		return sysUserInfoDAO.updateSysUserInfo(entity);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年10月13日 上午9:57:12
	 * @param userid
	 * @return
	 */
	public SysUserInfoDTO getSysUserInfoDTOByUserId(String userid){
		SysUserInfo userinfo = sysUserInfoDAO.getSysUserInfoById(userid);
		if(userinfo!=null){
			return getSysUserInfoDTOByAccountAndPassword(userinfo.getAccount(),userinfo.getPassword());
		}else{
			return null;
		}
	}
	
	/**
	 * 获得当前机构下的所有人员信息作为环信联系人
	 * @author lingy
	 * @date 2015年10月13日 下午1:58:59
	 * @param orgid
	 * @return
	 */
	public List<EasemobUser> getEasemobContactPerson(String orgid){
		return sysUserInfoDAO.getEasemobContactPerson(orgid);
	}
	
	
}
