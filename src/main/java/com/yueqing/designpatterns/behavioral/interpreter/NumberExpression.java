package com.yueqing.designpatterns.behavioral.interpreter;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public class NumberExpression implements Expression{
    private long number;

    public NumberExpression(long number) {
        this.number = number;
    }

    public NumberExpression(String number) {
        this.number = Long.parseLong(number);
    }

    @Override
    public long interpreter() {
        return this.number;
    }
}
