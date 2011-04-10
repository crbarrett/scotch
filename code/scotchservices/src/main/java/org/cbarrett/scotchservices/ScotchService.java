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
package org.cbarrett.scotchservices;

import org.cbarrett.scotchservices.domain.Malt;
import org.cbarrett.scotchservices.domain.RefDistilleryStatus;
import org.cbarrett.scotchservices.domain.RefRegion;
import org.cbarrett.scotchservices.domain.RefStyle;

import java.util.List;

public interface ScotchService {
	/*
	public List getOwners();
	public List getIndependentBottlers();
	public List getDistilleries();
	*/
	public Malt getMaltByName(String name);
	public List<Malt> getMalts();
	public List<Malt> getMaltsByDistillery(String distillery);
	
	public List<RefDistilleryStatus> getDistilleryStatus();
	public List<RefRegion> getRegion();
	public List<RefStyle> getStyle();
	/*
	public List getBottlings();
	
	public List getTastingNotes();
	public List getPurchaseRecords();
	
	public List getRegions();
	public List getStyles();
	*/
}
