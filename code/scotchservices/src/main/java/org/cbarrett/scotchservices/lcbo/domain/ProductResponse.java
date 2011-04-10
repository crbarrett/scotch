package org.cbarrett.scotchservices.lcbo.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class ProductResponse extends GenericLCBOResponse {
	private Product product;
	
	public Product getProduct() {
		return this.product;
	}
	
	@JsonProperty("result")
	public void setProduct(Product product) {
		this.product= product;
	}
}
