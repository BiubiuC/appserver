package com.arcst.config;

import com.arcst.config.system.BeanPoolInfo;

public class AppServerConf {
	private static Object lock = new Object();
	
	private static AppServerConf conf = null;
	
	
	private BeanPoolInfo bpi = null;
	
	
	private AppServerConf() {
		
	}
	
	public static AppServerConf getConf() {
		if(conf == null) {
			synchronized (lock) {
				if(conf == null) {
					conf = new AppServerConf();
				}
			}
		}
		return conf;
	}
	
	public Object get(String key) {
		//TODO:
		return null;
	}
	
	public BeanPoolInfo getBeanPoolInfo() {
		return null;
	}
	
}
