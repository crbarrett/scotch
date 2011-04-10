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
package org.cbarrett.scotchservices.db.ref;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import org.cbarrett.scotchservices.db.mapper.ref.RefDistilleryStatusRowMapper;
import org.cbarrett.scotchservices.domain.RefDistilleryStatus;

public class RefDistilleryStatusDAOImpl implements RefDistilleryStatusDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<RefDistilleryStatus> select(String statusName) {
		return this.jdbcTemplate.query(
						"select ID_REF_DISTILLERY_STATUS, STATUS_NAME, STATUS_DESCRIPTION from REF_DISTILLERY_STATUS where STATUS_NAME = ?",
						new RefDistilleryStatusRowMapper(),
						new Object[] { statusName });
	}

	public List<RefDistilleryStatus> selectAll() {
		return this.jdbcTemplate.query("select ID_REF_DISTILLERY_STATUS, STATUS_NAME, STATUS_DESCRIPTION from REF_DISTILLERY_STATUS",
				new RefDistilleryStatusRowMapper());
	}
}