package com.yueqing.designpatterns.structural.facade.demo.impl;

import com.yueqing.designpatterns.structural.facade.demo.IPoints;

/**
 * @author dingliming
 * @date 2022/7/25
 */
public class PointsImpl implements IPoints {

    @Override
    public void addPoints() {
        System.out.println("add points");
    }

    @Override
    public void deductPoints() {
        System.out.println("deduct points");
    }
}
