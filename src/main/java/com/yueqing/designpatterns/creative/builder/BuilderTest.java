package com.yueqing.designpatterns.creative.builder;

/**
 * @author dingliming
 * @date 2022/8/1
 */
public class BuilderTest {

    public static void main(String[] args) {
        CacheConfig config = CacheConfig.CacheConfigBuilder.builder().withName("AAA")
                .withMaxSize(10).withTime(2).withIsAsyn(true).build();

        System.out.println(config);
    }
}
