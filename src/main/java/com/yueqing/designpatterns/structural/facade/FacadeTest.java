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
public class FacadeTest {


    public static void main(String[] args) {

        IAccount account = new AccountImpl();
        account.deductBalance();
        IInventory inventory = new InventoryImpl();
        inventory.deducted();
        IPoints points = new PointsImpl();
        points.addPoints();


        //门面
        IOrder order = new OrderImpl();
        order.createOrder();
    }

}
