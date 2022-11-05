package com.yueqing.designpatterns.creative.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author dingliming
 * @date 2022/7/4
 */
public enum EnumSingleton {
    //单例
    SINGLETON;

    private AtomicLong id = new AtomicLong(0);

    public Long getId(){
        return id.getAndIncrement();
    }

    public static void main(String[] args) throws Exception {
        //Class<T> singleClass = (Class<T>) Class.forName(tClass.getName());
        //Constructor<T> declaredConstructor = singleClass.getDeclaredConstructor(String.class,int.class);
        //SingletonTest.reflectTest(EnumSingleton.class,null);
        SingletonTest.serializeTest(EnumSingleton.SINGLETON);
    }
}
