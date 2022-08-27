package com.yueqing.example.parse;

/**
 *
 * 平台枚举
 *
 * @author dingliming
 * @date 2022/7/16
 */
public enum Platform {

    /**
     * 平台
     */
    Windows, Linux, IOS;

    public boolean isWindows(){
        return Windows.equals(this);
    }

    public boolean isLinux(){
        return Linux.equals(this);
    }

    public boolean isIos(){
        return IOS.equals(this);
    }
}
