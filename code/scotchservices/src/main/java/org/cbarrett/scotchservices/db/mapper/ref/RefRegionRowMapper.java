package org.cbarrett.scotchservices.db.mapper.ref;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cbarrett.scotchservices.domain.RefRegion;
import org.springframework.jdbc.core.RowMapper;

public class RefRegionRowMapper implements RowMapper<RefRegion> {
	@Override
	public RefRegion mapRow(ResultSet rs, int line) throws SQLException {
		RefRegionExtractor extractor = new RefRegionExtractor();
		return extractor.extractData(rs);
	}
}
