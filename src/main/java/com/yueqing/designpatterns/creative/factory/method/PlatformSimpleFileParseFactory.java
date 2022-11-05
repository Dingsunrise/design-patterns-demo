package com.yueqing.designpatterns.creative.factory.method;

import java.util.HashMap;
import java.util.Map;

import com.yueqing.designpatterns.creative.factory.method.methodfactory.FileParseFactory;
import com.yueqing.designpatterns.creative.factory.method.methodfactory.IosFileParseFactory;
import com.yueqing.designpatterns.creative.factory.method.methodfactory.LinuxFileParseFactory;
import com.yueqing.designpatterns.creative.factory.method.methodfactory.WindowsFileParseFactory;
import com.yueqing.example.parse.Platform;

/**
 * 简单工厂模式
 *
 * @author dingliming
 * @date 2022/7/4
 */
public class PlatformSimpleFileParseFactory {

    public static final Map<Platform, FileParseFactory> PLATFORM_MAP = new HashMap<>();

    static {
        PLATFORM_MAP.put(Platform.Windows, new WindowsFileParseFactory());
        PLATFORM_MAP.put(Platform.Linux, new LinuxFileParseFactory());
        PLATFORM_MAP.put(Platform.IOS, new IosFileParseFactory());
    }

    /**
     * 可复用对象 简单工厂模式
     *
     * @param platform 类型
     */
    public static FileParseFactory getReusableFileParse(Platform platform) {
        if (null == platform) {
            return null;
        }
        return PLATFORM_MAP.get(platform);
    }


    /**
     * 不可复用对象 简单工厂模式
     *
     * @param platform 类型
     */
    public static FileParseFactory getNonReusableFileParse(Platform platform) {
        if (null == platform) {
            return null;
        }
        if (platform.isWindows()) {
            return new WindowsFileParseFactory();
        }
        if (platform.isLinux()) {
            return new LinuxFileParseFactory();
        }
        if (platform.isIos()) {
            return new IosFileParseFactory();
        }
        return null;
    }
}
