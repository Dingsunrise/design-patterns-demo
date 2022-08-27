package com.yueqing.designpatterns.behavioral.chainofresponsibility;

import java.io.File;

import com.yueqing.example.parse.FileParse;

/**
 * @author dingliming
 * @date 2022/8/11
 */
public class FinalParse implements FileParse {

    @Override
    public String parse(File file) {
        System.out.println("final parse");
        return null;
    }
}
