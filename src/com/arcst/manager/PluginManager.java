package com.arcst.manager;

import com.arcst.plugin.PluginUnit;

public class PluginManager {
	private static Object lock = new Object();
	private static PluginManager t = null;
	
	
	private PluginManager() {
		
	}
	
	public void addPlugin(PluginUnit plugin) {
		//TODO:
	}
	
	public PluginUnit getPlugin(String name) {
		//TODO:
		return null;
	}

	public static PluginManager getManage() {
		// TODO Auto-generated method stub
		if(t == null) {
			synchronized (lock) {
				if(t == null) {
					t = new PluginManager();
				}
			}
		}
		return t;
	}

	public static PluginUnit createPlugin(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
