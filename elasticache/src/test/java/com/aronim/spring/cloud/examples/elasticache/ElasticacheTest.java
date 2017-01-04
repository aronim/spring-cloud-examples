package com.aronim.spring.cloud.examples.elasticache;

import com.amazonaws.services.elasticache.AmazonElastiCache;
import com.amazonaws.services.elasticache.AmazonElastiCacheClient;
import com.amazonaws.services.elasticache.model.DescribeCacheClustersRequest;
import com.amazonaws.services.elasticache.model.DescribeCacheClustersResult;
import org.junit.Test;

/**
 * User: Kevin W. Sewell
 * Date: 2017-01-04
 * Time: 16h50
 */
public class ElasticacheTest
{
    private AmazonElastiCache amazonElastiCache = new AmazonElastiCacheClient();

    @Test
    public void name() throws Exception
    {
        DescribeCacheClustersRequest describeCacheClustersRequest = new DescribeCacheClustersRequest()
                .withCacheClusterId("OneClickMoment");
        describeCacheClustersRequest.setShowCacheNodeInfo(true);

        DescribeCacheClustersResult describeCacheClustersResult
                = this.amazonElastiCache.describeCacheClusters(describeCacheClustersRequest);

        System.out.println();

    }
}
