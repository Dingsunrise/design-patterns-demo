package com.yueqing.designpatterns.behavioral.observer;

/**
 * 主题枚举
 *
 * @author dingliming
 * @date 2022/7/30
 */
public enum SubjectEnum {

    /**
     * 记录日志
     */
    recordLog, liveStated;

    public boolean isRecordLog() {
        return recordLog.equals(this);
    }

    public boolean isLiveStated() {
        return liveStated.equals(this);
    }

}
