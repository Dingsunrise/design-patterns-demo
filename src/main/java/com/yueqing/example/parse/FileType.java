package com.yueqing.example.parse;

/**
 * @author dingliming
 * @date 2022/7/16
 */
public enum FileType {

    /**
     * 文件类型
     */
    JSON,PROPERTIES,XML;

    public boolean isJson(){
        return JSON.equals(this);
    }

    public boolean isProperties(){
        return PROPERTIES.equals(this);
    }

    public boolean isXml(){
        return XML.equals(this);
    }
}
