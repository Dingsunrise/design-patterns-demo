package com.yueqing.designpatterns.structural.composite;

import com.google.common.collect.Lists;

/**
 * @author dingliming
 * @date 2022/7/22
 */
public class CombinationTest {

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

        //System.out.println(category.calculateScore());


        Employee employee = new Employee(100001,2345.56);
        Employee employee1 = new Employee(10002,23545.99);
        Employee employee2 = new Employee(10003,8954.23);
        Employee employee3 = new Employee(11011,5623.05);
        Employee employee4 = new Employee(11012,65412.03);
        Employee employee5 = new Employee(20001,6542.32);
        Employee employee6 = new Employee(21003,6845.23);
        Employee employee7 = new Employee(40001,9856.23);

        Department department = new Department(10000);
        Department department1 = new Department(11000);
        Department department2 = new Department(20000);
        Department department3 = new Department(21000);
        Department department4 = new Department(40000);

        department4.setSubResources(Lists.newArrayList(employee7));
        department3.setSubResources(Lists.newArrayList(employee6));
        department2.setSubResources(Lists.newArrayList(department3,employee5));
        department1.setSubResources(Lists.newArrayList(employee3,employee4));
        department.setSubResources(Lists.newArrayList(employee,employee1,employee2,department1));

        System.out.println(department.calculateSalary());
    }

}
