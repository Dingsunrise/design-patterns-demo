package com.yueqing.designpatterns.structural.decorator;

import com.yueqing.designpatterns.structural.decorator.components.IMilkTea;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public class RedBeansMilkTea implements IMilkTea {

    private final IMilkTea milkTea;

    public RedBeansMilkTea(IMilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public String teaName() {
        return "红豆"+milkTea.teaName();
    }

    @Override
    public double cost() {
        return milkTea.cost() + 1.5;
    }
}