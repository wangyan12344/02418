package com.repast.core.cache;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.repast.core.cache.config.CacheKeyDef;
import com.repast.core.cache.config.MethodDef;
import com.repast.core.cache.config.TableDef;

public class CacheKeyDefineManager {

	private static CacheKeyDefineManager cacheKeyDefineManagerInstance = null;
	private static Map<String,String> cacheKeyMap = null;
	private static Map<String, CacheKeyDef> cacheKeyDefMap = null;
	private static Map<String, Set<String>> tableAndRootkeyMap = null;
	private static Logger logger = Logger.getLogger("logger");

	private CacheKeyDefineManager() {

	}

	public static CacheKeyDefineManager getInstance() {
		if (cacheKeyDefineManagerInstance == null) {
			cacheKeyDefineManagerInstance = new CacheKeyDefineManager();
			cacheKeyDefMap = new HashMap<String, CacheKeyDef>();
			cacheKeyMap = new HashMap<String, String>();
			tableAndRootkeyMap = new HashMap<String, Set<String>>();
		}
		return cacheKeyDefineManagerInstance;
	}

	public void init() {
		if (cacheKeyDefMap.size() == 0) {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			String rootPath = loader.getResource("").getPath() + "cache"+File.separator+"config";

			File rootFile = new File(rootPath.replace("%20", " "));
			try {
				for (String file : listFiles(rootFile, new ArrayList<String>())) {

					CacheKeyDef cachekeyDef = CacheKeyDefineLoader.loadCacheKeyDefineXml(file);
					if (cacheKeyDefMap.containsKey(cachekeyDef.getCachekeyid()))
						logger.error("警告：CacheKey中出现重复定义，请检查" + cachekeyDef.getCachekeyid());
					cacheKeyDefMap.put(cachekeyDef.getCachekeyid(), cachekeyDef);
					createCacheKey(cachekeyDef);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("CacheKeyDefineManager初始化完成;共扫描加载CacheKey定义" + cacheKeyDefMap.size() + "个,"+"加载MethodDef定义" + cacheKeyMap.size() + "个;");
		}
	}

	public CacheKeyDef getCacheKeyDefineById(String cacheKeyId) {
		this.init();
		// 判断生产模式，如果为
		if ("debug".equalsIgnoreCase("debug")) {
			// BigpipeLoader.loadBigPiplDefineXml(bigpipeXmlPath);
		}

		if (cacheKeyDefMap.containsKey(cacheKeyId))
			return cacheKeyDefMap.get(cacheKeyId);
		else
			return null;
	}

	/**
	 * 获取所有文件列表
	 * 
	 * @param rootFile
	 * @param fileList
	 * @throws IOException
	 */
	private static List<String> listFiles(File rootFile, List<String> fileList) throws IOException {
		File[] allFiles = rootFile.listFiles();
		for (File file : allFiles) {
			if (file.isDirectory()) {
				listFiles(file, fileList);
			} else {
				String path = file.getCanonicalPath();
				fileList.add(path);
			}
		}
		return fileList;
	}
	
	private void createCacheKey(CacheKeyDef cacheKeyDef){
		List<MethodDef> MethodDefList = cacheKeyDef.getMethoddefList();
		for (MethodDef methodDef : MethodDefList) {
			String methodId = methodDef.getId();
			String methodid = "[methodid="+methodDef.getId()+"]";
			List<TableDef> tableDefList = methodDef.getTabledefList();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("");
			for (TableDef tableDef : tableDefList) {
				stringBuffer.append(tableDef.getName()).append("|");
			}
			String tables = stringBuffer.toString();
			int lastindex = tables.lastIndexOf("|");
			if(lastindex != -1){
				tables = tables.substring(0, lastindex);
			}
			tables = "[tables="+tables+"]";
			String cacheKey = methodid + tables;
			for (TableDef tableDef : tableDefList) {
				/*建立表名与缓存根key之间的对应关系*/
				String tablename = tableDef.getName();
				Set<String> tableKeySet = tableAndRootkeyMap.get(tablename);
				if(tableKeySet == null){
					tableKeySet = new HashSet<String>();
					tableKeySet.add(cacheKey);
					tableAndRootkeyMap.put(tablename, tableKeySet);
				}else{
					tableKeySet.add(cacheKey);
				}
			}
			//建立cacheconfig中methodId与缓存根key之间的关系
			if (cacheKeyMap.containsKey(methodId)){
				logger.error("警告：methoddef中出现重复定义，请检查" + methodId);
				//此处应该有一个停止tomcat的代码
			}
			cacheKeyMap.put(methodId, cacheKey);
		}
	}

	public Map<String, String> getCacheKeyMap() {
		return cacheKeyMap;
	}

	public Map<String, Set<String>> getTableAndRootkeyMap() {
		return tableAndRootkeyMap;
	}

	
}