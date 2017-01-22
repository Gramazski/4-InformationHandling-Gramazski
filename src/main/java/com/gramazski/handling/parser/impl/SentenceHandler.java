package com.gramazski.handling.parser.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.parser.AbstractTextHandler;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.regex.Matcher;
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
        Matcher matcher = SENTENCE_REG.matcher(data);
        ArrayList<String> stringArrayList = new ArrayList<String>();
        while (matcher.find()){
            stringArrayList.add(matcher.group().trim());
        }
        logger.log(Level.DEBUG, "Group: " + stringArrayList.toString());

        return stringArrayList.toArray(new String[stringArrayList.size()]);
    }
}
