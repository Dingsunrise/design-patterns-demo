package com.yueqing.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author dingliming
 * @date 2022/7/30
 */
public class RecordLog implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(SubjectEnum subjectEnum) {
        //结合迭代器模式使用
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(subjectEnum);
        }
    }
}
