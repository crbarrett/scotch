package org.cbarrett.scotchservices.lcbo.domain;

public abstract class GenericLCBOResponse {
	private int status;
	private String message;
	
	public int getStatus() {
		return this.status;
	}
	public String getMessage() {
		return this.message;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
