package com.arcst.tool;

import org.dom4j.Attribute;

public class StrKit {
	
	/**
	 * XML解析扩展
	 * @param s
	 * @return
	 */
	public static int attrIntValue(Attribute s) {
		if(s == null)return 0;
		if(s.getStringValue()!=null && s.getStringValue().length()!=0)
			return Integer.valueOf(s.getStringValue());
		return 0;
	}
	public static String attrStringValue(Attribute s) {
		if(s == null)return null;
		return s.getStringValue();
	}
}
