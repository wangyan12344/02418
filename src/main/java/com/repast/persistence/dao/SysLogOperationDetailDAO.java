package com.repast.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.util.JDBCHelper;
import com.repast.persistence.entity.SysLogOperationDetail;

@Component("SysLogOperationDetailDAO")
public class SysLogOperationDetailDAO extends BaseDao{

	
	private final static String QueryTableSql = "SELECT T.* FROM SYS_LOGOPERATION_DETAIL T WHERE 1=1 ";
	
    private JDBCHelper makeSearch(SysLogOperationDetail sysLogOperationDetail, String sql)
    {
        JDBCHelper jdbcHelper = new JDBCHelper(sql);
        if(sysLogOperationDetail!=null)
        {
        		jdbcHelper.putParam(JDBCHelper.AND, "T.LOGID", JDBCHelper.EQ, sysLogOperationDetail.getLogid());
        		jdbcHelper.putParam(JDBCHelper.AND, "T.TABLENAME", JDBCHelper.EQ, sysLogOperationDetail.getTablename());
        		jdbcHelper.putOrder("T.LOGID desc");
        }
        return jdbcHelper;
    }
    
    public List<SysLogOperationDetail> getSysLogOperationTables(String logid){
    	String sql = "SELECT T.TABLENAME from SYS_LOGOPERATION_DETAIL T WHERE T.LOGID = ? GROUP BY T.TABLENAME";
    	Object[] param = new Object[]{logid};
    	return this.queryForList(sql,param, SysLogOperationDetail.class);
    }
	
	public List<SysLogOperationDetail> querySysLogOperationDetailList(SysLogOperationDetail sysLogOperationDetail) {
		JDBCHelper helper = makeSearch(sysLogOperationDetail,QueryTableSql);
		return this.queryForList(helper.getSql(), helper.getParam(), SysLogOperationDetail.class);
	}
	
	
	
}
