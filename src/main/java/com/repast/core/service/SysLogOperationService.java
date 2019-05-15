package com.repast.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.repast.core.system.Pagination;
import com.repast.persistence.dao.SysLogOperationDAO;
import com.repast.persistence.dao.SysLogOperationDetailDAO;
import com.repast.persistence.entity.SysLogOperation;
import com.repast.persistence.entity.SysLogOperationDetail;


@Service("SysLogOperationService")
public class SysLogOperationService {
	
	@Resource
	private SysLogOperationDAO sysLogOperationDAO;
	
	@Resource
	private SysLogOperationDetailDAO sysLogOperationDetailDAO;
	
	
	public void saveSysLogOperation(SysLogOperation sysLogOperation,List<SysLogOperationDetail> sysLogOperationDetailList){
		sysLogOperationDAO.saveSysLogOperation(sysLogOperation, sysLogOperationDetailList);
	}

	
	public Pagination<SysLogOperation> querySysLogOperationPageList(SysLogOperation sysLogOperation,int pageIndex,int pageSize) {
		Pagination<SysLogOperation> page = sysLogOperationDAO.querySysLogOperationPageList(sysLogOperation, pageIndex, pageSize);
		return page;
	}
	
	public SysLogOperation querySysLogOperationDetailByLogID(String logID){
		SysLogOperation sysLogOperation = sysLogOperationDAO.getEntityById(logID, SysLogOperation.class);
		
		SysLogOperationDetail queryObj = new SysLogOperationDetail();
		queryObj.setLogid(sysLogOperation.getLogid());
		List<SysLogOperationDetail> tableList = sysLogOperationDetailDAO.querySysLogOperationDetailList(queryObj);
		sysLogOperation.setLogDetailList(tableList);
		
		return sysLogOperation;
	}
	
	public List<SysLogOperation> queryBusinessNameList(){
		return sysLogOperationDAO.queryBusinessNameList();
	}
	
	public void TruncateLog(){
		sysLogOperationDAO.TruncateLog();
	}
}
