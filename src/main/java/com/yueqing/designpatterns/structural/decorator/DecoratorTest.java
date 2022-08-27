package com.yueqing.designpatterns.structural.decorator;

import com.yueqing.designpatterns.structural.decorator.components.IMilkTea;
import com.yueqing.designpatterns.structural.decorator.components.OriginalMilkTea;

/**
 * @author dingliming
 * @date 2022/7/19
 */
public class DecoratorTest {

    public static void main(String[] args) {
        OriginalMilkTea originalMilkTea = new OriginalMilkTea();
        IMilkTea milkTea = new CoconutFruitMilkTea(new RedBeansMilkTea(new PearlMilkTea(originalMilkTea)));
        System.out.println(milkTea.teaName()+" cost:"+milkTea.cost());
    }
}
