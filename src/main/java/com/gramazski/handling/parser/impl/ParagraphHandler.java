package com.gramazski.handling.parser.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.impl.TextComposite;
import com.gramazski.handling.parser.AbstractTextHandler;

/**
 * Created by gs on 17.01.2017.
 */
public class ParagraphHandler extends AbstractTextHandler {

    public ParagraphHandler(){
        successor = new SentenceHandler();
    }

    protected String[] decomposeText(String data, IComponent compositeText) {
        String[] decomposingText = data.split("/n");
        return decomposingText;
    }

    protected void chain(String[] decomposingText, IComponent compositeText) {
        for (int i = 0; i < decomposingText.length; i++){
            IComponent textComponent = new TextComposite(TextPartType.PARAGRAPH, "/n");
            compositeText.add(textComponent);
            if (successor != null){
                successor.handleRequest(decomposingText[i], textComponent);
            }
        }
    }
}
