package com.arcst.manager;

import org.apache.log4j.Logger;

public class BusiManager {
	
	static Logger logger = Logger.getLogger(BusiManager.class);

	private static Object lock = new Object();
	private static BusiManager t = null;
	
	private BusiManager() {
		
	}
	
	public void initBusiPool() {
		logger.info("初始化业务池开始");
		// TODO Auto-generated method stub
		logger.info("初始化业务池完成");
	}

	public static BusiManager getManage() {
		// TODO Auto-generated method stub
		if(t == null) {
			synchronized (lock) {
				if(t == null) {
					t = new BusiManager();
				}
			}
		}
		return t;
	}
}
