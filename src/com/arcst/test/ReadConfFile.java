package com.arcst.test;

import com.arcst.config.ConfigLoader;

public class ReadConfFile {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.arcst.config.ConfigLoader");
		ConfigLoader.loadVconst();
	} 
}
