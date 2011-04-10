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
