package com.gramazski.handling.interpretator.parser;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gs on 22.01.2017.
 */
public class ExpressionParserTest {
    @Test
    public void parse() throws Exception {
        String expression = "-2+4*cos(2-3/(4-2))";
        String expected = "242342-/-*+";
        ExpressionParser parser = new ExpressionParser();

        String actual = parser.parse(expression);

        Assert.assertEquals("Expression parsing failed.", expected, actual);
    }

    @Test
    public void preparingForParsing(){
        String expression = "(-2)";
        String expected = "((1-2))";
        ExpressionParser expressionParser = new ExpressionParser();
        String actual = expressionParser.prepareForParsing(expression);
        Assert.assertEquals("Preparing for parsing failed.", expected, actual);
    }
}