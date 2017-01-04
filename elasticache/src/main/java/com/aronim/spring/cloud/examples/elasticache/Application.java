package com.aronim.spring.cloud.examples.elasticache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.aws.cache.config.annotation.CacheClusterConfig;
import org.springframework.cloud.aws.cache.config.annotation.EnableElastiCache;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.UUID;

/**
 * User: Kevin W. Sewell
 * Date: 2017-01-04
 * Time: 15h59
 */
@ComponentScan
@EnableCaching
@EnableElastiCache(@CacheClusterConfig(name = "oneclickmoment"))
@SpringBootApplication
@EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class}, excludeName = "GenericCacheConfiguration")
public class Application
{
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)
    {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class);

        Map<String, CachingConfigurer> beansOfType = applicationContext.getBeansOfType(CachingConfigurer.class);

        ExampleService exampleService = applicationContext.getBean(ExampleService.class);

        String key = UUID.randomUUID().toString();
        LOG.info("Bla: " + exampleService.bla(key));
        LOG.info("Bla: " + exampleService.bla(key));
    }

    @Configuration
    protected static class MyConfiguration
    {
        @Bean(name = "cacheManager")
        public CacheManager cacheManager(CachingConfigurer cachingConfigurer)
        {
            return cachingConfigurer.cacheManager();
        }
    }
}