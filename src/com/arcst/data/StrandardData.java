package com.arcst.data;

public interface StrandardData {
	/**
	 * 1.序列化
	 * 2.获取值
	 * 3.设置值
	 * 4.复制一个版本的副本（deep clone）
	 * 5.获取当前数据版本
	 * 6.设置当前数据版本
	 * 7.获取最大版本数
	 * 8.超出最大版本数处理
	 */
	public Object serial();
	public Object get(Object key);
	public Object set(Object key,Object value);
	public StrandardData clone(int ver);
	public int getVer();
	public StrandardData setVer();
	public int maxVer();
	public void outOfMacVer();
	public void clear();
}
