package com.gramazski.handling.interpretator;

import com.gramazski.handling.interpretator.parser.ExpressionParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gs on 22.01.2017.
 */
public class InterpreterClientTest {
    @Test
    //Unary minus
    public void calculate() throws Exception {
        InterpreterClient interpreterClient = new InterpreterClient();
        String expression = "Pi";
        int expected = 2;
        ExpressionParser parser = new ExpressionParser();
        //String inverseExpression = parser.parse(expression);
        interpreterClient.setExpression(expression);

        int actual = interpreterClient.calculate().intValue();

        Assert.assertEquals("Expression interpreting failed.", expected, actual);
    }

}