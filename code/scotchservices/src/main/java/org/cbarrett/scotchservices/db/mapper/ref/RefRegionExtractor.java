package org.cbarrett.scotchservices.db.mapper.ref;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import org.cbarrett.scotchservices.domain.RefRegion;

public class RefRegionExtractor implements ResultSetExtractor<RefRegion> {
	
	@Override
	public RefRegion extractData(ResultSet rs) throws SQLException {
		RefRegion region = new RefRegion();
		region.setId(rs.getInt(1));
		region.setRegionName(rs.getString(2));
		region.setRegionDescription(rs.getString(3));
		return region;
	}
}