package com.gramazski.handling.action.impl;

import com.gramazski.handling.action.AbstractActioner;
import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.impl.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gs on 23.01.2017.
 */
public class SentenceCounter extends AbstractActioner {
    private ArrayList<IComponent> sentenceWithSameWords = new ArrayList<IComponent>();
    private Logger logger = LogManager.getLogger(SentenceCounter.class);

    public IComponent getResult() {
        IComponent resultComponent = new TextComposite(TextPartType.TEXT, "");
        IComponent paragraphComponent = new TextComposite(TextPartType.PARAGRAPH, "");
        paragraphComponent.setInnerList(sentenceWithSameWords);
        resultComponent.add(paragraphComponent);

        return resultComponent;
    }

    protected void processSentence(IComponent sentence) {
        List<IComponent> wordsList = sentence.getInnerList();

        for (int currentIndex = 0; currentIndex < wordsList.size(); currentIndex++){
            for (int i = 0; i < wordsList.size(); i++){
                try {
                    if ((i != currentIndex) && (wordsList.get(i).equals(wordsList.get(currentIndex)))){
                        sentenceWithSameWords.add(sentence.clone());
                        currentIndex = wordsList.size();
                        break;
                    }
                }
                catch (CloneNotSupportedException ex){
                    logger.log(Level.DEBUG, "Cloning failed, course: " + ex.getMessage());
                }
            }
        }
    }
}
