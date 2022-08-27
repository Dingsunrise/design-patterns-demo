package com.yueqing.designpatterns.behavioral.observer;

/**
 * @author dingliming
 * @date 2022/7/30
 */
public class DeuSite implements Observer{
    @Override
    public void update(SubjectEnum subjectEnum) {
        if(subjectEnum.isLiveStated()){
            System.out.println("this live has started!");
        }
        if(subjectEnum.isRecordLog()){
            System.out.println("deu site has been recorded!");
        }
    }
}
