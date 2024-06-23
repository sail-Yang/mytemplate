package org.example.admin.common.config;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangfan
 * @version 1.0
 * @description: 配置布隆过滤器
 * @date 2024/6/23 11:53
 */
@Configuration(value="rBloomFilterConfigurationByAdmin")
public class RBloomFilterConfiguration {
    /**
     * 防止用户注册查询数据库的布隆过滤器
     */
    @Bean
    public RBloomFilter<String> userRegisterCachePenetrationBloomFilter(RedissonClient redissonClient) {
        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter("userRegisterCachePenetrationBloomFilter");
        //初始化布隆过滤器容量
        cachePenetrationBloomFilter.tryInit(1000000L, 0.001);
        return cachePenetrationBloomFilter;
    }

}
