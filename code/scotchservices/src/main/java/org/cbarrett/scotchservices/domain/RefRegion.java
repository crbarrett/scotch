package org.cbarrett.scotchservices.domain;

public class RefRegion {

	private int id;
	private String regionName;
	private String regionDescription;

	public int getId() {
		return id;
	}

	public String getRegionName() {
		return regionName;
	}

	public String getRegionDescription() {
		return regionDescription;
	}

	public int setId(int id) {
		return this.id = id;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}
}
