/**
 *  Copyright 2011 Chris Barrett
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.cbarrett.scotchservices.lcbo.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.cbarrett.scotchservices.lcbo.db.mapper.LCBOProductRowMapper;
import org.cbarrett.scotchservices.lcbo.domain.Product;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class LCBONewProductDAOImpl implements LCBONewProductDAO {
		
    static private Log _log = LogFactory.getLog("LCBONewProductDAOImpl");
		    
    private SimpleJdbcTemplate simpleJdbcTemplate;    
    private SimpleJdbcInsert insertDataset;
    
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.insertDataset = 
            new SimpleJdbcInsert(dataSource).withTableName("NEW_PRODUCTS");    
	}

	public void truncate() {
		this.simpleJdbcTemplate.getJdbcOperations().execute(
				"truncate table new_products");	
	}	
	
	public void add(Product product) {
        Map<String, Object> parameters = new HashMap<String, Object>(2);
        parameters.put("cspc", product.getId());
        parameters.put("name", product.getName());
        parameters.put("description", product.getDescription());
        
        try {
        	this.insertDataset.execute(parameters);
        } catch (DuplicateKeyException e) {
        	_log.info("Skipped duplicate entry; " + product.getId() + " (" + product.getName() + ")");
        }
	}
	
	public List<Product> selectAll() {
		return this.simpleJdbcTemplate.query("select CSPC, NAME, DESCRIPTION from NEW_PRODUCTS",
				new LCBOProductRowMapper());		
	}
	
}
