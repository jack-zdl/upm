package com.api.exception;

/**
 * http�����쳣������
 * 
 * @author HCK
 *
 */
public class HttpConnectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpConnectionException(){
		
	}
	
	public HttpConnectionException(String msg) {
		super(msg);
	}
}
