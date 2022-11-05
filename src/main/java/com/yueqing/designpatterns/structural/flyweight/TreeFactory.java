package com.yueqing.designpatterns.structural.flyweight;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author dingliming
 * @date 2022/8/5
 */
public class TreeFactory {

    public static final Set<Tree> TREE_SET = new HashSet<>();

    public static Tree getTree(String name, String color, int height) {
        Tree tree = new Tree(height, color, name);
        Optional<Tree> optional = TREE_SET.stream().filter(o -> o.equals(tree)).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        TREE_SET.add(tree);
        return tree;
    }

}
