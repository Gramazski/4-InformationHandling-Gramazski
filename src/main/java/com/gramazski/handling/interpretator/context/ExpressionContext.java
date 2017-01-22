package com.gramazski.handling.interpretator.context;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by gs on 22.01.2017.
 */
public class ExpressionContext {
    private Deque<Integer> contextValues = new ArrayDeque<Integer>();
    public Integer popValue() {
        return contextValues.pop();
    }
    public void pushValue(Integer value) {
        this.contextValues.push(value);
    }
}
