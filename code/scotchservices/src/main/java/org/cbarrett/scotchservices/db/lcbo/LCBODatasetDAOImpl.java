package org.cbarrett.scotchservices.db.lcbo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.cbarrett.scotchservices.db.mapper.lcbo.LCBODatasetRowMapper;
import org.cbarrett.scotchservices.lcbo.domain.Dataset;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class LCBODatasetDAOImpl implements LCBODatasetDAO {
    private SimpleJdbcTemplate simpleJdbcTemplate;    
    private SimpleJdbcInsert insertDataset;
    
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.insertDataset = 
            new SimpleJdbcInsert(dataSource).withTableName("DATASET");    
	}

	public void truncate() {
		this.simpleJdbcTemplate.getJdbcOperations().execute(
				"truncate table DATASET");	
	}	
	public void add(Dataset ds) {
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("id_dataset", ds.getId());
        parameters.put("total_products", ds.getTotalProducts());
        parameters.put("total_stores", ds.getTotalStores());
        parameters.put("csv_location", ds.getCsvDump());
        
        this.insertDataset.execute(parameters);	
	}

	public int delete(int id) {
		return this.simpleJdbcTemplate.update("delete from DATASET where ID = ?",
				new Object[] { id }, Integer.class );
		
	}
	
	public List<Dataset> select(int id) {
		return this.simpleJdbcTemplate.query(
				"select ID_DATASET, CSV_LOCATION from DATASET where ID = ?",
				new LCBODatasetRowMapper(),
				new Object[] { id }, Integer.class);
	}
	public List<Dataset> selectAll() {
		return this.simpleJdbcTemplate.query("select ID_REF_DISTILLERY_STATUS, STATUS_NAME, STATUS_DESCRIPTION from REF_DISTILLERY_STATUS",
				new LCBODatasetRowMapper());		
	}
	public int getMaxId() {
		return this.simpleJdbcTemplate.queryForInt("select max(ID_DATASET) from DATASET");
	}
}
