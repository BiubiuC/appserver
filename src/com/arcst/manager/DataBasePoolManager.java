package com.arcst.manager;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import com.arcst.config.ConfigLoader;
import com.arcst.config.system.DataBasePoolInfo;

public class DataBasePoolManager {
	static Logger logger = Logger.getLogger(DataBasePoolManager.class);
	private static Object lock = new Object();
	private static DataBasePoolManager t = null;
	
	private DataBasePoolInfo dbpi = null;
	
	private DataBasePoolManager() {
		
	}
	public static DataBasePoolManager getManage() {
		// TODO Auto-generated method stub
		if(t == null) {
			synchronized (lock) {
				if(t == null) {
					t = new DataBasePoolManager();
				}
			}
		}
		return t;
	}
	
	public void initConnPool() {
		logger.info("初始化数据库连接池开始");
		// TODO Auto-generated method stub
		Document doc = ConfigLoader.getAppXmlDocument();
		Element database = doc.getRootElement().element("database");
		//TODO: BiubiuC Doing
		
		logger.info("初始化数据库连接池完成");
	}

}
