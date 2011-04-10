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

import org.cbarrett.scotchservices.db.mapper.ref.RefStyleRowMapper;
import org.cbarrett.scotchservices.domain.RefStyle;

public class RefStyleDAOImpl implements RefStyleDAO{
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<RefStyle> select(String StyleName) {
		return this.jdbcTemplate.query(
						"select ID_REF_STYLE, STYLE_NAME, STYLE_DESCRIPTION from REF_STYLE where STYLE_NAME = ?",
						new RefStyleRowMapper(),
						new Object[] { StyleName });
	}

	public List<RefStyle> selectAll() {
		return this.jdbcTemplate.query("select ID_REF_STYLE, STYLE_NAME, STYLE_DESCRIPTION from REF_STYLE",
				new RefStyleRowMapper());
	}
}