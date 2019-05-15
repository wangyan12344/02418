package com.zhiliang.persistence.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.StringUtils;
import com.repast.core.entity.EasemobUser;
import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.CommonUtil;
import com.repast.core.util.JDBCHelper;
import com.repast.persistence.entity.TraderPauUrl;
import com.zhiliang.persistence.dto.SysUserInfoDTO;
import com.zhiliang.persistence.entity.SysUserInfo;
/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author 齐建军
 */
@Component("SysUserInfoDAO")
public class SysUserInfoDAO extends BaseDao {

	@Resource(name="TraderPauUrl")
	private TraderPauUrl traderPauUrl;
	
	public final static String QueryTableSql = "SELECT T.* FROM sys_user_info T WHERE 1=1 ";
	
	private JDBCHelper makeSearch(SysUserInfo entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. userid", JDBCHelper.EQ, entiy.getUserid());
				jdbcHelper.putParam(JDBCHelper.AND,  JDBCHelper.LIKE, entiy.getUsername(),"T. username","T. account");
				jdbcHelper.putParam(JDBCHelper.AND, "T. account", JDBCHelper.EQ, entiy.getAccount());
				jdbcHelper.putParam(JDBCHelper.AND, "T. password", JDBCHelper.EQ, entiy.getPassword());
				jdbcHelper.putParam(JDBCHelper.AND, "T. headpicpath", JDBCHelper.EQ, entiy.getHeadpicpath());
				jdbcHelper.putParam(JDBCHelper.AND, "T. orgid", JDBCHelper.EQ, entiy.getOrgid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. shopid", JDBCHelper.EQ, entiy.getShopid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. contacttelnumber", JDBCHelper.EQ, entiy.getContacttelnumber());
				jdbcHelper.putParam(JDBCHelper.AND, "T. officetelnumber", JDBCHelper.EQ, entiy.getOfficetelnumber());
				jdbcHelper.putParam(JDBCHelper.AND, "T. email", JDBCHelper.EQ, entiy.getEmail());
				jdbcHelper.putParam(JDBCHelper.AND, "T. gender", JDBCHelper.EQ, entiy.getGender());
				jdbcHelper.putParam(JDBCHelper.AND, "T. birthday", JDBCHelper.EQ, entiy.getBirthday());
				jdbcHelper.putParam(JDBCHelper.AND, "T. entrytime", JDBCHelper.EQ, entiy.getEntrytime());
				jdbcHelper.putParam(JDBCHelper.AND, "T. officeaddress", JDBCHelper.EQ, entiy.getOfficeaddress());
				jdbcHelper.putOrder( " account asc,username asc " );
		}
		return jdbcHelper;
	}
	private JDBCHelper makeSearch_count(SysUserInfo entiy, String sql) {
		JDBCHelper jdbcHelper = new JDBCHelper(sql);
		if (entiy != null) {
				jdbcHelper.putParam(JDBCHelper.AND, "T. userid", JDBCHelper.EQ, entiy.getUserid());
				jdbcHelper.putParam(JDBCHelper.AND,  JDBCHelper.LIKE, entiy.getUsername(),"T. username","T. account");
				jdbcHelper.putParam(JDBCHelper.AND, "T. account", JDBCHelper.EQ, entiy.getAccount());
				jdbcHelper.putParam(JDBCHelper.AND, "T. password", JDBCHelper.EQ, entiy.getPassword());
				jdbcHelper.putParam(JDBCHelper.AND, "T. headpicpath", JDBCHelper.EQ, entiy.getHeadpicpath());
				jdbcHelper.putParam(JDBCHelper.AND, "T. orgid", JDBCHelper.EQ, entiy.getOrgid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. shopid", JDBCHelper.EQ, entiy.getShopid());
				jdbcHelper.putParam(JDBCHelper.AND, "T. contacttelnumber", JDBCHelper.EQ, entiy.getContacttelnumber());
				jdbcHelper.putParam(JDBCHelper.AND, "T. officetelnumber", JDBCHelper.EQ, entiy.getOfficetelnumber());
				jdbcHelper.putParam(JDBCHelper.AND, "T. email", JDBCHelper.EQ, entiy.getEmail());
				jdbcHelper.putParam(JDBCHelper.AND, "T. gender", JDBCHelper.EQ, entiy.getGender());
				jdbcHelper.putParam(JDBCHelper.AND, "T. birthday", JDBCHelper.EQ, entiy.getBirthday());
				jdbcHelper.putParam(JDBCHelper.AND, "T. entrytime", JDBCHelper.EQ, entiy.getEntrytime());
				jdbcHelper.putParam(JDBCHelper.AND, "T. officeaddress", JDBCHelper.EQ, entiy.getOfficeaddress());
				jdbcHelper.putOrder( " newscount DESC " );
		}
		return jdbcHelper;
	}
	/**
	 * 分页查询entity List
	 * @author 齐建军
	 */
	public Pagination<SysUserInfo> querySysUserInfoList(SysUserInfo entity, int pageIndex, int pageSize) {
		JDBCHelper helper = makeSearch(entity, QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysUserInfo.class, pageIndex, pageSize);
	}
	/**
	 * 分页查询entity List
	 * @author 齐建军
	 */
	public Pagination<SysUserInfo> querySysUserInfoListForCount(SysUserInfo entity, int pageIndex, int pageSize) {
		String sql="SELECT (SELECT COUNT(*) from zl_b_news WHERE adduserid=T.userid ) as newscount,T.* FROM sys_user_info T WHERE 1=1 ";
		JDBCHelper helper = makeSearch_count(entity, sql);
		return getPage(helper.getSql(), helper.getParam(), SysUserInfo.class, pageIndex, pageSize);
	}
	/**
	 * 保存实体对象entity
	 * @author 齐建军
	 */
	public int saveSysUserInfo(SysUserInfo entity) {
   			 if(entity.getUserid()==null)
   			 {
				entity.setUserid(this.getUUId());
				String headpicpath = entity.getHeadpicpath();
				if(headpicpath==null||"".equals(headpicpath.trim()))
				{
					String defaultPic = traderPauUrl.getUrl()+"defaultpic/user.png";
					entity.setHeadpicpath(defaultPic);
				}
   			 }
		
		int flag =  this.saveNew(entity);
		return flag;
	}

	/**
	 * 修改实体对象entity
	 * @author 齐建军
	 */
	public int updateSysUserInfo(SysUserInfo entity) {
		if(entity!=null)
		{
			String headpicpath = entity.getHeadpicpath();
			if(headpicpath==null||"".equals(headpicpath.trim()))
			{
				String defaultPic = traderPauUrl.getUrl()+"defaultpic/user.png";
				entity.setHeadpicpath(defaultPic);
			}
		}
		int flag =  this.saveUpdate(entity);
		return flag;
	}
	
	/**
	 * 修改商城用户实体信息
	 * @author 马骞
	 */
	public int updateShopUserData(SysUserInfo entity) {
		
		int flag =  this.saveUpdate(entity);
		return flag;
	}
	
	

	/**
	 * 删除实体对象entity
	 * @author 齐建军
	 */
	public int deleteSysUserInfo(SysUserInfo entity) {
		return this.saveRemove(entity);
	}

	/**
	 * 根据实体对象Id返回entity
	 * @author 齐建军
	 */
	public SysUserInfo getSysUserInfoById(String id) {
		return this.getEntityById(id, SysUserInfo.class);
	}
	/**
	 * 根据实体对象Id查询商城用户
	 * @author 马骞
	 */
	public SysUserInfo getSysUserInfoDataById(String id) {
		String sql="SELECT T.* FROM sys_user_info T WHERE T.shopid is not NULL and T.userid=?";
		
		return this.queryObject(sql, new Object[]{id},SysUserInfo.class);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月9日 下午1:40:26
	 * @param sysUserInfo
	 * @return
	 */
	public SysUserInfo querySysUserInfo(String account,String password){
		String sql = " select * from sys_user_info t where t.account = ? and t.`password` = ? ";
		return this.queryObject(sql, new Object[]{account,password}, SysUserInfo.class);
	}
	/**
	 * 根据组织机构信息获取用户列表
	 * @author qijianjun
	 * @param orgid
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<SysUserInfoDTO>  getSysUserInfoDTOListByOrgId(String  orgid,int pageIndex,int pageSize)
	{
		String sql = " select * from sys_user_info t where t.orgid = ? order by t.username asc";
		return this.getPage(sql, new Object[]{orgid}, SysUserInfoDTO.class, pageIndex, pageSize);
	}
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月9日 下午1:40:26
	 * @param sysUserInfo
	 * @return
	 */
	public SysUserInfoDTO getSysUserInfoDTO(String account,String password){
		String sql = " select * from sys_user_info t where t.account = ? and t.`password` = ? ";
		return this.queryObject(sql, new Object[]{account,password}, SysUserInfoDTO.class);
	}
	/**
	 * 根据账号获取用户信息
	 * @author qijianjun
	 * @param account
	 * @return
	 */
	public SysUserInfo getSysUserInfoByAccount(String account)
	{
		String sql = " select * from sys_user_info t where t.account = ?  ";
		return this.queryObject(sql, new Object[]{account}, SysUserInfo.class);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月25日 下午2:47:45
	 * @param userid
	 * @param account
	 * @return
	 */
	public int checkAccountUnique(String userid,String account){
		String sql = " select count(1) from sys_user_info t where t.account = ? ";
		if(!StringUtils.isNullOrEmpty(userid)){
			sql = sql + " and t.userid <> '"+userid+"' ";
		}
		return this.queryForInt(sql, new Object[]{account});
	}
	
	/**
	 * 校验用户密码是否正确
	 * @author lingy
	 * @date 2015年10月12日 上午11:34:06
	 * @param userid
	 * @param originalPassword
	 * @return
	 */
	public int existUserInfoByUseridAndPassword(String userid,String originalPassword){
		String sql = " select count(1) from sys_user_info t where t.userid = ? and t.`password` = ? ";
		return this.queryForInt(sql, new Object[]{userid,originalPassword});
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年10月13日 下午2:07:42
	 * @param orgid
	 * @return
	 */
	public List<EasemobUser> getEasemobContactPerson(String orgid){
		String sql = " select t.userid as easemobusername,t.username as csusername,t.headpicpath as headimage from sys_user_info t where t.orgid = ? ";
		return this.queryForList(sql, new Object[]{orgid}, EasemobUser.class);
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年10月14日 上午9:19:14
	 * @param shopid
	 * @return
	 */
	public List<SysUserInfoDTO> getShopMemberinfoList(String shopid){
		String sql = " select t.*,m.isadmin,m.ismember from sys_user_info t,(select s.userid,s.isadmin,s.ismember from sys_user_shop s where s.shopid = ? and (s.isadmin = '1' or s.ismember = '1')) m where t.userid = m.userid ";
		return this.queryForList(sql, new Object[]{shopid}, SysUserInfoDTO.class);
	}
	public int updateEntityDataPassword(SysUserInfo sysUserInfo){
	String sql="update sys_user_info set password='"+sysUserInfo.getPassword()+"' where userid='"+sysUserInfo.getUserid()+"'";
		
		return this.executeSQL(sql);
	}
}