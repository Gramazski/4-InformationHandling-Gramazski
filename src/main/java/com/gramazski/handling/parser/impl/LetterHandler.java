package com.gramazski.handling.parser.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.parser.AbstractTextHandler;

/**
 * Created by gs on 17.01.2017.
 */
public class LetterHandler extends AbstractTextHandler {

    public LetterHandler(){
        //Add default handler for avoiding null checking
        successor = null;
        textType = TextPartType.LETTER;
    }

    protected String[] decomposeText(String data, IComponent compositeText) {
        String[] decomposingText = data.split("");

        return decomposingText;
    }
}
