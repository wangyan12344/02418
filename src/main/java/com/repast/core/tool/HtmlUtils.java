package com.repast.core.tool;
/**
 * 异步静态化处理类
 * @author luandong
 *
 */
public class HtmlUtils implements Runnable {
	
	private String url;
	
	private String filePath;
	
	public HtmlUtils(String url,String filePath){
		this.url = url;
		this.filePath = filePath;
	}

	@Override
	public void run() {
		CommonTool.Url2HtmlPage(url, filePath);
	}

}
