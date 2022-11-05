package com.yueqing.designpatterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.yueqing.designpatterns.structural.decorator.components.IMilkTea;

/**
 * @author dingliming
 * @date 2022/7/20
 */
public class MilkTeaInvocationHandler implements InvocationHandler {

    private final IMilkTea milkTea;

    public MilkTeaInvocationHandler(IMilkTea milkTea) {
        this.milkTea = milkTea;
    }

    public static IMilkTea getMilkTea(IMilkTea milkTea) {
        return (IMilkTea) Proxy.newProxyInstance(milkTea.getClass().getClassLoader(), milkTea.getClass().getInterfaces(), new MilkTeaInvocationHandler(milkTea));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean isCost = method.getName().equals("cost");
        boolean isTeaName = method.getName().equals("teaName");
        if (isCost) {
            System.out.println("start cost");
        }
        if (isTeaName) {
            System.out.println("start get teaName");
        }
        Object invoke = method.invoke(milkTea, args);
        if (isCost) {
            System.out.println("cost end");
        }
        if (isTeaName) {
            System.out.println("get teaName end");
        }
        return invoke;
    }
}