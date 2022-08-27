package com.yueqing.designpatterns.structural.decorator.components;

/**
 * @author dingliming
 * @date 2022/7/18
 */
public class MatchaMilkTea implements IMilkTea{
    @Override
    public String teaName() {
        return "抹茶奶茶";
    }

    @Override
    public double cost() {
        return 13;
    }
}
