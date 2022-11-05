package com.yueqing.designpatterns.creative.singleton;

import java.io.Serializable;

/**
 *
 * 匿名内部类
 *
 * @author dingliming
 * @date 2022/7/4
 */
public class InnerClassSingleton implements Serializable {

    private InnerClassSingleton(){
        if(getInstance()!=null){
            throw new RuntimeException("Permission denied");
        }
        System.out.println("init ");
    }

    public static InnerClassSingleton getInstance(){
        return InnerSingleton.getInnerClassSingleton();
    }

    public Object readResolve(){
        return getInstance();
    }

    private static class InnerSingleton{
        private static final InnerClassSingleton INNER_CLASS_SINGLETON = new InnerClassSingleton();

        public static InnerClassSingleton getInnerClassSingleton(){
            return INNER_CLASS_SINGLETON;
        }
    }

    public static void main(String[] args) throws Exception {
        SingletonTest.reflectTest(InnerClassSingleton.class,null);
        //SingletonTest.serializeTest(InnerClassSingleton.getInstance());
    }
}
