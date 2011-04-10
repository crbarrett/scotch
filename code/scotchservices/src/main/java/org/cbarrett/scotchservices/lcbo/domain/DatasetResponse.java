package org.cbarrett.scotchservices.lcbo.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class DatasetResponse extends GenericLCBOResponse{
	private Dataset dataset;
	
	public Dataset getDataset() {
		return this.dataset;
	}
	
	@JsonProperty("result")
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}
}
