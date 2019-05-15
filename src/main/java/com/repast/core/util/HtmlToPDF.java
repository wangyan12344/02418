package com.repast.core.util;

import java.io.IOException;

public class HtmlToPDF {

	/**
	 * 生成店铺巡检报告
	 * @param reportid
	 * @param imgname
	 * @return
	 */
	public static String createShopCheckPdfByResouce(String reportid,String imgname){
		Runtime rt = Runtime.getRuntime();
		try {
			long starttime = System.currentTimeMillis();
			String execSta = CommonUtil.PDF_TOOL_PATH + "phantomjs " + CommonUtil.PDF_TOOL_PATH + "rasterize.js " + CommonUtil.POOL_PDF_TEMPLATE_URL + reportid + " " + CommonUtil.REPORT_FILE_ROOTPATH +imgname+"";
			rt.exec(execSta);
			long endtime = System.currentTimeMillis();
			System.out.println((endtime-starttime)+" ms");
			return CommonUtil.REPORT_FILE_ROOTPATH +imgname;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-------------------请求资源超时，生成PDF失败-------------------");
		}
		return "";
	}
	
	
	/**
	 * 生成零售巡店报告
	 * @param reportid
	 * @param imgname
	 */
	public static String createPdfByResouce(String reportid,String imgname){
		Runtime rt = Runtime.getRuntime();
		try {
			long starttime = System.currentTimeMillis();
			String execSta = CommonUtil.PDF_TOOL_PATH + "phantomjs " + CommonUtil.PDF_TOOL_PATH + "rasterize.js " + CommonUtil.PDF_TEMPLATE_URL + reportid + " " + CommonUtil.REPORT_FILE_ROOTPATH +imgname+"";
			rt.exec(execSta);
			long endtime = System.currentTimeMillis();
			System.out.println((endtime-starttime)+" ms");
			return CommonUtil.REPORT_FILE_ROOTPATH +imgname;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-------------------请求资源超时，生成PDF失败-------------------");
		}
		return "";
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年10月29日 上午11:01:05
	 * @param reportid
	 * @param imgname
	 * @return
	 */
	public static String createQuestionPdfByResouce(String reportid,String imgname){
		Runtime rt = Runtime.getRuntime();
		try {
			long starttime = System.currentTimeMillis();
			String execSta = CommonUtil.PDF_TOOL_PATH + "phantomjs " + CommonUtil.PDF_TOOL_PATH + "rasterize.js " + CommonUtil.QUES_PDF_TEMPLATE_URL + reportid + " " + CommonUtil.REPORT_FILE_ROOTPATH +imgname+"";
			rt.exec(execSta);
			long endtime = System.currentTimeMillis();
			System.out.println((endtime-starttime)+" ms");
			return CommonUtil.REPORT_FILE_ROOTPATH +imgname;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("-------------------请求资源超时，生成问题PDF失败-------------------");
		}
		return "";
	}
	
	public static void main(String[] args){
		createPdfByResouce("f41cc17d3b654928bad36f6545ab852a","ddd.pdf");
	}
}
