package com.yueqing.designpatterns.structural.decorator;

import com.yueqing.designpatterns.structural.decorator.components.IMilkTea;

/**
 * @author dingliming
 * @date 2022/7/18
 */
public class PearlMilkTea implements IMilkTea {

    private final IMilkTea milkTea;

    public PearlMilkTea(IMilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public String teaName() {
        return "珍珠"+milkTea.teaName();
    }

    @Override
    public double cost() {
        return milkTea.cost() + 1.5;
    }
}
