package com.yueqing.designpatterns.structural.composite;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import lombok.Data;

/**
 * @author dingliming
 * @date 2022/7/22
 */
@Data
public class Department implements SalaryResource {

    private Integer departmentId;

    private Double salary;

    private List<SalaryResource> subResources;

    public Department(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public double calculateSalary() {
        System.out.println("departmentId: "+departmentId);
        if(CollectionUtils.isEmpty(subResources)){
            return 0;
        }
        double totalSalary = 0;
        for (SalaryResource subResource : subResources) {
            totalSalary+=subResource.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }
}
