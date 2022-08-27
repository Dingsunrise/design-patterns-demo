package com.yueqing.designpatterns.structural.proxy;

import com.yueqing.designpatterns.structural.decorator.CoconutFruitMilkTea;
import com.yueqing.designpatterns.structural.decorator.PearlMilkTea;
import com.yueqing.designpatterns.structural.decorator.RedBeansMilkTea;
import com.yueqing.designpatterns.structural.decorator.components.IMilkTea;
import com.yueqing.designpatterns.structural.decorator.components.OriginalMilkTea;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class ProxyTest {

    public static void main(String[] args) {

        OriginalMilkTea originalMilkTea = new OriginalMilkTea();
        IMilkTea coconutFruitMilkTea = new CoconutFruitMilkTea(new RedBeansMilkTea(new PearlMilkTea(originalMilkTea)));
        IMilkTea milkTea = new MilkTeaProxy(coconutFruitMilkTea);
        System.out.println(milkTea.teaName() + " cost:" + milkTea.cost());

        //此参数用来输出生成的动态代理文件，默认输出路径，当前工作空间下工作空间下的 com\sun\proxy 目录中
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IMilkTea milkTea2 = MilkTeaInvocationHandler.getMilkTea(coconutFruitMilkTea);
        System.out.println(milkTea2.teaName() + " cost:" + milkTea2.cost());
    }
}
