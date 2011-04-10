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