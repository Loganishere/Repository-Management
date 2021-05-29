package com.repo.Management.Model;

public class GenericErrorModel {

	private String errorCode; // 500
	private String errorMessage; // Internal Server Error
	private String errorDesc; // An unexpected error occured
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	public GenericErrorModel(String errorCode, String errorMessage, String errorDesc) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorDesc = errorDesc;
	}
	
	public GenericErrorModel() {
		this.errorCode = "500";
		this.errorMessage = "An unexpected error occured. Please check with Administrator!";
		this.errorDesc = "Internal Server Error";
	}
}
