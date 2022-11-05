package com.yueqing.designpatterns.structural.facade;

import com.yueqing.designpatterns.structural.facade.demo.IAccount;
import com.yueqing.designpatterns.structural.facade.demo.IInventory;
import com.yueqing.designpatterns.structural.facade.demo.IPoints;
import com.yueqing.designpatterns.structural.facade.demo.impl.AccountImpl;
import com.yueqing.designpatterns.structural.facade.demo.impl.InventoryImpl;
import com.yueqing.designpatterns.structural.facade.demo.impl.PointsImpl;

/**
 * @author dingliming
 * @date 2022/7/25
 */
public class OrderImpl implements IOrder{

    private IAccount account = new AccountImpl();
    private IInventory inventory = new InventoryImpl();
    private IPoints points = new PointsImpl();

    @Override
    public void createOrder() {
        System.out.println("create order");
        account.deductBalance();
        inventory.deducted();
        points.addPoints();
    }
}
