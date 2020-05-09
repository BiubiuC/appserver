package com.arcst.exception;

public class InfoObjAlreadySetEndException extends AppServerException {
	
	public InfoObjAlreadySetEndException() {
		super();
	}
	public InfoObjAlreadySetEndException(Class<?> cls) {
		super(cls.getName());
	}
	
}
