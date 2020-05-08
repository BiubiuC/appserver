package com.arcst.manager;

import org.apache.log4j.Logger;


public class ThreadManager {

	static Logger logger = Logger.getLogger(ThreadManager.class);
	
	private static Object lock = new Object();
	private static ThreadManager t = null;
	
	private ThreadManager() {
		
	}
	
	public void initThreadPool() {
		logger.info("初始化工作线程池开始");
		// TODO Auto-generated method stub
		logger.info("初始化工作线程池完成");
	}

	public static ThreadManager getManage() {
		// TODO Auto-generated method stub
		if(t == null) {
			synchronized (lock) {
				if(t == null) {
					t = new ThreadManager();
				}
			}
		}
		return t;
	}
}
