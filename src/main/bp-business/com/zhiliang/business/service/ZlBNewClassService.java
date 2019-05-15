package com.zhiliang.business.service;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.repast.core.system.Pagination;
import com.zhiliang.persistence.dao.ZlBNewsCategoryDAO;
import com.zhiliang.persistence.dao.ZlBNewsDAO;
import com.zhiliang.persistence.entity.ZlBNews;
import com.zhiliang.persistence.entity.ZlBNewsCategory;

@Service("ZlBNewClassService")
public class ZlBNewClassService {
	@Resource
	private ZlBNewsCategoryDAO zlBNewsCategoryDAO;
	@Resource
	private ZlBNewsDAO zlBNewsDAO;
	/**
	 * 查询新闻分类实体分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pagination<ZlBNewsCategory> queryZlBNewsCategoryPageList(ZlBNewsCategory entity, int pageIndex, int pageSize) {
		return zlBNewsCategoryDAO.queryZlBNewsCategoryList(entity, pageIndex, pageSize);
	}
	/**
	 * 保存新闻信息实体
	 * @param entity
	 * @return
	 */
	public int saveZlBNewsCategory(ZlBNewsCategory entity)
	{
		return zlBNewsCategoryDAO.saveZlBNewsCategory(entity);
	}
	
	/**
	 * 删除新闻信息实体
	 * @param entity
	 * @return
	 */
	public int deleteZlBNewsCategory(ZlBNewsCategory entity)
	{
		return zlBNewsCategoryDAO.deleteZlBNewsCategory(entity);
	}
	
	/**
	 * 根据实体对象ID查询实体
	 * @param entity
	 * @return
	 */
	public ZlBNewsCategory getZlBNewsCategoryById(ZlBNewsCategory entity)
	{
		return zlBNewsCategoryDAO.getZlBNewsCategoryById(entity.getCategoryid());
	}
	
	/**
	 * 修改实体对象
	 * @param entity
	 * @return
	 */
	public int updateZlBNewsCategory(ZlBNewsCategory entity)
	{
		return zlBNewsCategoryDAO.updateZlBNewsCategory(entity);
	}
	
	/**
	 * 保存修改后新闻信息
	 * @param entity
	 * @return
	 */
	public int saveUpdateZlBNewsCategory(ZlBNewsCategory entity)
	{
		ZlBNewsCategory entity_o=zlBNewsCategoryDAO.getZlBNewsCategoryById(entity.getCategoryid());
		if ("0".equals(entity_o.getParentid())) {
			zlBNewsCategoryDAO.updateZlBNewsCategoryPermissionsByParentid(entity.getCategoryid(), entity.getPermissions());
		}
		return zlBNewsCategoryDAO.saveUpdateZlBNewsCategory(entity);
	}
	
