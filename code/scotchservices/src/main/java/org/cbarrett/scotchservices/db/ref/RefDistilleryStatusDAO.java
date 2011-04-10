package org.cbarrett.scotchservices.db.ref;

import java.util.List;
import javax.sql.DataSource;

import org.cbarrett.scotchservices.domain.RefDistilleryStatus;

public interface RefDistilleryStatusDAO {

	void setDataSource(DataSource ds);

	List<RefDistilleryStatus> select(String statusName);
	List<RefDistilleryStatus> selectAll();
}
