package com.yueqing.designpatterns.creative.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author dingliming
 * @date 2022/7/4
 */
public class SingletonTest {

    public static <T> void reflectTest(Class<T> tClass,T t) throws Exception {
        Class<T> singleClass = (Class<T>) Class.forName(tClass.getName());
        Constructor<T> declaredConstructor = singleClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        T singleton1 = declaredConstructor.newInstance();
        T singleton2 = declaredConstructor.newInstance();

        System.out.println(t);
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println("reflect "+singleton1.equals(singleton2));

        //使用自定义类加载器进行加载
        MyClassLoader classLoader = new MyClassLoader("D:/Project/git/design-patterns/src/main/java/");
        Class<T> loadClass = (Class<T>) classLoader.loadClass(tClass.getName());
        Constructor<T> declaredConstructor2 = loadClass.getDeclaredConstructor(null);
        declaredConstructor2.setAccessible(true);
        T singleton3 = declaredConstructor2.newInstance();
        System.out.println(singleton3);
        System.out.println(singleton3.equals(singleton1));
    }



    public static <T> void serializeTest(T t) throws Exception {
        File file = new File("D:/a.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
             outputStream.writeObject(t);

            T singleton = (T) inputStream.readObject();
            System.out.println(t+"  "+singleton);
            System.out.println("serialize "+t.equals(singleton));
        }
    }
}
