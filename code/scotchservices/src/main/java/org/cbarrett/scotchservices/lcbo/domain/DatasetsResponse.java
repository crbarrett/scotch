package org.cbarrett.scotchservices.lcbo.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DatasetsResponse extends GenericLCBOResponse {
	private Pager pager;
	private List<Dataset> pageOfDatasets;
	
	public Pager getPager() {
		return this.pager;
	}
	public List<Dataset> getPageOfDatasets() {
		return this.pageOfDatasets;
	}
	
	@JsonProperty("pager")
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	@JsonProperty("result")
	public void setDatasets(List<Dataset> datasets) {
		this.pageOfDatasets = datasets;
	}
}
