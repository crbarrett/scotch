package org.cbarrett.scotchservices.db.mapper.lcbo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cbarrett.scotchservices.lcbo.domain.Dataset;
import org.springframework.jdbc.core.ResultSetExtractor;

public class LCBODatasetExtractor implements ResultSetExtractor<Dataset> {
	@Override
	public Dataset extractData(ResultSet rs) throws SQLException {
		Dataset ds = new Dataset();
		ds.setId(rs.getInt(1));
		ds.setCsvDump(rs.getString(2));
		return ds;
	}
}
