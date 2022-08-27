package com.yueqing.designpatterns.creative.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public class CopyPrototype {

    /**
     * 浅拷贝，复制基本类型数据
     *
     * @param prototype 源数据
     * @return 复制数据
     * @throws CloneNotSupportedException
     */
    public static Prototype shallowCopyByClone(Prototype prototype) throws CloneNotSupportedException {
        return prototype.clone();
    }

    /**
     * 浅拷贝，复制基本类型数据
     *
     * @param prototype 源数据
     * @return 复制数据
     */
    public static Prototype shallowCopyByCglib(Prototype prototype) {
        Prototype copy = new Prototype();
        //cglib的beanCopier 性能很快，但是不支持名称相同类型不同的参数，以及get和set不匹配的属性,如果需要支持，需要字节实现Converter
        BeanCopier beanCopier = BeanCopier.create(Prototype.class, Prototype.class, false);
        beanCopier.copy(prototype, copy, null);
        return copy;
    }

    public static Prototype shallowCopyBySpringBeanUtils(Prototype prototype) {
        Prototype copy = new Prototype();
        BeanUtils.copyProperties(prototype, copy);
        return copy;
    }


    /**
     * 通过序列化实现深拷贝
     * <p>
     * 必要条件： 原类及属性中的类 都需要强制实现Serializable 接口
     */
    public static Prototype deepCopyWithSerializable(Prototype source) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(source);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);

        return (Prototype) oi.readObject();
    }

    /**
     * 通过序列化实现深拷贝
     * <p>
     * 必要条件： 原类及属性中的类  需要有无参构造器
     */
    public static Prototype deepCopyWithJson(Prototype source) throws JsonProcessingException {
        //需要无参构造器
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(objectMapper.writeValueAsString(source), Prototype.class);
    }

    /**
     * 使用Dozer 深拷贝
     * <p>
     * 目前发现，如果有File属性，无法复制
     */
    public static Prototype deepCopyWithDozer(Prototype source) {
        //不能复制file
        return DozerBeanMapperBuilder.buildDefault().map(source, Prototype.class);
    }

    public static void main(String[] args) throws Exception {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 76};
        File file = new File("D:/test.txt");

        Address address = new Address("tianhai", "China");
        Prototype prototype = new Prototype(1, "source", bytes, new Prototype.Inner(1000L), address);

        Prototype shallowCopy = shallowCopyByClone(prototype);
        Prototype copyByCglib = shallowCopyByCglib(prototype);
        Prototype copyBySpringBeanUtils = shallowCopyBySpringBeanUtils(prototype);

        Prototype deepCopyWithSerializable = deepCopyWithSerializable(prototype);
        Prototype deepCopyWithJson = deepCopyWithJson(prototype);
        Prototype deepCopyWithDozer = deepCopyWithDozer(prototype);

        prototype.setName("copy");
        //prototype.setFile(new File("D:/textCopy.txt"));
        prototype.setAddress(new Address("Tianxia", "China"));
        address.setCity("haitian");

        System.out.println(shallowCopy);
        System.out.println(copyByCglib);
        System.out.println(copyBySpringBeanUtils);

        System.out.println(deepCopyWithSerializable);
        System.out.println(deepCopyWithJson);
        System.out.println(deepCopyWithDozer);
    }
}
