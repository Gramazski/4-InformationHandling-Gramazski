package com.gramazski.handling.interpretator;

import com.gramazski.handling.interpretator.parser.ExpressionParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gs on 22.01.2017.
 */
public class InterpreterClientTest {
    @Test
    public void calculate() throws Exception {
        InterpreterClient interpreterClient = new InterpreterClient();
        String expression = "(-5+1/2*(2+5*2))*1200";
        int expected = 1200;
        ExpressionParser parser = new ExpressionParser();
        interpreterClient.setExpression(expression);

        int actual = interpreterClient.calculate().intValue();

        Assert.assertEquals("Expression interpreting failed.", expected, actual);
    }

}