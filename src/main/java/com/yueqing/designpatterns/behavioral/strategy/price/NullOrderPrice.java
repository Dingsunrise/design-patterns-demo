package com.yueqing.designpatterns.behavioral.strategy.price;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public class NullOrderPrice implements IPriceStrategy {
    @Override
    public double calculatePrice(double skuPrice) {
        return skuPrice;
    }
}
