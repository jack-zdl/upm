package com.api.exception;

/**
 * httpClient�쳣������
 * 
 * @author HCK
 *
 */
public class HttpClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpClientException(){
		
	}
	
	public HttpClientException(String msg) {
		super(msg);
	}
}
