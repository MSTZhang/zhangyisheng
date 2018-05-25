package com.zhangyisheng.exception;

/**
 * Title: 鑷畾涔夌殑RuntimeException
 * Description:Token杩囨湡鏃舵姏鍑�
 * @author rico
 * @created 2017骞�鏈�鏃�涓嬪崍4:56:44
 */
public class TokenException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String msg;

	public TokenException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
