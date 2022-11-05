package com.yueqing.designpatterns.structural.proxy;

import com.yueqing.designpatterns.structural.decorator.components.IMilkTea;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class MilkTeaProxy implements IMilkTea {

    private IMilkTea milkTea;

    public MilkTeaProxy(IMilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public String teaName() {
        System.out.println("start get teaName");
        String teaName = milkTea.teaName();
        System.out.println("get teaName end");
        return teaName;
    }

    @Override
    public double cost() {
        System.out.println("start cost");
        double cost = milkTea.cost();
        System.out.println("cost end");
        return cost;
    }
}
