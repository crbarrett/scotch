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

public class RefDistilleryStatus implements DomainObject {

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + id;
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object otherObject) {
		boolean result = false;

		if (this == otherObject) {
			result = true;
		} else if (otherObject == null) {
			result = false;
		} else if (!(otherObject instanceof RefDistilleryStatus)) {
			result = false;
		} else {
			RefDistilleryStatus otherStatus = (RefDistilleryStatus) otherObject;
			result = (
					  (id == otherStatus.id)
					  && ((statusName == null) ? otherStatus.statusName == null : statusName.equals(otherStatus.statusName))
					 );
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(RefDistilleryStatus.class.getSimpleName());
		sb.append("[id: " + Integer.valueOf(id).toString() + ",");
		sb.append("statusName: " + statusName + "]");
		return sb.toString();
	}	
}
