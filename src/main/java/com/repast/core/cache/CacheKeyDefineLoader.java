package com.repast.core.cache;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.repast.core.cache.config.CacheKeyDef;
import com.repast.core.cache.config.MethodDef;
import com.repast.core.cache.config.TableDef;

public class CacheKeyDefineLoader {


	public static CacheKeyDef loadCacheKeyDefineXml(String cachekeyXmlPath) {
		CacheKeyDef cachekeyDef = null;
		SAXParserFactory saxpf = SAXParserFactory.newInstance();
		SAXParser saxp;
		try {
			saxp = saxpf.newSAXParser();

			XMLReader reader = saxp.getXMLReader();
			CacheKeyXmlHandler handler = new CacheKeyXmlHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(new FileInputStream(cachekeyXmlPath)));
			cachekeyDef = handler.getMacheKeyDef();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return cachekeyDef;
	}


}

class CacheKeyXmlHandler extends DefaultHandler {

	private CacheKeyDef cachekeyDef = new CacheKeyDef();
	private MethodDef methodDef = null;

	private TableDef tableDef;
	private List<TableDef> tableList;

	private List<MethodDef> methodDefMap = new ArrayList<MethodDef>();

	public void startDocument() throws SAXException {
		// 开始解析 打印 begin
	}

	@Override
	public void endDocument() throws SAXException {
		// 结束后  打印 end
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (qName.equals("cachekey")) {
			for (int i = 0; i < attributes.getLength(); i++) {
				String attrName = attributes.getQName(i);
				String attrVal = attributes.getValue(i);

				if ("cachekeyid".equals(attrName))
					cachekeyDef.setCachekeyid(attrVal);
				else if ("description".equals(attrName))
					cachekeyDef.setDescription(attrVal);
			}
		}

		if (qName.equals("methoddef")) {
			if (methodDef == null) {
				methodDef = new MethodDef();
			}
			for (int i = 0; i < attributes.getLength(); i++) {
				String attrName = attributes.getQName(i);
				String attrVal = attributes.getValue(i);
				
				if ("id".equals(attrName))
					methodDef.setId(attrVal);
				else if ("description".equals(attrName))
					methodDef.setDescription(attrVal);
			}

		}

		if (qName.equals("table-list")) {
			if (tableList == null) {
				tableList = new ArrayList<TableDef>();
			}
		}

		if (qName.equals("table-def")) {
			tableDef = new TableDef();
			for (int i = 0; i < attributes.getLength(); i++) {
				String attrName = attributes.getQName(i);
				String attrVal = attributes.getValue(i);
				if ("name".equals(attrName))
					tableDef.setName(attrVal.toLowerCase());
			}
		}

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("methoddef")) {
			methodDefMap.add(methodDef);
			methodDef = null;
		}

		if (qName.equals("table-def")) {
			tableList.add(tableDef);
			tableDef = null;
		}

		if (qName.equals("table-list")) {
			methodDef.setTabledefList(tableList);
			tableList = null;
		}

	}

	public CacheKeyDef getMacheKeyDef() {
		this.cachekeyDef.setMethoddefList(this.methodDefMap);
		return cachekeyDef;
	}
}
