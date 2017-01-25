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
 * Created by gs on 25.01.2017.
 */
public class WordEraser extends AbstractActioner {
    private int wordLength;
    private Character startLetter;
    private ArrayList<IComponent> sentenceWithErasedWords = new ArrayList<IComponent>();
    private Logger logger = LogManager.getLogger(WordEraser.class);

    public WordEraser(int wordLength, Character startLetter){
        this.wordLength = wordLength;
        this.startLetter = startLetter;
    }

    public IComponent getResult() {
        IComponent resultComponent = new TextComposite(TextPartType.TEXT, "");
        IComponent paragraphComponent = new TextComposite(TextPartType.PARAGRAPH, "");
        paragraphComponent.setInnerList(sentenceWithErasedWords);
        resultComponent.add(paragraphComponent);

        return resultComponent;
    }

    protected void processSentence(IComponent sentence) {
        try {
            IComponent localSentence = sentence.clone();
            List<IComponent> wordsList = localSentence.getInnerList();
            for (int i = 0; i < wordsList.size(); i++){
                if ((wordsList.get(i).getInnerList().get(0).toString().equals(String.valueOf(startLetter)))
                        && (wordsList.get(i).getInnerList().size() == wordLength)){
                    localSentence.remove(i);
                }
            }
            sentenceWithErasedWords.add(localSentence);
        } catch (CloneNotSupportedException ex) {
            logger.log(Level.DEBUG, "Cloning failed, course: " + ex.getMessage());
        }
    }
}
