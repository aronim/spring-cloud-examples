package com.aronim.spring.cloud.examples.elasticache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2017-01-04
 * Time: 16h00
 */
@Service
public class ExampleServiceImpl implements ExampleService
{
    private static final Logger LOG = LoggerFactory.getLogger(ExampleServiceImpl.class);

    @Override
    @Cacheable(value = "mycache", cacheManager = "cacheManager")
    public String bla(String key)
    {
        LOG.info("Bla: " + key);

        return key + "-value";
    }
}
