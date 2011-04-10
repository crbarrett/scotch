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

import org.cbarrett.scotchservices.domain.RefDistilleryStatus;
import org.springframework.jdbc.core.RowMapper;

public class RefDistilleryStatusRowMapper implements RowMapper<RefDistilleryStatus> {
	@Override
	public RefDistilleryStatus mapRow(ResultSet rs, int line) throws SQLException {
		RefDistilleryStatusExtractor extractor = new RefDistilleryStatusExtractor();
		return extractor.extractData(rs);
	}
}
