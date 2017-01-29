package jp.otknoy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import jp.otknoy.dmm.SearchApi;

@Configuration()
public class Config {

    @Value("${dmm.apiId}")
    String apiId;

    @Value("${dmm.affiliateId}")
    String affiliateId;

    @Bean
    public SearchApi getSearchApi() {
	System.out.println(apiId);
	System.out.println(affiliateId);
	return new SearchApi(apiId, affiliateId);
    }
}
