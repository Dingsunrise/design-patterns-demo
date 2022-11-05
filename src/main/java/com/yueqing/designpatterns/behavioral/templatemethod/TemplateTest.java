package com.yueqing.designpatterns.behavioral.templatemethod;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class TemplateTest {

    public static void main(String[] args) {
       TmAbstractStartOrder startOrder = new TmAbstractStartOrder();
       startOrder.startOrder(7890L);

       JdAbstractStartOrder jdStartOrder = new JdAbstractStartOrder();
       jdStartOrder.startOrder(7890L);
    }
}
