package org.cbarrett.scotchservices.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class Malt {

	@JsonProperty
	String name = null;
	
	//TODO - delete this, not needed once example is concluded
	public Malt() {
		
	}
	
	public Malt(String name) {
		this.name = name;
	}
}
