package com.repast.core.cache.config;

import java.util.List;

public class MethodDef implements Cloneable{

	private String id;
	private String description;
	private List<TableDef> tabledefList;

	public List<TableDef> getTabledefList() {
		return tabledefList;
	}

	public void setTabledefList(List<TableDef> tabledefList) {
		this.tabledefList = tabledefList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object clone()    
    {    
		
		MethodDef o=null;    
       try    
        {    
    	   o=(MethodDef)super.clone();    
        }    
       catch(CloneNotSupportedException e)    
        {    
            System.out.println(e.toString());    
        }    
       return o;    
    } 
}
