package com.yueqing.designpatterns.behavioral.iterator;

/**
 * @author dingliming
 * @date 2022/8/7
 */
public class IteratorTest {

    public static void main(String[] args) {
        Category category = new Category(1000L,"category1",100);
        Category category2 = new Category(1010L,"category2",99);
        Category category3 = new Category(1020L,"category3",88);
        Category category4 = new Category(1030L,"category4",56);
        Category category5 = new Category(1011L,"category5",64);
        Category category6 = new Category(1012L,"category6",32);
        Category category7 = new Category(1021L,"category7",52);
        Category category8 = new Category(1023L,"category8",16);

        category2.addChild(category5);
        category2.addChild(category6);
        category3.addChild(category7);
        category3.addChild(category8);
        category.addChild(category2);
        category.addChild(category3);
        category.addChild(category4);

        Iterator iterator = category.iterator();
        while (iterator.hasNext()){
            final Category next = iterator.next();
            if(next.getCode()==1030){
                iterator.remove();
            }else {
                System.out.println(next);
            }
        }
    }
    
}
