package com.yueqing.designpatterns.behavioral.strategy.price;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public class PxxOrderPrice implements IPriceStrategy {
    @Override
    public double calculatePrice(double skuPrice) {
        return skuPrice * 0.3;
    }
}
