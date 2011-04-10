package org.cbarrett.scotchservices.db.ref;

import java.util.List;
import javax.sql.DataSource;

import org.cbarrett.scotchservices.domain.RefStyle;

public interface RefStyleDAO {

	void setDataSource(DataSource ds);

	List<RefStyle> select(String styleName);
	List<RefStyle> selectAll();
}
