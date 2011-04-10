package org.cbarrett.scotchservices.lcbo.domain;

import java.util.List;

import org.cbarrett.scotchservices.lcbo.domain.serializer.JsonDateTimeDeserializer;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.DateTime;

public class Dataset {
	private int id;
	private int totalProducts;
	private int totalStores;
	private int totalInventories;
	private int totalProductInventoryCount;
	private long totalProductInventoryVolumeInMilliliters;
	private long totalProductInventoryPriceInCents;
	
	private List<String> storeIds;
	private List<String> cspcIds;
	private List<String> addedProductIds;
	private List<String> addedStoreIds;
	private List<String> removedProductIds;
	private List<String> removedStoreIds;
	
	private DateTime createdAt;
	private DateTime updatedAt;
	
	private String csvDump;
	
//	    "id": 61,
//	    "total_products": 10362,
//	    "total_stores": 608,
//	    "total_inventories": 885908,
//	    "total_product_inventory_count": 19441802,
//	    "total_product_inventory_volume_in_milliliters": 16364143133,
//	    "total_product_inventory_price_in_cents": 28348549660,
//	    "store_ids": [],
//	    "product_ids": [],
//	    "added_product_ids": [],
//	    "added_store_ids": [],
//	    "removed_product_ids": [],
//	    "removed_store_ids": [],
//	    "created_at": "2011-03-05T03:43:13+00:00",
//	    "updated_at": "2011-03-05T06:02:33+00:00",
//	    "csv_dump": "http://static.lcboapi.com/datasets/61.zip"
	
	public int getId() {
		return id;
	}
	public int getTotalProducts() {
		return totalProducts;
	}
	public int getTotalStores() {
		return totalStores;
	}
	public int getTotalInventories() {
		return totalInventories;
	}
	public int getTotalProductInventoryCount() {
		return totalProductInventoryCount;
	}
	public long getTotalProductInventoryVolumeInMilliliters() {
		return totalProductInventoryVolumeInMilliliters;
	}
	public long getTotalProductInventoryPriceInCents() {
		return totalProductInventoryPriceInCents;
	}

	public List<String> getStoreIds() {
		return storeIds;
	}
	public List<String> getCspcIds() {
		return cspcIds;
	}
	public List<String> getAddedProductIds() {
		return addedProductIds;
	}
	public List<String> getAddedStoreIds() {
		return addedStoreIds;
	}
	public List<String> getRemovedProductIds() {
		return removedProductIds;
	}
	public List<String> getRemovedStoreIds() {
		return removedStoreIds;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}
	public DateTime getUpdatedAt() {
		return updatedAt;
	}
	public String getCsvDump() {
		return csvDump;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty("total_products")
	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}
	@JsonProperty("total_stores")
	public void setTotalStores(int totalStores) {
		this.totalStores = totalStores;
	}
	@JsonProperty("total_inventories")
	public void setTotalInventories(int totalInventories) {
		this.totalInventories = totalInventories;
	}
	@JsonProperty("total_product_inventory_count")
	public void setTotalProductInventoryCount(int totalProductInventoryCount) {
		this.totalProductInventoryCount = totalProductInventoryCount;
	}
	@JsonProperty("total_product_inventory_volume_in_milliliters")
	public void setTotalProductInventoryVolumeInMilliliters(
			long totalProductInventoryVolumeInMilliliters) {
		this.totalProductInventoryVolumeInMilliliters = totalProductInventoryVolumeInMilliliters;
	}
	@JsonProperty("total_product_inventory_price_in_cents")
	public void setTotalProductInventoryPriceInCents(
			long totalProductInventoryPriceInCents) {
		this.totalProductInventoryPriceInCents = totalProductInventoryPriceInCents;
	}

	@JsonProperty("store_ids")
	public void setStoreIds(List<String> storeIds) {
		this.storeIds = storeIds;
	}
	@JsonProperty("product_ids")
	public void setCspcIds(List<String> cspcIds) {
		this.cspcIds = cspcIds;
	}
	@JsonProperty("added_product_ids")
	public void setAddedProductIds(List<String> addedProductIds) {
		this.addedProductIds = addedProductIds;
	}
	@JsonProperty("added_store_ids")
	public void setAddedStoreIds(List<String> addedStoreIds) {
		this.addedStoreIds = addedStoreIds;
	}
	@JsonProperty("removed_product_ids")
	public void setRemovedProductIds(List<String> removedProductIds) {
		this.removedProductIds = removedProductIds;
	}
	@JsonProperty("removed_store_ids")
	public void setRemovedStoreIds(List<String> removedStoreIds) {
		this.removedStoreIds = removedStoreIds;
	}

	@JsonDeserialize(using = JsonDateTimeDeserializer.class)
	@JsonProperty("created_at")
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	@JsonDeserialize(using = JsonDateTimeDeserializer.class)
	@JsonProperty("updated_at")
	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty("csv_dump")
	public void setCsvDump(String csvDump) {
		this.csvDump = csvDump;
	}	
}