	/**
	 * 保存添加新闻信息
	 * @param entity
	 * @return
	 */
	public int saveAddZlBNewsCategory(ZlBNewsCategory entity)
	{	
		String id=entity.getCategoryid();//父级别id临时存储		
		String sname=entity.getSname();//新增分类名称临时存储
		String level=entity.getLevel();
		//当前深度下最大rootid
		String rootidnumMax="0";
		int rootidnum=1;
		//如果为顶级分类，rootid+1，parentid=0,ordernum=0,
		if("0".equals(level) || "".equals(level) || level==null || "null".equals(level) || StringUtils.isEmpty(level)){
			
			ZlBNewsCategory entityrootMax=zlBNewsCategoryDAO.getZlBNewsCategoryMaxrootidByRootidNull();	
			if(entityrootMax!=null && !StringUtils.isEmpty(entityrootMax.getRootid())){
				rootidnumMax=entityrootMax.getRootid();
			}
			    rootidnum=Integer.parseInt(rootidnumMax)+1;
//			    entity.setFvalue(zlBNewsCategoryDAO.getUUId());
//				entity.setFname(sname);
//				entity.setSvalue("0");
//				entity.setSname("0");
//				entity.setTvalue("0");
//				entity.setTname("0");
				entity.setLevel("1");
				entity.setRootid(String.valueOf(rootidnum));
//				entity.setOrdernum(String.valueOf(rootidnum));
				entity.setOrdernum("0");
				entity.setParentid("0");
				entity.setCategoryname(sname);
		}else{	
			//根据父级ID查实体信息
			
			ZlBNewsCategory entityP=zlBNewsCategoryDAO.getZlBNewsCategoryById(id);	
			//当前分类下，子分类最大ordernum
			//新增实体排序id	
			int ordernum=0;
			int ordernum1=0;
			ZlBNewsCategory entityorderMax=zlBNewsCategoryDAO.getZlBNewsCategoryMaxOrdernumByParentid(entityP.getCategoryid());	
			//
			
			int ordernumMax=Integer.parseInt(entityP.getOrdernum());	//新增前子分类ordernum最大值
			if(entityorderMax!=null && !StringUtils.isEmpty(entityorderMax.getOrdernum())){
				ZlBNewsCategory	entityorderMax3=zlBNewsCategoryDAO.getZlBNewsCategoryMaxOrdernumByParentid(entityorderMax.getCategoryid());	
				if(entityorderMax3!=null && !StringUtils.isEmpty(entityorderMax3.getOrdernum())){
					ordernumMax=Integer.parseInt(entityorderMax3.getOrdernum());//新增前子分类ordernum最大值
				}else{
					ordernumMax=Integer.parseInt(entityorderMax.getOrdernum());//新增前子分类ordernum最大值
				}
				ordernum=ordernumMax+1;
			
			}else{
				ordernum=ordernumMax+1;
			}
			//当前深度下最大ordernum,用来重新排序
			ZlBNewsCategory entityorderMax1=zlBNewsCategoryDAO.getZlBNewsCategoryMaxrootidByRootid(entityP.getRootid());
			String ordernumMax1="1";
			if(entityorderMax1!=null  && !StringUtils.isEmpty(entityorderMax1.getOrdernum())){
			 ordernumMax1=entityorderMax1.getOrdernum();
			 ordernum1=Integer.parseInt(ordernumMax1);//当前深度下最大ordernum	
			}
			//更新ordernum整体排序
			if(ordernum!=0 && ordernum1!=0 && ordernum<=ordernum1){}
				 for (int j = ordernum1; j >=ordernum; j--) {
					 String num11=String.valueOf(j);
					 String num22=String.valueOf(j+1);
					 zlBNewsCategoryDAO.updateZlBNewsCategoryOrdernumByrootid(entityP.getRootid(),num11,num22);
				 } 
				 
				if("1".equals(level)){
//						entity.setFvalue(entityP.getFvalue());
//						entity.setFname(entityP.getFname());
//						entity.setSvalue(zlGoodTypeDAO.getUUId());
//						entity.setSname(sname);
//						entity.setTvalue("0");
//						entity.setTname("0");
						entity.setLevel("2");
						entity.setRootid(entityP.getRootid());
						entity.setOrdernum(String.valueOf(ordernum));
						entity.setCategoryname(sname);
						entity.setPermissions(entityP.getPermissions());
					}else if("2".equals(level)){
//						entity.setFvalue(entityP.getFvalue());
//						entity.setFname(entityP.getFname());
//						entity.setSvalue(entityP.getSvalue());
//						entity.setSname(entityP.getSname());
//						entity.setTvalue(zlGoodTypeDAO.getUUId());
//						entity.setTname(sname);
						entity.setLevel("3");
						entity.setRootid(entityP.getRootid());
						entity.setOrdernum(String.valueOf(ordernum));
						entity.setCategoryname(sname);
						entity.setPermissions(entityP.getPermissions());
					}	
					 entity.setParentid(id);
		}
		
				String uid=zlBNewsCategoryDAO.getUUId();
						entity.setCategoryid(uid);	
						//保存关系
//				saveZlMallTlandgdandgdte(entity.getTerminalid(),entity.getId(),"0");
		
		return zlBNewsCategoryDAO.saveAddZlBNewsCategory(entity);
}
	
	/**
	 * 根据parentid获取下级分类
	 * @author Wy
	 * @param entity
	 * @return
	 */
	public List<ZlBNewsCategory> getZlBNewsCategoryListByParentid(ZlBNewsCategory entity){		
		return zlBNewsCategoryDAO.getZlBNewsCategoryListByParentid(entity.getParentid());
	}
	
	/**
	 * 根据parentid获取下级分类
	 * @author Wy
	 * @param entity
	 * @return
	 */
	public List<ZlBNewsCategory> getZlBNewsCategoryListByParentidAndUserid(ZlBNewsCategory entity,String userid){		
		return zlBNewsCategoryDAO.getZlBNewsCategoryListByParentidAndUserid(entity.getParentid(),userid);
	}
	/**
	 * 根据parentid获取下级分类
	 * @author Wy
	 * @param entity
	 * @return
	 */
	public List<ZlBNewsCategory> queryNewClassListByParentid(ZlBNewsCategory entity,int num){
		
		List<ZlBNewsCategory> list=zlBNewsCategoryDAO.queryNewClassListByParentid(entity.getParentid(),num);
		for (int i = 0; i < list.size(); i++) {
			String categoryidString=list.get(i).getCategoryid();
			//根据分类查询一条置顶新闻
			ZlBNews entityBNews=zlBNewsDAO.queryZlBNewsByParentidOrderByIstop(categoryidString);
			if (entityBNews!=null) {
				list.get(i).setZlbnews(entityBNews);	
			}
			//按序号、时间排序查询10条新闻
			List<ZlBNews> newlist=zlBNewsDAO.getZlBNewslistByParentid(list.get(i).getCategoryid(),10);
			if (newlist.size()>0) {
				list.get(i).setZlBNewslist(newlist);
			}
		}
		return list;
	}
	public List<ZlBNews> queryZlBNewsListByParentid(String parentid,int num){
		
		List<ZlBNews> newlist=zlBNewsDAO.queryZlBNewsListByParentid(parentid,num);
		return newlist;
	}
	
}
