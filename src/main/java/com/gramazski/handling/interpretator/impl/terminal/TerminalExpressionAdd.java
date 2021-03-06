package com.gramazski.handling.interpretator.impl.terminal;

import com.gramazski.handling.interpretator.AbstractExpression;
import com.gramazski.handling.interpretator.context.ExpressionContext;

/**
 * Created by gs on 22.01.2017.
 */
public class TerminalExpressionAdd extends AbstractExpression {
    public void interpret(ExpressionContext context) {
        context.pushValue(context.popValue().doubleValue() + context.popValue().doubleValue());
    }
}
