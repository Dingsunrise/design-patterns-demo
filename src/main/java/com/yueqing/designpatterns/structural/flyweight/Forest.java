package com.yueqing.designpatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingliming
 * @date 2022/8/5
 */
public class Forest {
    private String name;
    private final List<Tree> trees = new ArrayList<>();

    public void addTree(String name, String color, int height) {
        trees.add(TreeFactory.getTree(name, color, height));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tree> getTrees() {
        return trees;
    }
}
