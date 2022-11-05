package com.yueqing.designpatterns.creative.singleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 *
 * @author dingliming
 * @date 2022/7/4
 */
public class HungrySingleton implements Serializable {

    private static final HungrySingleton HUNGRY_SINGLE = new HungrySingleton();

    /**
     * 防反射
     */
    private HungrySingleton() {
        if (null != HUNGRY_SINGLE) {
            //throw new RuntimeException("Permission denied");
        }
    }

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLE;
    }

    /**
     * 防序列化
     */
    private Object readResolve() {
        return HUNGRY_SINGLE;
    }

    public static void main(String[] args) throws Exception {
        SingletonTest.reflectTest(HungrySingleton.class,HungrySingleton.getInstance());
        SingletonTest.serializeTest(HungrySingleton.getInstance());
    }
}
