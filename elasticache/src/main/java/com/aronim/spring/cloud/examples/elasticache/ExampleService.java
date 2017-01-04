package com.aronim.spring.cloud.examples.elasticache;

import org.springframework.cache.annotation.Cacheable;

/**
 * User: Kevin W. Sewell
 * Date: 2017-01-04
 * Time: 16h00
 */
public interface ExampleService
{
    @Cacheable("OneClickMoment-Cache")
    String bla(String key);
}
