package com.repast.core.uiview.format.impl;

import java.util.Map;

import com.repast.core.codelist.CodelistManager;
import com.repast.core.uiview.format.IConvert;

/**
 * 通过codelist代码表数据进行值转换
 * @author luandong
 *
 */
public class CodeListConvertImpl extends IConvert {


	private String codeKind;

	public CodeListConvertImpl(String scoureProName, String targetProName,String codeKind) {
		this.scoureProName = scoureProName;
		this.targetProName = targetProName;
		this.codeKind = codeKind;
		initMap();
	}

	@Override
	public Map getConvertDataMap() {
		return dataMap;
	}

	@Override
	protected void initMap() {

		// List<SysCodelist> codeLists = CodelistManager.getInstance().getCodeListByKind(codeKind);

			Map<String, Map<String, String>> codelistjson = CodelistManager.getInstance().getCodeList(codeKind);
			
			if(codelistjson.containsKey(codeKind)){
				this.dataMap = codelistjson.get(codeKind);
				
			}
			/*
			Map<String, String> codeMap = new HashMap<String, String>();
			for (SysCodelist codeList : codeLists) {
				String codeName = codeList.getCodename();
				String codeValue = codeList.getCodevalue();
				codeMap.put(codeValue, codeName);
			}
			
			this.dataMap = codeMap;
			
			*/
	}

}
