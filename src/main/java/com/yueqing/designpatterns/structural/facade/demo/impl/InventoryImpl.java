package com.yueqing.designpatterns.structural.facade.demo.impl;

import com.yueqing.designpatterns.structural.facade.demo.IInventory;

/**
 * @author dingliming
 * @date 2022/7/25
 */
public class InventoryImpl implements IInventory {

    @Override
    public void deducted() {
        System.out.println("deduct inventory");
    }

    @Override
    public void increase() {
        System.out.println("increase inventory");
    }
}
