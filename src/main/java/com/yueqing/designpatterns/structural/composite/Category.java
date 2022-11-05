package com.yueqing.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dingliming
 * @date 2022/7/20
 */
@Data
@NoArgsConstructor
public class Category{

    private Long code;

    private String name;

    private int score;

    private List<Category> subCategoryList = new ArrayList<>();

    public Category(Long code, String name, int score) {
        this.code = code;
        this.name = name;
        this.score = score;
    }

    public boolean isHaveChild() {
        return CollectionUtils.isNotEmpty(subCategoryList);
    }

    public void addChild(Category category){
        subCategoryList.add(category);
    }

    public long calculateScore() {
        if(!isHaveChild()){
            return score;
        }
        int temp = score;
        for (Category category : subCategoryList) {
            temp+=category.calculateScore();
        }
        return temp;
    }
}
