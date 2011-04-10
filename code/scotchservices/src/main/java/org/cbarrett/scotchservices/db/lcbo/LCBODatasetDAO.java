package org.cbarrett.scotchservices.db.lcbo;

import java.util.List;

import javax.sql.DataSource;

import org.cbarrett.scotchservices.lcbo.domain.Dataset;

public interface LCBODatasetDAO {
	void setDataSource(DataSource ds);

	void truncate();
	void add(Dataset dataset);
	
	List<Dataset> select(int id);
	List<Dataset> selectAll();
	
	int delete(int id);
	
	int getMaxId();
}
