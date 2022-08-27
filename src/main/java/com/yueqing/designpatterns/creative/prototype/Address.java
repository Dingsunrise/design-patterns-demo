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
public class Address implements Cloneable, Serializable {

    private String city;

    private String country;

    @Override
    protected Address clone() throws CloneNotSupportedException {

        //其他操作。。。
        return (Address)super.clone();
    }
}
