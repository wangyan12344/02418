package com.repast.core.log.businesslog;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.Transient;
import com.repast.core.service.SysLogOperationService;
import com.repast.core.tool.ApplicationContextUtil;
import com.repast.persistence.entity.SysLogOperation;
import com.repast.persistence.entity.SysLogOperationDetail;

public class LogUtils implements Runnable {
	private Log log;
	public static String getUUId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	
	private static String getTableName(Class<?> pojoClass) {
		Entity entity = pojoClass.getAnnotation(Entity.class);
		if (entity != null) {
			return entity.name();
		} else {
			return null;
		}
	}

	
	private static <T> String[] getFieldNames(Class<T> pojoClass) {
		List<String> columns = new ArrayList<String>();
		Field[] fields = pojoClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String column = getColumnName(fields[i]);
			if (column != null && !"serialVersionUID".equals(column)) {
				columns.add(fields[i].getName());
			}
		}
		String[] rts = new String[columns.size()];
		return columns.toArray(rts);
	}
	
	
	private static <T> String[] getColumnNames(Class<T> pojoClass) {
		List<String> columns = new ArrayList<String>();
		Field[] fields = pojoClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String column = getColumnName(fields[i]);
			if (column != null && !"serialVersionUID".equals(column)) {
				columns.add(column);
			}
		}
		String[] rts = new String[columns.size()];
		return columns.toArray(rts);
	}
	
	private static <T> String[] getColumnComments(Class<T> pojoClass) {
		List<String> columns = new ArrayList<String>();
		Field[] fields = pojoClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String column = getColumnComment(fields[i]);
			if (column != null && !"serialVersionUID".equals(column)) {
				columns.add(column);
			}
		}
		String[] rts = new String[columns.size()];
		return columns.toArray(rts);
	}


	private static String getColumnName(Field field) {
		Annotation[] ats = field.getAnnotations();
		if (ats.length > 0) {
			for (int y = 0; y < ats.length; y++) {
				if (ats[y] instanceof Transient) {
					return null;
				} else if (ats[y] instanceof Column) {
					return ((Column) ats[y]).name();
				}
			}
		}
		return field.getName();
	}

	
	private static String getColumnComment(Field field) {
		Annotation[] ats = field.getAnnotations();
		if (ats.length > 0) {
			for (int y = 0; y < ats.length; y++) {
				if (ats[y] instanceof Transient) {
					return null;
				} else if (ats[y] instanceof Column) {
					return ((Column) ats[y]).comment();
				}
			}
		}
		return field.getName();
	}

	public void saveLog() {
		SysLogOperation sysLogOperation = new SysLogOperation();
		sysLogOperation.setLogid(getUUId());
		sysLogOperation.setOperationTime(new Date());
		sysLogOperation.setOperationType(log.getOperationType());
		sysLogOperation.setOperationUserId(log.getOperationUserId());
		sysLogOperation.setOperationUserName(log.getOperationUserName());
		sysLogOperation.setDeviceType(log.getDeviceType());
		sysLogOperation.setBusinessName(log.getBusinessName());
		sysLogOperation.setRestaurantid(log.getRestaurantid());
		sysLogOperation.setMemo(log.getMemo());
		sysLogOperation.setIpaddress(log.getIpAddress());
		
		List<Object> oldList = log.getOldEntiyList();
		List<Object> newList = log.getNewEntiyList();
		List detailList = new ArrayList();
		if(newList!=null&&newList.size()>0)
		{
		for(int idx=0;idx<newList.size();idx++){
			
			Object newObj = newList.get(idx);
			Object oldObj = oldList.get(idx);
			
			//取得tableName
			String tableName = getTableName(newObj.getClass());
			//取得ColumnName
			String[] columnNames = getColumnNames(newObj.getClass());
			//取得comment
			String[] columnComments = getColumnComments(newObj.getClass());
			//取得对象中的javabean属性
			String[] fields =  getFieldNames(newObj.getClass());
		

			BeanWrapper newBw = PropertyAccessorFactory.forBeanPropertyAccess(newObj);
			BeanWrapper oldBw = null;
			if(oldObj!=null)
				oldBw = PropertyAccessorFactory.forBeanPropertyAccess(oldObj);
			
			for (int i = 0; i < fields.length; i++) {
				if (!"serialVersionUID".equals(fields[i])) {
					SysLogOperationDetail detail = new SysLogOperationDetail();
					detail.setId(getUUId());
					detail.setLogid(sysLogOperation.getLogid());
					detail.setTablename(tableName);
					
					detail.setColumnName(columnNames[i]);
					detail.setColunmComt(columnComments[i]);
					try{
						detail.setNewVal(newBw.getPropertyValue(fields[i]).toString());
					}catch(Exception e){
						detail.setNewVal("");
					}
					
					try{
					if(oldObj!=null)
						detail.setOldVal(oldBw.getPropertyValue(fields[i]).toString());
					else
						detail.setOldVal("");
					}catch(Exception e){
						detail.setOldVal("");
					}
					
					detailList.add(detail);
				}
			}
			
			
		}
		}
		
		 
//		SysLogOperationService service  = (SysLogOperationService)ApplicationContextUtil.getBean("SysLogOperationService");
//		service.saveSysLogOperation(sysLogOperation, detailList);
		
	}

	public LogUtils(Log log){
		this.log = log;
	}
	@Override
	public void run() {
		saveLog();		
	}
}
