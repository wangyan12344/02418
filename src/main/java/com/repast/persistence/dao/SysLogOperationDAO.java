package com.repast.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repast.core.system.BaseDao;
import com.repast.core.system.Pagination;
import com.repast.core.util.JDBCHelper;
import com.repast.persistence.entity.SysLogOperation;
import com.repast.persistence.entity.SysLogOperationDetail;

@Component("SysLogOperationDAO")
public class SysLogOperationDAO extends BaseDao{
	
	/**
	 * 保存系统业务日志
	 * @param sysLogOperation
	 * @param sysLogOperationDetailList
	 */
	public void saveSysLogOperation(SysLogOperation sysLogOperation,List<SysLogOperationDetail> sysLogOperationDetailList){
		this.saveNew(sysLogOperation);
		this.saveBatchObjects(sysLogOperationDetailList);
	}

	
	private final static String QueryTableSql = "SELECT T.* FROM SYS_LOGOPERATION T WHERE 1=1 ";
	
    private JDBCHelper makeSearch(SysLogOperation sysLogOperation, String sql)
    {
        JDBCHelper jdbcHelper = new JDBCHelper(sql);
        if(sysLogOperation!=null)
        {
        		jdbcHelper.putParam(JDBCHelper.AND, "T.BUSINESSNAME", JDBCHelper.EQ, sysLogOperation.getBusinessName());
        		jdbcHelper.putParam(JDBCHelper.AND, "T.OPERATIONTYPE", JDBCHelper.EQ, sysLogOperation.getOperationType());
        		
        		jdbcHelper.putOrder(sysLogOperation);
        		jdbcHelper.putOrder("T.OPERATIONTIME desc");
        }
        return jdbcHelper;
    }
	
	public Pagination<SysLogOperation> querySysLogOperationPageList(SysLogOperation sysLogOperation,int pageIndex,int pageSize) {
		JDBCHelper helper = makeSearch(sysLogOperation,QueryTableSql);
		return getPage(helper.getSql(), helper.getParam(), SysLogOperation.class, pageIndex, pageSize);
	}
	
	public List<SysLogOperation> queryBusinessNameList(){
		String sql = "SELECT T.businessName FROM SYS_LOGOPERATION T WHERE 1=1 GROUP BY T.businessName ";
		List<SysLogOperation> businessNameList = this.queryForList(sql, SysLogOperation.class);
		return businessNameList;
	}
	
	public void TruncateLog(){
		this.executeSQL("TRUNCATE TABLE SYS_LOGOPERATION");
		this.executeSQL("TRUNCATE TABLE SYS_LOGOPERATION_DETAIL");
	}
	
}
