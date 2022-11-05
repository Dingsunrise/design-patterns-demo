package com.yueqing.designpatterns.behavioral.strategy.price;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public class TmOrderPrice implements IPriceStrategy {
    @Override
    public double calculatePrice(double skuPrice) {
        return skuPrice * 1.1;
    }
}
