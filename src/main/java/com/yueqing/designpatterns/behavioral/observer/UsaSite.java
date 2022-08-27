package com.yueqing.designpatterns.behavioral.observer;

/**
 * @author dingliming
 * @date 2022/7/30
 */
public class UsaSite implements Observer{
    @Override
    public void update(SubjectEnum subjectEnum) {
        if(subjectEnum.isLiveStated()){
            System.out.println("this live has started!");
        }
        if(subjectEnum.isRecordLog()){
            System.out.println("usa site has been recorded!");
        }
    }
}
