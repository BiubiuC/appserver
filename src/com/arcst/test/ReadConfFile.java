package com.arcst.test;

import com.arcst.config.ConfigLoader;
import com.arcst.config.ConstValue;

public class ReadConfFile {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.arcst.config.ConfigLoader");
		ConfigLoader.loadOths();
		System.out.println(ConstValue.IS_USED_DB);
	} 
}
