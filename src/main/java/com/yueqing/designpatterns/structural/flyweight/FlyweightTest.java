package com.yueqing.designpatterns.structural.flyweight;

/**
 * @author dingliming
 * @date 2022/8/5
 */
public class FlyweightTest {

    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.addTree("cypress","red",10);
        forest.addTree("cypress","red",10);
        forest.addTree("cypress","red",10);
        forest.addTree("cypress","red",10);

        forest.addTree("pine","Purple",20);
        forest.addTree("pine","Purple",20);
        forest.addTree("pine","Purple",20);
        forest.addTree("poplar","white",30);
        forest.addTree("poplar","white",30);
        forest.addTree("poplar","white",30);
    }

}
