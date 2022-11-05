package com.yueqing.designpatterns.creative.prototype;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.StringJoiner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dingliming
 * @date 2022/7/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prototype implements Cloneable, Serializable {

    private Integer id;

    private String name;

    private byte[] bytes;

    //private File file;

    private Inner inner;

    private Address address;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Inner implements Serializable{
        private Long id;
    }

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        Prototype prototypeCopy = (Prototype) super.clone();
        //深copy 需要重写 clone方法
        //Address addressCopy = address.clone();
        //prototypeCopy.setAddress(addressCopy);
        return prototypeCopy;
    }
}
