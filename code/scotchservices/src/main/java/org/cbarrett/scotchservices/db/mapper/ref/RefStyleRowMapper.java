package org.cbarrett.scotchservices.db.mapper.ref;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cbarrett.scotchservices.domain.RefStyle;

import org.springframework.jdbc.core.RowMapper;

public class RefStyleRowMapper implements RowMapper<RefStyle> {
	@Override
	public RefStyle mapRow(ResultSet rs, int line) throws SQLException {
		RefStyleExtractor extractor = new RefStyleExtractor();
		return extractor.extractData(rs);
	}
}
