package org.cbarrett.scotchservices.db.mapper.ref;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import org.cbarrett.scotchservices.domain.RefStyle;

public class RefStyleExtractor implements ResultSetExtractor<RefStyle> {
	
	@Override
	public RefStyle extractData(ResultSet rs) throws SQLException {
		RefStyle style = new RefStyle();
		style.setId(rs.getInt(1));
		style.setStyleName(rs.getString(2));
		style.setStyleDescription(rs.getString(3));
		return style;
	}
}