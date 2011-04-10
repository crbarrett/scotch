package org.cbarrett.scotchservices.db.ref;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import org.cbarrett.scotchservices.db.mapper.ref.RefRegionRowMapper;
import org.cbarrett.scotchservices.domain.RefRegion;

public class RefRegionDAOImpl implements RefRegionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<RefRegion> select(String regionName) {
		return this.jdbcTemplate.query(
						"select ID_REF_REGION, REGION_NAME, REGION_DESCRIPTION from REF_REGION where REGION_NAME = ?",
						new RefRegionRowMapper(),
						new Object[] { regionName });
	}

	public List<RefRegion> selectAll() {
		return this.jdbcTemplate.query("select ID_REF_REGION, REGION_NAME, REGION_DESCRIPTION from REF_REGION",
				new RefRegionRowMapper());
	}
}