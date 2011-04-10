package org.cbarrett.scotchservices.db.mapper.ref;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import org.cbarrett.scotchservices.domain.RefDistilleryStatus;

public class RefDistilleryStatusExtractor implements ResultSetExtractor<RefDistilleryStatus> {
	
	@Override
	public RefDistilleryStatus extractData(ResultSet rs) throws SQLException {
		RefDistilleryStatus status = new RefDistilleryStatus();
		status.setId(rs.getInt(1));
		status.setStatusName(rs.getString(2));
		status.setStatusDescription(rs.getString(3));
		return status;
	}
}