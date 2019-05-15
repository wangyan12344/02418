package com.repast.core.util;

public class CommonUtil {
//
//	public  static String WEBSITE = "http://192.168.1.10:8080/";
//	
//	public static String ShowimgPath = "http://192.168.1.10:8080/hld/";
//	
//	public static String FTPIP="192.168.31.122";
//	
//	public static String InterFaceWebsite="http://192.168.1.10:8080/hld/";
	
//	
	public  static String WEBSITE = "http://shengdafeitong.02418.com/hld/";
	
	public static String ShowimgPath = "http://shengdafeitong.02418.com/hld/";
	
	public static String FTPIP="192.168.31.122";
	
	public static String InterFaceWebsite="http://shengdafeitong.02418.com/hld/";


	
	/**
	 * 商城平台用户默认shopid
	 * */
	public static String SYS_SHOPID = "managershopid";
	/**
	 * 是否需要生成pdf报告
	 */
	public final static boolean NEED_CREATE_PDF=true;
	/**
	 * 生成pdf工具的bin位置
	 */
	public final static String PDF_TOOL_PATH = "/home/website/www/checkshop/phantomjs/";
	/**
	 * 生成pdf在服务器上的物理路径
	 */
	public final static String REPORT_FILE_ROOTPATH = "/home/website/www/checkshop/report/";
	/**
	 * 生成pdf模板位置
	 */
	public final static String PDF_TEMPLATE_URL = WEBSITE+"ReportController/htmlToPdf.do?reportid=";
	/**
	 * 生成问题报告模板路径
	 */
	public final static String QUES_PDF_TEMPLATE_URL = WEBSITE+"ReportController/probleminfoToPdf.do?reportid=";
	/**
	 * 巡检报告模板路径
	 */
	public final static String POOL_PDF_TEMPLATE_URL = WEBSITE+"ReportController/shopcheckToPdf.do?reportid=";
	
}
