package com.yueqing.designpatterns.creative.factory.simple;

import java.util.HashMap;
import java.util.Map;

import com.yueqing.example.parse.FileParse;
import com.yueqing.example.parse.FileType;
import com.yueqing.example.parse.windows.WindowsJsonFileParse;
import com.yueqing.example.parse.windows.WindowsPropertiesFileParse;
import com.yueqing.example.parse.windows.WindowsXmlFileParse;

/**
 * 简单工厂模式
 *
 * @author dingliming
 * @date 2022/7/4
 */
public class WindowsSimpleFileParseFactory {

    public static final Map<FileType, FileParse> PARSE_MAP = new HashMap<>();

    static {
        PARSE_MAP.put(FileType.JSON, new WindowsJsonFileParse());
        PARSE_MAP.put(FileType.XML, new WindowsXmlFileParse());
        PARSE_MAP.put(FileType.PROPERTIES, new WindowsPropertiesFileParse());
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
            return new WindowsJsonFileParse();
        }
        if (fileType.isXml()) {
            return new WindowsXmlFileParse();
        }
        if (fileType.isProperties()) {
            return new WindowsPropertiesFileParse();
        }
        return null;
    }
}
