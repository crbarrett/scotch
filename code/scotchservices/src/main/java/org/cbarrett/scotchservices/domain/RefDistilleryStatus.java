package org.cbarrett.scotchservices.domain;

public class RefDistilleryStatus {

	private int id;
	private String statusName;
	private String statusDescription;

	public int getId() {
		return id;
	}

	public String getStatusName() {
		return statusName;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public int setId(int id) {
		return this.id = id;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
