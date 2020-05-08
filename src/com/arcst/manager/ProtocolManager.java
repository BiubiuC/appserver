package com.arcst.manager;

public class ProtocolManager {
	private static Object lock = new Object();
	private static ProtocolManager t = null;
	
	private ProtocolManager() {
		
	}
	
	public void initProtocols() {
		
	}

	public static ProtocolManager getManage() {
		// TODO Auto-generated method stub
		if(t == null) {
			synchronized (lock) {
				if(t == null) {
					t = new ProtocolManager();
				}
			}
		}
		return t;
	}
}
