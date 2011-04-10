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
