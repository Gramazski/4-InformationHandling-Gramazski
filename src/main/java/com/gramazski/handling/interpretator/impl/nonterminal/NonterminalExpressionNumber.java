package com.gramazski.handling.interpretator.impl.nonterminal;

import com.gramazski.handling.interpretator.AbstractExpression;
import com.gramazski.handling.interpretator.context.ExpressionContext;

/**
 * Created by gs on 22.01.2017.
 */
public class NonterminalExpressionNumber extends AbstractExpression {
    private int number;

    public NonterminalExpressionNumber(int number) {
        this.number = number;
    }

    public void interpret(ExpressionContext context) {
        context.pushValue(number);
    }
}
