package com.yueqing.designpatterns.behavioral.visitor;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public class VisitorTest {

    public static void main(String[] args) {

        List<FileParse> fileParses = Lists.newArrayList(new JsonParse(),new XmlParse(),new PropertiesParse());

        PrintFileVisitor printFileVisitor = new PrintFileVisitor();

        fileParses.forEach(o->o.accept(printFileVisitor));

        CompressorFileVisitor compressorFileVisitor = new CompressorFileVisitor();

        fileParses.forEach(o->o.accept(compressorFileVisitor));
    }

}
