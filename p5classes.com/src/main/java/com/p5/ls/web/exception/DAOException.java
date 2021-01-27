package com.p5.ls.web.exception;

public class DAOException extends Exception {

	private String erMsg;
	private String erDetails;
	private int erCode;

	public DAOException(int erCode, String erMsg, String erDetails) {
		super();
		this.erCode = erCode;
		this.erMsg = erMsg;
		this.erDetails = erDetails;
	}

	public String getErMsg() {
		return erMsg;
	}

	public void setErMsg(String erMsg) {
		this.erMsg = erMsg;
	}

	public String getErDetails() {
		return erDetails;
	}

	public void setErDetails(String erDetails) {
		this.erDetails = erDetails;
	}

	public int getErCode() {
		return erCode;
	}

	public void setErCode(int erCode) {
		this.erCode = erCode;
	}


}