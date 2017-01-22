package com.gramazski.handling.interpretator;

import com.gramazski.handling.interpretator.context.ExpressionContext;

/**
 * Created by gs on 22.01.2017.
 */
public abstract class AbstractExpression {
    public abstract void interpret(ExpressionContext context);
}
