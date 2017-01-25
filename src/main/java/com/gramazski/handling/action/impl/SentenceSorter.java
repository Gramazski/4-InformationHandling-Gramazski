package com.gramazski.handling.action.impl;

import com.gramazski.handling.action.AbstractActioner;
import com.gramazski.handling.action.comparator.SentenceByLexemeCountComparator;
import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.impl.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gs on 25.01.2017.
 */
public class SentenceSorter extends AbstractActioner {
    private ArrayList<IComponent> sentenceForSortingList = new ArrayList<IComponent>();
    private Logger logger = LogManager.getLogger(SentenceSorter.class);

    public IComponent getResult() {
        Collections.sort(sentenceForSortingList, new SentenceByLexemeCountComparator());

        IComponent resultComponent = new TextComposite(TextPartType.TEXT, "");
        IComponent paragraphComponent = new TextComposite(TextPartType.PARAGRAPH, "");
        paragraphComponent.setInnerList(sentenceForSortingList);
        resultComponent.add(paragraphComponent);
        
        return resultComponent;
    }

    protected void processSentence(IComponent sentence) {
        try {
            sentenceForSortingList.add(sentence.clone());
        } catch (CloneNotSupportedException ex) {
            logger.log(Level.DEBUG, "Cloning failed, course: " + ex.getMessage());
        }
    }
}
