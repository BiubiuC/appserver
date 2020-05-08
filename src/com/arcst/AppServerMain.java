package com.arcst;

import org.apache.log4j.Logger;

import com.arcst.config.AppServerConf;
import com.arcst.config.ConfigLoader;
import com.arcst.config.ConstValue;
import com.arcst.manager.BeanManager;
import com.arcst.manager.BusiManager;
import com.arcst.manager.DataBasePoolManager;
import com.arcst.manager.ProtocolManager;
import com.arcst.manager.ThreadManager;
import com.arcst.manager.TopManager;
import com.arcst.montior.DefaultMonitor;
import com.arcst.net.accept.DefaultNetAccepter;
import com.arcst.net.accept.NetAccepter;
import com.arcst.selector.DefaultSelectDispatcher;
import com.arcst.selector.SelectDispatcher;



public class AppServerMain {

	static Logger logger = Logger.getLogger(AppServerMain.class);
	
	public static void main(String[] args) {
		
		loadConfig();
		initPool();
		initResource();
		initMoniAndMng();
		
	}

	private static void loadConfig() {
		ConfigLoader.loadVconst();
		ConfigLoader.loadFirstCfgFile();
		ConfigLoader.loadSecondCfgFile();
		ConfigLoader.loadThridCfgFile();
		ConfigLoader.loadPluggin();
		ConfigLoader.loadProxy();
	}
	private static void initPool() {
		if(ConstValue.IS_USED_DB) {
			DataBasePoolManager.getManage().initConnPool();
		}
		ThreadManager.getManage().initThreadPool();
		BusiManager.getManage().initBusiPool();
		BeanManager.getManage().initBeanPool();
	}
	
	private static void initResource() {
		SelectDispatcher dispatcher = null;
		NetAccepter netAccepter = null;
		/* init dispatcher */
		if(ConstValue.DEF_DISPATCHER) {
			try {
				Class<?> cls = Class.forName((String) AppServerConf.getConf().get(ConstValue.DISPATCH_CLASS));
				dispatcher = (SelectDispatcher)cls.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(dispatcher == null) {
			dispatcher = new DefaultSelectDispatcher();
		}
		BeanManager.getManage().putSystem(ConstValue.CURR_DISPATCHER, dispatcher);
		
		/* init protocol */
		ProtocolManager.getManage().initProtocols();
		
		/* init listener */
		if(ConstValue.DEF_NETACCEPTER) {
			try {
				Class<?> cls = Class.forName((String) AppServerConf.getConf().get(ConstValue.NETACCEPTER_CLASS));
				netAccepter = (NetAccepter)cls.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(netAccepter == null) {
			netAccepter = new DefaultNetAccepter();
		}
		DefaultNetAccepter mainNetAccepter = new DefaultNetAccepter();
		BeanManager.getManage().putSystem(ConstValue.MAIN_NETACCEPTER,mainNetAccepter);
		mainNetAccepter.start();
	}
	
	private static void initMoniAndMng() {
		DefaultMonitor mon = new DefaultMonitor();
		mon.startMon();
		
		TopManager tmng = TopManager.getManage();
		tmng.start();
	}
}
