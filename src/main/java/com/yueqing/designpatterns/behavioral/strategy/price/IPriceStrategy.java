package com.yueqing.designpatterns.behavioral.strategy.price;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public interface IPriceStrategy {

    double calculatePrice(double skuPrice);
}
