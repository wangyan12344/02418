package com.repast.persistence.dao;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.repast.persistence.entity.SysUser;
/**
 * 
 * Application name:  
 * Application describing:实体类
 * Copyright:Copyright copy;   
 * Company:  
 * @author 栾冬
 */
@Component("SysUserDAO")
public class SysUserDAO extends BaseDao
{

	public final static String QueryTableSql = "SELECT T.* FROM SYS_USER T WHERE 1=1 ";
	public final static String DELETE_SYS_USER_BYID = "DELETE FROM SYS_USER where 1=1 AND ID=?";
	
    private JDBCHelper makeSearch(SysUser sysUser, String sql)
    {
        JDBCHelper jdbcHelper = new JDBCHelper(sql);
        if(sysUser!=null)
        {
        		jdbcHelper.putParam(JDBCHelper.AND, "T.USERNAME", JDBCHelper.LIKE, sysUser.getUsername());
        		jdbcHelper.putParam(JDBCHelper.AND, "T.USERTYPE", JDBCHelper.EQ, sysUser.getUsertype());
        		jdbcHelper.putOrder(sysUser);
        		jdbcHelper.putOrder("T.username desc");
        }
        return jdbcHelper;
    }
	
	public Pagination<SysUser> queryUserPageList(SysUser sysUser,int pageIndex,int pageSize) {
		JDBCHelper helper = makeSearch(sysUser,QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysUser.class, pageIndex, pageSize);
	}
	
	
	/**
     * 
     * 保存实体对象entity
     * @author 
     */
    public int saveSysUser(SysUser entity)
    {
        return this.saveNew(entity);
    }
    /**
     * 
     * 修改实体对象entity
     * @author 
     */
    public int updateSysUser(SysUser entity)
    {
        return this.saveUpdate(entity);
    }
    /**
     * 
     * 删除实体对象entity
     * @author 
     */    
    public int deleteSysUser(SysUser entity)
    {
        return this.saveRemove(entity);
    }
    /**
     * 
     * 根据实体对象Id返回entity
     * @author 
     */    
    public SysUser getSysUserById(String id)
    {
        return this.getEntityById(id, SysUser.class);
    }
    
    
    /**
     * 
     *删除用户
     * @author 
     */ 
    public int deleteSysUser(String id){
    	
    	return super.executeSQL(DELETE_SYS_USER_BYID, new Object[]{id});
    }
    
    /**
     * 
     *根据用户名密码查询用户信息
     * @author 
     */ 
    public SysUser queryUserinfo(SysUser entity){
    	String sql=QueryTableSql+" AND account=? AND password=? AND ENABLED='1'";
    	return super.queryObject(sql, new Object[]{entity.getAccount(),entity.getPassword()}, SysUser.class);
    }

    /**
	 * 校验电话号是否重复
	 * */
    public SysUser checkPhoneNumber(String phoneNumber){
    	
    	String sql=QueryTableSql+" and phone=?";
    	return super.queryObject(sql,new Object[]{phoneNumber}, SysUser.class);
    }
    
    /**
	 * 校验用户名是否重复
	 * */
    public SysUser checkUserName(String userName){
    	
    	String sql=QueryTableSql+" and username=?";;
    	return super.queryObject(sql,new Object[]{userName}, SysUser.class);
    }
}
