package com.arcst.config;

public class AppServerConf {
	private static Object lock = new Object();
	
	private static AppServerConf conf = null;
	
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
	
}
