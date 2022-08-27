package com.yueqing.designpatterns.structural.decorator.components;

/**
 * @author dingliming
 * @date 2022/7/18
 */
public class OriginalMilkTea implements IMilkTea{
    @Override
    public String teaName() {
        return "原味奶茶";
    }

    @Override
    public double cost() {
        return 10;
    }
}
