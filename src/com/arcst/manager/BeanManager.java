package com.arcst.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.arcst.bean.BaseBean;

public class BeanManager {
	static Logger logger = Logger.getLogger(BeanManager.class);
	private static Object lock = new Object();
	private static BeanManager t = null;
	
	private Map<Object,Object> systembeans = null;
	private Map<Object,BaseBean> beans = null;
	
	private BeanManager() {
		
	}
	
	public void initBeanPool() {
		logger.info("初始化对象池开始");
		// TODO Auto-generated method stub
		systembeans = new ConcurrentHashMap<Object, Object>();
		beans = new ConcurrentHashMap<Object, BaseBean>();
		logger.info("初始化对象池完成");
		
	}

	public static BeanManager getManage() {
		if(t == null) {
			synchronized (lock) {
				if(t == null) {
					t = new BeanManager();
				}
			}
		}
		return t;
	}
	public void put(Object key,BaseBean bean) {
		beans.put(key, bean);
	}
	public void putSystem(Object key,Object bean) {
		systembeans.put(key, bean);
		logger.info("设置系统单元:"+key+":"+bean);
	}
	public BaseBean get(Object key) {
		return beans.get(key);
	}
	public Object getSystem(Object key) {
		return systembeans.get(key);
	}
}
