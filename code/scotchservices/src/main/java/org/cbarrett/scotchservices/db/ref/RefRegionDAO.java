package org.cbarrett.scotchservices.db.ref;

import java.util.List;
import javax.sql.DataSource;

import org.cbarrett.scotchservices.domain.RefRegion;

public interface RefRegionDAO {

	void setDataSource(DataSource ds);

	List<RefRegion> select(String regionName);
	List<RefRegion> selectAll();
}
