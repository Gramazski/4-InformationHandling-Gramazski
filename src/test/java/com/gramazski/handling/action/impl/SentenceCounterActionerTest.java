package com.gramazski.handling.action.impl;

import com.gramazski.handling.composite.IComponent;
import com.gramazski.handling.composite.attribute.composite.TextPartType;
import com.gramazski.handling.composite.impl.TextComposite;
import com.gramazski.handling.exception.DataReaderException;
import com.gramazski.handling.parser.AbstractTextHandler;
import com.gramazski.handling.parser.impl.ParagraphHandler;
import com.gramazski.handling.reader.AbstractReader;
import com.gramazski.handling.reader.file.TextFileReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gs on 25.01.2017.
 */
public class SentenceCounterActionerTest {
    private IComponent compositeText;

    @Before
    public void initComposite(){
        AbstractReader reader = new TextFileReader();
        String data = "";

        try {
            data = reader.read("src/main/resources/data/text.txt");
        } catch (DataReaderException e) {
            e.printStackTrace();
        }

        compositeText = new TextComposite(TextPartType.TEXT, "");
        AbstractTextHandler textHandler = new ParagraphHandler();

        textHandler.handleRequest(data, compositeText);
    }

    @After
    public void clearComposite(){
        compositeText = new TextComposite(TextPartType.TEXT, "");
    }

    @Test
    public void processSentence() throws Exception {
        String actual = "It was popularised in the 5*(1*2*(3*(4*(5-4)-3)-2)-1) with the release of " +
                "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software " +
                "like Aldus PageMaker including versions of Lorem Ipsum. It is a long established fact that a reader will be " +
                "distracted by the readable content of a page when looking at its layout. The point of using " +
                "(71-(2*2*(3*(2-1/2*2)-2)-10/2))*cos(5) Ipsum is that it has a more-or-less normal distribution of " +
                "letters, as opposed to using 'Content here, content here', making it look like readable English. " +
                "It is a (-5+1/2*(2+5*2))*1200 established fact that a reader will be of a page when looking at its layout. \n";
        SentenceCounterActioner sentenceCounterActioner = new SentenceCounterActioner();
        sentenceCounterActioner.handle(compositeText);
        Assert.assertEquals("Sentence counting failed.", sentenceCounterActioner.getResult().toString(), actual);
    }

}