/**
 *  Copyright 2011 Chris Barrett
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.cbarrett.scotchservices.domain;

import org.cbarrett.common.domain.DomainObject;
import org.codehaus.jackson.annotate.JsonProperty;

public class Malt implements DomainObject {

	@JsonProperty
	String name = null;
	
	//TODO - delete this, not needed once example is concluded
	public Malt() {
		
	}
	
	public Malt(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + name.hashCode();
		
		return result;
	}
	@Override
	public boolean equals(Object other) {
		boolean result = false;

		if (this == other) {
			result = true;
		} else if (other == null) {
			result = false;
		} else if (!(other instanceof Malt)) {
			result = false;
		} else {
			Malt otherMalt= (Malt) other;
			result = (name.equals(otherMalt.name));
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(Malt.class.getSimpleName());
		sb.append("[name: " + name + "]");
		return sb.toString();
	}	
}
