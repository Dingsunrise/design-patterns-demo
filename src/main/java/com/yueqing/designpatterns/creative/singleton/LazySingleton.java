package com.yueqing.designpatterns.creative.singleton;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 懒汉式单例
 *
 * @author dingliming
 * @date 2022/7/4
 */
public class LazySingleton implements Serializable {

    private static volatile LazySingleton lazySingleton;
    private static final Object OBJECT = new Object();

    private static final AtomicBoolean atomicBoolean = new AtomicBoolean();

    private LazySingleton() {
        if (!atomicBoolean.compareAndSet(false, true)) {
            throw new RuntimeException("Permission denied");
        }
        if (Objects.nonNull(lazySingleton)) {
            throw new RuntimeException("Permission denied");
        }
    }

    public static LazySingleton getInstance() {
        LazySingleton temp = lazySingleton;
        if (Objects.isNull(temp)) {
            synchronized (OBJECT) {
                temp = lazySingleton;
                if (Objects.isNull(temp)) {
                    temp = lazySingleton = new LazySingleton();
                }
            }
        }
        return temp;
    }

    /**
     * 防序列化
     */
    private Object readResolve() {
        return lazySingleton;
    }

    public static void main(String[] args) throws Exception {
        //SingletonTest.reflectTest(LazySingleton.class,null);
        SingletonTest.serializeTest(LazySingleton.getInstance());
    }
}
