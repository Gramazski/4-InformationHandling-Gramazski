package com.gramazski.handling.interpretator.parser;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gs on 22.01.2017.
 */
public class ExpressionParserTest {
    @Test
    public void parse() throws Exception {
        String expression = "2+4*(2-3/(4-2))";
        String expected = "242342-/-*+";
        ExpressionParser parser = new ExpressionParser();

        String actual = parser.parse(expression);

        Assert.assertEquals("Expression parsing failed.", expected, actual);
    }

}