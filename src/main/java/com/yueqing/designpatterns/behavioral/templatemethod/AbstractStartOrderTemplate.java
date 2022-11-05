package com.yueqing.designpatterns.behavioral.templatemethod;

import com.yueqing.example.Commodity;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public abstract class AbstractStartOrderTemplate {

    final public void startOrder(Long commodityId) {
        Commodity commodity = getCommodityById(commodityId);
        double price = calculatePrice(commodity.getPrice());
        debit(price);
        ship(commodity);
        //钩子函数
        if (isLog()) {
            System.out.println(commodityId + " has been ordered!");
        }
    }

    protected abstract double calculatePrice(double price);

    protected abstract void ship(Commodity commodity);

    protected boolean isLog() {
        return false;
    }

    private Commodity getCommodityById(Long commodityId) {
        return new Commodity(commodityId, "Time Machine", 789.99);
    }

    private void debit(double price) {
        System.out.println("Account debited $" + price);
    }
}
