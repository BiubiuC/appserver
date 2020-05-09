package com.arcst.config;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.arcst.manager.PluginManager;
import com.arcst.plugin.PluginUnit;

public class ConfigLoader {

	static Logger logger = Logger.getLogger(ConfigLoader.class);
	static SAXReader sax = null;
	static Document doc = null;
	static {
		try {
			sax = new SAXReader();
			doc = sax.read(ConstValue.APPSERVER_CONF);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			logger.error("加载应用配置失败");
			e.printStackTrace();
		}
		if (sax == null || doc == null) {
			logger.error("加载应用配置失败");
			throw new RuntimeException();
		}
	}

	public static Document getAppXmlDocument() {
		return doc;
	}
	
	public static void loadProxy() {
		// TODO Auto-generated method stub
		logger.info("加载代理信息开始");

		logger.info("加载代理信息完成");
	}

	@SuppressWarnings("unchecked")
	public static void loadPluggin() {
		// TODO Auto-generated method stub
		logger.info("加载插件开始");
		Element section = doc.getRootElement().element("constValues");
		section.elements().forEach(e -> {
			if(((Element)e).getName().equalsIgnoreCase("unit")) {
				PluginUnit unit = PluginManager.createPlugin(((Element)e).getName());
				PluginManager.getManage().addPlugin(unit);
				logger.info("加载插件:"+unit);
			}
		});
		logger.info("加载插件完成");
	}

	public static void loadThridCfgFile() {
		// TODO Auto-generated method stub
		logger.info("加载辅助配置文件开始");

		logger.info("加载辅助配置文件完成");
	}

	public static void loadSecondCfgFile() {
		// TODO Auto-generated method stub
		logger.info("加载次要配置文件开始");

		logger.info("加载次要配置文件完成");
	}

	public static void loadFirstCfgFile() {
		// TODO Auto-generated method stub
		logger.info("加载主要配置文件开始");

		logger.info("加载主要配置文件完成");
	}

	public static void loadVconst() {
		// TODO Auto-generated method stub
		logger.info("加载静态变量开始");
		
		ConstValue.DEF_DISPATCHER = false;
		ConstValue.DEF_NETACCEPTER = false;
		
		Element section = doc.getRootElement().element("constValues");
		Element dispatcher = section.element("def_dispatcher");
		if(dispatcher != null) {
			Element dispatchClassName = dispatcher.element("dispatch_class");
			if(dispatchClassName != null && dispatchClassName.getTextTrim() != null && dispatchClassName.getTextTrim().length()!=0) {
				logger.info("使用指定分发器:"+dispatchClassName.getTextTrim());
				try {
					Class.forName(dispatchClassName.getTextTrim());
					ConstValue.DEF_DISPATCHER = true;
					ConstValue.DISPATCH_CLASS = dispatchClassName.getTextTrim();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					logger.warn("未找到指定分发器:"+dispatchClassName.getTextTrim());
				}
			}
		}
		Element netaccepter = section.element("def_netaccepter");
		if(netaccepter != null) {
			Element netAccepterClassName = netaccepter.element("netaccepter_class");
			if(netAccepterClassName!= null && netAccepterClassName.getTextTrim() != null && netAccepterClassName.getTextTrim().length()!=0) {
				logger.info("使用指定监听器:"+netAccepterClassName.getTextTrim());
				try {
					Class.forName(netAccepterClassName.getTextTrim());
					ConstValue.DEF_NETACCEPTER = true;
					ConstValue.NETACCEPTER_CLASS = netAccepterClassName.getTextTrim();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					logger.warn("未找到指定监听器:"+netAccepterClassName.getTextTrim());
				}
			}
		}
		logger.info("加载静态变量结束");

	}
	/**
	 * 获取后续需要到一些章节定义到属性
	 */
	public static void loadOths() {
		// TODO Auto-generated method stub
		Element section = doc.getRootElement().element("database");
		Attribute usedAttr = section.attribute("used");
		if(usedAttr == null) {
			ConstValue.IS_USED_DB = false;
		}else {
			String val = usedAttr.getStringValue();
			if(val != null && val.equalsIgnoreCase("Y")) {
				ConstValue.IS_USED_DB = true;
			}else {
				ConstValue.IS_USED_DB = false;
			}
		}
	}
}
