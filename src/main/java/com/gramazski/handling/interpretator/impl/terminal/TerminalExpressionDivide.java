package com.gramazski.handling.interpretator.impl.terminal;

import com.gramazski.handling.interpretator.AbstractExpression;
import com.gramazski.handling.interpretator.context.ExpressionContext;

/**
 * Created by gs on 22.01.2017.
 */
public class TerminalExpressionDivide extends AbstractExpression {
    public void interpret(ExpressionContext context) {
        int previousValue = context.popValue();

        context.pushValue(context.popValue() / previousValue);
    }
}
