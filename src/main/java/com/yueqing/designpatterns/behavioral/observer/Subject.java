package com.yueqing.designpatterns.behavioral.observer;

/**
 * @author dingliming
 * @date 2022/7/30
 */
public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notify(SubjectEnum subjectEnum);
}
