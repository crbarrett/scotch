package org.cbarrett.scotchservices;

public interface LCBOService {
	public String getStartingDataset();
	
	public void getMissingDatasets();
	public void getNewProductList();
	public void getProductDetails(String cspc);
	
	public void searchForProduct(String search);
	
	public void findStoresWithProduct(String cspc, String location);
	public void findStores(String location);
}
