package com.gramazski.handling.interpretator.context;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by gs on 22.01.2017.
 */
public class ExpressionContext {
    private Deque<Number> contextValues = new ArrayDeque<Number>();
    public Number popValue() {
        return contextValues.pop();
    }
    public void pushValue(Number value) {
        this.contextValues.push(value);
    }
}
