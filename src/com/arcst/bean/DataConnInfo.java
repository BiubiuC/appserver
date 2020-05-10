package com.arcst.bean;

public class DataConnInfo implements BaseBean {

	public int maxnum;
	public String type;
	public String connstr;
	public String username;
	public String password;

	@Override
	public int hashCode() {
		return maxnum + type.hashCode() + connstr.hashCode() + username.hashCode() + password.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DataConnInfo))
			return false;
		DataConnInfo dst = (DataConnInfo) obj;
		return maxnum == dst.maxnum && type.equals(dst.type) && connstr.equals(dst.connstr)
				&& username.equals(dst.username) && password.equals(dst.password);
	}

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public byte[] serial() {
		return null;
	}
}
