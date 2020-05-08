package com.arcst.montior;

import org.apache.log4j.Logger;

public class DefaultMonitor implements TopMonitor {
	
	static Logger logger = Logger.getLogger(DefaultMonitor.class);
	
	@Override
	public void startMon() {
		logger.info("系统监控启动......");
		// TODO Auto-generated method stub
		logger.info("系统监控启动..完成");
	}

}
