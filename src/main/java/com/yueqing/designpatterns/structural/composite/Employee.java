package com.yueqing.designpatterns.structural.composite;

import lombok.Data;

/**
 * @author dingliming
 * @date 2022/7/22
 */
@Data
public class Employee implements SalaryResource {

    private Integer employeeId;

    private Double salary;

    public Employee(Integer employeeId, Double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        System.out.println("employeeId: "+employeeId);
        return salary;
    }
}
