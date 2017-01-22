package com.gramazski.handling.parser.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.parser.AbstractTextHandler;

import java.util.regex.Pattern;

/**
 * Created by gs on 17.01.2017.
 */
public class SentenceHandler extends AbstractTextHandler {
    private static final Pattern SENTENCE_REG = Pattern.compile("[\\s\\S]*?[\\.|!|\\?]");

    public SentenceHandler(){
        successor = new WordHandler();
        textType = TextPartType.SENTENCE;
    }

    protected String[] decomposeText(String data, IComponent compositeText) {
        String[] decomposingText = SENTENCE_REG.split(data);
        return decomposingText;
    }
}
