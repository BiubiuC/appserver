package com.arcst.config.system;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.arcst.bean.DataConnInfo;
import com.arcst.exception.InfoObjAlreadySetEndException;

public class DataBasePoolInfo implements BasePoolInfo{
	
	private boolean isSeted = false;
	
	boolean isUsed = false;
	int defaultIdx = 0;
	private Map<String,DataConnInfo> condefmap = null;
	
	public DataBasePoolInfo() {
		condefmap = new HashMap<String,DataConnInfo>();
	}
	/**
	 * 配置加载器显示的调用此方法终止该对象的设置行为，后续该对象将无法被继续设置，此对象运行时应仅作读取使用，进行并发处理
	 */
	@Override
	public void shutdownSet() {
		isSeted = true;
	}
	public void setUsed(boolean b) {
		if(isSeted)
			throw new InfoObjAlreadySetEndException(this.getClass());
		isUsed = b;
	}
	public void add(String name,DataConnInfo dci) {
		add(name,dci.maxnum,dci.type,dci.connstr,dci.username,dci.password);
	}
	public void add(String name,int max,String type,String connstr,String username,String password) {
		if(isSeted)
			throw new InfoObjAlreadySetEndException(this.getClass());
		DataConnInfo dci = new DataConnInfo();
		dci.maxnum = max;
		dci.type = type;
		dci.connstr = connstr;
		dci.username = username;
		dci.password = password;
		if(name == null) {
			name = (defaultIdx++)+"";
		}
		condefmap.put(name, dci);
	}
	public Set<DataConnInfo> getDataConnInfos(){
		return condefmap.values().stream().collect(Collectors.toSet());
	}
	public DataConnInfo get(String name) {
		return condefmap.get(name);
	}
	
}
