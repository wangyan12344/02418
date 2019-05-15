package com.repast.core.tool;

public class EmptyUtilHelper {

	public static boolean isEmpty(Object entity){
		if (entity==null||entity=="") {
			return true;
		} else {
			return false;
		}
}
	public static String[] headerTitle(String rowname){
		String[] heardrow=rowname.split(",");
		  String[] headerTitle=new String[heardrow.length];
		  for (int i=0;i<heardrow.length;i++) {
			  String[] arry=heardrow[i].split("-");
			  headerTitle[i]=arry[0];
			  
		  }
		  return headerTitle;
	}
	
	public static String arryEntity(String rowname){
		 String[] heardrow=rowname.split(",");
		  String[] entity=new String[heardrow.length];
		  for (int i=0;i<heardrow.length;i++) {
			  String[] arry=heardrow[i].split("-");
			  entity[i]=arry[1];
		  }
		  
		  StringBuffer sb = new StringBuffer();
		  for(int i = 0; i < entity.length; i++){
			  if (i<=entity.length-2) {
				  sb. append(entity[i]+",");
			  } else {
				  sb. append(entity[i]);
			  }
		  }
		  return sb.toString();  //将数组转为字符串
		  
	}
	
	public static String[] atrEntity(String rowname){
		String[] heardrow=rowname.split(",");
		  String[] entity=new String[heardrow.length];
		  for (int i=0;i<heardrow.length;i++) {
			  String[] arry=heardrow[i].split("-");
			 
			  entity[i]=arry[1];
		  }
		  return entity;
	}
	
}
