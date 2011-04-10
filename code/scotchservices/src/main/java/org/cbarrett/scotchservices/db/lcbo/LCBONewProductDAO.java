package org.cbarrett.scotchservices.db.lcbo;

import javax.sql.DataSource;

import org.cbarrett.scotchservices.lcbo.domain.Product;

public interface LCBONewProductDAO {
	void setDataSource(DataSource ds);
	
	void save(Product product);
}
