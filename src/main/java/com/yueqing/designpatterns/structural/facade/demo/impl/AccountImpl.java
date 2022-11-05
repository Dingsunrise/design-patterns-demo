package com.yueqing.designpatterns.structural.facade.demo.impl;

import com.yueqing.designpatterns.structural.facade.demo.IAccount;

/**
 * @author dingliming
 * @date 2022/7/25
 */
public class AccountImpl implements IAccount {

   @Override
   public void deductBalance() {
      System.out.println("deduct balance");
   }

   @Override
   public void increaseBalance() {
      System.out.println("increase balance");
   }
}
