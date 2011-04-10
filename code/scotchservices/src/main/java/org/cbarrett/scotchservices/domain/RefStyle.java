package org.cbarrett.scotchservices.domain;

public class RefStyle {

	private int id;
	private String styleName;
	private String styleDescription;

	public int getId() {
		return id;
	}

	public String getStyleName() {
		return styleName;
	}

	public String getStyleDescription() {
		return styleDescription;
	}

	public int setId(int id) {
		return this.id = id;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public void setStyleDescription(String styleDescription) {
		this.styleDescription = styleDescription;
	}
}
