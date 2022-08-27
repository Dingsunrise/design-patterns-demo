package com.yueqing.designpatterns.behavioral.iterator;

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
public class Category {

    private Long code;

    private String name;

    private int score;

    private List<Category> subCategoryList = new ArrayList<>();

    private int modCount = 0;

    public Category(Long code, String name, int score) {
        this.code = code;
        this.name = name;
        this.score = score;
    }

    public boolean isHaveChild() {
        return CollectionUtils.isNotEmpty(subCategoryList);
    }

    public void addChild(Category category){
        modCount++;
        subCategoryList.add(category);
    }

    public Iterator iterator(){
        return new CategoryIterator();
    }

    private class CategoryIterator implements Iterator{
        int cursor;
        int lastRet = -1;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != subCategoryList.size();
        }

        @Override
        public Category next() {
            if(expectedModCount!=modCount){
                return null;
            }
            int i = cursor;
            if(i>=subCategoryList.size()){
                return null;
            }
            cursor = i+1;
            lastRet = i;
            return subCategoryList.get(i);
        }

        @Override
        public void remove() {
            if(expectedModCount!=modCount){
                return;
            }
            int i = cursor;
            if(i>=subCategoryList.size()){
                return;
            }
            subCategoryList.remove(i);
            modCount++;
            expectedModCount++;
            cursor = lastRet;
        }
    }
}
