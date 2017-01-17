package com.gramazski.handling.parser.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.leaf.LexemeType;
import com.gramazski.handling.composite.impl.LexemeLeaf;
import com.gramazski.handling.parser.AbstractTextHandler;

/**
 * Created by gs on 17.01.2017.
 */
public class LetterHandler extends AbstractTextHandler {

    public LetterHandler(){
        //Add default handler for avoiding null checking
        successor = null;
    }

    protected String[] decomposeText(String data, IComponent compositeText) {
        String[] decomposingText = data.split("");

        return decomposingText;
    }

    protected void chain(String[] decomposingText, IComponent compositeText) {
        for (int i = 0; i < decomposingText.length; i++){
            //Add regexp for finding syntax letters
            IComponent textComponent = new LexemeLeaf(decomposingText[i], LexemeType.LETTER);
            compositeText.add(textComponent);
            if (successor != null){
                successor.handleRequest(decomposingText[i], textComponent);
            }
        }
    }
}
