package com.yueqing.designpatterns.creative.builder;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import lombok.Data;

/**
 * @author dingliming
 * @date 2022/7/26
 */
@Data
public class CacheConfig {

    private String name;

    private long time;

    private TimeUnit unit;

    private int maxSize;

    private boolean isSyn;

    private boolean isAsyn;


    public static final class CacheConfigBuilder {
        private String name;
        private long time;
        private TimeUnit unit;
        private int maxSize;
        private boolean isSyn;
        private boolean isAsyn;

        private CacheConfigBuilder() {
        }

        public static CacheConfigBuilder builder() {
            return new CacheConfigBuilder();
        }

        public CacheConfigBuilder withName(String name) {
            if(StringUtils.isNotBlank(name)){
                this.name = name;
            }
            return this;
        }

        public CacheConfigBuilder withTime(long time) {
            this.time = time;
            return this;
        }

        public CacheConfigBuilder withUnit(TimeUnit unit) {
            this.unit = unit;
            return this;
        }

        public CacheConfigBuilder withMaxSize(int maxSize) {
            if(maxSize<100 ){
                maxSize = 100;
            }
            this.maxSize = maxSize;
            return this;
        }

        public CacheConfigBuilder withIsSyn(boolean isSyn) {
            this.isSyn = isSyn;
            this.isAsyn = !isSyn;
            return this;
        }

        public CacheConfigBuilder withIsAsyn(boolean isAsyn) {
            this.isAsyn = isAsyn;
            this.isSyn = !isAsyn;
            return this;
        }

        public CacheConfig build() {
            CacheConfig cacheConfig = new CacheConfig();
            cacheConfig.setName(name);
            if(StringUtils.isBlank(name)){
                return cacheConfig;
            }
            cacheConfig.setTime(time);
            if(time>0){
                cacheConfig.setUnit(unit);
            }
            cacheConfig.setMaxSize(maxSize);
            cacheConfig.isAsyn = this.isAsyn;
            cacheConfig.isSyn = this.isSyn;
            return cacheConfig;
        }
    }
}
