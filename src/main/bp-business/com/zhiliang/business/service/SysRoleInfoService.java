package com.zhiliang.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.repast.core.codelist.SysCodelist;
import com.repast.core.codelist.SysCodelistDAO;
import com.repast.core.system.Pagination;
import com.zhiliang.persistence.dao.SysMenuInfoDAO;
import com.zhiliang.persistence.dao.SysRoleInfoDAO;
import com.zhiliang.persistence.dao.SysRoleMenuDAO;
import com.zhiliang.persistence.dto.MenuTreeDTO;
import com.zhiliang.persistence.entity.SysRoleInfo;
import com.zhiliang.persistence.entity.SysRoleMenu;


/**
 * 
 * @author lingy
 * SysRoleInfoService.java
 */
@Service("SysRoleInfoService")
public class SysRoleInfoService {
	
	@Resource
	private SysCodelistDAO sysCodelistDAO;
	
	@Resource
	private SysRoleInfoDAO sysRoleInfoDAO;
	
	@Resource
	private SysMenuInfoDAO sysMenuInfoDAO;
	
	@Resource
	private SysRoleMenuDAO sysRoleMenuDAO;
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月10日 下午2:50:20
	 * @param sysUserInfo
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<SysRoleInfo> querySysRoleInfoList(SysRoleInfo sysRoleInfo,int pageIndex,int pageSize){
		return sysRoleInfoDAO.querySysRoleInfoList(sysRoleInfo, pageIndex, pageSize);
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
	 * @date 2015年9月15日 上午8:44:49
	 * @param userid
	 * @return
	 */
	public List<MenuTreeDTO> getMenuTreeListByUserid(String userid){
		List<MenuTreeDTO> menuTreeList = sysMenuInfoDAO.getMenuTreeListByUserid(userid);
		for (MenuTreeDTO menuTreeDTO : menuTreeList) {
			String checked = menuTreeDTO.getChecked();
			String pId = menuTreeDTO.getpId();
			if(StringUtils.isNullOrEmpty(checked)){
				menuTreeDTO.setChecked("false");
			}else{
				menuTreeDTO.setChecked("true");
			}
			if("-1".equals(pId)){
				menuTreeDTO.setOpen("true");
			}
		}
		return menuTreeList;
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午8:44:49
	 * @param userid
	 * @return
	 */
	public List<MenuTreeDTO> getClassMenuTreeListByUserid(String userid){
		List<MenuTreeDTO> menuTreeList = sysMenuInfoDAO.getClassMenuTreeListByUserid(userid);
		for (MenuTreeDTO menuTreeDTO : menuTreeList) {
			String checked = menuTreeDTO.getChecked();
			String pId = menuTreeDTO.getpId();
			if(StringUtils.isNullOrEmpty(checked)){
				menuTreeDTO.setChecked("false");
			}else{
				menuTreeDTO.setChecked("true");
			}
			if("-1".equals(pId)){
				menuTreeDTO.setOpen("true");
			}
		}
		return menuTreeList;
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午9:33:57
	 * @param sysRoleInfo
	 * @param roleMenuList
	 * @return
	 */
	public int saveSysUserRoleAndRoleMenu(SysRoleInfo sysRoleInfo,List<SysRoleMenu> roleMenuList){
		String roleid = sysRoleInfoDAO.getUUId();
		sysRoleInfo.setRoleid(roleid);
		for (SysRoleMenu sysRoleMenu : roleMenuList) {
			sysRoleMenu.setId(sysRoleMenuDAO.getUUId());
			sysRoleMenu.setRoleid(roleid);
		}
		sysRoleMenuDAO.saveBatchObjects(roleMenuList);
		return sysRoleInfoDAO.saveSysRoleInfo(sysRoleInfo);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午9:47:30
	 * @param sysRoleInfo
	 * @param roleMenuList
	 * @return
	 */
	public int updateSysUserRoleAndRoleMenu(SysRoleInfo sysRoleInfo,List<SysRoleMenu> roleMenuList){
		String roleid = sysRoleInfo.getRoleid();
		sysRoleMenuDAO.batchDeleteRoleMenuByRoleid(roleid);
		for (SysRoleMenu sysRoleMenu : roleMenuList) {
			sysRoleMenu.setId(sysRoleMenuDAO.getUUId());
			sysRoleMenu.setRoleid(roleid);
		}
		sysRoleMenuDAO.saveBatchObjects(roleMenuList);
		return sysRoleInfoDAO.updateSysRoleInfo(sysRoleInfo);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午9:45:49
	 * @param sysRoleInfo
	 * @return
	 */
	public int deleteSysRoleInfo(SysRoleInfo sysRoleInfo){
		String roleid = sysRoleInfo.getRoleid();
		sysRoleMenuDAO.batchDeleteRoleMenuByRoleid(roleid);
		return sysRoleInfoDAO.deleteSysRoleInfo(sysRoleInfo);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月15日 上午9:46:10
	 * @param roleid
	 * @return
	 */
	public SysRoleInfo getSysRoleInfoByRoleid(String roleid){
		return sysRoleInfoDAO.getSysRoleInfoById(roleid);
	}
	/**
	 * 
	 * @author wy
	 * @param userid
	 * @return
	 */
	public List<MenuTreeDTO> getNewsClassTree(String userid){
		List<MenuTreeDTO> menuTreeList = sysMenuInfoDAO.getNewsClassTree(userid);
		for (MenuTreeDTO menuTreeDTO : menuTreeList) {
			String checked = menuTreeDTO.getChecked();
			String pId = menuTreeDTO.getpId();
			if(StringUtils.isNullOrEmpty(checked)){
				menuTreeDTO.setChecked("false");
			}else{
				menuTreeDTO.setChecked("true");
			}
			if("-1".equals(pId)){
				menuTreeDTO.setOpen("true");
			}
		}
		return menuTreeList;
	}
}
