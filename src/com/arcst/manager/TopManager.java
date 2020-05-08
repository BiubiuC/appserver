package com.arcst.manager;

import org.apache.log4j.Logger;

public class TopManager {
	
	
	static Logger logger = Logger.getLogger(TopManager.class);
	
	private static Object lock = new Object();
	private static TopManager t = null;
	
	private TopManager() {
		
	}
	
	public void start() {
		logger.info("管理进程启动......");
		// TODO Auto-generated method stub
		logger.info("管理进程启动..完成");
	}

	public static TopManager getManage() {
		// TODO Auto-generated method stub
		if(t == null) {
			synchronized (lock) {
				if(t == null) {
					t = new TopManager();
				}
			}
		}
		return t;
	}
}
