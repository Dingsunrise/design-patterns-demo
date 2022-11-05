package com.yueqing.designpatterns.behavioral.interpreter;

/**
 * @author dingliming
 * @date 2022/8/9
 */
public class AdditionExpression implements Expression{

    private final Expression expression1;
    private final Expression expression2;

    public AdditionExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public long interpreter() {
        return expression1.interpreter() + expression2.interpreter();
    }
}
