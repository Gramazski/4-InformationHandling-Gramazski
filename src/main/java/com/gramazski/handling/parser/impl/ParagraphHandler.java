package com.gramazski.handling.parser.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.parser.AbstractTextHandler;

/**
 * Created by gs on 17.01.2017.
 */
public class ParagraphHandler extends AbstractTextHandler {

    public ParagraphHandler(){
        successor = new SentenceHandler();
        textType = TextPartType.PARAGRAPH;
    }

    protected String[] decomposeText(String data, IComponent compositeText) {
        String[] decomposingText = data.split("\n");
        return decomposingText;
    }
}
