package com.repast.core.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * Description: 公共工具
 */
public class CommonTool {
	public static final String ak = "cScOhinBHq5wM15YL6R3CRdf";
	
	
	public static Object parseJavaObject(String jsonStr,Class clazz){
		return JSON.toJavaObject(JSON.parseObject(jsonStr), clazz);
	}
	
	/**
	 * 通过百度坐标获取gps坐标
	 * @param lon 百度坐标经度
	 * @param lat 百度坐标纬度
	 * @return "经度，纬度"
	 * @throws IOException
	 */
	public static String getGps(String lon,String lat){
		String lon1;
		String lat1;
		String resuoltString = "";
		String datastring= readContentFromGet(lon,lat);
		int index = datastring.indexOf("x");
		if(index>0){
			lon1 = datastring.substring(datastring.indexOf("x")+3, datastring.indexOf("y")-2);
			datastring = datastring.substring(datastring.indexOf("y")+3);
			lat1 = datastring.substring(0,datastring.indexOf("}"));
			Double x1=Double.parseDouble(lon);
			Double y1=Double.parseDouble(lat);
			Double x2=Double.parseDouble(lon1);
			Double y2=Double.parseDouble(lat1);
			Double x = 2*x1-x2;
			Double y = 2*y1-y2;
			resuoltString = x+","+y;
		}
		return resuoltString;
	}
	
	public static String readContentFromGet(String lon,String lat) {
		URL getUrl;
		String returnString="";
		try {
			getUrl = new URL("http://api.map.baidu.com/geoconv/v1/?coords="+lon+","+lat+"&from=1&to=5&ak="+ak);
			HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			while ((lines = reader.readLine()) != null) {
				returnString = lines;
//			System.out.println(lines);
			}
			reader.close();
			connection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnString;
	}
	
	/**
	 * @description 获取两个时间差 xx分 aftertime-beforetime
	 * @author chao
	 * @updateAuthor chao
	 * @param beforetime
	 * @param aftertime
	 * @return
	 * @throws ParseException 
	 * @created 2015年3月6日 下午2:11:11
	 */
	public static String getTimeDifference(Date beforetime,Date aftertime){
		long between=(aftertime.getTime()-beforetime.getTime())/1000/60;//换成分
		String dateStr = between+"分钟";
		return dateStr;
	}
	
	/**
	 * @description 获取两个时间差 xx天xx小时xx分xx秒  aftertime-beforetime
	 * @author chao
	 * @updateAuthor chao
	 * @param beforetime
	 * @param aftertime
	 * @return
	 * @throws ParseException 
	 * @created 2015年3月6日 下午2:11:11
	 */
	public static String getTimeAllDifference(Date beforetime,Date aftertime){
		long between=(aftertime.getTime()-beforetime.getTime())/1000;//换成秒
		long day1=between/(24*3600);
		long hour1=between%(24*3600)/3600;
		long minute1=between%3600/60;
		long second1=between%60;
		String dateStr = "";
		if(day1!=0){
			dateStr += day1+"天";
		}
		if(hour1!=0||(hour1==0&&dateStr.length()>0)){
			dateStr += hour1+"小时";
		}
		dateStr += minute1+"分钟";
		return dateStr;
	}
	
	
	/**
	 * 根据url生成静态页面
	 * 
	 * @param url
	 *            动态文件路经 如：http://www.exueji.com/kkk.jsp
	 * @param path
	 *            文件存放路经如：d:\aaabbb.html
	 * @return
	 */
	public static boolean Url2HtmlPage(String url, String filePath) {

		//String str = "";
		try {
			URL Url = new URL(url);
			InputStream is = Url.openStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
//			int i=0;
//			while (!br.ready()&&i<1000000) {i++;}
			String str = null;
			StringBuffer result = new StringBuffer();
			  while((str = br.readLine()) != null)
			  {
			   result.append(str);
			  }
//			  while (br.ready()) {
//				str += br.readLine() + "\n";
//			}
			br.close();
			// 写入文件
			System.out.println(filePath);
			File f = new File(filePath);
			
			if(f.exists())
				f.delete();


				OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
				BufferedWriter writer = new BufferedWriter(write);
				writer.write(result.toString());
				writer.close();

			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 获得六位随机验证码
	 * @return
	 */
	public static String phoneValidatecode(){
		String[] numbers = new String[]{"1","2","3","4","5","6","7","8","9","0"};
		StringBuffer validate = new StringBuffer();
		for(int i = 0; i < 6; i++){
			int index = (int)(Math.random()*10);
			validate.append(numbers[index]);
		}
		return validate.toString();
	}

	
	public static void main(String args[]){
		
	}
	
	

}
