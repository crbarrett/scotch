package org.cbarrett.scotchservices.db.mapper.lcbo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cbarrett.scotchservices.lcbo.domain.Dataset;
import org.springframework.jdbc.core.RowMapper;

public class LCBODatasetRowMapper implements RowMapper<Dataset> {
	@Override
	public Dataset mapRow(ResultSet rs, int line) throws SQLException {
		LCBODatasetExtractor extractor = new LCBODatasetExtractor();
		return extractor.extractData(rs);
	}
}
