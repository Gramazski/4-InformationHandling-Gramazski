package com.gramazski.handling.parser.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.impl.TextComposite;
import com.gramazski.handling.parser.AbstractTextHandler;

/**
 * Created by gs on 17.01.2017.
 */
public class SentenceHandler extends AbstractTextHandler {

    public SentenceHandler(){
        successor = new WordHandler();
    }

    protected String[] decomposeText(String data, IComponent compositeText) {
        //Add regexp for . ? ! & etc.
        String[] decomposingText = data.split("[.!?]\\\\s*");
        return decomposingText;
    }

    protected void chain(String[] decomposingText, IComponent compositeText) {
        for (int i = 0; i < decomposingText.length; i++){
            //Add regexp for . ? ! & etc.
            IComponent textComponent = new TextComposite(TextPartType.SENTENCE, "");
            compositeText.add(textComponent);
            if (successor != null){
                successor.handleRequest(decomposingText[i], textComponent);
            }
        }
    }
}
