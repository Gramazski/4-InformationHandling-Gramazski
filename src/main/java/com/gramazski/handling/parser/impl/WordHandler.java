package com.gramazski.handling.parser.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.interpretator.InterpreterClient;
import com.gramazski.handling.parser.AbstractTextHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gs on 17.01.2017.
 */
public class WordHandler extends AbstractTextHandler {
    private static final Pattern EXPRESSION_REG = Pattern.compile("^(?:\\d+[*+/-])+\\d+$");//Change

    public WordHandler(){
        successor = new LetterHandler();
        textType = TextPartType.WORD;
    }

    protected String[] decomposeText(String data, IComponent compositeText) {
        String[] decomposingText = data.split(" ");
        calculateExpressions(decomposingText);
        return decomposingText;
    }

    private void calculateExpressions(String[] decomposingText){
        InterpreterClient interpreterClient = new InterpreterClient();

        for (int i = 0; i < decomposingText.length; i++) {
            Matcher expressionMatcher = EXPRESSION_REG.matcher(decomposingText[i]);
            if (expressionMatcher.matches()){
                interpreterClient.setExpression(decomposingText[i]);
                decomposingText[i] = String.valueOf(interpreterClient.calculate());
            }
        }
    }
}
