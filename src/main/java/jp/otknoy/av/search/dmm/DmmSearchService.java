package jp.otknoy.av.search.dmm;

import jp.otknoy.av.search.dmm.item.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class DmmSearchService {
    private static String baseUrl = "https://api.dmm.com";

    @Value("${dmm.api_id}")
    private String apiId;

    @Value("${dmm.affiliate_id}")
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
        log.info("http get: uri={}", uri.toString());

        RestTemplate rt = new RestTemplate();
        Response res = null;
        try {
            res = rt.getForObject(uri, Response.class);
            log.info("search success");
        } catch (RestClientException e) {
            log.info("search failed");
            e.printStackTrace();
        }

        return res;
    }

    public Response search(String keyword) {
        return search(keyword, 10, 1, "rank");
    }

}
