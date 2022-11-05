package com.yueqing.designpatterns.behavioral.strategy;

import com.yueqing.designpatterns.behavioral.strategy.price.JdOrderPrice;
import com.yueqing.designpatterns.behavioral.strategy.price.PxxOrderPrice;
import com.yueqing.designpatterns.behavioral.strategy.price.TmOrderPrice;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public enum OrderPriceEnum {

    TMOrder(TmOrderPrice.class.getSimpleName()),JdOrder(JdOrderPrice.class.getSimpleName()),PxxOrder(PxxOrderPrice.class.getSimpleName());

    private final String strategyName;

    OrderPriceEnum(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getStrategyName() {
        return strategyName;
    }
}
