package com.yueqing.designpatterns.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dingliming
 * @date 2022/8/5
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Tree {

    private int height;

    private String color;

    private String name;
}
