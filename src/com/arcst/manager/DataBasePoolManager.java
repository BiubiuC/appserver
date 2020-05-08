package com.arcst.manager;

import org.apache.log4j.Logger;

public class DataBasePoolManager {

	
	static Logger logger = Logger.getLogger(DataBasePoolManager.class);
	
	private static Object lock = new Object();
	private static DataBasePoolManager t = null;
	
	private DataBasePoolManager() {
		
	}
	
	public void initThreadPool() {
		
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
		logger.info("初始化数据库连接池完成");
	}

}
