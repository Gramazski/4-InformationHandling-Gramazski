package com.gramazski.handling.action.impl;

import com.gramazski.handling.action.AbstractActioner;
import com.gramazski.handling.composite.IComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gs on 23.01.2017.
 */
//Good class name!!!!!!!?????
public class SentenceCounterActioner extends AbstractActioner {
    private ArrayList<IComponent> sentenceWithSameWords = new ArrayList<IComponent>();

    protected void processSentence(IComponent sentence) {
        List<IComponent> wordsList = sentence.getInnerList();

        for (int currentIndex = 0; currentIndex < wordsList.size(); currentIndex++){
            for (int i = 0; i < wordsList.size(); i++){
                if ((i != currentIndex) && (wordsList.get(i).equals(wordsList.get(currentIndex)))){
                    //Should clone list, not a reference!!!
                    sentenceWithSameWords.add(sentence);
                    break;
                }
            }
        }
    }
}
