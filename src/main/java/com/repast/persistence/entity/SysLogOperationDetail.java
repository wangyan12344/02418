package com.repast.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.system.BaseEntity;

@Entity(name="Sys_LogOperation_detail")
public class SysLogOperationDetail extends BaseEntity implements Serializable, Cloneable{

	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6701190761344609234L;

	public SysLogOperationDetail clone() {

		SysLogOperationDetail o = null;

		try {
			o = (SysLogOperationDetail) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return o;
	}
	
	@ID
	@Column(name="ID",comment="主键")
	private	String id;
    
    @Column(name="LOGID",comment="日志ID")
    private String logid;

    @Column(name="tablename",comment="数据表名")
    private String tablename;
    
    @Column(name="columnName",comment="字段名称")
    private String columnName;
    
    @Column(name="colunmComt",comment="字段描述")
    private String colunmComt;
    
    @Column(name="oldVal",comment="原值")
    private String oldVal;
    
    @Column(name="newVal",comment="新值")
    private String newVal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColunmComt() {
		return colunmComt;
	}

	public void setColunmComt(String colunmComt) {
		this.colunmComt = colunmComt;
	}

	public String getOldVal() {
		return oldVal;
	}

	public void setOldVal(String oldVal) {
		this.oldVal = oldVal;
	}

	public String getNewVal() {
		return newVal;
	}

	public void setNewVal(String newVal) {
		this.newVal = newVal;
	}
    
    
}
