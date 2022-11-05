package com.yueqing.designpatterns.behavioral.templatemethod;

import com.yueqing.designpatterns.behavioral.strategy.OrderPriceEnum;
import com.yueqing.designpatterns.behavioral.strategy.PriceStrategyFactory;
import com.yueqing.example.Commodity;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class PxxAbstractStartOrder extends AbstractStartOrderTemplate {

    @Override
    protected double calculatePrice(double price) {
        return PriceStrategyFactory.getPriceStrategy(OrderPriceEnum.PxxOrder).calculatePrice(price);
    }

    @Override
    protected void ship(Commodity commodity) {
        System.out.println("The "+commodity.getName()+" has been shipped by Pxx Express");
    }
}
