package com.arcst.config;

import org.apache.log4j.Logger;

public class ConfigLoader {
	
	static Logger logger = Logger.getLogger(ConfigLoader.class);
	
	public static void loadProxy() {
		// TODO Auto-generated method stub
		logger.info("加载代理信息开始");
		
		logger.info("加载代理信息完成");
	}

	public static void loadPluggin() {
		// TODO Auto-generated method stub
		logger.info("加载插件开始");
		
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
		
		logger.info("加载静态变量结束");
		
	}
}
