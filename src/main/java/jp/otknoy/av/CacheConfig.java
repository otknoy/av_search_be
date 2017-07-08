package jp.otknoy.av;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Bean
    @Autowired
    public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setUsePrefix(true);
        cacheManager.setDefaultExpiration(new Long(60));

        Map<String, Long> expires = new HashMap<>();
        expires.put("searchItems", new Long(60 * 60 * 24));
        cacheManager.setExpires(expires);

        return cacheManager;

    }
}
