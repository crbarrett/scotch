package org.cbarrett.scotchservices.db.lcbo;

import javax.sql.DataSource;

import org.cbarrett.scotchservices.lcbo.domain.Product;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class LCBONewProductDAOImpl implements LCBONewProductDAO {
    private SimpleJdbcTemplate simpleJdbcTemplate;    
    private SimpleJdbcInsert insertDataset;
    
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.insertDataset = 
            new SimpleJdbcInsert(dataSource).withTableName("DATASET");    
	}

	public void save(Product product) {

	}
}
