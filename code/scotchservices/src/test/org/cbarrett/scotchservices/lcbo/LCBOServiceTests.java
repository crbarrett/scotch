package org.cbarrett.scotchservices.lcbo;

import org.cbarrett.scotchservices.LCBOService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/service-beans.xml"})
public class LCBOServiceTests {

    @Autowired
    private ApplicationContext applicationContext;
    
    //Datasets	/datasets
    @Test
    public void testStartDataset() throws Exception {
    	// get first page of datasets
        LCBOService lcbo = applicationContext.getBean(LCBOService.class);
    	String response = lcbo.getStartingDataset();

        //output fun
        System.out.println("Dataset : " + response);
    }
 }