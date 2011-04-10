package org.cbarrett.scotchservices.lcbo;

import org.cbarrett.scotchservices.db.lcbo.LCBODatasetDAO;
import org.cbarrett.scotchservices.db.lcbo.LCBODatasetDAOImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/lcbo-dao.xml")
public class LCBODBTests {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Test
	public void testFirstDataset() throws Exception {
    	LCBODatasetDAO lcboDatasetDAO = applicationContext.getBean(LCBODatasetDAOImpl.class);
    	
    	lcboDatasetDAO.truncate();

    	// count the rows
    }
  }