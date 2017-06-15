package jp.otknoy.av.search;

import jp.otknoy.av.search.items.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class DmmSearchService {
    private static final Logger logger = LoggerFactory.getLogger(DmmSearchService.class);

    private static String baseUrl = "https://api.dmm.com";

    @Value("${dmm.apiId}")
    private String apiId;

    @Value("${dmm.affiliateId}")
    private String affiliateId;

    public Response search(String keyword, int hits, int offset, String sort) {
        URI uri = UriComponentsBuilder.fromUriString(baseUrl)
                .path("/affiliate/v3/ItemList")
                .queryParam("api_id", apiId)
                .queryParam("affiliate_id", affiliateId)
                .queryParam("site", "DMM.R18")
                .queryParam("service", "digital")
                .queryParam("floor", "videoa")
                .queryParam("hits", String.valueOf(hits))
                .queryParam("offset", String.valueOf(offset))
                .queryParam("keyword", keyword)
                .queryParam("sort", sort)
                .build()
                .toUri();

        logger.info("http get: uri={}", uri);

        RestTemplate rt = new RestTemplate();
        Response res = null;
        try {
            res = rt.getForObject(uri, Response.class);
            logger.info("search successed");
        } catch (RestClientException e) {
            logger.info("search failed");
            e.printStackTrace();
        }

        return res;
    }

    public Response search(String keyword) {
        return search(keyword, 10, 1, "rank");
    }

}
