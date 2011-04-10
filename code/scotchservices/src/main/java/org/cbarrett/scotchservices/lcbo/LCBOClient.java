package org.cbarrett.scotchservices.lcbo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.cbarrett.scotchservices.lcbo.domain.Dataset;
import org.cbarrett.scotchservices.lcbo.domain.DatasetResponse;
import org.cbarrett.scotchservices.lcbo.domain.DatasetsResponse;
import org.cbarrett.scotchservices.lcbo.domain.Product;
import org.cbarrett.scotchservices.lcbo.domain.ProductResponse;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class LCBOClient {
    private final RestTemplate restTemplate;
    
    private static final String baseURL = "http://lcboapi.com/";
    private static final String datasetsServ = "datasets";
    private static final String productServ = "products";
     
    public LCBOClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        CommonsClientHttpRequestFactory factory = (CommonsClientHttpRequestFactory) restTemplate.getRequestFactory();
		HttpClient client = factory.getHttpClient();
        
        client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
        client.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        client.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        client.getParams().setParameter("http.useragent", "scotch-services");
    }
    
    public List<Dataset> getDatasetsFirstPage() {
        DatasetsResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ, DatasetsResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp.getPageOfDatasets();  	
    }
    public Dataset getDatasetsByPage(int page) {
        DatasetResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ + "/" + Integer.valueOf(page).toString(), DatasetResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp.getDataset();  	
    }

    public Dataset getDataset(int dataset) {
        DatasetResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ + "/" + Integer.valueOf(dataset).toString(), DatasetResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp.getDataset();  	
    }
    
    public DatasetsResponse getTodaysNewProducts() {
        DatasetsResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ + "/1", DatasetsResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp;
    }
    public DatasetsResponse getTodaysRemovedProducts() {
        DatasetsResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ + "/1", DatasetsResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp;
    }
    
    public Product getProduct(String cspc) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("cspc", cspc);
        
        ProductResponse resp = restTemplate.getForObject(baseURL + "/" + productServ + "/{cspc}", ProductResponse.class, vars);
        checkStatus(resp.getStatus(), resp.getMessage());

        return resp.getProduct();
    }

    private void checkStatus(int status, String message) {
        if (!(status >= 200 && status < 300)) {
            new HttpException(((message != null) ? message : "Received error") + " : " + status);
        }
    }    
}
