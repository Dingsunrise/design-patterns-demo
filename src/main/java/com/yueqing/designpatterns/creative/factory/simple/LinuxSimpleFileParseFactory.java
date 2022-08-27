package com.yueqing.designpatterns.creative.factory.simple;

import java.util.HashMap;
import java.util.Map;

import com.yueqing.example.parse.FileParse;
import com.yueqing.example.parse.FileType;
import com.yueqing.example.parse.ios.IosJsonFileParse;
import com.yueqing.example.parse.ios.IosPropertiesFileParse;
import com.yueqing.example.parse.ios.IosXmlFileParse;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public class LinuxSimpleFileParseFactory {

    public static final Map<FileType, FileParse> PARSE_MAP = new HashMap<>();

    static {
        PARSE_MAP.put(FileType.JSON, new IosJsonFileParse());
        PARSE_MAP.put(FileType.XML, new IosXmlFileParse());
        PARSE_MAP.put(FileType.PROPERTIES, new IosPropertiesFileParse());
    }

    /**
     * 可复用对象 简单工厂模式
     *
     * @param fileType 类型
     */
    public static FileParse getReusableFileParse(FileType fileType) {
        if (null == fileType) {
            return null;
        }
        return PARSE_MAP.get(fileType);
    }


    /**
     * 不可复用对象 简单工厂模式
     *
     * @param fileType 类型
     */
    public static FileParse getNonReusableFileParse(FileType fileType) {
        if (null == fileType) {
            return null;
        }
        if (fileType.isJson()) {
            return new IosJsonFileParse();
        }
        if (fileType.isXml()) {
            return new IosXmlFileParse();
        }
        if (fileType.isProperties()) {
            return new IosPropertiesFileParse();
        }
        return null;
    }
}
