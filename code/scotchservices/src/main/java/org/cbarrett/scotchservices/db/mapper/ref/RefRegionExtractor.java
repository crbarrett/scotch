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
package org.cbarrett.scotchservices.db.mapper.ref;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import org.cbarrett.scotchservices.domain.RefRegion;

public class RefRegionExtractor implements ResultSetExtractor<RefRegion> {
	
	@Override
	public RefRegion extractData(ResultSet rs) throws SQLException {
		RefRegion region = new RefRegion();
		region.setId(rs.getInt(1));
		region.setRegionName(rs.getString(2));
		region.setRegionDescription(rs.getString(3));
		return region;
	}
}