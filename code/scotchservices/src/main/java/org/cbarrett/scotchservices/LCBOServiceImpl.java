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
package org.cbarrett.scotchservices;

import java.util.List;

import org.cbarrett.scotchservices.lcbo.LCBOClient;
import org.cbarrett.scotchservices.lcbo.db.LCBODatasetDAO;
import org.cbarrett.scotchservices.lcbo.db.LCBONewProductDAO;
import org.cbarrett.scotchservices.lcbo.domain.Dataset;
import org.cbarrett.scotchservices.lcbo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LCBOServiceImpl implements LCBOService {
	
	@Autowired
	LCBOClient lcboClient;
	
	@Autowired
	private LCBODatasetDAO lcboDatasetDAO;
	@Autowired
	private LCBONewProductDAO lcboNewProductDAO;
	
	public String getStartingDataset() {
		// drop the current lcbo dataset content
		lcboDatasetDAO.truncate();
		
		// find newest dataset (all, but paged)
		List<Dataset> ds = lcboClient.getDatasetsFirstPage();
				
		//TODO needed? retrieve current dataset
		//Dataset missingDs = lcboClient.getDataset(ds.get(0).getId());

		// store latest
		lcboDatasetDAO.add(ds.get(0));
		
		return ds.get(0).toString();
	}
	
	public void getMissingDatasets() {
		// find newest dataset (all, but paged)
		List<Dataset> ds = lcboClient.getDatasetsFirstPage();
		
		// current latest dataset
		int currentDsId = ds.get(0).getId();
		int maxStoredDsId = lcboDatasetDAO.getMaxId();
		
		// retrieve missing datasets (or start with latest)
		if (maxStoredDsId != -1) {
			for (int i = currentDsId - 1; i > maxStoredDsId; i++) {
				Dataset missingDs = lcboClient.getDataset(i);
				
				List<String> cspcList = missingDs.getAddedProductIds();
				int newProductCount = cspcList.size();
				// fetch new product info
				for (int j = 0; j < newProductCount; j++) {
					String currentCspc = cspcList.get(j);
					Product currentProduct = lcboClient.getProduct(currentCspc);
					
					// save new product
					lcboNewProductDAO.save(currentProduct);
				}
			}
		}
	}

	public void getNewProductList() {
		
	}
	public void getProductDetails(String cspc) {
		
	}
	
	public void searchForProduct(String search) {
		
	}
	
	public void findStoresWithProduct(String cspc, String location) {
		
	}
	public void findStores(String location) {
		
	}

}