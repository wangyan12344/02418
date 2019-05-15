package com.zhiliang.persistence.dto;

import java.util.List;

import com.zhiliang.persistence.entity.ZlBDepartment;
import com.zhiliang.persistence.entity.ZlBDepartmentUser;

public class departmentDTO {
	
	private String months;
	private String datetime;
	private String newsnum;
	private String departmentname;
	private List<ZlBDepartmentUser> ZlBDepartmentUserlist;
	private List<ZlBDepartment> ZlBDepartmentlist;
	
	
	
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getNewsnum() {
		return newsnum;
	}

	public void setNewsnum(String newsnum) {
		this.newsnum = newsnum;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public List<ZlBDepartmentUser> getZlBDepartmentUserlist() {
		return ZlBDepartmentUserlist;
	}

	public void setZlBDepartmentUserlist(List<ZlBDepartmentUser> zlBDepartmentUserlist) {
		ZlBDepartmentUserlist = zlBDepartmentUserlist;
	}

	public List<ZlBDepartment> getZlBDepartmentlist() {
		return ZlBDepartmentlist;
	}

	public void setZlBDepartmentlist(List<ZlBDepartment> zlBDepartmentlist) {
		ZlBDepartmentlist = zlBDepartmentlist;
	}


}
