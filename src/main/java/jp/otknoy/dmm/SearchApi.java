package jp.otknoy.dmm;

import java.util.List;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.HashMap;
import java.net.URI;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;

import jp.otknoy.dmm.Response;
import jp.otknoy.dmm.Item;

public class SearchApi {

    private static String baseUrl = "https://api.dmm.com";

    private String apiId;
    private String affiliateId;
    private String site;

    public SearchApi(String apiId, String affiliateId, String site) {
	this.apiId = apiId;
	this.affiliateId = affiliateId;
	this.site = site;
    }

    public SearchApi(String apiId, String affiliateId) {
	this(apiId, affiliateId, "DMM.R18");
    }

    public Response search(String keyword, int hits, int offset, String sort) {
	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

	URI uri = UriComponentsBuilder.fromUriString(this.baseUrl)
	    .path("/affiliate/v3/ItemList")
	    .queryParam("api_id", this.apiId)
	    .queryParam("affiliate_id", this.affiliateId)
	    .queryParam("site", this.site)
	    .queryParam("keyword", keyword)
	    .queryParam("hits", String.valueOf(hits))
	    .queryParam("offset", String.valueOf(offset))
	    .queryParam("sort", sort)
	    .build()
	    .toUri();

	RestTemplate rt = new RestTemplate();
	Response response = null;
	try {
	    response = rt.getForObject(uri, Response.class);
	} catch (org.springframework.web.client.HttpClientErrorException e) {
	    e.printStackTrace();
	}

	return response;
    }

    public Response search(String keyword) {
	return search(keyword, 10, 1, "rank");
    }
}
