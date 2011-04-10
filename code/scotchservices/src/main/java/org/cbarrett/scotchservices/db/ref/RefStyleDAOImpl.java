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